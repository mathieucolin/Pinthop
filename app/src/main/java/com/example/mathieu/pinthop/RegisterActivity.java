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

public class RegisterActivity extends AppCompatActivity {

    ProgressDialog progressDialog = null;
    EditText userName, password, adresse_mail,passwordConfirmation, age = null;
    String SuserName, Spassword, Sadresse_mail, Sage = null;
    Button register = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setTitle("Inscription");

        userName = (EditText) findViewById(R.id.userName);
        password = (EditText) findViewById(R.id.password);
        adresse_mail = (EditText) findViewById(R.id.adresse_mail);
        passwordConfirmation = (EditText) findViewById(R.id.passwordConfirmation);
        age = (EditText) findViewById(R.id.age);
        register = (Button) findViewById(R.id.register);

        register.setOnClickListener(register_listener);
    }

    private View.OnClickListener register_listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            SuserName = userName.getText().toString();
            Spassword = password.getText().toString();
            Sadresse_mail = adresse_mail.getText().toString();
            Sage = age.getText().toString();

            new insertUserTask().execute(new ApiConnector(RegisterActivity.this));

        }
    };

    private class insertUserTask extends AsyncTask<ApiConnector, Long, String>
    {
        @Override
        protected void onPreExecute()
        {
            progressDialog = new ProgressDialog(RegisterActivity.this);
            progressDialog.setTitle("Loading...");
            progressDialog.setMessage("Please wait...");
            progressDialog.setCancelable(false);
            progressDialog.setIndeterminate(false);
            progressDialog.show();
        }

        @Override
        protected String doInBackground(ApiConnector... params) {

            return params[0].insertUser(SuserName, Spassword, Sadresse_mail, Sage);
        }

        @Override
        protected void onPostExecute(String result) {
            progressDialog.dismiss();
            Toast.makeText(RegisterActivity.this, result, Toast.LENGTH_LONG).show();
            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(intent);
        }
    }

}
