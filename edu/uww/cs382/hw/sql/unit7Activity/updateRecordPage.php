<h1>Update Records</h1>
<table>
    <tr>
        <th>Name</th>
        <th>Type</th>
        <th>Year</th>
        <th></th>
    </tr>
    <?php
    $db = $GLOBALS['db'];
    $sql = "SELECT * FROM movies";
    $list = fetchResults($db, $sql);
    foreach ($list as $row) {
        echo "<tr>";
        echo "<td>" . $row['title'] . "</td>";
        echo "<td>" . $row['type'] . "</td>";
        echo "<td>" . $row['year'] . "</td>";
        echo "<td><a href='index.php?mode=updaterecord&title=" . $row['title'] . "&type=" . $row['type'] . "&year=" . $row['year'] . "'>Edit</a></td>";
        echo "</tr>";
    }
    ?>
</table>

<style>
    table {
        width: 100%;
    }

    th,
    td {
        border-top: 1px solid black;
        text-align: left;
    }

    th {
        background-color: #f2f2f2;
    }
</style>