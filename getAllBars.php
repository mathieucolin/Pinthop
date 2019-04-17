<?php
	header( 'content-type: text/html; charset=utf-8' );
	
	$con = mysql_connect("localhost", "beervnus_admin", "BCCS#liatelle69");
	if(!$con)
	{
		die("La connexion à la base base de données à échouée".mysql_error());
	}	
	
	mysql_set_charset( 'utf8' );
	
	mysql_select_db("beervnus_beeriend", $con);
	
	$result = mysql_query("SELECT * FROM Bar");
	
	while($row = mysql_fetch_assoc($result))
	{
		$output[]=$row;
	}
	
	print(json_encode($output));
	
	mysql_close($con);
?>