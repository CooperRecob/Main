<nav class="navbar navbar-expand-lg navbar-dark" style="background-color: #6c757d;">
    <div class="collapse navbar-collapse" id="navbarText">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="index.php">Home</a>
            </li>
            <?php
            if (!empty($_SESSION['memberID'])) {
                ?>
                <li class="nav-item">
                    <a class="nav-link" href="index.php?mode=catalog">Course Catalog</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="index.php?mode=schedule">Schedule of Classes</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="index.php?mode=COMPSCI">COMPSCI Classes</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="index.php?mode=MATH">MATH Classes</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="index.php?mode=MAGD">MAGD Classes</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="index.php?mode=CORE">CORE Classes</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="index.php?mode=GENED">Gen Ed Classes</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="index.php?mode=plan">Semseter Plan</a>
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