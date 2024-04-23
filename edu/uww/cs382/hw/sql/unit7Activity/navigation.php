<nav class="navbar navbar-expand-lg navbar-dark" style="background-color: #6c757d;">
    <div class="collapse navbar-collapse" id="navbarText">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="index.php">Home</a>
            </li>
 <?php 
 if(!empty($_SESSION['adminID']))
 {
 ?>
            <li class="nav-item">
                <a class="nav-link" href="index.php?mode=newmovie">Add New Movie</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="index.php?mode=updaterecord">Update a Record</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="index.php?mode=signout">Sign Out</a>
            </li>
 <?php 
 }
 ?>
        </ul>
    </div>
</nav>