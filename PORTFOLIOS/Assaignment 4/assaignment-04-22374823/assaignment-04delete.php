<?php
include 'assaignment-04connect.php';

if(isset($_GET['deleteid']))
{
  $id = $_GET['deleteid'];

  $sql = "DELETE FROM `info` WHERE id=$id";
  
  $result = mysqli_query($con, $sql);
  
  // Check if the deletion was successful
  if($result)
  {
    // Redirect to 'display.php' if successful
    header('location:assaignment-04display.php');
  }
  else
  {
    // Display MySQL error if deletion failed
    die(mysqli_error($con));
  }
}
?>

