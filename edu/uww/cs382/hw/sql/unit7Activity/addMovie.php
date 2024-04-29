<h1>Add New Movie</h1>
<form action="index.php?mode=results" method="post">
    <p>Movie Title: <input type="text" name="title"  /></p>
    <p>Movie Type: <select name="type" >
        <?php 
        include ('pdo_connect.php');
        $sql = "SELECT DISTINCT type from `movies` order by type";
        $list = fetchResults($db, $sql);
        echo "<option value=''>--select one--</option>";
        foreach ($list as $row) {
            echo "<option value='" . $row['type'] . "'>" . $row['type'] . "</option>";
        }
        ?>
    </select></p>
    <p>Year: <input type="text" name="year"  /></p>
    <button type="submit" class="btn btn-primary ">Add New Movie</button>
    <button type="reset" class="btn btn-primary ">Clear</button>
</form>