package com.example.mathieu.pinthop;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.AsyncTask;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.MalformedURLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    LatLng center_zone = null;
    LatLng coordonatesUser;

    LatLngBounds.Builder builder = new LatLngBounds.Builder();

    String binchas = null;
    double distance;
    CameraUpdate cu = null;
    int ID_biere_recup = 0;
    Marker bar = null;
    JSONObject json = null;
    JSONObject jsonmarker = null;

    double perimetre = 2;
    String nom_bar_tmp = null;
    String adresse_bar_tmp = null;
    String style_bar_tmp = null;

    int choix_lieu = 0;
    int choix_biere = 0;

    LinearLayout layout_affichage_bar = null;
    TextView nom_bar;
    TextView adresse_bar;
    TextView type_soiree;

    Button confirmer_postion = null;

    Marker position_user = null;
    int counter = 0;

    double rad = 0;
    private ProgressDialog progressDialog;

    private static final String TAG = "myApp";

    private HashMap<Marker, JSONObject> mHashMap = new HashMap<>();

    ArrayList <Marker> list_markers = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        layout_affichage_bar = (LinearLayout) findViewById(R.id.layout_affichage_bar_xml);
        nom_bar = (TextView) findViewById(R.id.nom_bar_xml);
        adresse_bar = (TextView) findViewById(R.id.adresse_bar_xml);
        type_soiree = (TextView) findViewById(R.id.type_soiree_xml);
        confirmer_postion = (Button) findViewById(R.id.confirmer_position);

        confirmer_postion.setOnClickListener(listener_confirmer_position);
        layout_affichage_bar.setOnClickListener(listener_layout);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

//        Intent intent = getIntent();

//        String id = intent.getStringExtra("ID_I_NEED");
//        choix_lieu = intent.getIntExtra("CHOIX_LIEU", 0);
//        choix_biere = intent.getIntExtra("CHOIX_BIERE", 0);

        SharedPreferences prefs = getSharedPreferences("MyPrefs", MODE_PRIVATE);

        String id = prefs.getString("ID_I_NEED", "no ID");
        choix_lieu = prefs.getInt("CHOIX_LIEU", -1);
        choix_biere = prefs.getInt("CHOIX_BIERE", -1);

        Gson gson = new Gson();
        String json = prefs.getString("POSITION_USER", "");
        coordonatesUser = gson.fromJson(json, LatLng.class);

        final Circle mapCircle;
        mapCircle = mMap.addCircle(new CircleOptions().center(coordonatesUser).radius(2000).strokeColor(Color.CYAN));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(coordonatesUser,12));

        position_user = mMap.addMarker(new MarkerOptions().position(coordonatesUser).title("Your Position").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        builder.include(coordonatesUser);

        if(id!="no ID") {
            ID_biere_recup = Integer.valueOf(id);
        }

        // Si choix lieu est : le plus près ou peu importe

        if(choix_lieu == 1 || choix_lieu == 3)
        {
            mapCircle.remove();

            // Si choix biere est : dégustation précise

            if(choix_biere == 2) {
                new GetBeerSellTask().execute(new ApiConnector(getApplicationContext()));
            }

            // Si choix biere est : peu importe

            if(choix_biere == 1)
            {
                new GetAllBarsTask().execute(new ApiConnector(getApplicationContext()));
            }
        }

        // Sinon le cercle et le bouton confirmer position seront affichés pour sélectionner une zone

        if(choix_lieu == 2)
        {
            confirmer_postion.setVisibility(View.VISIBLE);
            mapCircle.setCenter(coordonatesUser);
            rad = mapCircle.getRadius();
            center_zone = coordonatesUser;
        }

        // Listener du click sur les markers qui permet d'afficher le nom du bar et son adresse ainsi qu'un floating button pour
        // partager
        // Ce listener affiche aussi le prix de la bière choisie et son nom si cette option a été utilisée

        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {

            public boolean onMarkerClick(Marker marker) {

                if(choix_lieu == 2)
                {
                    if(mapCircle != null)             {
                        mapCircle.setCenter(marker.getPosition());
                        rad = mapCircle.getRadius();
                        center_zone = marker.getPosition();
                    }
                }

                if (marker.equals(position_user)) {

                    layout_affichage_bar.setVisibility(View.GONE);
                } else {
                    try {
                        jsonmarker = mHashMap.get(marker);

                        nom_bar_tmp = jsonmarker.getString("nom_bar");
                        adresse_bar_tmp = jsonmarker.getString("adresse");

                        if (choix_biere == 2) {
                            style_bar_tmp = jsonmarker.getString("Prix");
                            binchas = jsonmarker.getString("nom_biere");
                            type_soiree.setText(style_bar_tmp + "€");
                        }

                        nom_bar.setText(nom_bar_tmp);
                        adresse_bar.setText(adresse_bar_tmp);

                        layout_affichage_bar.setVisibility(View.VISIBLE);

                        FloatingActionButton myFab = (FloatingActionButton) findViewById(R.id.fab);
                        myFab.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View v) {
                                Intent sendIntent = new Intent();
                                sendIntent.setAction(Intent.ACTION_SEND);
                                String s = "";

                                s = "Hey salut les couilles on va au " + nom_bar_tmp;

                                if (choix_biere == 2) {
                                    s = s + " y'a de la " + binchas + " à " + style_bar_tmp + " balles !";
                                }
                                sendIntent.putExtra(Intent.EXTRA_TEXT, s);
                                sendIntent.setType("text/plain");
                                startActivity(sendIntent);
                            }
                        });
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                return false;
            }
        });

        // Listener lorsque l'on clique sur la carte
        // On enlève l'affichage des infos d'un bar
        // Si le choix est : dans une zone, on affiche le bouton confirmer position et on récupère les infos du cercle
        // son centre et son rayon

        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {

            public void onMapClick(LatLng latLng) {
                layout_affichage_bar.setVisibility(View.GONE);

                if(choix_lieu == 2)
                {
                    if(mapCircle != null)             {
                        mapCircle.setCenter(latLng);
                        rad = mapCircle.getRadius();
                        center_zone = latLng;
                    }
                }
            }
        });
    }

    private  View.OnClickListener listener_layout = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent newactivity = new Intent(getApplicationContext(), InfosBar.class);
            try {
                newactivity.putExtra("ID_Bar", jsonmarker.getString("idBar"));
                newactivity.putExtra("NOM_BAR", jsonmarker.getString("nom_bar"));
//                newactivity.putExtra("ADRESSE", jsonmarker.getString("adresse"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            startActivity(newactivity);
        }
    };

    // Listener du bouton confirmer la position
    // Le périmètre est initialisé
    // les anciencs markers s'effacent
    // GetBeerSellTask ou GetAllBarsTask est executé en fonction du choix : dégustation précise ou peu importe

    private View.OnClickListener listener_confirmer_position = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            perimetre = rad/1000;
            if(!list_markers.isEmpty()) {
                for (int i = 0; i < list_markers.size(); i++) {
                    list_markers.get(i).remove();
                }

                list_markers.clear();
            }

            // Si choix bière est : dégustation précise

            if(choix_biere == 2)
            {
                new GetBeerSellTask().execute(new ApiConnector(getApplicationContext()));
            }

            // Si choix bière est : peu importe

            if(choix_biere == 1) {
                new GetAllBarsTask().execute(new ApiConnector(getApplicationContext()));
            }
        }
    };

    // Fonction qui permet de passer le JSon des bars récupérés à l'asyncTask DataLongOperationAsynchTask qui va placer les bars
    // sur la carte

    public void recupBar(JSONArray jsonArray)
    {
        if(jsonArray == null)
        {
            Toast.makeText(this, "Biere non trouvée ", Toast.LENGTH_LONG).show();
        }
        else {
            for (int i = 0; i < jsonArray.length(); i++) {
                try {
                    json = jsonArray.getJSONObject(i);

                    new DataLongOperationAsynchTask().execute(new ApiConnector(getApplicationContext()),json);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    // AsyncTask pour récupérer tous les bars

    private class GetAllBarsTask extends AsyncTask<ApiConnector, Long, JSONArray>
    {
        @Override
        protected void onPreExecute()
        {
            progressDialog = new ProgressDialog(MapsActivity.this);
            progressDialog.setTitle("Loading...");
            progressDialog.setMessage("Please waitas...");
            progressDialog.setCancelable(false);
            progressDialog.setIndeterminate(false);
            progressDialog.show();
        }

        @Override
        protected JSONArray doInBackground(ApiConnector... params) {

            try {
                return params[0].GetAllBars();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(JSONArray jsonArray) {
            recupBar(jsonArray);
            progressDialog.dismiss();
        }
    }

    // AsyncTask pour récupérer tous les bars qui possèdent la bière demandée

    private class GetBeerSellTask extends AsyncTask<ApiConnector, Long, JSONArray>
    {

        @Override
        protected void onPreExecute()
        {
            progressDialog = new ProgressDialog(MapsActivity.this);
            progressDialog.setTitle("Loading...");
            progressDialog.setMessage("Please wait...");
            progressDialog.setCancelable(false);
            progressDialog.setIndeterminate(false);
            progressDialog.show();
        }

        @Override
        protected JSONArray doInBackground(ApiConnector... params) {

            return params[0].GetBeerSell(ID_biere_recup);
        }

        @Override
        protected void onPostExecute(JSONArray jsonArray) {
            recupBar(jsonArray);
            progressDialog.dismiss();
        }
    }

    // AsyncTask qui permet de récupérer les coordonnées GPS d'une adresse via L'API Geocoding de Google

    private class DataLongOperationAsynchTask extends AsyncTask<Object, Void, Wrapper> {
        ProgressDialog dialog = new ProgressDialog(MapsActivity.this);
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog.setMessage("Please waitadas...");
            dialog.setCanceledOnTouchOutside(false);
            dialog.show();
        }

        @Override
        protected Wrapper doInBackground(Object... params) {
            String response;
            Wrapper w = new Wrapper();
            JSONObject jsonas;

            try {
                ApiConnector responsas = (ApiConnector) params[0];
                jsonas = (JSONObject) params[1];
                response = responsas.getLatLongByURL("http://maps.google.com/maps/api/geocode/json?address=" + jsonas.getString("adresse") + "&sensor=false");
                w.resultats = new String[] {response};
                w.nom_du_marker = jsonas.getString("nom_bar");
                w.json_recup = jsonas;
                return w;
            } catch (Exception e) {
                w.resultats[0] = "error";
                return w;
            }
        }

        @Override
        protected void onPostExecute(Wrapper w) {
            try {
                JSONObject jsonObject = new JSONObject(w.resultats[0]);

                double lng = ((JSONArray)jsonObject.get("results")).getJSONObject(0)
                        .getJSONObject("geometry").getJSONObject("location")
                        .getDouble("lng");

                double lat = ((JSONArray)jsonObject.get("results")).getJSONObject(0)
                        .getJSONObject("geometry").getJSONObject("location")
                        .getDouble("lat");

                LatLng coordonates = new LatLng(lat, lng);

                // Si le choix pour la localisation est : peu importe

                if(choix_lieu == 3) {

                    bar = mMap.addMarker(new MarkerOptions().position(coordonates).title(w.nom_du_marker));
                    list_markers.add(bar);
                    counter++;
                    builder.include(bar.getPosition());
                    mHashMap.put(bar, w.json_recup);

                        LatLngBounds bounds = builder.build();
                        int padding = 100; // offset from edges of the map in pixels
                        cu = CameraUpdateFactory.newLatLngBounds(bounds, padding);
                        mMap.moveCamera(cu);

                }

                // Si le choix pour la localisation est : le plus près ou dans une zone

                if(choix_lieu == 1 || choix_lieu == 2) {

                    if(position_user != null) {

                        // Dans une zone la distance sera calculée par rapport au centre de la zone
                        if(choix_lieu == 2)
                        {
                            distance = CalculationByDistance(coordonates, center_zone);
                        }
                        // Le plus près la distance sera calculée par rapport à la position de l'utilisateur
                        if(choix_lieu == 1) {
                            distance = CalculationByDistance(coordonates, position_user.getPosition());
                        }
                        Log.d(TAG, "distance calculée : " + distance);

                        // perimetre est initalement à 2 pour le plus près mais si zone est est séléctionnée perimetre est égal au
                        // rayon de la zone (cette valeur lui est donnée dans le listener du bouton confirmer position)

                        if (distance < perimetre) {

                            bar = mMap.addMarker(new MarkerOptions().position(coordonates).title(w.nom_du_marker));
                            list_markers.add(bar);
                            counter++;
                            builder.include(bar.getPosition());
                            mHashMap.put(bar, w.json_recup);

                                LatLngBounds bounds = builder.build();
                                int padding = 100; // offset from edges of the map in pixels
                                cu = CameraUpdateFactory.newLatLngBounds(bounds, padding);
                                mMap.moveCamera(cu);
                        }
                    }
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (dialog.isShowing()) {
                dialog.dismiss();
            }
        }
    }

    // Classe Wrapper pour permettre le passage de plusieurs paramètres entre le DoInBackGround et le OnPostExecute

    public class Wrapper
    {
        String [] resultats;
        String nom_du_marker;
        JSONObject json_recup;
    }

    public double CalculationByDistance(LatLng StartP, LatLng EndP) {
        int Radius = 6371;// radius of earth in Km
        double lat1 = StartP.latitude;
        double lat2 = EndP.latitude;
        double lon1 = StartP.longitude;
        double lon2 = EndP.longitude;
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                + Math.cos(Math.toRadians(lat1))
                * Math.cos(Math.toRadians(lat2)) * Math.sin(dLon / 2)
                * Math.sin(dLon / 2);
        double c = 2 * Math.asin(Math.sqrt(a));
        double valueResult = Radius * c;
        double km = valueResult / 1;
        DecimalFormat newFormat = new DecimalFormat("####");
        int kmInDec = Integer.valueOf(newFormat.format(km));
        double meter = valueResult % 1000;
        int meterInDec = Integer.valueOf(newFormat.format(meter));
        Log.d(TAG, "Radius Value : " + valueResult + "   KM  " + kmInDec + " Meter   " + meterInDec);

        return Radius * c;
    }
}
