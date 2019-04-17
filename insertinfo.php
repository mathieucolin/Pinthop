<?php
	header( 'content-type: text/html; charset=utf-8' );
	
	$con = mysql_connect("localhost", "beervnus_admin", "BCCS#liatelle69");
	if(!$con)
	{
		die("La connexion à la base base de données à échouée".mysql_error());
	}	
		
	mysql_set_charset( 'utf8' );
	
	mysql_select_db("beervnus_beeriend", $con);

	$json = file_get_contents('php://input');
	$obj = json_decode($json);
	$nom_bar= $obj->{'nom_bar'};
	$style= $obj->{'style'};
	$adresse= $obj->{'adresse'};
	$style_deux= $obj->{'ambiance2'};
	$style_trois= $obj->{'ambiance3'};
	$terrasse= $obj->{'terrasse'};
	$sportif= $obj->{'sportif'};

	$horaire_lundi_ouverture= $obj->{'horaire_lundi_ouverture'};
	$horaire_lundi_fermeture= $obj->{'horaire_lundi_fermeture'};

	$horaire_mardi_ouverture= $obj->{'horaire_mardi_ouverture'};
	$horaire_mardi_fermeture= $obj->{'horaire_mardi_fermeture'};
	
	$horaire_mercredi_ouverture= $obj->{'horaire_mercredi_ouverture'};
	$horaire_mercredi_fermeture= $obj->{'horaire_mercredi_fermeture'};
	
	$horaire_jeudi_ouverture= $obj->{'horaire_jeudi_ouverture'};
	$horaire_jeudi_fermeture= $obj->{'horaire_jeudi_fermeture'};
	
	$horaire_vendredi_ouverture= $obj->{'horaire_vendredi_ouverture'};
	$horaire_vendredi_fermeture= $obj->{'horaire_vendredi_fermeture'};
	
	$horaire_samedi_ouverture= $obj->{'horaire_samedi_ouverture'};
	$horaire_samedi_fermeture= $obj->{'horaire_samedi_fermeture'};
	
	$horaire_dimanche_ouverture= $obj->{'horaire_dimanche_ouverture'};
	$horaire_dimanche_fermeture= $obj->{'horaire_dimanche_fermeture'};
	
	$horaire_happy_hours_debut= $obj->{'happy_hours_debut'};
	$horaire_happy_hours_fin= $obj->{'happy_hours_fin'};

	
	$resultNom = mysql_query("SELECT * FROM Bar WHERE nom_bar='$nom_bar'");
 	$resultAdresse = mysql_query("SELECT * FROM Bar WHERE adresse='$adresse'");
 	$num_rows_nom = mysql_num_rows($resultNom);
 	$num_rows_adresse = mysql_num_rows($resultAdresse);

 	if ($num_rows_nom >= 1 && $num_rows_adresse >= 1) {
  		echo "Ce bar existe déjà";
  		die();
 	}
	
	else
	{
        $reponse = mysql_query("INSERT INTO Bar(nom_bar, style, adresse, horaire_lundi_ouverture, horaire_lundi_fermeture, horaire_mardi_ouverture, horaire_mardi_fermeture, horaire_mercredi_ouverture, horaire_mercredi_fermeture, horaire_jeudi_ouverture, horaire_jeudi_fermeture, horaire_vendredi_ouverture, horaire_vendredi_fermeture, horaire_samedi_ouverture, horaire_samedi_fermeture, horaire_dimanche_ouverture, horaire_dimanche_fermeture, happy_hours_debut, happy_hours_fin, ambiance2, ambiance3, sportif, terrasse) VALUES('$nom_bar', '$style', '$adresse', '$horaire_lundi_ouverture', '$horaire_lundi_fermeture', '$horaire_mardi_ouverture', '$horaire_mardi_fermeture', '$horaire_mercredi_ouverture', '$horaire_mercredi_fermeture', '$horaire_jeudi_ouverture', '$horaire_jeudi_fermeture', '$horaire_vendredi_ouverture', '$horaire_vendredi_fermeture', '$horaire_samedi_ouverture', '$horaire_samedi_fermeture', '$horaire_dimanche_ouverture', '$horaire_dimanche_fermeture', '$horaire_happy_hours_debut', '$horaire_happy_hours_fin', '$style_deux', '$style_trois', '$terrasse', '$sportif' )");
        echo "Bar ajouté";
        }
        
	mysql_close($con);
	
?>