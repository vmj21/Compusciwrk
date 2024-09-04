<?php

$con = new mysqli('localhost','root' ,'' ,'users');    // connnecting to database

// Check if connection to the database is unsuccessful
if(!$con)
{
    die(mysqli_error($con));
}

