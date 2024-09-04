<?php
include 'connect.php'; // file containing the database connection

if(isset($_POST['search'])){ 
// Check if the form has been submitted with the name 'search'
    $searchName = $_POST['searchName']; 
    // Get the value of the input field named 'searchName'

    // Construct SQL query to search for records where the first name or surname contains the search term
    $sql = "SELECT * FROM info WHERE firstname LIKE '%$searchName%' OR surname LIKE '%$searchName%'"; 
    $result = mysqli_query($con, $sql); 
    // Execute the query

    // Check if there are any results
    if(mysqli_num_rows($result) > 0) {
        echo "<h2>Search Results:</h2>";
        echo "<table class='table'>
                <thead>
                    <tr>
                        <th scope='col'>No</th>
                        <th scope='col'>Title</th>
                        <th scope='col'>FirstName</th>
                        <th scope='col'>LastName</th>
                        <th scope='col'>Mobile</th>
                        <th scope='col'>Email</th>
                        <th scope='col'>AddressLine1</th>
                        <th scope='col'>AddressLine2</th>
                        <th scope='col'>Town</th>
                        <th scope='col'>County</th>
                        <th scope='col'>Eircode</th>
                    </tr>
                </thead>
                <tbody>";
        $count = 1; // Initialize a counter variable
        // Loop through each row of the result set and display the data in a table
        while($row = mysqli_fetch_assoc($result)) {
            echo "<tr>
                    <th scope='row'>".$count++."</th>
                    <td>".$row['Title']."</td>
                    <td>".$row['FirstName']."</td>
                    <td>".$row['Surname']."</td>
                    <td>".$row['Mobile']."</td>
                    <td>".$row['Email']."</td>
                    <td>".$row['AddressLine1']."</td>
                    <td>".$row['AddressLine2']."</td>
                    <td>".$row['Town']."</td>
                    <td>".$row['County']."</td>
                    <td>".$row['Eircode']."</td>
                </tr>";
        }
        echo "</tbody></table>"; // Close the table
    } else {
        echo "<h2>No results found</h2>"; // Display a message if no results are found
    }
}
?>

<!doctype html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Search User Information</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>

<body>
    <div class="container my-2">
        <h1>Search User Information</h1>
        <!-- Form for searching user information -->
        <form method="post">
            <div class="form-group">
                <label>Enter Name to Search:</label>
                <input type="text" class="form-control" placeholder="Enter name" name="searchName" autocomplete="off">
            </div>
            <button type="submit" class="btn btn-success" name="search">Search</button>
        </form>
    </div>
</body>

</html>

