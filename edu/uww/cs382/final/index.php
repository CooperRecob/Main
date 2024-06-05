<?php

session_start();

include ("pdo_connect.php");
include ('header.html');

include ("navigation.php");


// Check if the adminID is already stored using a session variable then display a message

if (empty($_SESSION['memberID']) && empty($_REQUEST['username'])) {
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
                $sql = "SELECT memberID, username FROM `members` 
            WHERE username = :username and password = :password";

                // Bind values to named parameters
                $parameterValues = [
                    ":username" => $username,
                    ":password" => md5($password)
                ];
                // Execute SQL statement
                $results = fetchResults($db, $sql, $parameterValues);

                // First element of the $results array should include matching record           
                if (!empty($results[0]['memberID'])) {
                    // Valid user - Define session variables
                    $_SESSION['memberID'] = $results[0]['memberID'];

                    $sql = "SELECT firstName, lastName FROM `members` 
                    WHERE memberID = :memberID";
                    $parameterValues = [
                        ":memberID" => $results[0]['memberID']
                    ];
                    $results = fetchResults($db, $sql, $parameterValues);

                    $_SESSION['name'] = $results[0]['firstName'] . " " . $results[0]['lastName'];

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
    case 'catalog':
        include ('catalog.php');
        break;
    case 'plan':
        include ('plan.php');
        break;
    case 'register':
        // Display the name of the class
        $schedule_id = $_GET['schedule_id'];
        $sql = "SELECT * FROM `schedules` JOIN `courses` ON schedules.course_id = courses.course_id WHERE schedule_id = :schedule_id";
        $parameterValues = [
            ":schedule_id" => $schedule_id
        ];
        $results = fetchResults($db, $sql, $parameterValues);
        echo "<p>" . $results[0]['subject'] . " " . $results[0]['number'] . " added to the semester plan</p>";

        // Add the course to the semesterplans table for the current user
        $sql = "INSERT INTO `semesterplans` (memberID, schedule_id) VALUES (:memberID, :schedule_id)";
        $parameterValues = [
            ":memberID" => $_SESSION['memberID'],
            ":schedule_id" => $schedule_id
        ];
        $results = fetchResults($db, $sql, $parameterValues);

        break;
    case 'delete':
        // Remove the course from the semesterplans table for the current user
        $sql = "DELETE FROM `semesterplans` WHERE schedule_id = :schedule_id AND memberID = :memberID";
        $parameterValues = [
            ":schedule_id" => $_REQUEST['schedule_id'],
            ":memberID" => $_SESSION['memberID']
        ];
        $results = fetchResults($db, $sql, $parameterValues);

        // reload page to display the updated plan
        include ('plan.php');

        break;
    case "schedule" || "COMPSCI" || "MATH" || "MAGD" || "CORE" || "GENED":
        include ('schedule.php');
        break;
    default:
        include ('home.html');
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
    echo "<h1>Welcome " . $_SESSION['name'] . "</h1>"; //grab name from session variable NOTWORKING
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