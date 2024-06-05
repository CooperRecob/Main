<h1>Fall 2024 Semester Plan</h1>
<?php
//display the name
echo "<p>Name: " . $_SESSION['name'] . "</p>";

$sql = "SELECT title, section, semesterplans.schedule_id, time, location, instructor, credits FROM `semesterplans`
JOIN `schedules` ON semesterplans.schedule_id = schedules.schedule_id
JOIN `courses` ON schedules.course_id = courses.course_id
WHERE memberID = :memberID";
$parameterValues = [
    ":memberID" => $_SESSION['memberID']
];
$results = fetchResults($db, $sql, $parameterValues);

//if results is empty display message
if (empty($results)) {
    echo "<p>Your semester plan is empty.</p>";
} else {
    echo "
<table class='table table-striped'>
    <thead>
        <tr>
            <th>Course</th>
            <th>Section</th>
            <th>Time</th>
            <th>Location</th>
            <th>Instructor</th>
            <th>Credits</th>
            <th>Action</th>
        </tr>
    </thead>
    <tbody>";

    foreach ($results as $row) {
        echo "<tr>";
        echo "<td>" . $row['title'] . "</td>";
        echo "<td>" . $row['section'] . "</td>";
        echo "<td>" . $row['time'] . "</td>";
        echo "<td>" . $row['location'] . "</td>";
        echo "<td>" . $row['instructor'] . "</td>";
        echo "<td>" . $row['credits'] . "</td>";
        echo "<td><a href='index.php?mode=delete&schedule_id=" . $row['schedule_id'] . "' onclick='return confirm(\"Are you sure you want to remove this course from your plan?\")'>Remove from Plan</a></td>";
        echo "</tr>";
    }
    ?>
    </tbody>
    </table>
    <?php
    // calculate the total number of credits
    $totalCredits = 0;
    foreach ($results as $row) {
        $totalCredits += $row['credits'];
    }
    echo "<p>Total Credits Planned: " . $totalCredits . "</p>";
}
?>