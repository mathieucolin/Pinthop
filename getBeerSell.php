<?php
	header( 'content-type: text/html; charset=utf-8' );
	
	if(isset($_REQUEST['BiereID']))
	{
	
	$con = mysql_connect("localhost", "beervnus_admin", "BCCS#liatelle69");
	if(!$con)
	{
		die("La connexion à la base base de données à échouée".mysql_error());
	}	
	
	mysql_set_charset( 'utf8' );
	
	mysql_select_db("beervnus_beeriend", $con);
	
	$BiereID = $_REQUEST['BiereID'];
	
	$result = mysql_query("SELECT * FROM Bar, Biere, Vend WHERE idBar = Bar_idBar AND idBiere = Biere_idBiere AND idBiere = '$BiereID'") or die('Errant query:');
	
	while($row = mysql_fetch_assoc($result))
	{
		$output[]=$row;
	}
	
	print(json_encode($output));
	
	mysql_close($con);
	}
	else
	{
	$output = "not found";
	print(json_encode($output));
	}
?>