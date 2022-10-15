<?php
$host = "grupo2-2022.mysql.database.azure.com";
$usuario = "grupo2@grupo2-2022.mysql.database.azure.com";
$contra = "Intecap2022";
$bd = "dbogrupo2";
$conection = mysqli_init();

//realizar conexion
mysqli_real_connect($conection,$host,$usuario,$contra,$bd);
mysqli_set_charset($conection,"utf8");


//prueba conexion

if(!mysqli_connect_error($conection)){
    //echo "Conexion Exitosa....<br>";
}
else{
    die("Error de conexion".mysqli_connect_error());
}

?>