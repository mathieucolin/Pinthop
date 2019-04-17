package com.example.mathieu.pinthop;

import android.app.TimePickerDialog;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;
import android.app.DialogFragment;
import android.app.Dialog;
import java.util.Calendar;
import android.widget.TimePicker;


public class TimePickerFragment extends DialogFragment{

    private static final String TAG = "myApp";

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        //Use the current time as the default values for the time picker
        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            timePickerDialog = new CustomTimePickerDialog(getActivity(), R.style.style_time_picker_dialog, timeSetListener, hour, minute, true);

        } else {
            timePickerDialog = new TimePickerDialog(getActivity(), R.style.style_time_picker_dialog, timeSetListener, hour, minute, true);
        }

        return  timePickerDialog;
    }

    private CustomTimePickerDialog.OnTimeSetListener timeSetListener = new CustomTimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            TextView horaire_lundi_ouverture = (TextView) getActivity().findViewById(R.id.ouverture_lundi);
            TextView horaire_lundi_fermeture = (TextView) getActivity().findViewById(R.id.fermeture_lundi);
            TextView horaire_mardi_ouverture = (TextView) getActivity().findViewById(R.id.ouverture_mardi);
            TextView horaire_mardi_fermeture = (TextView) getActivity().findViewById(R.id.fermeture_mardi);
            TextView horaire_mercredi_ouverture = (TextView) getActivity().findViewById(R.id.ouverture_mercredi);
            TextView horaire_mercredi_fermeture = (TextView) getActivity().findViewById(R.id.fermeture_mercredi);
            TextView horaire_jeudi_ouverture = (TextView) getActivity().findViewById(R.id.ouverture_jeudi);
            TextView horaire_jeudi_fermeture = (TextView) getActivity().findViewById(R.id.fermeture_jeudi);
            TextView horaire_vendredi_ouverture = (TextView) getActivity().findViewById(R.id.ouverture_vendredi);
            TextView horaire_vendredi_fermeture = (TextView) getActivity().findViewById(R.id.fermeture_vendredi);
            TextView horaire_samedi_ouverture = (TextView) getActivity().findViewById(R.id.ouverture_samedi);
            TextView horaire_samedi_fermeture = (TextView) getActivity().findViewById(R.id.fermeture_samedi);
            TextView horaire_dimanche_ouverture = (TextView) getActivity().findViewById(R.id.ouverture_dimanche);
            TextView horaire_dimanche_fermeture = (TextView) getActivity().findViewById(R.id.fermeture_dimanche);
            TextView horaire_happy_hours_debut = (TextView) getActivity().findViewById(R.id.happy_hours_debut);
            TextView horaire_happy_hours_fin = (TextView) getActivity().findViewById(R.id.happy_hours_fin);

            TextView horaire_mardi_beginninghh = (TextView) getActivity().findViewById(R.id.debuthh_mardi);
            TextView horaire_mardi_endinghh = (TextView) getActivity().findViewById(R.id.finhh_mardi);
            TextView horaire_mercredi_beginninghh = (TextView) getActivity().findViewById(R.id.debuthh_mercredi);
            TextView horaire_mercredi_endinghh = (TextView) getActivity().findViewById(R.id.finhh_mercredi);
            TextView horaire_jeudi_beginninghh = (TextView) getActivity().findViewById(R.id.debuthh_jeudi);
            TextView horaire_jeudi_endinghh = (TextView) getActivity().findViewById(R.id.finhh_jeudi);
            TextView horaire_vendredi_beginninghh = (TextView) getActivity().findViewById(R.id.debuthh_vendredi);
            TextView horaire_vendredi_endinghh = (TextView) getActivity().findViewById(R.id.finhh_vendredi);
            TextView horaire_samedi_beginninghh = (TextView) getActivity().findViewById(R.id.debuthh_samedi);
            TextView horaire_samedi_endinghh = (TextView) getActivity().findViewById(R.id.finhh_samedi);
            TextView horaire_dimanche_beginninghh = (TextView) getActivity().findViewById(R.id.debuthh_dimanche);
            TextView horaire_dimanche_endinghh = (TextView) getActivity().findViewById(R.id.finhh_dimanche);

            int button_timepicker = TabBaseDeDonnees.button_timepicker;
            int closed = CustomTimePickerDialog.closed;

            if(button_timepicker == 1) {

                if(closed == 1)
                {
                    horaire_lundi_ouverture.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));
                    horaire_lundi_fermeture.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));
                }
                else {
                    horaire_lundi_ouverture.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));
                    horaire_mardi_ouverture.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));
                    horaire_mercredi_ouverture.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));
                    horaire_jeudi_ouverture.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));
                    horaire_vendredi_ouverture.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));
                    horaire_samedi_ouverture.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));
                    horaire_dimanche_ouverture.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));
                }
            }
            if(button_timepicker == 2) {

                if(closed == 1)
                {
                    horaire_lundi_ouverture.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));
                    horaire_lundi_fermeture.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));
                }

                else {
                    horaire_lundi_fermeture.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));
                    horaire_mardi_fermeture.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));
                    horaire_mercredi_fermeture.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));
                    horaire_jeudi_fermeture.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));
                    horaire_vendredi_fermeture.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));
                    horaire_samedi_fermeture.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));
                    horaire_dimanche_fermeture.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));
                }
            }

            if(button_timepicker == 3) {

                if(closed == 1)
                {
                    horaire_mardi_ouverture.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));
                    horaire_mardi_fermeture.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));
                }
                else {
                    horaire_mardi_ouverture.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));
                }
            }
            if(button_timepicker == 4) {
                if(closed == 1)
                {
                    horaire_mardi_ouverture.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));
                    horaire_mardi_fermeture.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));
                }
                else {
                    horaire_mardi_fermeture.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));
                }
            }

            if(button_timepicker == 5) {
                if(closed == 1)
                {
                    horaire_mercredi_ouverture.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));
                    horaire_mercredi_fermeture.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));
                }
                else {
                    horaire_mercredi_ouverture.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));
                }
            }

            if(button_timepicker == 6) {
                if(closed == 1)
                {
                    horaire_mercredi_ouverture.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));
                    horaire_mercredi_fermeture.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));
                }
                else {
                    horaire_mercredi_fermeture.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));
                }
            }

            if(button_timepicker == 7) {
                if(closed == 1) {
                    horaire_jeudi_fermeture.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));
                    horaire_jeudi_ouverture.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));
                }
                else {
                    horaire_jeudi_ouverture.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));
                }
            }
            if(button_timepicker == 8) {
                if(closed == 1) {
                    horaire_jeudi_fermeture.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));
                    horaire_jeudi_ouverture.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));
                }
                else {
                    horaire_jeudi_fermeture.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));
                }
            }

            if(button_timepicker == 9) {

                if(closed == 1)
                {
                    horaire_vendredi_fermeture.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));
                    horaire_vendredi_ouverture.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));
                }
                else {
                    horaire_vendredi_ouverture.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));
                }
            }

            if(button_timepicker == 10) {
                if(closed == 1)
                {
                    horaire_vendredi_fermeture.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));
                    horaire_vendredi_ouverture.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));
                }
                else {
                    horaire_vendredi_fermeture.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));
                }
            }

            if(button_timepicker == 11) {
                if(closed == 1)
                {
                    horaire_samedi_ouverture.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));
                    horaire_samedi_fermeture.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));
                }
                else {
                    horaire_samedi_ouverture.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));
                }
            }

            if(button_timepicker == 12) {
                if(closed == 1)
                {
                    horaire_samedi_ouverture.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));
                    horaire_samedi_fermeture.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));
                }
                else {
                    horaire_samedi_fermeture.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));
                }
            }

            if(button_timepicker == 13) {
                if(closed == 1)
                {
                    horaire_dimanche_ouverture.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));
                    horaire_dimanche_fermeture.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));
                }
                else {
                    horaire_dimanche_ouverture.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));
                }
            }

            if(button_timepicker == 14) {
                if(closed == 1)
                {
                    horaire_dimanche_ouverture.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));
                    horaire_dimanche_fermeture.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));
                }
                else {
                    horaire_dimanche_fermeture.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));
                }
            }

            if(button_timepicker == 15) {
                if(closed == 1)
                {
                    horaire_happy_hours_debut.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));
                    horaire_happy_hours_fin.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));
                    horaire_mardi_beginninghh.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));
                    horaire_mercredi_beginninghh.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));
                    horaire_jeudi_beginninghh.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));
                    horaire_vendredi_beginninghh.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));
                    horaire_samedi_beginninghh.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));
                    horaire_dimanche_beginninghh.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));
                    horaire_mardi_endinghh.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));
                    horaire_mercredi_endinghh.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));
                    horaire_jeudi_endinghh.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));
                    horaire_vendredi_endinghh.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));
                    horaire_samedi_endinghh.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));
                    horaire_dimanche_endinghh.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));
                }
                else {
                    horaire_happy_hours_debut.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));
                    horaire_mardi_beginninghh.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));
                    horaire_mercredi_beginninghh.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));
                    horaire_jeudi_beginninghh.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));
                    horaire_vendredi_beginninghh.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));
                    horaire_samedi_beginninghh.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));
                    horaire_dimanche_beginninghh.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));
                }
            }

            if(button_timepicker == 16) {
                if(closed == 1)
                {
                    horaire_happy_hours_debut.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));
                    horaire_happy_hours_fin.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));

                }
                else {
                    horaire_happy_hours_fin.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));
                    horaire_mardi_endinghh.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));
                    horaire_mercredi_endinghh.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));
                    horaire_jeudi_endinghh.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));
                    horaire_vendredi_endinghh.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));
                    horaire_samedi_endinghh.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));
                    horaire_dimanche_endinghh.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));
                }
            }

            /*
            TimePicker pour les Happy Hours

             */

            if(button_timepicker == 17) {

                if(closed == 1)
                {
                    horaire_mardi_beginninghh.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));
                    horaire_mardi_endinghh.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));
                }
                else {
                    horaire_mardi_beginninghh.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));
                }
            }
            if(button_timepicker == 18) {
                if(closed == 1)
                {
                    horaire_mardi_beginninghh.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));
                    horaire_mardi_endinghh.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));
                }
                else {
                    horaire_mardi_endinghh.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));
                }
            }

            if(button_timepicker == 19) {
                if(closed == 1)
                {
                    horaire_mercredi_beginninghh.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));
                    horaire_mercredi_endinghh.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));
                }
                else {
                    horaire_mercredi_beginninghh.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));
                }
            }

            if(button_timepicker == 20) {
                if(closed == 1)
                {
                    horaire_mercredi_beginninghh.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));
                    horaire_mercredi_endinghh.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));
                }
                else {
                    horaire_mercredi_endinghh.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));
                }
            }

            if(button_timepicker == 21) {
                if(closed == 1) {
                    horaire_jeudi_endinghh.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));
                    horaire_jeudi_beginninghh.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));
                }
                else {
                    horaire_jeudi_beginninghh.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));
                }
            }
            if(button_timepicker == 22) {
                if(closed == 1) {
                    horaire_jeudi_endinghh.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));
                    horaire_jeudi_beginninghh.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));
                }
                else {
                    horaire_jeudi_endinghh.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));
                }
            }

            if(button_timepicker == 23) {

                if(closed == 1)
                {
                    horaire_vendredi_endinghh.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));
                    horaire_vendredi_beginninghh.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));
                }
                else {
                    horaire_vendredi_beginninghh.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));
                }
            }

            if(button_timepicker == 24) {
                if(closed == 1)
                {
                    horaire_vendredi_endinghh.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));
                    horaire_vendredi_beginninghh.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));
                }
                else {
                    horaire_vendredi_endinghh.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));
                }
            }

            if(button_timepicker == 25) {
                if(closed == 1)
                {
                    horaire_samedi_beginninghh.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));
                    horaire_samedi_endinghh.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));
                }
                else {
                    horaire_samedi_beginninghh.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));
                }
            }

            if(button_timepicker == 26) {
                if(closed == 1)
                {
                    horaire_samedi_beginninghh.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));
                    horaire_samedi_endinghh.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));
                }
                else {
                    horaire_samedi_endinghh.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));
                }
            }

            if(button_timepicker == 27) {
                if(closed == 1)
                {
                    horaire_dimanche_beginninghh.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));
                    horaire_dimanche_endinghh.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));
                }
                else {
                    horaire_dimanche_beginninghh.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));
                }
            }

            if(button_timepicker == 28) {
                if(closed == 1)
                {
                    horaire_dimanche_beginninghh.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));
                    horaire_dimanche_endinghh.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));
                }
                else {
                    horaire_dimanche_endinghh.setText(new StringBuilder().append(String.valueOf(hourOfDay)).append(":").append(String.valueOf(minute)));
                }
            }

        }
    };
}