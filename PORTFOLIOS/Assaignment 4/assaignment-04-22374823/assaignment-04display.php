<?php
include 'assaignment-04connect.php'; // Include the file containing the database connection
?>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>CRUD Operation</title>
     <!-- Bootstrap CSS -->
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
 
<div class="container">
    <!-- Add User button -->
    <button class="btn btn-warning my-5"><a href="assaignment-04user.php" class="text-light">Add User</a></button>
</div>

<table class="table">
  <thead>
    <tr>
      <th scope="col">No</th>
      <th scope="col">Title</th>
      <th scope="col">FirstName</th>
      <th scope="col">LastName</th>
      <th scope="col">Mobile</th>
      <th scope="col">Email</th>
      <th scope="col">AddressLine1</th>
      <th scope="col">AddressLine2</th>
      <th scope="col">Town</th>
      <th scope="col">County</th>
      <th scope="col">Eircode</th>
      <th scope="col">Operations</th>
    </tr>
  </thead>
  <tbody>

  <?php
   // Select all records from the 'info' table
   $sql = "SELECT * FROM info";
   $result = mysqli_query($con, $sql); // Execute the query
   
   if($result)
   {
    // Loop through each row of the result set
    while($row = mysqli_fetch_assoc($result))
    {
        // Extract data from the row
        $id = $row['id'];
        $Title = $row['Title'];
        $FirstName = $row['FirstName'];
        $Surname = $row['Surname'];
        $Mobile = $row['Mobile'];
        $Email = $row['Email'];
        $AddressLine1 = $row['AddressLine1'];
        $AddressLine2 = $row['AddressLine2'];
        $Town = $row['Town'];
        $County = $row['County'];
        $Eircode = $row['Eircode'];

        // Display each record in a table row
        echo '<tr>
        <th scope="row">'.$id.'</th>
        <td>'.$Title.'</td>
        <td>'.$FirstName.'</td>
        <td>'.$Surname.'</td>
        <td>'.$Mobile.'</td>
        <td>'.$Email.'</td>
        <td>'.$AddressLine1.'</td>
        <td>'.$AddressLine2.'</td>
        <td>'.$Town.'</td>
        <td>'.$County.'</td>
        <td>'.$Eircode.'</td> 
        <td>
        <button class="btn btn-success"><a href="assaignment-04update.php?updateid='.$id.'" class="text-light">Update</a></button>
        <button class="btn btn-danger"><a href="assaignment-04delete.php?deleteid='.$id.'" class="text-light">Delete</a></button>
        </td>
        </tr>';
    }
   }
  ?>
</tbody>
</table>
</body>
</html>  
