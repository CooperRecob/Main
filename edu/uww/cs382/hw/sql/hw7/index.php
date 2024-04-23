<!DOCTYPE html>
<html>

<head>
    <title>Homework 7</title>
    <?php
    // connect to the db
    include 'pdo_connect.php';
    ?>
</head>

<body>
    <h1>Online Movie Store</h1>
    <?php
    // get movies from the db
    $allMovies = $db->query('SELECT title, type, year FROM movies UNION SELECT title, type, year FROM disney_movies');
    $recentReleases = $db->query('SELECT title, type, year FROM movies WHERE year > 2019');
    $classicalMovies = $db->query('SELECT title, type, year FROM movies WHERE year < 1980');
    $popularDramaMovies = $db->query('SELECT DISTINCT title, type, year FROM movies JOIN rentals ON movies.movieID = rentals.movieID WHERE movies.type = "Drama"');
    $recentDisneyMovies = $db->query('SELECT title, type, year FROM disney_movies WHERE year > 2020');
    $disneyFamilyClassics = $db->query('SELECT title, type, year FROM disney_movies WHERE year < 1950');
    $latestDisneyAnimationMovies = $db->query('SELECT title, type, year FROM disney_movies WHERE year > 2020 AND type = "Animation"');

    // close db connection
    $db = null;
    ?>

    <!--create links-->
    <a href='index.php'>All | </a>
    <a href='index.php?link=recentReleases'>Recent Releases | </a>
    <a href='index.php?link=classicalMovies'>Classical Movies | </a>
    <a href='index.php?link=popularDramaMovies'>Popular Drama Movies | </a>
    <a href='index.php?link=recentDisneyMovies'>Recent Disney Movies | </a>
    <a href='index.php?link=disneyFamilyClassics'>Disney Family Classics | </a>
    <a href='index.php?link=latestDisneyAnimationMovies'>Latest Disney Animation Movies | </a>
    <br><br>

    <?php
    // display filtered movies as a table
    if (isset($_GET['link'])) {
        $link = $_GET['link'];
        switch ($link) {
            case 'recentReleases':
                $movies = $recentReleases;
                break;
            case 'classicalMovies':
                $movies = $classicalMovies;
                break;
            case 'popularDramaMovies':
                $movies = $popularDramaMovies;
                break;
            case 'recentDisneyMovies':
                $movies = $recentDisneyMovies;
                break;
            case 'disneyFamilyClassics':
                $movies = $disneyFamilyClassics;
                break;
            case 'latestDisneyAnimationMovies':
                $movies = $latestDisneyAnimationMovies;
                break;
        }
    } else {
        $movies = $allMovies;
    }

    // display movies
    displayMovies($movies);
    ?>
</body>

</html>
<?php
function displayMovies($movies)
{
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
}
?>