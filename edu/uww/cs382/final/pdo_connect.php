<?php

$user = 'root';
$pass = '';
$dsn = 'mysql:host=localhost;dbname=moviestore'; // i just decided to use the same database :/
try {
    $db = new PDO($dsn, $user, $pass);

} catch (PDOException $e) {
    print "Error!: " . $e->getMessage() . "<br/>";
    die();
}