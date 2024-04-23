<!DOCTYPE html>
<html>

<head>
    <title>Unit 5 Activity</title>
</head>

<body>
    <h1>Online Movie Store</h1>
    <?php
    // connect to the db
    try {
        $db = new PDO('mysql:host=localhost;dbname=moviestore', 'root', '');

    } catch (PDOException $e) {
        print "Error!: " . $e->getMessage() . "<br/>";
        die();
    }

    // get movies from the db
    $movies = $db->query('SELECT * FROM movies');
    $movieGenres = $db->query('SELECT type FROM movies');

    // remove duplicates from the genres
    $movieGenres = $movieGenres->fetchAll(PDO::FETCH_ASSOC);
    $movieGenres = array_unique($movieGenres, SORT_REGULAR);

    // display genres as links for filtering
    echo "<a href='index.php'>All | </a>";
    foreach ($movieGenres as $genre) {
        echo "<a href='index.php?genre=" . $genre['type'] . "'>" . $genre['type'] . " | </a>";
    }
    echo "<br>";
    echo "<br>";

    // display filtered movies
    if (isset($_GET['genre'])) {
        $genre = $_GET['genre'];
        $movies = $db->query("SELECT * FROM movies WHERE `type` LIKE '%$genre%'");
    }
    echo "<table border='1'>";
    echo "<tr><th>Title</th><th>Genre</th><th>Year</th></tr>";
    foreach ($movies as $movie) {
        echo "<tr>";
        echo "<td>" . $movie['title'] . "</td>";
        echo "<td>" . $movie['type'] . "</td>";
        echo "<td>" . $movie['year'] . "</td>";
        echo "</tr>";
    }
    echo "</table>";

    // close db connection
    $db = null;
    ?>
</body>

</html>