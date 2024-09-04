<?php
// file containing the database connection
include 'assaignment-04connect.php';
// Getting the ID of the record to be updated
$id = $_GET['updateid'];

// Select the record from the database based on the ID
$sql= "SELECT * FROM info where `id`= '$id'";
$result = mysqli_query($con, $sql);
$row = mysqli_fetch_assoc($result);

// Assign values from the selected record to variables
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

    // Construct SQL update query to update the record in the 'info' table
    $sql= "UPDATE `info` SET title='$Title', firstname='$FirstName', surname='$Surname', mobile='$Mobile',
    email='$Email', AddressLine1='$AddressLine1', AddressLine2='$AddressLine2',
    Town='$Town', County='$County', Eircode='$Eircode' WHERE id='$id'";
    $result = mysqli_query($con, $sql); 
    // Execute the query

    
    if($result) {
        // Redirect to 'display.php' if successful
        header('location: assaignment-04display.php');
    } else {
        
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
    <title>Update User Information</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css"
        integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>

<body>
    <div class="container my-2">
        <h1>Update User Information</h1>
        <form method="post">
            <!-- Input fields pre-filled with the values from the selected record -->
            <div class="form-group">
                <label>Title</label>
                <input type="text" class="form-control" placeholder="Please enter your Title" name="title" autocomplete="off"
                 value="<?php echo $Title;?>">
            </div>
            <div class="form-group">
                <label>FirstName</label>
                <input type="text" class="form-control" placeholder="Please enter your First name" name="firstname" autocomplete="off"
                value="<?php echo $FirstName;?>">
            </div>
            <div class="form-group">
                <label>Surname</label>
                <input type="text" class="form-control" placeholder="Please enter your Surname" name="surname" autocomplete="off"
                value="<?php echo $Surname;?>">
            </div>
            <div class="form-group">
                <label>Mobile</label>
                <input type="text" class="form-control" placeholder="Please enter your phone number" name="mobile" autocomplete="off"
                value="<?php echo $Mobile;?>">
            </div>
            <div class="form-group">
                <label>Email</label>
                <input type="email" class="form-control" placeholder="Please enter your email address" name="email" autocomplete="off"
                value="<?php echo $Email;?>">
            </div>
            <div class="form-group">
                <label>AddressLine1</label>
                <input type="text" class="form-control" placeholder="Please enter your AddressLine1" name="AddressLine1" autocomplete="off"
                value="<?php echo $AddressLine1;?>">
            </div>
            <div class="form-group">
                <label>AddressLine2</label>
                <input type="text" class="form-control" placeholder="Please enter your AddressLine2" name="AddressLine2" autocomplete="off"
                value="<?php echo $AddressLine2;?>">
            </div>
            <div class="form-group">
                <label>Town</label>
                <input type="text" class="form-control" placeholder="Please enter your Town" name="Town" autocomplete="off"
                value="<?php echo $Town;?>">
            </div>
            <div class="form-group">
                <label>County</label>
                <input type="text" class="form-control" placeholder="Please enter your County" name="County" autocomplete="off"
                value="<?php echo $County;?>">
            </div>
            <div class="form-group">
                <label>Eircode</label>
                <input type="text" class="form-control" placeholder="Please enter your Eircode" name="Eircode" autocomplete="off"
                value="<?php echo $Eircode;?>">
            </div>
            <!-- Submit button to update the record -->
            <button type="submit" class="btn btn-primary" name="submit">Update</button>
        </form>
    </div>
</body>

</html>


