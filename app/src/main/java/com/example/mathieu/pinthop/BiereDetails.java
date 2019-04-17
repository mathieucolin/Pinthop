package com.example.mathieu.pinthop;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class BiereDetails extends AppCompatActivity {

    TextView nationalite, type, type2, couleur, brasserie, methodebrassage, degrealcool, commentaires = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biere_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        String Snom_biere = intent.getStringExtra("NOM_BIERE");
        String Snationalite = intent.getStringExtra("NATIONALITE");
        String Stype = intent.getStringExtra("TYPE");
        String Stype2 = intent.getStringExtra("TYPE2");
        String Scouleur = intent.getStringExtra("COULEUR");
        String Sbrasserie = intent.getStringExtra("BRASSERIE");
        String Smethodebrassage = intent.getStringExtra("METHODEBRASSAGE");
        String Sdegrealcool = intent.getStringExtra("DEGREALCOOL");
        String Scommentaires = intent.getStringExtra("COMMENTAIRES");

        nationalite = (TextView) findViewById(R.id.nationalite);
        type = (TextView) findViewById(R.id.type);
        type2 = (TextView) findViewById(R.id.type2);
        couleur = (TextView) findViewById(R.id.couleur);
        brasserie = (TextView) findViewById(R.id.brasserie);
        methodebrassage = (TextView) findViewById(R.id.methodebrassage);
        degrealcool = (TextView) findViewById(R.id.degrealcool);
        commentaires = (TextView) findViewById(R.id.commentaires);

        getSupportActionBar().setTitle(Snom_biere);

        nationalite.setText(Snationalite);
        type.setText("Type : " + Stype);
        if(!Stype2.equals("") && !Stype2.equals("null"));
        {
            type2.setText(Stype2);
            type2.setVisibility(View.VISIBLE);
        }
        couleur.setText("Couleur : " + Scouleur);
        brasserie.setText("Brasserie : " + Sbrasserie);
        methodebrassage.setText("Méthode de brassage : " + Smethodebrassage);
        degrealcool.setText("Dégrés d'alcool : " + Sdegrealcool + "°");
        commentaires.setText(Scommentaires);
    }
}
