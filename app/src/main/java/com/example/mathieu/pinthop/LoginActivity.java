package com.example.mathieu.pinthop;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    ProgressDialog progressDialog = null;

    EditText userName, password = null;
    String SuserName, Spassword = null;
    Button register, login = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Connexion");

        userName = (EditText) findViewById(R.id.userName);
        password = (EditText) findViewById(R.id.password);

        register = (Button) findViewById(R.id.enregistrer);
        login = (Button) findViewById(R.id.login);

        register.setOnClickListener(bouton_enregistrer);
        login.setOnClickListener(bouton_login);
    }

    private View.OnClickListener bouton_enregistrer  = new View.OnClickListener() {

        @Override
        public void onClick(View v) {

            Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(intent);
        }
    };

    private View.OnClickListener bouton_login  = new View.OnClickListener() {

        @Override
        public void onClick(View v) {

            SuserName = userName.getText().toString();
            Spassword = password.getText().toString();

            new loginTask().execute(new ApiConnector(LoginActivity.this));

        }
    };

    private class loginTask extends AsyncTask<ApiConnector, Long, String>
    {
        @Override
        protected void onPreExecute()
        {
            progressDialog = new ProgressDialog(LoginActivity.this);
            progressDialog.setTitle("Loading...");
            progressDialog.setMessage("Please wait...");
            progressDialog.setCancelable(false);
            progressDialog.setIndeterminate(false);
            progressDialog.show();
        }

        @Override
        protected String doInBackground(ApiConnector... params) {

            return params[0].LoginUser(SuserName, Spassword);
        }

        @Override
        protected void onPostExecute(String result) {
            progressDialog.dismiss();
            if(result.equals(""))
            {
                Toast.makeText(LoginActivity.this, "Erreur de nom d'utilisateur ou de mot de passe", Toast.LENGTH_LONG).show();
            }
            else {

                Toast.makeText(LoginActivity.this, "Bienvenue : " + result + " ! Vous êtes connectey", Toast.LENGTH_LONG).show();
            }
        }
    }
}
