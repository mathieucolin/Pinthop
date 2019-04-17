package com.example.mathieu.pinthop;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;

public class ListeBieresActivity extends AppCompatActivity {

    ListView listViewBieres;
    private ProgressDialog progressDialog;
    JSONObject json_beer, json_beer_tmp = null;
    ArrayList<String> liste_biere = new ArrayList<>();
    String nom_biere = null;

    private HashMap<String, JSONObject> mHashMap_biere = new HashMap<>();

    Biere biere = new Biere();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_bieres);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Bières");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listViewBieres = (ListView) findViewById(R.id.listViewBiere);

        listViewBieres.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String tmp;
                tmp = parent.getItemAtPosition(position).toString();
                json_beer_tmp = mHashMap_biere.get(tmp);

                try {
                    biere = new Biere(json_beer_tmp.getString("nom_biere"), json_beer_tmp.getString("nationalite"), json_beer_tmp.getString("type"), json_beer_tmp.getString("type2"), json_beer_tmp.getString("couleur"), json_beer_tmp.getString("brasserie"), json_beer_tmp.getString("methodebrassage"), json_beer_tmp.getString("degre_alcool"), json_beer_tmp.getString("commentaires"), json_beer_tmp.getString("common_name"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                Intent intent = new Intent(ListeBieresActivity.this, BiereDetails.class);
                try {
                    intent.putExtra("NOM_BIERE", json_beer_tmp.getString("nom_biere"));
                    intent.putExtra("NATIONALITE", json_beer_tmp.getString("nationalite"));
                    intent.putExtra("TYPE", json_beer_tmp.getString("type"));
                    intent.putExtra("TYPE2", json_beer_tmp.getString("type2"));
                    intent.putExtra("COULEUR", json_beer_tmp.getString("couleur"));
                    intent.putExtra("BRASSERIE", json_beer_tmp.getString("brasserie"));
                    intent.putExtra("METHODEBRASSAGE", json_beer_tmp.getString("methodebrassage"));
                    intent.putExtra("DEGREALCOOL",json_beer_tmp.getString("degre_alcool"));
                    intent.putExtra("COMMENTAIRES", json_beer_tmp.getString("commentaires"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                startActivity(intent);

            }
        });

        new GetAllBeersTask().execute(new ApiConnector(getApplicationContext()));
    }

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
            progressDialog = new ProgressDialog(ListeBieresActivity.this);
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


        protected void onPostExecute(JSONArray jsonArray) {
            setBeersInArray(jsonArray);
            progressDialog.dismiss();
            ArrayAdapter<String> adapter_liste_biere = new ArrayAdapter<String>(ListeBieresActivity.this, android.R.layout.simple_list_item_1, liste_biere);
            listViewBieres.setAdapter(adapter_liste_biere);
        }
    }


}
