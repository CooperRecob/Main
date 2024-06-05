<h1>Course Catalog</h1>
<table class="table table-striped">
    <thead>
        <tr>
            <th>Course</th>
            <th>Title</th>
            <th>Description</th>
            <th>Credits</th>
            <th>Gen Ed</th>
        </tr>
    </thead>
    <tbody>
        <?php
        //display catalog from courses table
        $sql = "SELECT * FROM `courses` ORDER BY subject, number";
        $results = fetchResults($db, $sql, null);

        foreach ($results as $row) {
            echo "<tr>";
            echo "<td>" . $row['subject'] . " " . $row['number'] . "</td>"; //subject + number
            echo "<td>" . $row['title'] . "</td>";
            echo "<td>" . $row['description'] . "</td>";
            echo "<td>" . $row['credits'] . "</td>";
            echo "<td>" . $row['gened'] . "</td>";
            echo "</tr>";
        }
        ?>
    </tbody>
</table>