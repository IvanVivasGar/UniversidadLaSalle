<?php

    $usuario    = "adminelectronicalasalle";
    $contrasena = "Qq0t9%!X9H^b&VGW";
    try{
        $conn = new PDO('mysql:host=localhost;dbname=electronicalasalle', $usuario, $contrasena);
        $conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
        }
        catch(PDOException $e)
            {
                echo "ERROR: " . $e->getMessage();
            }
            
?>