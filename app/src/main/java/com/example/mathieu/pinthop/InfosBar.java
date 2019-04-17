package com.example.mathieu.pinthop;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class InfosBar extends AppCompatActivity {

    private ProgressDialog progressDialog;
    String id;
    int id_bar;
    JSONObject json = null;

    LinearLayout layoutbieres;

    TextView adresse, style, style2, style3, sportif, terrasse, list, horaire_lundi, horaire_mardi, horaire_mercredi, horaire_jeudi, horaire_vendredi, horaire_samedi, horaire_dimanche, horaire_lundiHH, horaire_mardiHH, horaire_mercrediHH, horaire_jeudiHH, horaire_vendrediHH, horaire_samediHH, horaire_dimancheHH;
    Bar bar = new Bar();
    private ArrayList<Biere> liste_biere = new ArrayList<Biere>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infos_bar);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        adresse = (TextView) findViewById(R.id.adresse_affichage_details);
        style = (TextView) findViewById(R.id.style_affichage_details);
        style2 = (TextView) findViewById(R.id.style2_affichage_details);
        style3 = (TextView) findViewById(R.id.style3_affichage_details);
        sportif = (TextView) findViewById(R.id.sportif_affichage_details);
        terrasse = (TextView) findViewById(R.id.terrasse_affichage_details);
        list = (TextView) findViewById(R.id.list_biere);
        layoutbieres = (LinearLayout) findViewById(R.id.layoutbieres);
        horaire_lundi = (TextView) findViewById(R.id.horaire_lundi);
        horaire_mardi = (TextView) findViewById(R.id.horaire__mardi);
        horaire_mercredi = (TextView) findViewById(R.id.horaire_mercredi);
        horaire_jeudi = (TextView) findViewById(R.id.horaire_jeudi);
        horaire_vendredi = (TextView) findViewById(R.id.horaire_vendredi);
        horaire_samedi = (TextView) findViewById(R.id.horaire_samedi);
        horaire_dimanche = (TextView) findViewById(R.id.horaire_dimanche);

        horaire_lundiHH = (TextView) findViewById(R.id.horaire_lundiHH);
        horaire_mardiHH = (TextView) findViewById(R.id.horaire_mardiHH);
        horaire_mercrediHH = (TextView) findViewById(R.id.horaire_mercrediHH);
        horaire_jeudiHH = (TextView) findViewById(R.id.horaire_jeudiHH);
        horaire_vendrediHH = (TextView) findViewById(R.id.horaire_vendrediHH);
        horaire_samediHH = (TextView) findViewById(R.id.horaire_samediHH);
        horaire_dimancheHH = (TextView) findViewById(R.id.horaire_dimancheHH);

        Intent intent = getIntent();
        id = intent.getStringExtra("ID_Bar");
        String nom_bar = intent.getStringExtra("NOM_BAR");
//        String adresse = intent.getStringExtra("ADRESSE");

        getSupportActionBar().setTitle(nom_bar);

        id_bar = Integer.valueOf(id);

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        new GetBeerSellTask().execute(new ApiConnector(getApplicationContext()));

    }

    private class GetBeerSellTask extends AsyncTask<ApiConnector, Long, JSONArray>
    {

        @Override
        protected void onPreExecute()
        {
            progressDialog = new ProgressDialog(InfosBar.this);
            progressDialog.setTitle("Loading...");
            progressDialog.setMessage("Please wait...");
            progressDialog.setCancelable(false);
            progressDialog.setIndeterminate(false);
            progressDialog.show();
        }

        @Override
        protected JSONArray doInBackground(ApiConnector... params) {
            return params[0].GetBarSells(id_bar);
        }

        @Override
        protected void onPostExecute(JSONArray jsonArray) {
            recupBar(jsonArray);
            affichageinfos();
            progressDialog.dismiss();
        }
    }

    public void recupBar(JSONArray jsonArray)
    {
        if(jsonArray == null)
        {
            Toast.makeText(this, "Erreur", Toast.LENGTH_LONG).show();
        }
        else {
            for (int i = 0; i < jsonArray.length(); i++) {
                try {

                    json = jsonArray.getJSONObject(i);

                    // Cas où le bar contient au moins une bière

                    if(json.getString("nom_biere") != null){
                        Biere beer = new Biere(json.getString("nom_biere"), json.getString("Prix"), json.getString("prix_happy_hour"), json.getString("conditionnement"));
                        liste_biere.add(beer);
                        Log.d("MyApp", beer.toString());
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            ArrayList<PlageHoraire> plageHoraires_liste= new ArrayList<>();

            try {
                plageHoraires_liste.add(new PlageHoraire(json.getString("horaire_lundi_ouverture"), json.getString("horaire_lundi_fermeture")));
                plageHoraires_liste.add(new PlageHoraire(json.getString("horaire_mardi_ouverture"), json.getString("horaire_mardi_fermeture")));
                plageHoraires_liste.add(new PlageHoraire(json.getString("horaire_mercredi_ouverture"), json.getString("horaire_mercredi_fermeture")));
                plageHoraires_liste.add(new PlageHoraire(json.getString("horaire_jeudi_ouverture"), json.getString("horaire_jeudi_fermeture")));
                plageHoraires_liste.add(new PlageHoraire(json.getString("horaire_vendredi_ouverture"), json.getString("horaire_vendredi_fermeture")));
                plageHoraires_liste.add(new PlageHoraire(json.getString("horaire_samedi_ouverture"), json.getString("horaire_samedi_fermeture")));
                plageHoraires_liste.add(new PlageHoraire(json.getString("horaire_dimanche_ouverture"), json.getString("horaire_dimanche_fermeture")));
                plageHoraires_liste.add(new PlageHoraire(json.getString("happy_hours_debut"), json.getString("happy_hours_fin")));

                plageHoraires_liste.add(new PlageHoraire(json.getString("horaire_mardi_debuthh"), json.getString("horaire_mardi_finhh")));
                plageHoraires_liste.add(new PlageHoraire(json.getString("horaire_mercredi_debuthh"), json.getString("horaire_mercredi_finhh")));
                plageHoraires_liste.add(new PlageHoraire(json.getString("horaire_jeudi_debuthh"), json.getString("horaire_jeudi_finhh")));
                plageHoraires_liste.add(new PlageHoraire(json.getString("horaire_vendredi_debuthh"), json.getString("horaire_vendredi_finhh")));
                plageHoraires_liste.add(new PlageHoraire(json.getString("horaire_samedi_debuthh"), json.getString("horaire_samedi_finhh")));
                plageHoraires_liste.add(new PlageHoraire(json.getString("horaire_dimanche_debuthh"), json.getString("horaire_dimanche_finhh")));

                bar = new Bar(json.getString("nom_bar"), json.getString("style"), json.getString("ambiance2"), json.getString("ambiance3"), json.getString("adresse"), json.getString("terrasse"), json.getString("sportif"), plageHoraires_liste);
            }
            catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    void affichageinfos()
    {
        adresse.setText("Adresse : " + bar.getAdresse());
        style.setText("Ambiance : " + bar.getStyle());
        style2.setText(bar.getStyle2());
        style3.setText(bar.getStyle3());
        sportif.setText("Sportif : " + bar.getSportif());
        terrasse.setText("Terrasse : " + bar.getTerrasse());
        list.setText("Bières disponibles dans ce bar : " + "\n" + "\n");

        for(int i = 0; i < liste_biere.size(); i++)
        {
            String old = list.getText().toString();
            String newString = old + liste_biere.get(i).toString() + "\n";
            list.setText(newString);
        }

        horaire_lundi.setText("Lundi : " + bar.getHoraires().get(0).getOuverture() + "h - " + bar.getHoraires().get(0).getFermeture() + "h");
        horaire_mardi.setText("Mardi : " + bar.getHoraires().get(1).getOuverture() + "h - " + bar.getHoraires().get(1).getFermeture() + "h");
        horaire_mercredi.setText("Mercredi : " + bar.getHoraires().get(2).getOuverture() + "h - " + bar.getHoraires().get(2).getFermeture() + "h");
        horaire_jeudi.setText("Jeudi : " + bar.getHoraires().get(3).getOuverture() + "h - " + bar.getHoraires().get(3).getFermeture() + "h");
        horaire_vendredi.setText("Vendredi : " + bar.getHoraires().get(4).getOuverture() + "h - " + bar.getHoraires().get(4).getFermeture() + "h");
        horaire_samedi.setText("Samedi : " + bar.getHoraires().get(5).getOuverture() + "h - " + bar.getHoraires().get(5).getFermeture() + "h");
        horaire_dimanche.setText("Dimanche : " + bar.getHoraires().get(6).getOuverture() + "h - " + bar.getHoraires().get(6).getFermeture() + "h");

        int count = 0;

        for(int i = 8; i < bar.getHoraires().size(); i ++)
        {
            if(bar.getHoraires().get(7).getOuverture().equals(bar.getHoraires().get(i).getOuverture()) && bar.getHoraires().get(7).getFermeture().equals(bar.getHoraires().get(i).getFermeture()))
            {
                count++;
            }

            else
            {
            }
        }

        if(count == 6) {
            horaire_lundiHH.setText("Happy Hours tous les jours : " + bar.getHoraires().get(7).getOuverture() + "h - " + bar.getHoraires().get(7).getFermeture() + "h");
        }

        else {

            horaire_mardiHH.setVisibility(View.VISIBLE);
            horaire_mercrediHH.setVisibility(View.VISIBLE);
            horaire_jeudiHH.setVisibility(View.VISIBLE);
            horaire_vendrediHH.setVisibility(View.VISIBLE);
            horaire_samediHH.setVisibility(View.VISIBLE);
            horaire_dimancheHH.setVisibility(View.VISIBLE);

            horaire_lundiHH.setText("Happy Hours : " + "\n" +  "Lundi : " + bar.getHoraires().get(7).getOuverture() + "h - " + bar.getHoraires().get(7).getFermeture() + "h");
            horaire_mardiHH.setText("Mardi : " + bar.getHoraires().get(8).getOuverture() + "h - " + bar.getHoraires().get(8).getFermeture() + "h");
            horaire_mercrediHH.setText("Mercredi : " + bar.getHoraires().get(9).getOuverture() + "h - " + bar.getHoraires().get(9).getFermeture() + "h");
            horaire_jeudiHH.setText("Jeudi : " + bar.getHoraires().get(10).getOuverture() + "h - " + bar.getHoraires().get(10).getFermeture() + "h");
            horaire_vendrediHH.setText("Vendredi : " + bar.getHoraires().get(11).getOuverture() + "h - " + bar.getHoraires().get(11).getFermeture() + "h");
            horaire_samediHH.setText("Samedi : " + bar.getHoraires().get(12).getOuverture() + "h - " + bar.getHoraires().get(12).getFermeture() + "h");
            horaire_dimancheHH.setText("Dimanche : " + bar.getHoraires().get(13).getOuverture() + "h - " + bar.getHoraires().get(13).getFermeture() + "h");
        }
    }
}
