<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Display Course Schedule</title>
    <style type="text/css">
    table { 
        border: 1px solid black; 
        border-collapse: collapse; 
        background: #fff; 
    }
    
    th, td { 
        border: 1px solid black; 
        padding: .2em .7em;   
        color: #000;
        font-size: 16px; 
        font-weight: 400; 
    } 
    
    thead th { 
        background-color: #1A466A; 
        color: #fff; 
        font-weight: bold;  
    }
    
    .container { 
        margin: 10px;
    }
    </style>
</head>
<body>
    <h1>Display Course Schedule</h1>
    <?php
    //Create a PHP script that reads data from the spring2024schedule.txt file and then displays a page
    /*
    1. The default display should include a list of all the sections. display it in a table format. ( 5  points)

    2. The output should include  Filter by Subjects links and Filter by Location links ( 7  points)

    3. When any of the Filter by Subject links is clicked, your script should filter and display schedules matching the selected subject. For example, an output similar to the following should be displayed when the Computer Science link is clicked: (4 points)

    4. When any of the Filter by Location links is clicked, your script should filter and display schedules matching the selected location. For example, an output similar to the following should be displayed when the MG0115 link is clicked: (4 points)
    
    the txt file is in this format:
        MAGD,150,1,Tu,09:30 10:45,Leighton,Fred ,L0123
        MAGD,150,1,M,14:00 15:15,Leighton,Fred Vichot,HE0101
        where it goes subject, course, section, day, time, teacher last name, teacher first name, location
    */
    $file = fopen("spring24schedule.txt", "r") or die("Unable to open file!");
    $data = array();

    // make a class for the data
    class Course {
        public $subject;
        public $course;
        public $section;
        public $day;
        public $time;
        public $teacher;
        public $location;
    }

    // read the file and put it into the class
    while(!feof($file)) {
        $line = fgets($file);
        $line = trim($line);
        $course = explode(",", $line);
        $data[] = (object) [
            "subject" => $course[0],
            "course" => $course[1],
            "section" => $course[2],
            "day" => $course[3],
            "time" => $course[4],
            "teacher" => $course[6] . " " . $course[5],
            "location" => $course[7]
        ];
    }
    fclose($file);

    // create the links to sort by subject, location, or display all courses 
    echo "<p><a href='?'>All Courses</a></p>";
    echo "<p>Filter by Subject: ";
    $subjects = array();
    foreach($data as $course) {
        if(!in_array($course->subject, $subjects)) {
            array_push($subjects, $course->subject);
            echo "<a href='?subject=" . $course->subject . "'>" . $course->subject . "</a> | ";
        }
    }
    echo "</p>";

    echo "<p>Filter by Location: ";
    $locations = array();
    foreach($data as $course) {
        if(!in_array($course->location, $locations)) {
            array_push($locations, $course->location);
            echo "<a href='?location=" . $course->location . "'>" . $course->location . "</a> | ";
        }
    }
    echo "</p><br>";

    // Filter the data based on query parameters
    $filteredData = $data;
    if(isset($_GET['subject'])) {
        $filteredData = array_filter($filteredData, function($course) {
            return $course->subject == $_GET['subject'];
        });
    }
    if(isset($_GET['location'])) {
        $filteredData = array_filter($filteredData, function($course) {
            return $course->location == $_GET['location'];
        });
    }

    // display the data in a table
    echo "<div class='container'>";
    echo "<table>";
    echo "<thead>";
    echo "<tr>";
    echo "<th>Subject</th>";
    echo "<th>Course</th>";
    echo "<th>Section</th>";
    echo "<th>Day</th>";
    echo "<th>Time</th>";
    echo "<th>Instructor</th>";
    echo "<th>Location</th>";
    echo "</tr>";
    echo "</thead>";
    echo "<tbody>";
    foreach($filteredData as $course) {
        echo "<tr>";
        echo "<td>" . $course->subject . "</td>";
        echo "<td>" . $course->course . "</td>";
        echo "<td>" . $course->section . "</td>";
        echo "<td>" . $course->day . "</td>";
        echo "<td>" . $course->time . "</td>";
        echo "<td>" . $course->teacher . "</td>";
        echo "<td>" . $course->location . "</td>";
        echo "</tr>";
    }
    echo "</tbody>";
    echo "</table>";
    echo "</div>";
    ?>
    </body>
    </html>