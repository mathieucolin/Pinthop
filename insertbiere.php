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
	$Bar_idBar= $obj->{'Bar_idBar'};
	$Biere_idBiere= $obj->{'Biere_idBiere'};
	$Prix= $obj->{'Prix'};
	
        $reponse = mysql_query("INSERT INTO Vend(Bar_idBar, Biere_idBiere, Prix) VALUES('$Bar_idBar', '$Biere_idBiere', '$Prix')");
        
	mysql_close($con);
	
?>