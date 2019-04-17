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
	$nom_bar= mysql_real_escape_string($obj->{'nom_bar'});
	$style= mysql_real_escape_string($obj->{'style'});
	$adresse= mysql_real_escape_string($obj->{'adresse'});
	$style_deux= mysql_real_escape_string($obj->{'ambiance2'});
	$style_trois= mysql_real_escape_string($obj->{'ambiance3'});
	$terrasse= mysql_real_escape_string($obj->{'terrasse'});
	$sportif= mysql_real_escape_string($obj->{'sportif'});

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
	
	$horaire_mardi_debuthh= $obj->{'horaire_mardi_debuthh'};
	$horaire_mardi_finhh= $obj->{'horaire_mardi_finhh'};
	
	$horaire_mercredi_debuthh= $obj->{'horaire_mercredi_debuthh'};
	$horaire_mercredi_finhh= $obj->{'horaire_mercredi_finhh'};
	
	$horaire_jeudi_debuthh= $obj->{'horaire_jeudi_debuthh'};
	$horaire_jeudi_finhh= $obj->{'horaire_jeudi_finhh'};
	
	$horaire_vendredi_debuthh= $obj->{'horaire_vendredi_debuthh'};
	$horaire_vendredi_finhh= $obj->{'horaire_vendredi_finhh'};
	
	$horaire_samedi_debuthh= $obj->{'horaire_samedi_debuthh'};
	$horaire_samedi_finhh= $obj->{'horaire_samedi_finhh'};
	
	$horaire_dimanche_debuthh= $obj->{'horaire_dimanche_debuthh'};
	$horaire_dimanche_finhh= $obj->{'horaire_dimanche_finhh'};
	
	
	$idBar = $obj->{'idBar'};

       $reponse = mysql_query("UPDATE Bar SET nom_bar = '$nom_bar', style = '$style', adresse = '$adresse', horaire_lundi_ouverture = '$horaire_lundi_ouverture', horaire_lundi_fermeture = '$horaire_lundi_fermeture', horaire_mardi_ouverture = '$horaire_mardi_ouverture', horaire_mardi_fermeture = '$horaire_mardi_fermeture', horaire_mercredi_ouverture = '$horaire_mercredi_ouverture',horaire_mercredi_fermeture =  '$horaire_mercredi_fermeture', horaire_jeudi_ouverture = '$horaire_jeudi_ouverture', horaire_jeudi_fermeture = '$horaire_jeudi_fermeture', horaire_vendredi_ouverture = '$horaire_vendredi_ouverture', horaire_vendredi_fermeture = '$horaire_vendredi_fermeture', horaire_samedi_ouverture = '$horaire_samedi_ouverture',  horaire_samedi_fermeture = '$horaire_samedi_fermeture',horaire_dimanche_ouverture =  '$horaire_dimanche_ouverture', horaire_dimanche_fermeture =  '$horaire_dimanche_fermeture', happy_hours_debut = '$horaire_happy_hours_debut',happy_hours_fin = '$horaire_happy_hours_fin',ambiance2 = '$style_deux', ambiance3 = '$style_trois',sportif = '$sportif' , terrasse = '$terrasse' WHERE idBar = '$idBar'");
        
        if(mysql_affected_rows()>0)
        {
                echo "Bar modifié";
        }
        else
        {
        	echo "Aucune modifications";
        }
        
        
	mysql_close($con);
	
?>