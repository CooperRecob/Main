<?php
include ('pdo_connect.php');
// check for db connection
if (isset ($db)) {
    echo "Connected";
} else {
    echo "Could not connect";
}
// do something with moves.sql
$movies = $db->query('SELECT * FROM movies');
// display the results as a table
echo "<table border='1'>";
echo "<tr><th>Movie ID</th><th>Title</th><th>Year</th><th>Type</th></tr>";
foreach ($movies as $row) {
    echo "<tr><td>".$row['movieID']."</td><td>".$row['title']."</td><td>".$row['year']."</td><td>".$row['type']."</td></tr>";
}
echo "</table>";
// close the db connection
$db = null;