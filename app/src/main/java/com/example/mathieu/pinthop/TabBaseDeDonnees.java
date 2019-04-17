package com.example.mathieu.pinthop;

/**
 * Created by Mathieu on 11/02/2016.
 */

import android.app.DialogFragment;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;

public class TabBaseDeDonnees extends Fragment implements AdapterView.OnItemClickListener {

    public static int button_timepicker = 0;
    int autocomplete_clicked = 0;
    JSONObject json_beer, json_bar, json_beer_tmp, json_bar_tmp = null;
    ArrayList <String> liste_biere = new ArrayList<>();
    ArrayList <String> liste_bar = new ArrayList<>();

    boolean exceptionHH = false;

    private HashMap<String, JSONObject> mHashMap_biere = new HashMap<>();
    private HashMap<String, JSONObject> mHashMap_bar = new HashMap<>();
    String id_biere_voulue, id_bar_voulue, nom_biere, nom_bar = null;
    Button ajouter, ajouter_biere, bouton_recup_bar, modifier_bar, exception = null;
    EditText nom_bar_ajout, style_bar_ajout, style_bar_ajout2, style_bar_ajout3, prix_hors_happy_hours, prix_happy_hours = null;
    AutoCompleteTextView selection_bar, selection_biere, recup_bar_autocomplete, adresse_bar_ajout = null;
    Switch switch_terrasse, switch_sportif, switch_conditionnement = null;
    Button bouton_lundi_ouverture, bouton_lundi_fermeture, bouton_mardi_ouverture, bouton_mardi_fermeture, bouton_mercredi_ouverture, bouton_mercredi_fermeture, bouton_jeudi_ouverture, bouton_jeudi_fermeture, bouton_vendredi_ouverture, bouton_vendredi_fermeture, bouton_samedi_ouverture , bouton_samedi_fermeture, bouton_dimanche_ouverture, bouton_dimanche_fermeture, bouton_happy_hours_debut, bouton_happy_hours_fin = null;
    Button bouton_mardi_debuthh, bouton_mardi_finhh, bouton_mercredi_debuthh, bouton_mercredi_finhh, bouton_jeudi_debuthh, bouton_jeudi_finhh, bouton_vendredi_debuthh, bouton_vendredi_finhh, bouton_samedi_debuthh , bouton_samedi_finhh, bouton_dimanche_debuthh, bouton_dimanche_finhh = null;
    TextView horaire_mardi_debuthh, horaire_mardi_finhh, horaire_mercredi_debuthh, horaire_mercredi_finhh, horaire_jeudi_debuthh, horaire_jeudi_finhh, horaire_vendredi_debuthh, horaire_vendredi_finhh, horaire_samedi_debuthh, horaire_samedi_finhh, horaire_dimanche_debuthh, horaire_dimanche_finhh = null;
    TextView message_ajout, text_switch_terrasse, text_switch_sportif, text_switch_conditionnement, horaire_lundi_ouverture, horaire_lundi_fermeture, horaire_mardi_ouverture, horaire_mardi_fermeture, horaire_mercredi_ouverture, horaire_mercredi_fermeture, horaire_jeudi_ouverture, horaire_jeudi_fermeture, horaire_vendredi_ouverture, horaire_vendredi_fermeture, horaire_samedi_ouverture, horaire_samedi_fermeture, horaire_dimanche_ouverture, horaire_dimanche_fermeture, horaire_happy_hours_debut, horaire_happy_hours_fin  = null;
    String switchOn = "Oui";
    String switchOff = "Non";
    String switchOn2 = "Bouteille";
    String switchOff2 = "Pression";
    LinearLayout layouthh = null;

    Bar bar = new Bar();
    Biere biere = new Biere();

    private ProgressDialog progressDialog;

    private static final String LOG_TAG = "Google Places Autocomplete";
    private static final String PLACES_API_BASE = "https://maps.googleapis.com/maps/api/place";
    private static final String TYPE_AUTOCOMPLETE = "/autocomplete";
    private static final String OUT_JSON = "/json";

    private static final String API_KEY = "AIzaSyCfwzn-QNDNwOfi9e01xq4F84DY9SQc5Ls";

    private static final String TAG = "myApp";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        inflater = getActivity().getLayoutInflater();

        final View view = inflater.inflate(R.layout.tab_base_de_donnees, container, false);

        new GetAllBarsTask().execute(new ApiConnector(getContext()));
//

        // Récupération de toutes les variables Layouts

        layouthh = (LinearLayout) view.findViewById(R.id.layouthh);
        message_ajout = (TextView) view.findViewById(R.id.ajoutBar);

        ajouter = (Button) view.findViewById(R.id.ajouter_infos_xml);
        ajouter_biere = (Button) view.findViewById(R.id.ajouter_biere_bar);

        selection_bar = (AutoCompleteTextView) view.findViewById(R.id.choix_bar_ajout);
        selection_biere = (AutoCompleteTextView) view.findViewById(R.id.choix_biere_ajout);
        recup_bar_autocomplete = (AutoCompleteTextView) view.findViewById(R.id.choix_bar_modifier);

        nom_bar_ajout = (EditText) view.findViewById(R.id.nom_bar_ajout_xml);
        style_bar_ajout = (EditText) view.findViewById(R.id.style_bar_ajout_xml);
        style_bar_ajout2 = (EditText) view.findViewById(R.id.style_bar_ajout2_xml);
        style_bar_ajout3 = (EditText) view.findViewById(R.id.style_bar_ajout3_xml);

        adresse_bar_ajout = (AutoCompleteTextView) view.findViewById(R.id.adresse_bar_ajout_xml);

        prix_happy_hours = (EditText) view.findViewById(R.id.prix_happy_hours);
        prix_hors_happy_hours = (EditText) view.findViewById(R.id.prix_hors_happy_hours);

        horaire_lundi_ouverture = (TextView) view.findViewById(R.id.ouverture_lundi);
        horaire_lundi_fermeture = (TextView) view.findViewById(R.id.fermeture_lundi);

        horaire_mardi_ouverture = (TextView) view.findViewById(R.id.ouverture_mardi);
        horaire_mardi_fermeture = (TextView) view.findViewById(R.id.fermeture_mardi);

        horaire_mercredi_ouverture = (TextView) view.findViewById(R.id.ouverture_mercredi);
        horaire_mercredi_fermeture = (TextView) view.findViewById(R.id.fermeture_mercredi);

        horaire_jeudi_ouverture = (TextView) view.findViewById(R.id.ouverture_jeudi);
        horaire_jeudi_fermeture = (TextView) view.findViewById(R.id.fermeture_jeudi);

        horaire_vendredi_ouverture = (TextView) view.findViewById(R.id.ouverture_vendredi);
        horaire_vendredi_fermeture = (TextView) view.findViewById(R.id.fermeture_vendredi);

        horaire_samedi_ouverture = (TextView) view.findViewById(R.id.ouverture_samedi);
        horaire_samedi_fermeture = (TextView) view.findViewById(R.id.fermeture_samedi);

        horaire_dimanche_ouverture = (TextView) view.findViewById(R.id.ouverture_dimanche);
        horaire_dimanche_fermeture = (TextView) view.findViewById(R.id.fermeture_dimanche);

        /*


        Happy Hours


         */
        horaire_happy_hours_debut = (TextView) view.findViewById(R.id.happy_hours_debut);
        horaire_happy_hours_fin = (TextView) view.findViewById(R.id.happy_hours_fin);

        horaire_mardi_debuthh = (TextView) view.findViewById(R.id.debuthh_mardi);
        horaire_mardi_finhh = (TextView) view.findViewById(R.id.finhh_mardi);

        horaire_mercredi_debuthh = (TextView) view.findViewById(R.id.debuthh_mercredi);
        horaire_mercredi_finhh= (TextView) view.findViewById(R.id.finhh_mercredi);

        horaire_jeudi_debuthh = (TextView) view.findViewById(R.id.debuthh_jeudi);
        horaire_jeudi_finhh = (TextView) view.findViewById(R.id.finhh_jeudi);

        horaire_vendredi_debuthh = (TextView) view.findViewById(R.id.debuthh_vendredi);
        horaire_vendredi_finhh = (TextView) view.findViewById(R.id.finhh_vendredi);

        horaire_samedi_debuthh = (TextView) view.findViewById(R.id.debuthh_samedi);
        horaire_samedi_finhh = (TextView) view.findViewById(R.id.finhh_samedi);

        horaire_dimanche_debuthh = (TextView) view.findViewById(R.id.debuthh_dimanche);
        horaire_dimanche_finhh = (TextView) view.findViewById(R.id.finhh_dimanche);

        text_switch_terrasse = (TextView) view.findViewById(R.id.text_switch_terrasse);
        text_switch_sportif = (TextView) view.findViewById(R.id.text_switch_sportif);
        text_switch_conditionnement = (TextView) view.findViewById(R.id.text_switch_conditionnement);

        bouton_lundi_ouverture = (Button) view.findViewById(R.id.bouton_ouverture_lundi);
        bouton_lundi_fermeture = (Button) view.findViewById(R.id.bouton_fermeture_lundi);

        bouton_mardi_ouverture = (Button) view.findViewById(R.id.bouton_ouverture_mardi);
        bouton_mardi_fermeture = (Button) view.findViewById(R.id.bouton_fermeture_mardi);

        bouton_mercredi_ouverture = (Button) view.findViewById(R.id.bouton_ouverture_mercredi);
        bouton_mercredi_fermeture = (Button) view.findViewById(R.id.bouton_fermeture_mercredi);

        bouton_jeudi_ouverture = (Button) view.findViewById(R.id.bouton_ouverture_jeudi);
        bouton_jeudi_fermeture = (Button) view.findViewById(R.id.bouton_fermeture_jeudi);

        bouton_vendredi_ouverture = (Button) view.findViewById(R.id.bouton_ouverture_vendredi);
        bouton_vendredi_fermeture = (Button) view.findViewById(R.id.bouton_fermeture_vendredi);

        bouton_samedi_ouverture = (Button) view.findViewById(R.id.bouton_ouverture_samedi);
        bouton_samedi_fermeture = (Button) view.findViewById(R.id.bouton_fermeture_samedi);

        bouton_dimanche_ouverture = (Button) view.findViewById(R.id.bouton_ouverture_dimanche);
        bouton_dimanche_fermeture = (Button) view.findViewById(R.id.bouton_fermeture_dimanche);

        /*
        Happy Hours buttons

         */
        bouton_happy_hours_debut = (Button) view.findViewById(R.id.bouton_happy_hours_debut);
        bouton_happy_hours_fin = (Button) view.findViewById(R.id.bouton_happy_hours_fin);

        bouton_mardi_debuthh = (Button) view.findViewById(R.id.bouton_debuthh_mardi);
        bouton_mardi_finhh = (Button) view.findViewById(R.id.bouton_finhh_mardi);

        bouton_mercredi_debuthh = (Button) view.findViewById(R.id.bouton_debuthh_mercredi);
        bouton_mercredi_finhh = (Button) view.findViewById(R.id.bouton_finhh_mercredi);

        bouton_jeudi_debuthh = (Button) view.findViewById(R.id.bouton_debuthh_jeudi);
        bouton_jeudi_finhh = (Button) view.findViewById(R.id.bouton_finhh_jeudi);

        bouton_vendredi_debuthh = (Button) view.findViewById(R.id.bouton_debuthh_vendredi);
        bouton_vendredi_finhh = (Button) view.findViewById(R.id.bouton_finhh_vendredi);

        bouton_samedi_debuthh = (Button) view.findViewById(R.id.bouton_debuthh_samedi);
        bouton_samedi_finhh = (Button) view.findViewById(R.id.bouton_finhh_samedi);

        bouton_dimanche_debuthh = (Button) view.findViewById(R.id.bouton_debuthh_dimanche);
        bouton_dimanche_finhh = (Button) view.findViewById(R.id.bouton_finhh_dimanche);

        /*
        Définitions des boutons
        Autres boutons : exception pour happy hours, récupération des infos d'un bar, modifier un bar

         */

        exception = (Button) view.findViewById(R.id.exception_hh);
        bouton_recup_bar = (Button) view.findViewById(R.id.recup_bar);
        modifier_bar = (Button) view.findViewById(R.id.modifier_bar);

        switch_terrasse = (Switch) view.findViewById(R.id.switch_terrasse);
        switch_sportif = (Switch) view.findViewById(R.id.switch_sportif);
        switch_conditionnement = (Switch) view.findViewById(R.id.switch_conditionnement);

        // Association des boutons aux listeners

        ajouter.setOnClickListener(bouton_ajout_bar);
        ajouter_biere.setOnClickListener(bouton_ajout_biere_bar);

        bouton_lundi_ouverture.setOnClickListener(button_time_monday_opening);
        bouton_lundi_fermeture.setOnClickListener(button_time_monday_closing);

        bouton_mardi_ouverture.setOnClickListener(button_time_tuesday_opening);
        bouton_mardi_fermeture.setOnClickListener(button_time_tuesday_closing);

        bouton_mercredi_ouverture.setOnClickListener(button_time_wednesday_opening);
        bouton_mercredi_fermeture.setOnClickListener(button_time_wednesday_closing);

        bouton_jeudi_ouverture.setOnClickListener(button_time_thursday_opening);
        bouton_jeudi_fermeture.setOnClickListener(button_time_thursday_closing);

        bouton_vendredi_ouverture.setOnClickListener(button_time_friday_opening);
        bouton_vendredi_fermeture.setOnClickListener(button_time_friday_closing);

        bouton_samedi_ouverture.setOnClickListener(button_time_saturday_opening);
        bouton_samedi_fermeture.setOnClickListener(button_time_saturday_closing);

        bouton_dimanche_ouverture.setOnClickListener(button_time_sunday_opening);
        bouton_dimanche_fermeture.setOnClickListener(button_time_sunday_closing);

        /*
            Association des boutons aux listeners pour Happy Hours
         */

        bouton_happy_hours_debut.setOnClickListener(button_time_happy_hours_beginning);
        bouton_happy_hours_fin.setOnClickListener(button_time_happy_hours_ending);

        bouton_mardi_debuthh.setOnClickListener(button_time_tuesday_beginninghh);
        bouton_mardi_finhh.setOnClickListener(button_time_tuesday_endinghh);

        bouton_mercredi_debuthh.setOnClickListener(button_time_wednesday_beginninghh);
        bouton_mercredi_finhh.setOnClickListener(button_time_wednesday_endinghh);

        bouton_jeudi_debuthh.setOnClickListener(button_time_thursday_beginninghh);
        bouton_jeudi_finhh.setOnClickListener(button_time_thursday_endinghh);

        bouton_vendredi_debuthh.setOnClickListener(button_time_friday_beginninghh);
        bouton_vendredi_finhh.setOnClickListener(button_time_friday_endinghh);

        bouton_samedi_debuthh.setOnClickListener(button_time_saturday_beginninghh);
        bouton_samedi_finhh.setOnClickListener(button_time_saturday_endinghh);

        bouton_dimanche_debuthh.setOnClickListener(button_time_sunday_beginninghh);
        bouton_dimanche_finhh.setOnClickListener(button_time_sunday_endinghh);


        bouton_recup_bar.setOnClickListener(button_getinfo_bar);
        modifier_bar.setOnClickListener(modify_bar);
        exception.setOnClickListener(bouton_exception);

        // Association des item cliqués des autocompletes aux listeners

        selection_biere.setOnItemClickListener(choix);
        selection_bar.setOnItemClickListener(choix_bar);
        recup_bar_autocomplete.setOnItemClickListener(choix_bar);

        // Définitions des 3 switchs : terrasse, sportif et conditionnement

        switch_terrasse.setTextOn(switchOn);
        switch_terrasse.setTextOff(switchOff);
        switch_terrasse.setChecked(true);
        switch_terrasse.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean bChecked) {
                if (bChecked) {
                    text_switch_terrasse.setText(switchOn);
                } else {
                    text_switch_terrasse.setText(switchOff);
                }
            }
        });

        if (switch_terrasse.isChecked()) {
            text_switch_terrasse.setText(switchOn);
        } else {
            text_switch_terrasse.setText(switchOff);
        }

        switch_sportif.setTextOn(switchOn);
        switch_sportif.setTextOff(switchOff);
        switch_sportif.setChecked(true);
        switch_sportif.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean bChecked) {
                if (bChecked) {
                    text_switch_sportif.setText(switchOn);
                } else {
                    text_switch_sportif.setText(switchOff);
                }
            }
        });

        if (switch_sportif.isChecked()) {
            text_switch_sportif.setText(switchOn);
        } else {
            text_switch_sportif.setText(switchOff);
        }

        switch_conditionnement.setTextOn(switchOn2);
        switch_conditionnement.setTextOff(switchOff2);
        switch_conditionnement.setChecked(true);
        switch_conditionnement.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean bChecked) {
                if (bChecked) {
                    text_switch_conditionnement.setText(switchOn2);
                } else {
                    text_switch_conditionnement.setText(switchOff2);
                }
            }
        });

        if (switch_sportif.isChecked()) {
            text_switch_conditionnement.setText(switchOn2);
        } else {
            text_switch_conditionnement.setText(switchOff2);
        }

        // Adapter de l'aucomplete de bière pour ajouter toutes les bières de la liste_bière

        ArrayAdapter<String> adapter_autocomplete_biere = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_dropdown_item_1line, liste_biere);
        selection_biere.setAdapter(adapter_autocomplete_biere);

        // Adapter de l'autocomplete de bar pour ajouter tous les bars de la liste_bar

        ArrayAdapter<String> adapter_autocomplete_bar = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_dropdown_item_1line, liste_bar);
        selection_bar.setAdapter(adapter_autocomplete_bar);

        // Adapter de l'autocomplete de bar à modifier avec la liste des bars : liste_bar

        ArrayAdapter<String> adapter_autocomplete_bar_modifier = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_dropdown_item_1line, liste_bar);
        recup_bar_autocomplete.setAdapter(adapter_autocomplete_bar_modifier);

        GooglePlacesAutocompleteAdapter googlePlacesAutocompleteAdapter = new GooglePlacesAutocompleteAdapter(this.getActivity(), R.layout.search_row);

        adresse_bar_ajout.setAdapter(googlePlacesAutocompleteAdapter);

        adresse_bar_ajout.setOnItemClickListener(this);
        return view;
    }

    public void onItemClick(AdapterView adapterView, View view, int position, long id) {
        String str = (String) adapterView.getItemAtPosition(position);
        Toast.makeText(getContext(), str, Toast.LENGTH_SHORT).show();
    }


    private View.OnClickListener bouton_exception = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            bouton_happy_hours_debut.setText("Lundi début HH");
            bouton_happy_hours_fin.setText("Lundi début HH");

            if(layouthh.getVisibility() == View.GONE) {
                layouthh.setVisibility(View.VISIBLE);
            }
            else
            {
                layouthh.setVisibility(View.GONE);
                bouton_happy_hours_debut.setText("Début Happy Hours");
                bouton_happy_hours_fin.setText("Fin Happy Hours");
            }
        }
    };

    // Listener du bouton pour ajouter les informations d'un bar
    // Insert les infos du bar dans la base de données

    private View.OnClickListener bouton_ajout_bar = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            ArrayList<PlageHoraire> plageHoraires_liste= new ArrayList<>();

            plageHoraires_liste.add(new PlageHoraire(horaire_lundi_ouverture.getText().toString(), horaire_lundi_fermeture.getText().toString()));
            plageHoraires_liste.add(new PlageHoraire(horaire_mardi_ouverture.getText().toString(), horaire_mardi_fermeture.getText().toString()));
            plageHoraires_liste.add(new PlageHoraire(horaire_mercredi_ouverture.getText().toString(), horaire_mercredi_fermeture.getText().toString()));
            plageHoraires_liste.add(new PlageHoraire(horaire_jeudi_ouverture.getText().toString(), horaire_jeudi_fermeture.getText().toString()));
            plageHoraires_liste.add(new PlageHoraire(horaire_vendredi_ouverture.getText().toString(), horaire_vendredi_fermeture.getText().toString()));
            plageHoraires_liste.add(new PlageHoraire(horaire_samedi_ouverture.getText().toString(), horaire_samedi_fermeture.getText().toString()));
            plageHoraires_liste.add(new PlageHoraire(horaire_dimanche_ouverture.getText().toString(), horaire_dimanche_fermeture.getText().toString()));
            plageHoraires_liste.add(new PlageHoraire(horaire_happy_hours_debut.getText().toString(), horaire_happy_hours_fin.getText().toString()));

            plageHoraires_liste.add(new PlageHoraire(horaire_mardi_debuthh.getText().toString(), horaire_mardi_finhh.getText().toString()));
            plageHoraires_liste.add(new PlageHoraire(horaire_mercredi_debuthh.getText().toString(), horaire_mercredi_finhh.getText().toString()));
            plageHoraires_liste.add(new PlageHoraire(horaire_jeudi_debuthh.getText().toString(), horaire_jeudi_finhh.getText().toString()));
            plageHoraires_liste.add(new PlageHoraire(horaire_vendredi_debuthh.getText().toString(), horaire_vendredi_finhh.getText().toString()));
            plageHoraires_liste.add(new PlageHoraire(horaire_samedi_debuthh.getText().toString(), horaire_samedi_finhh.getText().toString()));
            plageHoraires_liste.add(new PlageHoraire(horaire_dimanche_debuthh.getText().toString(), horaire_dimanche_finhh.getText().toString()));


            bar = new Bar(nom_bar_ajout.getText().toString(), style_bar_ajout.getText().toString(), style_bar_ajout2.getText().toString(), style_bar_ajout3.getText().toString(), adresse_bar_ajout.getText().toString(), text_switch_terrasse.getText().toString(), text_switch_sportif.getText().toString(), plageHoraires_liste);

            new insertinfoTask().execute(new ApiConnector(getContext()));
        }
    };

    // Listener du bouton pour ajouter une bière à un bar
    // Insert les infos de la bière dans le bar choisit dans la base de données

    private View.OnClickListener bouton_ajout_biere_bar = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            biere = new Biere(prix_hors_happy_hours.getText().toString(), prix_happy_hours.getText().toString(), text_switch_conditionnement.getText().toString());
            new insertinfoBiereTask().execute(new ApiConnector(getContext()));

        }
    };

    // Listener du bouton pour récupérer les infos du bar choisi

    private View.OnClickListener button_getinfo_bar = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            new GetAllBarsTask2().execute(new ApiConnector(getContext()));
        }
    };

    // Listener du bouton modifier un bar lorsque l'on a récupérer les informations

    private View.OnClickListener modify_bar = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            ArrayList<PlageHoraire> plageHoraires_liste= new ArrayList<>();

            plageHoraires_liste.add(new PlageHoraire(horaire_lundi_ouverture.getText().toString(), horaire_lundi_fermeture.getText().toString()));
            plageHoraires_liste.add(new PlageHoraire(horaire_mardi_ouverture.getText().toString(), horaire_mardi_fermeture.getText().toString()));
            plageHoraires_liste.add(new PlageHoraire(horaire_mercredi_ouverture.getText().toString(), horaire_mercredi_fermeture.getText().toString()));
            plageHoraires_liste.add(new PlageHoraire(horaire_jeudi_ouverture.getText().toString(), horaire_jeudi_fermeture.getText().toString()));
            plageHoraires_liste.add(new PlageHoraire(horaire_vendredi_ouverture.getText().toString(), horaire_vendredi_fermeture.getText().toString()));
            plageHoraires_liste.add(new PlageHoraire(horaire_samedi_ouverture.getText().toString(), horaire_samedi_fermeture.getText().toString()));
            plageHoraires_liste.add(new PlageHoraire(horaire_dimanche_ouverture.getText().toString(), horaire_dimanche_fermeture.getText().toString()));
            plageHoraires_liste.add(new PlageHoraire(horaire_happy_hours_debut.getText().toString(), horaire_happy_hours_fin.getText().toString()));

                plageHoraires_liste.add(new PlageHoraire(horaire_mardi_debuthh.getText().toString(), horaire_mardi_finhh.getText().toString()));
                plageHoraires_liste.add(new PlageHoraire(horaire_mercredi_debuthh.getText().toString(), horaire_mercredi_finhh.getText().toString()));
                plageHoraires_liste.add(new PlageHoraire(horaire_jeudi_debuthh.getText().toString(), horaire_jeudi_finhh.getText().toString()));
                plageHoraires_liste.add(new PlageHoraire(horaire_vendredi_debuthh.getText().toString(), horaire_vendredi_finhh.getText().toString()));
                plageHoraires_liste.add(new PlageHoraire(horaire_samedi_debuthh.getText().toString(), horaire_samedi_finhh.getText().toString()));
                plageHoraires_liste.add(new PlageHoraire(horaire_dimanche_debuthh.getText().toString(), horaire_dimanche_finhh.getText().toString()));



            bar = new Bar(nom_bar_ajout.getText().toString(), style_bar_ajout.getText().toString(), style_bar_ajout2.getText().toString(), style_bar_ajout3.getText().toString(), adresse_bar_ajout.getText().toString(), text_switch_terrasse.getText().toString(), text_switch_sportif.getText().toString(), plageHoraires_liste);

            new modifyBarTask().execute(new ApiConnector(getContext()));

        }
    };

    // Listeners de tous les boutons horaires

    private View.OnClickListener button_time_monday_opening = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            button_timepicker = 1;
            DialogFragment newFragment = new TimePickerFragment();
            newFragment.show(getActivity().getFragmentManager(), "TimePicker");
        }
    };

    private View.OnClickListener button_time_monday_closing = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            button_timepicker = 2;
            DialogFragment newFragment1 = new TimePickerFragment();
            newFragment1.show(getActivity().getFragmentManager(), "TimePicker");
        }
    };

    private View.OnClickListener button_time_tuesday_opening = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            button_timepicker = 3;
            DialogFragment newFragment = new TimePickerFragment();
            newFragment.show(getActivity().getFragmentManager(),"TimePicker");
        }
    };

    private View.OnClickListener button_time_tuesday_closing = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            button_timepicker = 4;
            DialogFragment newFragment = new TimePickerFragment();
            newFragment.show(getActivity().getFragmentManager(),"TimePicker");
        }
    };

    private View.OnClickListener button_time_wednesday_opening = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            button_timepicker = 5;
            DialogFragment newFragment = new TimePickerFragment();
            newFragment.show(getActivity().getFragmentManager(),"TimePicker");
        }
    };

    private View.OnClickListener button_time_wednesday_closing = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            button_timepicker = 6;
            DialogFragment newFragment = new TimePickerFragment();
            newFragment.show(getActivity().getFragmentManager(),"TimePicker");
        }
    };

    private View.OnClickListener button_time_thursday_opening = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            button_timepicker = 7;
            DialogFragment newFragment = new TimePickerFragment();
            newFragment.show(getActivity().getFragmentManager(),"TimePicker");
        }
    };

    private View.OnClickListener button_time_thursday_closing = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            button_timepicker = 8;
            DialogFragment newFragment = new TimePickerFragment();
            newFragment.show(getActivity().getFragmentManager(),"TimePicker");
        }
    };

    private View.OnClickListener button_time_friday_opening = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            button_timepicker = 9;
            DialogFragment newFragment = new TimePickerFragment();
            newFragment.show(getActivity().getFragmentManager(),"TimePicker");
        }
    };

    private View.OnClickListener button_time_friday_closing = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            button_timepicker = 10;
            DialogFragment newFragment = new TimePickerFragment();
            newFragment.show(getActivity().getFragmentManager(),"TimePicker");
        }
    };

    private View.OnClickListener button_time_saturday_opening = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            button_timepicker = 11;
            DialogFragment newFragment = new TimePickerFragment();
            newFragment.show(getActivity().getFragmentManager(),"TimePicker");
        }
    };

    private View.OnClickListener button_time_saturday_closing = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            button_timepicker = 12;
            DialogFragment newFragment = new TimePickerFragment();
            newFragment.show(getActivity().getFragmentManager(),"TimePicker");
        }
    };

    private View.OnClickListener button_time_sunday_opening = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            button_timepicker = 13;
            DialogFragment newFragment = new TimePickerFragment();
            newFragment.show(getActivity().getFragmentManager(),"TimePicker");
        }
    };

    private View.OnClickListener button_time_sunday_closing = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            button_timepicker = 14;
            DialogFragment newFragment = new TimePickerFragment();
            newFragment.show(getActivity().getFragmentManager(),"TimePicker");
        }
    };


    private View.OnClickListener button_time_happy_hours_beginning = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            button_timepicker = 15;
            DialogFragment newFragment = new TimePickerFragment();
            newFragment.show(getActivity().getFragmentManager(),"TimePicker");
        }
    };


    /*
    Définitions des Listeners pour les boutons des Happy Hours

     */
    private View.OnClickListener button_time_happy_hours_ending = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            button_timepicker = 16;
            DialogFragment newFragment = new TimePickerFragment();
            newFragment.show(getActivity().getFragmentManager(),"TimePicker");
        }
    };

    private View.OnClickListener button_time_tuesday_beginninghh = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            button_timepicker = 17;
            DialogFragment newFragment = new TimePickerFragment();
            newFragment.show(getActivity().getFragmentManager(),"TimePicker");
        }
    };

    private View.OnClickListener button_time_tuesday_endinghh = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            button_timepicker = 18;
            DialogFragment newFragment = new TimePickerFragment();
            newFragment.show(getActivity().getFragmentManager(),"TimePicker");
        }
    };

    private View.OnClickListener button_time_wednesday_beginninghh = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            button_timepicker = 19;
            DialogFragment newFragment = new TimePickerFragment();
            newFragment.show(getActivity().getFragmentManager(),"TimePicker");
        }
    };

    private View.OnClickListener button_time_wednesday_endinghh = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            button_timepicker = 20;
            DialogFragment newFragment = new TimePickerFragment();
            newFragment.show(getActivity().getFragmentManager(),"TimePicker");
        }
    };

    private View.OnClickListener button_time_thursday_beginninghh = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            button_timepicker = 21;
            DialogFragment newFragment = new TimePickerFragment();
            newFragment.show(getActivity().getFragmentManager(),"TimePicker");
        }
    };

    private View.OnClickListener button_time_thursday_endinghh = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            button_timepicker = 22;
            DialogFragment newFragment = new TimePickerFragment();
            newFragment.show(getActivity().getFragmentManager(),"TimePicker");
        }
    };

    private View.OnClickListener button_time_friday_beginninghh = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            button_timepicker = 23;
            DialogFragment newFragment = new TimePickerFragment();
            newFragment.show(getActivity().getFragmentManager(),"TimePicker");
        }
    };

    private View.OnClickListener button_time_friday_endinghh = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            button_timepicker = 24;
            DialogFragment newFragment = new TimePickerFragment();
            newFragment.show(getActivity().getFragmentManager(),"TimePicker");
        }
    };

    private View.OnClickListener button_time_saturday_beginninghh = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            button_timepicker = 25;
            DialogFragment newFragment = new TimePickerFragment();
            newFragment.show(getActivity().getFragmentManager(),"TimePicker");
        }
    };

    private View.OnClickListener button_time_saturday_endinghh = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            button_timepicker = 26;
            DialogFragment newFragment = new TimePickerFragment();
            newFragment.show(getActivity().getFragmentManager(),"TimePicker");
        }
    };

    private View.OnClickListener button_time_sunday_beginninghh = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            button_timepicker = 27;
            DialogFragment newFragment = new TimePickerFragment();
            newFragment.show(getActivity().getFragmentManager(),"TimePicker");
        }
    };

    private View.OnClickListener button_time_sunday_endinghh = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            button_timepicker = 28;
            DialogFragment newFragment = new TimePickerFragment();
            newFragment.show(getActivity().getFragmentManager(),"TimePicker");
        }
    };


    // Créer deux button time exception en caché et si clique sur excetpion affichés

    // Listener sur l'item cliquée qui récupère l'ID de la bière sélectionnée dans l'autocomplete textview de bière

    private AdapterView.OnItemClickListener choix = new AdapterView.OnItemClickListener() {

        @Override
        public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
            String tmp;
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

    // Listener sur l'item cliquée qui récupère l'ID du bar sélectionné dans l'autocomplete textview de bar

    private AdapterView.OnItemClickListener choix_bar = new AdapterView.OnItemClickListener() {

        @Override
        public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
            String tmp;
            autocomplete_clicked = 1;
            tmp = arg0.getItemAtPosition(arg2).toString();

            json_bar_tmp = mHashMap_bar.get(tmp);
            try {
                id_bar_voulue = json_bar_tmp.getString("idBar");
            } catch (JSONException e) {
                e.printStackTrace();
            }

            InputMethodManager in = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
            in.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), 0);
        }

    };

    // Récupère le nom de toutes les bières présentent dans la base de données et les placent dans une liste list_bière

    public void setBeersInArray(JSONArray jsonArray)
    {
        for(int i = 0; i < jsonArray.length(); i++) {
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

    // Récupère le nom de toutes les bars présent dans la base de données et les placent dans une liste list_bars

    public void setBarsInArray(JSONArray jsonArray)
    {
        for(int i = 0; i < jsonArray.length(); i++) {
            try {
                json_bar = jsonArray.getJSONObject(i);

                nom_bar = json_bar.getString("nom_bar");

                liste_bar.add(nom_bar);

                mHashMap_bar.put(nom_bar, json_bar);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    // Récupère toutes les infos d'un bar

    public void Replace_info_bar (JSONArray jsonArray)
    {
        Log.d(TAG, "MOULASS : " + jsonArray);
        for(int i = 0; i < jsonArray.length(); i++) {
            try {
                json_bar = jsonArray.getJSONObject(i);

                nom_bar_ajout.setText(json_bar.getString("nom_bar"));
                adresse_bar_ajout.setText(json_bar.getString("adresse"));
                style_bar_ajout.setText(json_bar.getString("style"));
                style_bar_ajout2.setText(json_bar.getString("ambiance2"));
                style_bar_ajout3.setText(json_bar.getString("ambiance3"));

                if(json_bar.getString("sportif").equals("Oui"))
                {
                    text_switch_sportif.setText(switchOn);
                    switch_sportif.setChecked(true);
                } else {
                    text_switch_sportif.setText(switchOff);
                    switch_sportif.setChecked(false);
                }

                if (json_bar.getString("terrasse").equals("Oui")) {
                    text_switch_terrasse.setText(switchOn);
                    switch_terrasse.setChecked(true);
                } else {
                    text_switch_terrasse.setText(switchOff);
                    switch_terrasse.setChecked(false);
                }

                horaire_lundi_ouverture.setText(json_bar.getString("horaire_lundi_ouverture"));
                horaire_lundi_fermeture.setText(json_bar.getString("horaire_lundi_fermeture"));

                horaire_mardi_ouverture.setText(json_bar.getString("horaire_mardi_ouverture"));
                horaire_mardi_fermeture.setText(json_bar.getString("horaire_mardi_fermeture"));

                horaire_mercredi_ouverture.setText(json_bar.getString("horaire_mercredi_ouverture"));
                horaire_mercredi_fermeture.setText(json_bar.getString("horaire_mercredi_fermeture"));

                horaire_jeudi_ouverture.setText(json_bar.getString("horaire_jeudi_ouverture"));
                horaire_jeudi_fermeture.setText(json_bar.getString("horaire_jeudi_fermeture"));

                horaire_vendredi_ouverture.setText(json_bar.getString("horaire_vendredi_ouverture"));
                horaire_vendredi_fermeture.setText(json_bar.getString("horaire_vendredi_fermeture"));

                horaire_samedi_ouverture.setText(json_bar.getString("horaire_samedi_ouverture"));
                horaire_samedi_fermeture.setText(json_bar.getString("horaire_samedi_fermeture"));

                horaire_dimanche_ouverture.setText(json_bar.getString("horaire_dimanche_ouverture"));
                horaire_dimanche_fermeture.setText(json_bar.getString("horaire_dimanche_fermeture"));

                horaire_happy_hours_debut.setText(json_bar.getString("happy_hours_debut"));
                horaire_happy_hours_fin.setText(json_bar.getString("happy_hours_fin"));

                horaire_mardi_debuthh.setText(json_bar.getString("horaire_mardi_debuthh"));
                horaire_mardi_finhh.setText((json_bar.getString("horaire_mardi_finhh")));

                horaire_mercredi_debuthh.setText(json_bar.getString("horaire_mercredi_debuthh"));
                horaire_mercredi_finhh.setText((json_bar.getString("horaire_mercredi_finhh")));

                horaire_jeudi_debuthh.setText(json_bar.getString("horaire_jeudi_debuthh"));
                horaire_jeudi_finhh.setText((json_bar.getString("horaire_jeudi_finhh")));

                horaire_vendredi_debuthh.setText(json_bar.getString("horaire_vendredi_debuthh"));
                horaire_vendredi_finhh.setText((json_bar.getString("horaire_vendredi_finhh")));

                horaire_samedi_debuthh.setText(json_bar.getString("horaire_samedi_debuthh"));
                horaire_samedi_finhh.setText((json_bar.getString("horaire_samedi_finhh")));

                horaire_dimanche_debuthh.setText(json_bar.getString("horaire_dimanche_debuthh"));
                horaire_dimanche_finhh.setText((json_bar.getString("horaire_dimanche_finhh")));

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    // AsyncTask pour insérer toutes les informations du bar

    private class insertinfoTask extends AsyncTask<ApiConnector, Long, String>
    {
        @Override
        protected void onPreExecute()
        {
            progressDialog = new ProgressDialog(getActivity());
            progressDialog.setTitle("Loading...");
            progressDialog.setMessage("Please wait...");
            progressDialog.setCancelable(false);
            progressDialog.setIndeterminate(false);
            progressDialog.show();
        }
        @Override
        protected String doInBackground(ApiConnector... params) {

            return params[0].insertInfoToServer(bar);
        }

        @Override
        protected void onPostExecute(String result) {

            progressDialog.dismiss();
            Toast.makeText(getContext(), result, Toast.LENGTH_LONG).show();

            nom_bar_ajout.getText().clear();
            style_bar_ajout.getText().clear();
            style_bar_ajout2.getText().clear();
            style_bar_ajout3.getText().clear();
            adresse_bar_ajout.getText().clear();

            text_switch_terrasse.setText(switchOn);
            text_switch_sportif.setText(switchOn);
            switch_terrasse.setChecked(true);
            switch_sportif.setChecked(true);

            horaire_lundi_ouverture.setText(null);
            horaire_lundi_fermeture.setText(null);
            horaire_mardi_ouverture.setText(null);
            horaire_mardi_fermeture.setText(null);
            horaire_mercredi_ouverture.setText(null);
            horaire_mercredi_fermeture.setText(null);
            horaire_jeudi_ouverture.setText(null);
            horaire_jeudi_fermeture.setText(null);
            horaire_vendredi_ouverture.setText(null);
            horaire_vendredi_fermeture.setText(null);
            horaire_samedi_ouverture.setText(null);
            horaire_samedi_fermeture.setText(null);
            horaire_dimanche_ouverture.setText(null);
            horaire_dimanche_fermeture.setText(null);
            horaire_happy_hours_debut.setText(null);
            horaire_happy_hours_fin.setText(null);
            horaire_mardi_debuthh.setText(null);
            horaire_mardi_finhh.setText(null);
            horaire_mercredi_debuthh.setText(null);
            horaire_mercredi_finhh.setText(null);
            horaire_jeudi_debuthh.setText(null);
            horaire_jeudi_finhh.setText(null);
            horaire_vendredi_debuthh.setText(null);
            horaire_vendredi_finhh.setText(null);
            horaire_samedi_debuthh.setText(null);
            horaire_samedi_finhh.setText(null);
            horaire_dimanche_debuthh.setText(null);
            horaire_dimanche_finhh.setText(null);

            layouthh.setVisibility(View.GONE);

        }
    }

    // AsyncTask pour récupérer toutes les bières

    private class GetAllBeersTask extends AsyncTask<ApiConnector, Long, JSONArray>
    {
        @Override
        protected void onPreExecute()
        {
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
            progressDialog.dismiss();
            setBeersInArray(jsonArray);
        }
    }

    // AsyncTask pour récupérer tous les bars

    private class GetAllBarsTask extends AsyncTask<ApiConnector, Long, JSONArray>
    {
        @Override
        protected void onPreExecute()
        {
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
                return params[0].GetAllBars();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(JSONArray jsonArray) {
            progressDialog.dismiss();
            setBarsInArray(jsonArray);
            new GetAllBeersTask().execute(new ApiConnector(getContext()));
        }
    }

    // AsyncTask pour récupérer les informations du bar choisi grâce à son ID

    private class GetAllBarsTask2 extends AsyncTask<ApiConnector, Long, JSONArray>
    {
        @Override
        protected void onPreExecute()
        {
            progressDialog = new ProgressDialog(getActivity());
            progressDialog.setTitle("Loading...");
            progressDialog.setMessage("Please wait...");
            progressDialog.setCancelable(false);
            progressDialog.setIndeterminate(false);
            progressDialog.show();
        }

        @Override
        protected JSONArray doInBackground(ApiConnector... params) {

            int id_bar_voulue_int = Integer.valueOf(id_bar_voulue);

            return params[0].GetBarByID(id_bar_voulue_int);
        }

        @Override
        protected void onPostExecute(JSONArray jsonArray) {
            progressDialog.dismiss();
            Replace_info_bar(jsonArray);
            recup_bar_autocomplete.clearComposingText();
        }
    }

    // AsyncTask pour ajouter une bière à un bar avec son prix en et hors happy hour et ainsi que le conditionnement

    private class insertinfoBiereTask extends AsyncTask<ApiConnector, Long, String>
    {
        @Override
        protected void onPreExecute()
        {
            progressDialog = new ProgressDialog(getActivity());
            progressDialog.setTitle("Loading...");
            progressDialog.setMessage("Please wait...");
            progressDialog.setCancelable(false);
            progressDialog.setIndeterminate(false);
            progressDialog.show();
        }

        @Override
        protected String doInBackground(ApiConnector... params) {

            return params[0].insertBiereToServer(biere, id_bar_voulue, id_biere_voulue);
        }

        @Override
        protected void onPostExecute(String result) {
            progressDialog.dismiss();
            Toast.makeText(getContext(), result, Toast.LENGTH_LONG).show();
            selection_bar.setText("");
            selection_biere.setText("");
            prix_happy_hours.getText().clear();
            prix_hors_happy_hours.getText().clear();
            text_switch_conditionnement.setText(switchOn2);
            switch_conditionnement.setChecked(true);
        }
    }

    private class modifyBarTask extends AsyncTask<ApiConnector, Long, String>
    {
        @Override
        protected void onPreExecute()
        {
            progressDialog = new ProgressDialog(getActivity());
            progressDialog.setTitle("Loading...");
            progressDialog.setMessage("Please wait...");
            progressDialog.setCancelable(false);
            progressDialog.setIndeterminate(false);
            progressDialog.show();
        }

        @Override
        protected String doInBackground(ApiConnector... params) {

            return params[0].modifyBarToServer(bar, id_bar_voulue);
        }

        @Override
        protected void onPostExecute(String result) {
            progressDialog.dismiss();
            Toast.makeText(getContext(), result, Toast.LENGTH_LONG).show();
            nom_bar_ajout.getText().clear();
            style_bar_ajout.getText().clear();
            style_bar_ajout2.getText().clear();
            style_bar_ajout3.getText().clear();
            adresse_bar_ajout.getText().clear();

            text_switch_terrasse.setText(switchOn);
            text_switch_sportif.setText(switchOn);
            switch_terrasse.setChecked(true);
            switch_sportif.setChecked(true);

            horaire_lundi_ouverture.setText(null);
            horaire_lundi_fermeture.setText(null);
            horaire_mardi_ouverture.setText(null);
            horaire_mardi_fermeture.setText(null);
            horaire_mercredi_ouverture.setText(null);
            horaire_mercredi_fermeture.setText(null);
            horaire_jeudi_ouverture.setText(null);
            horaire_jeudi_fermeture.setText(null);
            horaire_vendredi_ouverture.setText(null);
            horaire_vendredi_fermeture.setText(null);
            horaire_samedi_ouverture.setText(null);
            horaire_samedi_fermeture.setText(null);
            horaire_dimanche_ouverture.setText(null);
            horaire_dimanche_fermeture.setText(null);
            horaire_happy_hours_debut.setText(null);
            horaire_happy_hours_fin.setText(null);
            horaire_mardi_debuthh.setText(null);
            horaire_mardi_finhh.setText(null);
            horaire_mercredi_debuthh.setText(null);
            horaire_mercredi_finhh.setText(null);
            horaire_jeudi_debuthh.setText(null);
            horaire_jeudi_finhh.setText(null);
            horaire_vendredi_debuthh.setText(null);
            horaire_vendredi_finhh.setText(null);
            horaire_samedi_debuthh.setText(null);
            horaire_samedi_finhh.setText(null);
            horaire_dimanche_debuthh.setText(null);
            horaire_dimanche_finhh.setText(null);

            recup_bar_autocomplete.setText("");

            layouthh.setVisibility(View.GONE);
        }
    }

    // AUTOCOMPLETE API GOOGLE PLACES

    public static ArrayList autocomplete(String input) {
        ArrayList<String> queryResults = new ArrayList<String>(); // new list

        HttpURLConnection conn = null;
        StringBuilder jsonResults = new StringBuilder();
        try {
            StringBuilder sb = new StringBuilder(PLACES_API_BASE + TYPE_AUTOCOMPLETE + OUT_JSON);
            sb.append("?key=" + API_KEY);
            sb.append("&components=country:fr");
            sb.append("&input=" + URLEncoder.encode(input, "utf8"));

            URL url = new URL(sb.toString());
            conn = (HttpURLConnection) url.openConnection();
            InputStreamReader in = new InputStreamReader(conn.getInputStream());

            // Load the results into a StringBuilder
            int read;
            char[] buff = new char[1024];
            while ((read = in.read(buff)) != -1) {
                jsonResults.append(buff, 0, read);
            }
        } catch (MalformedURLException e) {
            return queryResults;
        } catch (IOException e) {
            return queryResults;
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }

        try {
            // Create a JSON object hierarchy from the results
            JSONObject jsonObj = new JSONObject(jsonResults.toString());
            JSONArray predsJsonArray = jsonObj.getJSONArray("predictions");

            // Extract the Place descriptions from the results
            queryResults = new ArrayList(predsJsonArray.length());
            for (int i = 0; i < predsJsonArray.length(); i++) {
                System.out.println(predsJsonArray.getJSONObject(i).getString("description"));
                System.out.println("============================================================");
                queryResults.add(predsJsonArray.getJSONObject(i).getString("description"));
            }
        } catch (JSONException e) {
        }

        return queryResults;
    }

    class GooglePlacesAutocompleteAdapter extends ArrayAdapter implements Filterable {
        private ArrayList resultList;

        public GooglePlacesAutocompleteAdapter(Context context, int textViewResourceId) {
            super(context, textViewResourceId);
        }

        @Override
        public int getCount() {
            return resultList.size();
        }

        @Override
        public String getItem(int index) {
            return (String) resultList.get(index);
        }

        @Override
        public Filter getFilter() {
            Filter filter = new Filter() {
                @Override
                protected FilterResults performFiltering(CharSequence constraint) {
                    FilterResults filterResults = new FilterResults();
                    ArrayList<String> queryResults;
                    if (constraint != null || constraint.length() == 0) {
//                        try {
//                            wait(750);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
                        try {
                            Thread.sleep(1000);
                        }
                        catch (InterruptedException e)
                        {
                            e.printStackTrace();
                        }
                        queryResults = autocomplete(constraint.toString());
                    } else {
                        queryResults = new ArrayList<String>(); // empty list/no suggestions showing if there's no valid constraint
                    }
                        // Assign the data to the FilterResults
                        filterResults.values = queryResults;
                        filterResults.count = queryResults.size();
                    return filterResults;
                }

                @Override
                protected void publishResults(CharSequence constraint, FilterResults results) {
                    resultList = (ArrayList<String>)results.values;
                    if (results.count > 0) {
                       notifyDataSetChanged();
                    } else {
                        notifyDataSetInvalidated();
                    }
                }
            };
            return filter;
        }
    }
}
