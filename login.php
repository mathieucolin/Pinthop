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
	$userName= mysql_real_escape_string($obj->{'userName'});
	$password= mysql_real_escape_string($obj->{'password'});
	
    $reponse = mysql_query("SELECT * FROM Utilisateurs WHERE userName = $userName AND password = $password");
    
	if($reponse > 0)
	{
		while($row = mysql_fetch_assoc($result))
		{
			$output[]=$row;
		}
		
		
		print(json_encode($output));
	}
	
	else
	{
		echo "not found";
	}
        
	mysql_close($con);
	
?>