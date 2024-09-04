<?php
// Include the file containing the database connection
include 'assaignment-04connect.php';

// Check if the form has been submitted
if(isset($_POST['submit'])){
    // Retrieve form data and store it in variables
    $Title = $_POST['title'];
    $FirstName = $_POST['firstname'];
    $Surname = $_POST['surname'];
    $Mobile = $_POST['mobile'];
    $Email = $_POST['email'];
    $AddressLine1 = $_POST['AddressLine1'];
    $AddressLine2 = $_POST['AddressLine2'];
    $Town = $_POST['Town'];
    $County = $_POST['County'];
    $Eircode = $_POST['Eircode'];

    // Construct SQL INSERT query to insert data into the 'info' table
    $sql = "INSERT INTO `info` (title, firstname, surname, mobile, email, AddressLine1, AddressLine2, Town, County, Eircode)
            values('$Title', '$FirstName', '$Surname', '$Mobile', '$Email', '$AddressLine1', '$AddressLine2', '$Town', '$County', '$Eircode')";
    // Execute the query
    $result = mysqli_query($con, $sql);
    
    // Check if insertion was successful
    if($result) {
       // Redirect to 'display.php' if successful
        header('location: assaignment-04display.php');
    } else {
        // Display MySQL error if insertion failed
        die(mysqli_error($con));
    }
}

?>

<!doctype html>
<html lang="en">

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min/css"> 
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css"
    integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    
    <title>PERSONAL INFO</title>
</head>

<body>
    <div class="container my-2">
        <!-- Form for entering personal information -->
        <form method="post">
         <div class="form-group">
                <label>Title</label>
                <!-- Input field for Title -->
                <input type="text" class="form-control" placeholder="Please enter your Title" name="title" autocomplete ="off" >
            </div>
            <div class="form-group">
                <label>FirstName</label>
                <!-- Input field for First Name -->
                <input type="text" class="form-control" placeholder="Please enter your First name" name="firstname" autocomplete ="off" >
            </div>
            <div class="form-group">
                <label> Surname</label>
                <!-- Input field for Surname -->
                <input type="text" class="form-control" placeholder="Please enter your Surname" name="surname"autocomplete ="off" >
            </div>

            <div class="form-group">
                <label>Mobile</label>
                <!-- Input field for Mobile -->
                <input type="text" class="form-control" placeholder="Please enter your phone number" name="mobile"autocomplete ="off" >
            </div>

            <div class="form-group">
                <label>Email</label>
                <!-- Input field for Email -->
                <input type="email" class="form-control" placeholder="Please enter your email address" name="email" autocomplete ="off" >
            </div>

            <div class="form-group">
                <label>AddressLine1</label>
                <!-- Input field for Address Line 1 -->
                <input type="text" class="form-control" placeholder="Please enter your AddressLine1" name="AddressLine1" autocomplete ="off" >
            </div>

            <div class="form-group">
                <label>AddressLine2</label>
                <!-- Input field for Address Line 2 -->
                <input type="text" class="form-control" placeholder="Please enter your AddressLine2" name="AddressLine2" autocomplete ="off" >
            </div>

            <div class="form-group">
                <label>Town</label>
                <!-- Input field for Town -->
                <input type="text" class="form-control" placeholder="Please enter your Town" name="Town" autocomplete ="off" >
            </div>

            <div class="form-group">
                <label>County</label>
                <!-- Input field for County -->
                <input type="text" class="form-control" placeholder="Please enter your County" name="County" autocomplete ="off" >
            </div>

            <div class="form-group">
                <label>Eircode</label>
                <!-- Input field for Eircode -->
                <input type="text" class="form-control" placeholder="Please enter your Eircode" name="Eircode" autocomplete ="off" >
            </div>

            <!-- Submit button to submit the form -->
            <button type="submit" class="btn btn-primary" name = "submit">Submit</button>
        </form>
    </div>
</body>

</html>
