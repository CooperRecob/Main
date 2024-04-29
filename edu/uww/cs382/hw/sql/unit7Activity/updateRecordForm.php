<h1>Update Movie</h1>
<?php 
echo"<p>Movie: " . $_REQUEST['title'] . "</p>";
?>
<form action="index.php?mode=updateresults" method="post">
    <input type="hidden" name="oldtitle" value="<?php echo $_REQUEST['title']; ?>" />
    <p>Movie Title: <input type="text" name="newtitle"  /></p>
    <p>Movie Type: <select name="newtype" >
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
    <p>Year: <input type="text" name="newyear"  /></p>
    <button type="submit" class="btn btn-primary ">Update</button>
    <button type="reset" class="btn btn-primary ">Clear</button>
</form>