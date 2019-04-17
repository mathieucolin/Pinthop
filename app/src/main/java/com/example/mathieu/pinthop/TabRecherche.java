package com.example.mathieu.pinthop;

/**
 * Created by Mathieu on 11/02/2016.
 */

import android.Manifest;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;

public class TabRecherche extends Fragment {
    private static final int REQUEST_CODE_LOCATION = 2;

    TextView message_bienvenue = null;
    TextView houblon = null;
    TextView localisation = null;
    TextView type = null;

    JSONObject json_beer = null;
    JSONObject json_beer_tmp = null;

    AutoCompleteTextView choix_biere = null;

    LatLng position_user = new LatLng(0,0);

    Button bouton_go_beer = null;

    Spinner spinner_biere = null;
    Spinner spinner_lieu = null;
    Spinner spinner_type = null;

    ArrayList<String> liste_biere = new ArrayList<>();
    String nom_biere = null;

    String id_biere_voulue = null;



    int autocomplete_clicked = 0;

    int choix_lieu = 0;
    int type_choix_biere = 0;
    double latUser = 0;
    double longUser = 0;

    private HashMap<String, JSONObject> mHashMap_biere = new HashMap<>();

    private ProgressDialog progressDialog;

    LocationManager locationManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.tab_recherche, container, false);

        message_bienvenue = (TextView) view.findViewById(R.id.message_bienvenue_xml);
        houblon = (TextView) view.findViewById(R.id.houblon_xml);
        localisation = (TextView) view.findViewById(R.id.localisation_xml);
        type = (TextView) view.findViewById(R.id.type_xml);
        choix_biere = (AutoCompleteTextView) view.findViewById(R.id.choix_biere_xml);

        bouton_go_beer = (Button) view.findViewById(R.id.go_beer_xml);

        spinner_biere = (Spinner) view.findViewById(R.id.spinner_biere);
        spinner_lieu = (Spinner) view.findViewById(R.id.spinner_lieu);
        spinner_type = (Spinner) view.findViewById(R.id.spinner_type);

        ArrayAdapter<CharSequence> adapter_spinner_biere = ArrayAdapter.createFromResource(getActivity().getBaseContext(), R.array.boissons, R.layout.spinner_customize);
        adapter_spinner_biere.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_biere.setAdapter(adapter_spinner_biere);

        ArrayAdapter<CharSequence> adapter_spinner_lieu = ArrayAdapter.createFromResource(getActivity().getBaseContext(), R.array.localisation, R.layout.spinner_customize);
        adapter_spinner_lieu.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_lieu.setAdapter(adapter_spinner_lieu);

        ArrayAdapter<CharSequence> adapter_spinner_type = ArrayAdapter.createFromResource(getActivity().getBaseContext(), R.array.type, R.layout.spinner_customize);
        adapter_spinner_type.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_type.setAdapter(adapter_spinner_type);

        ArrayAdapter<String> adapter_autocomplete_biere = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_dropdown_item_1line, liste_biere);
        choix_biere.setAdapter(adapter_autocomplete_biere);

        bouton_go_beer.setOnClickListener(go_beer);
        spinner_biere.setOnItemSelectedListener(biere);
        spinner_lieu.setOnItemSelectedListener(lieu);
        choix_biere.setOnItemClickListener(choix);

        locationManager = (LocationManager) getContext().getSystemService(Context.LOCATION_SERVICE);

        if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_CODE_LOCATION);
        }

        Location lastLocation = locationManager.getLastKnownLocation(getContext().LOCATION_SERVICE);

        if(lastLocation != null) {

            double lat = lastLocation.getLatitude();
            double lng = lastLocation.getLongitude();
            LatLng lastKnownLocation = new LatLng(lat, lng);
            position_user = lastKnownLocation;
        }

        if(lastLocation == null) {
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);
        }

        return view;
    }

    private AdapterView.OnItemSelectedListener biere = new AdapterView.OnItemSelectedListener() {

        @Override
        public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
            if (position == 1) {

                type_choix_biere = 2;
                choix_biere.setVisibility(View.VISIBLE);
                new GetAllBeersTask().execute(new ApiConnector(getContext()));
            }
            if (position == 0) {
                type_choix_biere = 1;
                autocomplete_clicked = 0;
                choix_biere.getText().clear();
                choix_biere.setVisibility(View.GONE);
            }
            if (position == 2) {
                type_choix_biere = 3;
                autocomplete_clicked = 0;
                choix_biere.getText().clear();
                choix_biere.setVisibility(View.GONE);
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parentView) {
            // your code here
        }
    };

    private AdapterView.OnItemSelectedListener lieu = new AdapterView.OnItemSelectedListener() {

        @Override
        public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
            if (position == 0) {
                choix_lieu = 1;
                statusCheck();
            }
            if (position == 1) {
                choix_lieu = 2;
            }
            if(position == 2)
            {
                choix_lieu = 3;
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parentView) {

            choix_lieu = 1;
        }
    };

    private View.OnClickListener go_beer = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent secondeActivite = new Intent(getActivity(), MapsActivity.class);
            SharedPreferences.Editor editor = getContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE).edit();
            Gson gson = new Gson();

            if (autocomplete_clicked == 1) {
                editor.putString("ID_I_NEED", id_biere_voulue);
            }

                editor.putInt("CHOIX_LIEU", choix_lieu);
                editor.putInt("CHOIX_BIERE", type_choix_biere);

            if(position_user.longitude != 0 && position_user.latitude != 0) {

                String json  = gson.toJson(position_user);
                editor.putString("POSITION_USER", json);
                editor.commit();

                Toast.makeText(getContext(), "Position de l'utiisateur :"+ position_user, Toast.LENGTH_SHORT).show();

                startActivity(secondeActivite);
            }

            if(position_user.longitude == 0 && position_user.latitude == 0)
            {
                Toast.makeText(getContext(), "Votre position n'a pas encore été détecté, veuillez patienter un instant", Toast.LENGTH_LONG).show();
            }
        }
    };

    private AdapterView.OnItemClickListener choix = new AdapterView.OnItemClickListener() {

        @Override
        public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
            String tmp = null;

            autocomplete_clicked = 1;
            tmp = arg0.getItemAtPosition(arg2).toString();

            json_beer_tmp = mHashMap_biere.get(tmp);
            try {
                id_biere_voulue = json_beer_tmp.getString("idBiere");
            } catch (JSONException e) {
                e.printStackTrace();
            }

            InputMethodManager in = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
            in.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), 0);
        }

    };

    public void setBeersInArray(JSONArray jsonArray) {
        for (int i = 0; i < jsonArray.length(); i++) {
            try {
                json_beer = jsonArray.getJSONObject(i);

                nom_biere = json_beer.getString("nom_biere");

                liste_biere.add(nom_biere);

                mHashMap_biere.put(nom_biere, json_beer);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private class GetAllBeersTask extends AsyncTask<ApiConnector, Long, JSONArray> {
        @Override
        protected void onPreExecute() {
            progressDialog = new ProgressDialog(getActivity());
            progressDialog.setTitle("Loading...");
            progressDialog.setMessage("Please wait...");
            progressDialog.setCancelable(false);
            progressDialog.setIndeterminate(false);
            progressDialog.show();
        }

        @Override
        protected JSONArray doInBackground(ApiConnector... params) {

            try {
                return params[0].GetAllBeers();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(JSONArray jsonArray) {
            setBeersInArray(jsonArray);
            progressDialog.dismiss();
        }
    }

    public void statusCheck() {
        final LocationManager manager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);

        if (!manager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            builbAlertMessageNoGps();
        }
    }

    private void builbAlertMessageNoGps() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("Votre GPS est désactivé, voulez vous l'activer ?").setCancelable(false).setPositiveButton("Oui", new DialogInterface.OnClickListener() {
            public void onClick(final DialogInterface dialog, final int id) {
                startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));
            }
        })
                .setNegativeButton("Non", new DialogInterface.OnClickListener() {
                    public void onClick(final DialogInterface dialog, final int id) {
                        dialog.cancel();
                    }
                });
        final AlertDialog alert = builder.create();
        alert.show();
    }

    LocationListener locationListener = new LocationListener() {
        public void onLocationChanged(Location locationUser) {


            latUser = locationUser.getLatitude();
            longUser = locationUser.getLongitude();

            final LatLng UserCoordonates = new LatLng(latUser, longUser);

            position_user = UserCoordonates;

            if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
            }
            locationManager.removeUpdates(this);

            // Called when a new location is found by the network location provider.
        }

        public void onStatusChanged(String provider, int status, Bundle extras) {}

        public void onProviderEnabled(String provider) {}

        public void onProviderDisabled(String provider) {}
    };
}