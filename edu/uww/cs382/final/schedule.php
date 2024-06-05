<h1>Schedule of Classes</h1>
<table class="table table-striped">
    <thead>
        <tr>
            <th>Course</th>
            <th>Section</th>
            <th>Time</th>
            <th>Location</th>
            <th>Instructor</th>
            <th>Gen Ed</th>
            <th>Action</th>
        </tr>
    </thead>
    <tbody>
        <?php
        //display catalog from courses and schedules tables
        $sql = "SELECT * FROM `courses` JOIN `schedules` ON courses.course_id = schedules.course_id ORDER BY subject, number";
        $results = fetchResults($db, $sql, null);

        //use the mode to filter the results either COPSCI, MATH, MAGD, CORE, or GENED
        if ($_GET['mode'] != "schedule" && $_GET['mode'] != "GENED") {
            $mode = $_GET['mode'];
            $sql = "SELECT * FROM `courses` JOIN `schedules` ON courses.course_id = schedules.course_id WHERE subject = :mode ORDER BY courses.number";
            $parameterValues = [
                ":mode" => $mode
            ];
            $results = fetchResults($db, $sql, $parameterValues);
        } else if ($_GET['mode'] == "GENED") {
            foreach ($results as $key => $row) {
                if ($row['gened'] == "") {
                    unset($results[$key]);
                }
            }

        }

        foreach ($results as $row) {
            echo "<tr>";
            echo "<td>" . $row['subject'] . " " . $row['number'] . "</td>"; //subject + number
            echo "<td>" . $row['section'] . "</td>";
            echo "<td>" . $row['time'] . "</td>";
            echo "<td>" . $row['location'] . "</td>";
            echo "<td>" . $row['instructor'] . "</td>";
            echo "<td>" . $row['gened'] . "</td>";
            echo "<td><a href='index.php?mode=register&schedule_id=" . $row['schedule_id'] . "'>Add to Plan</a></td>";
            echo "</tr>";
        }
        ?>
    </tbody>
</table>