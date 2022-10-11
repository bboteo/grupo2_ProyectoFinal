<?php
include_once("conexion.php");

$usr = $_GET['usr'];
$contrasena = $_GET['contrasena'];

if(isset($usr) && isset($contrasena)){
    $sql = "SELECT usr, contrasena FROM usuario WHERE usr ='$usr' AND contrasena = '$contrasena'";
    if(mysqli_query($conection,$sql)){
        if(mysqli_num_rows(mysqli_query($conection,$sql)) > 0){

            $registros = mysqli_fetch_array(mysqli_query($conection,$sql));
                $retorno = array("usuarios" => [$registros]);
                echo json_encode($retorno);
                mysqli_close($conexion);
    }
    else{
        $retornoVacio = array("usuario"=>[["error"=>"0"]]);
                echo json_encode($retornoVacio);
                mysqli_close($conexion);
    }
 }
 else{
    mysqli_close($conexion);
    die("Error la consulta " . mysqli_connect_error());
}
 }
 else{
    mysqli_close($conexion);
        die("Error en la obtencion de la informacion del ciente");
    }
 
?>