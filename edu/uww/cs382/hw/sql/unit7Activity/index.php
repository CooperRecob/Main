<?php

session_start();

/* This script performs several tasks
1. Add a new record
2. Update existing record
3. Delete a record

*/

include ("pdo_connect.php");
include ('header.html');

include ("navigation.php");


// Check if the adminID is already stored using a session variable then display a message

if (empty($_SESSION['adminID']) && empty($_REQUEST['username'])) {
    // Invalid user
    displayloginform();
    exit();
}

$parameterValues = null;
$mode = "";
if (isset($_REQUEST["mode"])) {
    $mode = $_REQUEST["mode"];
}

switch ($mode) {
    case "signout":
        // Destroy session variables and display the login form
        session_unset();
        setcookie(session_name(), '', time() - 1000, '/');
        $_SESSION = array();
        // Need to reload the page to hide navigation links
        header('Location: index.php');
        break;

    case 'login':
        // Validate user
        if (isset($_REQUEST['username'])) {
            // Validate user
            $username = (!empty($_REQUEST['username'])) ? $_REQUEST['username'] : "";
            $password = (!empty($_REQUEST['password'])) ? $_REQUEST['password'] : "";
            if ($username == "" || $password == "") {
                // Invalid data
                echo "<p>Invalid data</p>";
                displayloginform();
            } else {
                // Validate the username and password
                $sql = "SELECT id, username FROM `users` 
            WHERE username = :username and password = :password";

                // Bind values to named parameters
                $parameterValues = [
                    ":username" => $username,
                    ":password" => md5($password)
                ];
                // Execute SQL statement
                $results = fetchResults($db, $sql, $parameterValues);

                // First element of the $results array should include matching record           
                if (!empty($results[0]['id'])) {
                    // Valid user - Define session variables
                    $_SESSION['adminID'] = $results[0]['id'];


                    // Need to reload the page to display navigation links
                    header('Location: index.php');

                } else {
                    // Invalid user
                    echo "Invalid user";
                    displayloginform();
                    exit();
                }
            }
        }
        break;
    case "newmovie":
        displayMoviePage();
        break;
    case "results":
        displayResults();
        break;
    case "updaterecord":
        displayUpdatePage();
        break;
    case "updateresults":
        displayUpdateResults();
        break;
    default:
        displayHomePage();
        break;
}

include ('footer.html');

function fetchResults($db, $sql, $parametervalues = null)
{
    //prepare statement class
    $stm = $db->prepare($sql);

    // Execute the statement with named parameters
    $stm->execute($parametervalues);

    // Fetch the result set
    $list = $stm->fetchAll(PDO::FETCH_ASSOC);

    // Return the result set
    return $list;
}

function displayHomePage()
{
    echo "<h1>Welcome Admin</h1>";
}

function displayMoviePage()
{
    include ('addMovie.php');
}

function displayUpdatePage()
{
    if(empty($_REQUEST['title'])){
        include ('updateRecordPage.php');
    } else if (!empty($_REQUEST['title'])){
        include ('updateRecordForm.php');
    }
}

function displayUpdateResults() 
{
    if (empty($_REQUEST['newtitle']) || empty($_REQUEST['newyear']) || empty($_REQUEST['newtype'])) {
        echo "<p>Empty data</p>";
        exit();
    } else if (!is_numeric($_REQUEST['newyear'])) { 
        echo "<p>Invalid year</p>";
        exit();
    }

    $db = $GLOBALS['db'];

    // Update the record
    $sql = "UPDATE `movies` SET title = :newtitle, type = :newtype, year = :newyear WHERE title = :oldtitle";
    $parameterValues = array(
        ":newtitle" => $_REQUEST['newtitle'],
        ":newtype" => $_REQUEST['newtype'],
        ":newyear" => $_REQUEST['newyear'],
        ":oldtitle" => $_REQUEST['oldtitle']
    );
    $stm = $db->prepare($sql);
    $stm->execute($parameterValues);

    // Display the updated record
    echo "<p>The movie \"" . $_REQUEST['oldtitle'] . "\" has been updated to:</p>";
    echo "<p>title: " . $_REQUEST['newtitle'] . "</p>";
    echo "<p>type: " . $_REQUEST['newtype'] . "</p>";
    echo "<p>year: " . $_REQUEST['newyear'] . "</p>";
}

function displayResults()
{
    if (empty($_REQUEST['title']) || empty($_REQUEST['year']) || empty($_REQUEST['type']))  {
        echo "<p>Empty data</p>";
        exit();
    } else if (!is_numeric($_REQUEST['year'])) {
        echo "<p>Invalid year</p>";
        exit();
    }

    $db = $GLOBALS['db'];

    // Insert a new record
    $sql = "INSERT INTO `movies` (title, type, year) VALUES (:title, :type, :year)";
    $parameterValues = array(
        ":title" => $_REQUEST['title'],
        ":type" => $_REQUEST['type'],
        ":year" => $_REQUEST['year']
    );
    $stm = $db->prepare($sql);
    $stm->execute($parameterValues);

    // Display the record
    echo "<p>The following record has been added:</p>";
    echo "<p>title: " . $_REQUEST['title'] . "</p>";
    echo "<p>type: " . $_REQUEST['type'] . "</p>";
    echo "<p>year: " . $_REQUEST['year'] . "</p>";

}

function displayloginform()
{
    ?>
    <form action="index.php?mode=login" method="post" class="form-signin">
        <h3>Sign in</h3>
        <p>Username: <input type="text" name="username" class="form-control" /></p>
        <p>Password: <input type="password" name="password" class="form-control" /></p>
        <p><button type="submit" class="btn btn-primary ">Sign in</button></p>
    </form>
    <?php
}
?>