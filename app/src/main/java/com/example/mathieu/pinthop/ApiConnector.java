package com.example.mathieu.pinthop;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Base64;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.net.ssl.HttpsURLConnection;


/**
 * Created by Mathieu on 24/02/2016.
 */
public class ApiConnector {

    private static final String TAG = "myApp";

    Context mContext;
    public ApiConnector(Context mContext) {
        this.mContext = mContext;
    }

    public JSONArray GetBarByID(int ID_bar_recup) {

        String url = "http://pinthop.com/Prod/getBarByID.php?BarID="+ID_bar_recup;
        InputStream response = null;

        Log.d(TAG, "ID DU GROS BAR : " + ID_bar_recup);

        try {
            URLConnection connection = new URL(url).openConnection();
            String mdp = "rpnGbdCDLiE1";
            String username = "mathieu";

            String userpassword = username + ":" + mdp;

            byte[] data = userpassword.getBytes("UTF-8");
            String base64 = Base64.encodeToString(data, Base64.DEFAULT);
            connection.setRequestProperty("Authorization", "Basic "+ base64);
            response = connection.getInputStream();

        } catch (IOException e) {
            e.printStackTrace();
        }

        JSONArray jsonArray = null;

        if(response != null)
        {
            try
            {
                Log.d(TAG, "jsonArray avant converson " + jsonArray);

                String entityResponse = convertStreamToString(response);
                Log.d(TAG, "jsonArray a entity response: " + entityResponse);

                jsonArray = new JSONArray(entityResponse);
                Log.d(TAG, "jsonArray après son constructeur dans getbarbyID: " + jsonArray);
            }
            catch(JSONException e)
            {
                e.printStackTrace();
            }
        }

        Log.d(TAG, "jsonArray apvant detre envoyé: " + jsonArray);
        return jsonArray;
    }
    public JSONArray GetAllBars() throws MalformedURLException {
//        String url = "http://pinthop.com/getAllBars.php";
        InputStream response = null;

        HttpURLConnection conn = null;
        URL url = new URL("http://pinthop.com/Prod/getAllBars.php");
        try
        {
            conn = (HttpURLConnection) url.openConnection();
            String mdp = "rpnGbdCDLiE1";
            String username = "mathieu";

            String userpassword = username + ":" + mdp;

            byte[] data = userpassword.getBytes("UTF-8");
            String base64 = Base64.encodeToString(data, Base64.DEFAULT);
            conn.setRequestProperty("Authorization", "Basic "+ base64);
            conn.connect();
            response = conn.getInputStream();

        } catch (IOException e) {
            e.printStackTrace();
        }

        JSONArray jsonArray = null;

        if(response != null)
        {
            try
            {
                Log.d(TAG, "Response pour getAllBars : " + response);

                String entityResponse = convertStreamToString(response);

                Log.d(TAG, "Response pour getAllBars : " + entityResponse);

                jsonArray = new JSONArray(entityResponse);

            }
            catch(JSONException e)
            {
                e.printStackTrace();
            }

        }

        try {
            response.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        conn.disconnect();
        return jsonArray;
    }

    public JSONArray GetAllBeers() throws MalformedURLException {
//        String url = "http://pinthop.com/getAllBeers.php";
        URL url = new URL("http://pinthop.com/Prod/getAllBeers.php");
        HttpURLConnection conn = null;

        InputStream response = null;

        try {
            conn = (HttpURLConnection) url.openConnection();

            String mdp = "rpnGbdCDLiE1";
            String username = "mathieu";

            String userpassword = username + ":" + mdp;

            byte[] data = userpassword.getBytes("UTF-8");
            String base64 = Base64.encodeToString(data, Base64.DEFAULT);
            conn.setRequestProperty("Authorization", "Basic "+ base64);
            conn.connect();
            response = conn.getInputStream();

        } catch (IOException e) {
            e.printStackTrace();
        }
        JSONArray jsonArray = null;

        if(response != null)
        {
            try
            {
                String entityResponse = convertStreamToString(response);
                jsonArray = new JSONArray(entityResponse);
            }
            catch(JSONException e)
            {
                e.printStackTrace();
            }
        }
        try {
            response.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        conn.disconnect();
        return jsonArray;
    }

    public JSONArray GetBeerSell(int ID_biere_recup)
    {
        Log.d(TAG, "ID DU GROS BAR DU cul " + ID_biere_recup);

        String url = "http://pinthop.com/Prod/getBeerSell.php?BiereID="+ID_biere_recup;
        InputStream response = null;

        try {
            URLConnection connection = new URL(url).openConnection();
            String mdp = "rpnGbdCDLiE1";
            String username = "mathieu";

            String userpassword = username + ":" + mdp;

            byte[] data = userpassword.getBytes("UTF-8");
            String base64 = Base64.encodeToString(data, Base64.DEFAULT);
            connection.setRequestProperty("Authorization", "Basic "+ base64);
            response = connection.getInputStream();

            Log.d(TAG, "Response du cul " + response);

        } catch (IOException e) {
            e.printStackTrace();
        }

        JSONArray jsonArray = null;

        if(response != null)
        {
            try
            {
                String entityResponse = convertStreamToString(response);
                Log.d(TAG, "jsonArray a entity response: " + entityResponse);

                jsonArray = new JSONArray(entityResponse);
                Log.d(TAG, "jsonArray du CUL " + jsonArray);


            }
            catch(JSONException e)
            {
                e.printStackTrace();
            }
        }

        return jsonArray;
    }

    public JSONArray GetBarSells(int ID_bar_recup)
    {
        String url = "http://pinthop.com/Prod/getBarSells.php?BarID="+ID_bar_recup;
        InputStream response = null;

        try {
            URLConnection connection = new URL(url).openConnection();
            String mdp = "rpnGbdCDLiE1";
            String username = "mathieu";

            String userpassword = username + ":" + mdp;

            byte[] data = userpassword.getBytes("UTF-8");
            String base64 = Base64.encodeToString(data, Base64.DEFAULT);
            connection.setRequestProperty("Authorization", "Basic "+ base64);
            response = connection.getInputStream();

        } catch (IOException e) {
            e.printStackTrace();
        }

        JSONArray jsonArray = null;

        if(response != null)
        {
            try
            {
                String entityResponse = convertStreamToString(response);

                jsonArray = new JSONArray(entityResponse);
            }
            catch(JSONException e)
            {
                e.printStackTrace();
            }
        }

        return jsonArray;
    }



    public String insertInfoToServer(Bar bar) {

        String nom_bar = bar.getNom_bar();
        String style = bar.getStyle();
        String adresse = bar.getAdresse();
        String style_deux = bar.getStyle2();
        String style_trois = bar.getStyle3();
        String switch_terrasse = bar.getTerrasse();
        String switch_sportif = bar.getSportif();

        String contentAsString = null;

        Date inputDate_lundi_ouverture = null;
        Date inputDate_lundi_fermeture = null;

        Date inputDate_mardi_ouverture = null;
        Date inputDate_mardi_fermeture = null;

        Date inputDate_mercredi_ouverture = null;
        Date inputDate_mercredi_fermeture = null;

        Date inputDate_jeudi_ouverture = null;
        Date inputDate_jeudi_fermeture = null;

        Date inputDate_vendredi_ouverture = null;
        Date inputDate_vendredi_fermeture = null;

        Date inputDate_samedi_ouverture = null;
        Date inputDate_samedi_fermeture = null;

        Date inputDate_dimanche_ouverture = null;
        Date inputDate_dimanche_fermeture = null;

        Date inputDate_happy_hours_debut = null;
        Date inputDate_happy_hours_fin = null;

        Date inputDate_mardi_debuthh = null;
        Date inputDate_mardi_finhh = null;

        Date inputDate_mercredi_debuthh = null;
        Date inputDate_mercredi_finhh = null;

        Date inputDate_jeudi_debuthh = null;
        Date inputDate_jeudi_finhh = null;

        Date inputDate_vendredi_debuthh = null;
        Date inputDate_vendredi_finhh = null;

        Date inputDate_samedi_debuthh = null;
        Date inputDate_samedi_finhh = null;

        Date inputDate_dimanche_debuthh = null;
        Date inputDate_dimanche_finhh = null;


        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
        try {

            inputDate_lundi_ouverture = simpleDateFormat.parse(bar.getHoraires().get(0).getOuverture());
            inputDate_lundi_fermeture = simpleDateFormat.parse(bar.getHoraires().get(0).getFermeture());

            inputDate_mardi_ouverture = simpleDateFormat.parse(bar.getHoraires().get(1).getOuverture());
            inputDate_mardi_fermeture = simpleDateFormat.parse(bar.getHoraires().get(1).getFermeture());

            inputDate_mercredi_ouverture = simpleDateFormat.parse(bar.getHoraires().get(2).getOuverture());
            inputDate_mercredi_fermeture = simpleDateFormat.parse(bar.getHoraires().get(2).getFermeture());

            inputDate_jeudi_ouverture = simpleDateFormat.parse(bar.getHoraires().get(3).getOuverture());
            inputDate_jeudi_fermeture = simpleDateFormat.parse(bar.getHoraires().get(3).getFermeture());

            inputDate_vendredi_ouverture = simpleDateFormat.parse(bar.getHoraires().get(4).getOuverture());
            inputDate_vendredi_fermeture = simpleDateFormat.parse(bar.getHoraires().get(4).getFermeture());

            inputDate_samedi_ouverture = simpleDateFormat.parse(bar.getHoraires().get(5).getOuverture());
            inputDate_samedi_fermeture = simpleDateFormat.parse(bar.getHoraires().get(5).getFermeture());

            inputDate_dimanche_ouverture = simpleDateFormat.parse(bar.getHoraires().get(6).getOuverture());
            inputDate_dimanche_fermeture = simpleDateFormat.parse(bar.getHoraires().get(6).getFermeture());

            inputDate_happy_hours_debut = simpleDateFormat.parse(bar.getHoraires().get(7).getOuverture());
            inputDate_happy_hours_fin = simpleDateFormat.parse(bar.getHoraires().get(7).getFermeture());

            inputDate_mardi_debuthh = simpleDateFormat.parse(bar.getHoraires().get(8).getOuverture());
            inputDate_mardi_finhh = simpleDateFormat.parse(bar.getHoraires().get(8).getFermeture());

            inputDate_mercredi_debuthh = simpleDateFormat.parse(bar.getHoraires().get(9).getOuverture());
            inputDate_mercredi_finhh = simpleDateFormat.parse(bar.getHoraires().get(9).getFermeture());

            inputDate_jeudi_debuthh = simpleDateFormat.parse(bar.getHoraires().get(10).getOuverture());
            inputDate_jeudi_finhh = simpleDateFormat.parse(bar.getHoraires().get(10).getFermeture());

            inputDate_vendredi_debuthh = simpleDateFormat.parse(bar.getHoraires().get(11).getOuverture());
            inputDate_vendredi_finhh = simpleDateFormat.parse(bar.getHoraires().get(11).getFermeture());

            inputDate_samedi_debuthh = simpleDateFormat.parse(bar.getHoraires().get(12).getOuverture());
            inputDate_samedi_finhh = simpleDateFormat.parse(bar.getHoraires().get(12).getFermeture());

            inputDate_dimanche_debuthh = simpleDateFormat.parse(bar.getHoraires().get(13).getOuverture());
            inputDate_dimanche_finhh = simpleDateFormat.parse(bar.getHoraires().get(13).getFermeture());

        } catch (ParseException e) {
            e.printStackTrace();
        }


        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String horaire_lundi_ouverture = simpleDateFormat.format(inputDate_lundi_ouverture);
        String horaire_lundi_fermeture = simpleDateFormat.format(inputDate_lundi_fermeture);

        String horaire_mardi_ouverture = simpleDateFormat.format(inputDate_mardi_ouverture);
        String horaire_mardi_fermeture = simpleDateFormat.format(inputDate_mardi_fermeture);

        String horaire_mercredi_ouverture = simpleDateFormat.format(inputDate_mercredi_ouverture);
        String horaire_mercredi_fermeture = simpleDateFormat.format(inputDate_mercredi_fermeture);

        String horaire_jeudi_ouverture = simpleDateFormat.format(inputDate_jeudi_ouverture);
        String horaire_jeudi_fermeture = simpleDateFormat.format(inputDate_jeudi_fermeture);

        String horaire_vendredi_ouverture = simpleDateFormat.format(inputDate_vendredi_ouverture);
        String horaire_vendredi_fermeture = simpleDateFormat.format(inputDate_vendredi_fermeture);

        String horaire_samedi_ouverture = simpleDateFormat.format(inputDate_samedi_ouverture);
        String horaire_samedi_fermeture = simpleDateFormat.format(inputDate_samedi_fermeture);

        String horaire_dimanche_ouverture = simpleDateFormat.format(inputDate_dimanche_ouverture);
        String horaire_dimanche_fermeture = simpleDateFormat.format(inputDate_dimanche_fermeture);

        String horaire_happy_hours_debut = simpleDateFormat.format(inputDate_happy_hours_debut);
        String horaire_happy_hours_fin = simpleDateFormat.format(inputDate_happy_hours_fin);

        String horaire_mardi_debuthh = simpleDateFormat.format(inputDate_mardi_debuthh);
        String horaire_mardi_finhh = simpleDateFormat.format(inputDate_mardi_finhh);

        String horaire_mercredi_debuthh = simpleDateFormat.format(inputDate_mercredi_debuthh);
        String horaire_mercredi_finhh = simpleDateFormat.format(inputDate_mercredi_finhh);

        String horaire_jeudi_debuthh = simpleDateFormat.format(inputDate_jeudi_debuthh);
        String horaire_jeudi_finhh = simpleDateFormat.format(inputDate_jeudi_finhh);

        String horaire_vendredi_debuthh = simpleDateFormat.format(inputDate_vendredi_debuthh);
        String horaire_vendredi_finhh = simpleDateFormat.format(inputDate_vendredi_finhh);

        String horaire_samedi_debuthh = simpleDateFormat.format(inputDate_samedi_debuthh);
        String horaire_samedi_finhh = simpleDateFormat.format(inputDate_samedi_finhh);

        String horaire_dimanche_debuthh = simpleDateFormat.format(inputDate_dimanche_debuthh);
        String horaire_dimanche_finhh = simpleDateFormat.format(inputDate_dimanche_finhh);


        OutputStream os = null;
        InputStream is = null;
        HttpURLConnection conn = null;

            try {
                //constants
                URL url = new URL("http://pinthop.com/Prod/insertinfo.php");
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("nom_bar", nom_bar);
                jsonObject.put("style", style);
                jsonObject.put("adresse", adresse);
                jsonObject.put("ambiance2", style_deux);
                jsonObject.put("ambiance3", style_trois);
                jsonObject.put("sportif", switch_sportif);
                jsonObject.put("terrasse", switch_terrasse);
                jsonObject.put("horaire_lundi_ouverture", horaire_lundi_ouverture);
                jsonObject.put("horaire_lundi_fermeture", horaire_lundi_fermeture);

                jsonObject.put("horaire_mardi_ouverture", horaire_mardi_ouverture);
                jsonObject.put("horaire_mardi_fermeture", horaire_mardi_fermeture);

                jsonObject.put("horaire_mercredi_ouverture", horaire_mercredi_ouverture);
                jsonObject.put("horaire_mercredi_fermeture", horaire_mercredi_fermeture);

                jsonObject.put("horaire_jeudi_ouverture", horaire_jeudi_ouverture);
                jsonObject.put("horaire_jeudi_fermeture", horaire_jeudi_fermeture);

                jsonObject.put("horaire_vendredi_ouverture", horaire_vendredi_ouverture);
                jsonObject.put("horaire_vendredi_fermeture", horaire_vendredi_fermeture);

                jsonObject.put("horaire_samedi_ouverture", horaire_samedi_ouverture);
                jsonObject.put("horaire_samedi_fermeture", horaire_samedi_fermeture);

                jsonObject.put("horaire_dimanche_ouverture", horaire_dimanche_ouverture);
                jsonObject.put("horaire_dimanche_fermeture", horaire_dimanche_fermeture);

                jsonObject.put("happy_hours_debut", horaire_happy_hours_debut);
                jsonObject.put("happy_hours_fin", horaire_happy_hours_fin);

                jsonObject.put("horaire_mardi_debuthh", horaire_mardi_debuthh);
                jsonObject.put("horaire_mardi_finhh", horaire_mardi_finhh);

                jsonObject.put("horaire_mercredi_debuthh", horaire_mercredi_debuthh);
                jsonObject.put("horaire_mercredi_finhh", horaire_mercredi_finhh);

                jsonObject.put("horaire_jeudi_debuthh", horaire_jeudi_debuthh);
                jsonObject.put("horaire_jeudi_finhh", horaire_jeudi_finhh);

                jsonObject.put("horaire_vendredi_debuthh", horaire_vendredi_debuthh);
                jsonObject.put("horaire_vendredi_finhh", horaire_vendredi_finhh);

                jsonObject.put("horaire_samedi_debuthh", horaire_samedi_debuthh);
                jsonObject.put("horaire_samedi_finhh", horaire_samedi_finhh);

                jsonObject.put("horaire_dimanche_debuthh", horaire_dimanche_debuthh);
                jsonObject.put("horaire_dimanche_finhh", horaire_dimanche_finhh);

                String message = jsonObject.toString();

                conn = (HttpURLConnection) url.openConnection();
                String mdp = "rpnGbdCDLiE1";
                String username = "mathieu";

                String userpassword = username + ":" + mdp;

                byte[] data = userpassword.getBytes("UTF-8");
                String base64 = Base64.encodeToString(data, Base64.DEFAULT);
                conn.setRequestProperty("Authorization", "Basic "+ base64);
                conn.setReadTimeout(10000 /*milliseconds*/);
                conn.setConnectTimeout(15000 /* milliseconds */);
                conn.setRequestMethod("POST");
                conn.setDoInput(true);
                conn.setDoOutput(true);
                conn.setFixedLengthStreamingMode(message.getBytes().length);

                //make some HTTP header nicety
                conn.setRequestProperty("Content-Type", "application/json;charset=utf-8");
                conn.setRequestProperty("X-Requested-With", "XMLHttpRequest");

                //open
                conn.connect();

                //setup send
                os = new BufferedOutputStream(conn.getOutputStream());
                os.write(message.getBytes());
                //clean up
                os.flush();

                //do somehting with response
                is = conn.getInputStream();
                contentAsString = convertStreamToString(is);

            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            } finally {
                //clean up
                try {
                    os.close();
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                conn.disconnect();
                return contentAsString;
            }
    }

    public String modifyBarToServer(Bar bar, String id_bar_voulue) {

        String nom_bar = bar.getNom_bar();
        String style = bar.getStyle();
        String adresse = bar.getAdresse();
        String style_deux = bar.getStyle2();
        String style_trois = bar.getStyle3();
        String switch_terrasse = bar.getTerrasse();
        String switch_sportif = bar.getSportif();

        String contentAsString = null;

        Date inputDate_lundi_ouverture = null;
        Date inputDate_lundi_fermeture = null;

        Date inputDate_mardi_ouverture = null;
        Date inputDate_mardi_fermeture = null;

        Date inputDate_mercredi_ouverture = null;
        Date inputDate_mercredi_fermeture = null;

        Date inputDate_jeudi_ouverture = null;
        Date inputDate_jeudi_fermeture = null;

        Date inputDate_vendredi_ouverture = null;
        Date inputDate_vendredi_fermeture = null;

        Date inputDate_samedi_ouverture = null;
        Date inputDate_samedi_fermeture = null;

        Date inputDate_dimanche_ouverture = null;
        Date inputDate_dimanche_fermeture = null;

        Date inputDate_happy_hours_debut = null;
        Date inputDate_happy_hours_fin = null;

        Date inputDate_mardi_debuthh = null;
        Date inputDate_mardi_finhh = null;

        Date inputDate_mercredi_debuthh = null;
        Date inputDate_mercredi_finhh = null;

        Date inputDate_jeudi_debuthh = null;
        Date inputDate_jeudi_finhh = null;

        Date inputDate_vendredi_debuthh = null;
        Date inputDate_vendredi_finhh = null;

        Date inputDate_samedi_debuthh = null;
        Date inputDate_samedi_finhh = null;

        Date inputDate_dimanche_debuthh = null;
        Date inputDate_dimanche_finhh = null;

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
        try {

            inputDate_lundi_ouverture = simpleDateFormat.parse(bar.getHoraires().get(0).getOuverture());
            inputDate_lundi_fermeture = simpleDateFormat.parse(bar.getHoraires().get(0).getFermeture());

            inputDate_mardi_ouverture = simpleDateFormat.parse(bar.getHoraires().get(1).getOuverture());
            inputDate_mardi_fermeture = simpleDateFormat.parse(bar.getHoraires().get(1).getFermeture());

            inputDate_mercredi_ouverture = simpleDateFormat.parse(bar.getHoraires().get(2).getOuverture());
            inputDate_mercredi_fermeture = simpleDateFormat.parse(bar.getHoraires().get(2).getFermeture());

            inputDate_jeudi_ouverture = simpleDateFormat.parse(bar.getHoraires().get(3).getOuverture());
            inputDate_jeudi_fermeture = simpleDateFormat.parse(bar.getHoraires().get(3).getFermeture());

            inputDate_vendredi_ouverture = simpleDateFormat.parse(bar.getHoraires().get(4).getOuverture());
            inputDate_vendredi_fermeture = simpleDateFormat.parse(bar.getHoraires().get(4).getFermeture());

            inputDate_samedi_ouverture = simpleDateFormat.parse(bar.getHoraires().get(5).getOuverture());
            inputDate_samedi_fermeture = simpleDateFormat.parse(bar.getHoraires().get(5).getFermeture());

            inputDate_dimanche_ouverture = simpleDateFormat.parse(bar.getHoraires().get(6).getOuverture());
            inputDate_dimanche_fermeture = simpleDateFormat.parse(bar.getHoraires().get(6).getFermeture());

            inputDate_happy_hours_debut = simpleDateFormat.parse(bar.getHoraires().get(7).getOuverture());
            inputDate_happy_hours_fin = simpleDateFormat.parse(bar.getHoraires().get(7).getFermeture());

            inputDate_mardi_debuthh = simpleDateFormat.parse(bar.getHoraires().get(8).getOuverture());
            inputDate_mardi_finhh = simpleDateFormat.parse(bar.getHoraires().get(8).getFermeture());

            inputDate_mercredi_debuthh = simpleDateFormat.parse(bar.getHoraires().get(9).getOuverture());
            inputDate_mercredi_finhh = simpleDateFormat.parse(bar.getHoraires().get(9).getFermeture());

            inputDate_jeudi_debuthh = simpleDateFormat.parse(bar.getHoraires().get(10).getOuverture());
            inputDate_jeudi_finhh = simpleDateFormat.parse(bar.getHoraires().get(10).getFermeture());

            inputDate_vendredi_debuthh = simpleDateFormat.parse(bar.getHoraires().get(11).getOuverture());
            inputDate_vendredi_finhh = simpleDateFormat.parse(bar.getHoraires().get(11).getFermeture());

            inputDate_samedi_debuthh = simpleDateFormat.parse(bar.getHoraires().get(12).getOuverture());
            inputDate_samedi_finhh = simpleDateFormat.parse(bar.getHoraires().get(12).getFermeture());

            inputDate_dimanche_debuthh = simpleDateFormat.parse(bar.getHoraires().get(13).getOuverture());
            inputDate_dimanche_finhh = simpleDateFormat.parse(bar.getHoraires().get(13).getFermeture());

        } catch (ParseException e) {
            e.printStackTrace();
        }

        String idBar = id_bar_voulue;

        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String horaire_lundi_ouverture = simpleDateFormat.format(inputDate_lundi_ouverture);
        String horaire_lundi_fermeture = simpleDateFormat.format(inputDate_lundi_fermeture);

        String horaire_mardi_ouverture = simpleDateFormat.format(inputDate_mardi_ouverture);
        String horaire_mardi_fermeture = simpleDateFormat.format(inputDate_mardi_fermeture);

        String horaire_mercredi_ouverture = simpleDateFormat.format(inputDate_mercredi_ouverture);
        String horaire_mercredi_fermeture = simpleDateFormat.format(inputDate_mercredi_fermeture);

        String horaire_jeudi_ouverture = simpleDateFormat.format(inputDate_jeudi_ouverture);
        String horaire_jeudi_fermeture = simpleDateFormat.format(inputDate_jeudi_fermeture);

        String horaire_vendredi_ouverture = simpleDateFormat.format(inputDate_vendredi_ouverture);
        String horaire_vendredi_fermeture = simpleDateFormat.format(inputDate_vendredi_fermeture);

        String horaire_samedi_ouverture = simpleDateFormat.format(inputDate_samedi_ouverture);
        String horaire_samedi_fermeture = simpleDateFormat.format(inputDate_samedi_fermeture);

        String horaire_dimanche_ouverture = simpleDateFormat.format(inputDate_dimanche_ouverture);
        String horaire_dimanche_fermeture = simpleDateFormat.format(inputDate_dimanche_fermeture);

        String horaire_happy_hours_debut = simpleDateFormat.format(inputDate_happy_hours_debut);
        String horaire_happy_hours_fin = simpleDateFormat.format(inputDate_happy_hours_fin);

        String horaire_mardi_debuthh = simpleDateFormat.format(inputDate_mardi_debuthh);
        String horaire_mardi_finhh = simpleDateFormat.format(inputDate_mardi_finhh);

        String horaire_mercredi_debuthh = simpleDateFormat.format(inputDate_mercredi_debuthh);
        String horaire_mercredi_finhh = simpleDateFormat.format(inputDate_mercredi_finhh);

        String horaire_jeudi_debuthh = simpleDateFormat.format(inputDate_jeudi_debuthh);
        String horaire_jeudi_finhh = simpleDateFormat.format(inputDate_jeudi_finhh);

        String horaire_vendredi_debuthh = simpleDateFormat.format(inputDate_vendredi_debuthh);
        String horaire_vendredi_finhh = simpleDateFormat.format(inputDate_vendredi_finhh);

        String horaire_samedi_debuthh = simpleDateFormat.format(inputDate_samedi_debuthh);
        String horaire_samedi_finhh = simpleDateFormat.format(inputDate_samedi_finhh);

        String horaire_dimanche_debuthh = simpleDateFormat.format(inputDate_dimanche_debuthh);
        String horaire_dimanche_finhh = simpleDateFormat.format(inputDate_dimanche_finhh);

        OutputStream os = null;
        InputStream is = null;
        HttpURLConnection conn = null;

        try {
            //constants
            URL url = new URL("http://pinthop.com/Prod/modifybar.php");
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("nom_bar", nom_bar);
            jsonObject.put("style", style);
            jsonObject.put("adresse", adresse);
            jsonObject.put("ambiance2", style_deux);
            jsonObject.put("ambiance3", style_trois);
            jsonObject.put("terrasse", switch_terrasse);
            jsonObject.put("sportif", switch_sportif);
            jsonObject.put("horaire_lundi_ouverture", horaire_lundi_ouverture);
            jsonObject.put("horaire_lundi_fermeture", horaire_lundi_fermeture);

            jsonObject.put("horaire_mardi_ouverture", horaire_mardi_ouverture);
            jsonObject.put("horaire_mardi_fermeture", horaire_mardi_fermeture);

            jsonObject.put("horaire_mercredi_ouverture", horaire_mercredi_ouverture);
            jsonObject.put("horaire_mercredi_fermeture", horaire_mercredi_fermeture);

            jsonObject.put("horaire_jeudi_ouverture", horaire_jeudi_ouverture);
            jsonObject.put("horaire_jeudi_fermeture", horaire_jeudi_fermeture);

            jsonObject.put("horaire_vendredi_ouverture", horaire_vendredi_ouverture);
            jsonObject.put("horaire_vendredi_fermeture", horaire_vendredi_fermeture);

            jsonObject.put("horaire_samedi_ouverture", horaire_samedi_ouverture);
            jsonObject.put("horaire_samedi_fermeture", horaire_samedi_fermeture);

            jsonObject.put("horaire_dimanche_ouverture", horaire_dimanche_ouverture);
            jsonObject.put("horaire_dimanche_fermeture", horaire_dimanche_fermeture);

            jsonObject.put("happy_hours_debut", horaire_happy_hours_debut);
            jsonObject.put("happy_hours_fin", horaire_happy_hours_fin);

            jsonObject.put("horaire_mardi_debuthh", horaire_mardi_debuthh);
            jsonObject.put("horaire_mardi_finhh", horaire_mardi_finhh);

            jsonObject.put("horaire_mercredi_debuthh", horaire_mercredi_debuthh);
            jsonObject.put("horaire_mercredi_finhh", horaire_mercredi_finhh);

            jsonObject.put("horaire_jeudi_debuthh", horaire_jeudi_debuthh);
            jsonObject.put("horaire_jeudi_finhh", horaire_jeudi_finhh);

            jsonObject.put("horaire_vendredi_debuthh", horaire_vendredi_debuthh);
            jsonObject.put("horaire_vendredi_finhh", horaire_vendredi_finhh);

            jsonObject.put("horaire_samedi_debuthh", horaire_samedi_debuthh);
            jsonObject.put("horaire_samedi_finhh", horaire_samedi_finhh);

            jsonObject.put("horaire_dimanche_debuthh", horaire_dimanche_debuthh);
            jsonObject.put("horaire_dimanche_finhh", horaire_dimanche_finhh);

            jsonObject.put("idBar", idBar);

            String message = jsonObject.toString();

            conn = (HttpURLConnection) url.openConnection();
            String mdp = "rpnGbdCDLiE1";
            String username = "mathieu";

            String userpassword = username + ":" + mdp;

            byte[] data = userpassword.getBytes("UTF-8");
            String base64 = Base64.encodeToString(data, Base64.DEFAULT);
            conn.setRequestProperty("Authorization", "Basic "+ base64);
            conn.setReadTimeout(10000 /*milliseconds*/);
            conn.setConnectTimeout(15000 /* milliseconds */);
            conn.setRequestMethod("POST");
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.setFixedLengthStreamingMode(message.getBytes().length);

            //make some HTTP header nicety
            conn.setRequestProperty("Content-Type", "application/json;charset=utf-8");
            conn.setRequestProperty("X-Requested-With", "XMLHttpRequest");

            //open
            conn.connect();

            //setup send
            os = new BufferedOutputStream(conn.getOutputStream());
            os.write(message.getBytes());
            //clean up
            os.flush();

            //do somehting with response
            is = conn.getInputStream();
            contentAsString = convertStreamToString(is);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } finally {
            //clean up
            try {
                os.close();
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            conn.disconnect();
            return contentAsString;
        }
    }

    public String insertBiereToServer(Biere biere, String id_bar_voulue, String id_biere_voulue) {

        String contentAsString = null;

        String id_bar = id_bar_voulue;
        String id_biere = id_biere_voulue;

        String prix = biere.getPrix_hors_hh();
        String conditionnement = biere.getConditionnement();
        String prix_happy_hours = biere.getPrix_hh();

        Log.d(TAG, "prix biere avant parse : " + prix);
        Log.d(TAG, "prix hh avant parse : " + prix_happy_hours);

        int Bar_idBar = Integer.valueOf(id_bar);
        int Biere_idBiere = Integer.valueOf(id_biere);
        double Prix = Double.parseDouble(prix);
        double prix_happy_hour = Double.parseDouble(prix_happy_hours);

        Log.d(TAG, "prix bieeeeeeeere : " + Prix);
        Log.d(TAG, "prix bieeeeeeeeere HH : " + prix_happy_hour);


        OutputStream os = null;
        InputStream is = null;
        HttpURLConnection conn = null;

        try {
            //constants
            URL url = new URL("http://pinthop.com/Prod/insertbiere.php");

            JSONObject jsonObject = new JSONObject();

            jsonObject.put("Bar_idBar", Bar_idBar);
            jsonObject.put("Biere_idBiere", Biere_idBiere);
            jsonObject.put("Prix", Prix);
            jsonObject.put("conditionnement", conditionnement);
            jsonObject.put("prix_happy_hour", prix_happy_hour);

            String message = jsonObject.toString();

            conn = (HttpURLConnection) url.openConnection();

            conn.setReadTimeout(10000 /*milliseconds*/);
            conn.setConnectTimeout(15000 /* milliseconds */);
            conn.setRequestMethod("POST");
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.setFixedLengthStreamingMode(message.getBytes().length);

            //make some HTTP header nicety
            String mdp = "rpnGbdCDLiE1";
            String username = "mathieu";

            String userpassword = username + ":" + mdp;

            byte[] data = userpassword.getBytes("UTF-8");
            String base64 = Base64.encodeToString(data, Base64.DEFAULT);
            conn.setRequestProperty("Authorization", "Basic "+ base64);

            conn.setRequestProperty("Content-Type", "application/json;charset=utf-8");
            conn.setRequestProperty("X-Requested-With", "XMLHttpRequest");

            //open
            conn.connect();

            //setup send
            os = new BufferedOutputStream(conn.getOutputStream());
            os.write(message.getBytes());
            //clean up
            os.flush();

            //do somehting with response
            is = conn.getInputStream();
            contentAsString = convertStreamToString(is);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } finally {
            //clean up
            try {
                os.close();
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            conn.disconnect();
            return contentAsString;
        }
    }

    public String insertUser(String SuserName, String Spassword, String Sadresse_mail, String Sage) {

        String contentAsString = null;

        String username = SuserName;
        String password = Spassword;
        String adresse_mail = Sadresse_mail;
        String Iage = Sage;

        int age = Integer.valueOf(Iage);

        OutputStream os = null;
        InputStream is = null;
        HttpURLConnection conn = null;

        try {
            //constants
            URL url = new URL("http://pinthop.com/Prod/insertUser.php");

            JSONObject jsonObject = new JSONObject();

            jsonObject.put("userName", username);
            jsonObject.put("password", password);
            jsonObject.put("adresse_mail", adresse_mail);
            jsonObject.put("age", age);

            String message = jsonObject.toString();

            conn = (HttpURLConnection) url.openConnection();

            conn.setReadTimeout(10000 /*milliseconds*/);
            conn.setConnectTimeout(15000 /* milliseconds */);
            conn.setRequestMethod("POST");
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.setFixedLengthStreamingMode(message.getBytes().length);

            //make some HTTP header nicety
            String mdp = "rpnGbdCDLiE1";
            String Myusername = "mathieu";

            String userpassword = Myusername + ":" + mdp;

            byte[] data = userpassword.getBytes("UTF-8");
            String base64 = Base64.encodeToString(data, Base64.DEFAULT);
            conn.setRequestProperty("Authorization", "Basic "+ base64);

            conn.setRequestProperty("Content-Type", "application/json;charset=utf-8");
            conn.setRequestProperty("X-Requested-With", "XMLHttpRequest");

            //open
            conn.connect();

            //setup send
            os = new BufferedOutputStream(conn.getOutputStream());
            os.write(message.getBytes());
            //clean up
            os.flush();

            //do somehting with response
            is = conn.getInputStream();
            contentAsString = convertStreamToString(is);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } finally {
            //clean up
            try {
                os.close();
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            conn.disconnect();
            return contentAsString;
        }
    }

    public String LoginUser(String SuserName, String Spassword) {

        String contentAsString = null;

        String username = SuserName;
        String password = Spassword;

        OutputStream os = null;
        InputStream is = null;
        HttpURLConnection conn = null;

        try {
            //constants
            URL url = new URL("http://pinthop.com/Prod/login.php");

            JSONObject jsonObject = new JSONObject();

            jsonObject.put("userName", username);
            jsonObject.put("password", password);

            String message = jsonObject.toString();

            conn = (HttpURLConnection) url.openConnection();

            conn.setReadTimeout(10000 /*milliseconds*/);
            conn.setConnectTimeout(15000 /* milliseconds */);
            conn.setRequestMethod("POST");
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.setFixedLengthStreamingMode(message.getBytes().length);

            //make some HTTP header nicety
            String mdp = "rpnGbdCDLiE1";
            String Myusername = "mathieu";

            String userpassword = Myusername + ":" + mdp;

            byte[] data = userpassword.getBytes("UTF-8");
            String base64 = Base64.encodeToString(data, Base64.DEFAULT);
            conn.setRequestProperty("Authorization", "Basic "+ base64);

            conn.setRequestProperty("Content-Type", "application/json;charset=utf-8");
            conn.setRequestProperty("X-Requested-With", "XMLHttpRequest");

            //open
            conn.connect();

            //setup send
            os = new BufferedOutputStream(conn.getOutputStream());
            os.write(message.getBytes());
            //clean up
            os.flush();

            //do somehting with response
            is = conn.getInputStream();
            contentAsString = convertStreamToString(is);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } finally {
            //clean up
            try {
                os.close();
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            conn.disconnect();
            return contentAsString;
        }
    }

    private String convertStreamToString(InputStream is) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line).append('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

    public String getLatLongByURL(String requestURL) {
        URL url;
        String response = "";
        try {

            String oldurl = requestURL;
            String newurl=oldurl.replaceAll(" ","%20");

            url = new URL(newurl);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(15000);
            conn.setConnectTimeout(15000);
            conn.setRequestMethod("GET");
            conn.setDoInput(true);
            conn.setRequestProperty("Content-Type",
                    "application/x-www-form-urlencoded");
            conn.setDoOutput(true);
            int responseCode = conn.getResponseCode();

            if (responseCode == HttpsURLConnection.HTTP_OK) {
                String line;
                BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                while ((line = br.readLine()) != null) {
                    response += line;
                }
            } else {
                InputStream is = conn.getErrorStream();
                response = "";
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    public boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }
}
