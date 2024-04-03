<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="stylesheets.css">
    <title>Online Order Form</title>
</head>

<body>
    <h1>Online Order Form</h1>
    <div id="top">
        <form action="">
            <label for="os">Operating System:</label>
            <select id="os" name="os">
                <option value="0">--Select Operating System--</option>
                <option value="Windows">Windows</option>
                <option value="Linux">Linux</option>
                <option value="Mac">Mac</option>
            </select>
            <br />
            <label for="processor">Processor:</label>
            <select id="processor" name="processor">
                <option value="0">Intel Core i5</option>
                <option value="300">Intel Core i7</option>
                <option value="400">AMD Ryzen</option>
            </select>
            <br />
            <label>Memory:</label>
            <input type="radio" id="8GB" name="memory" value="0" checked />
            <label for="8GB">8 GB</label>
            <input type="radio" id="16GB" name="memory" value="100" />
            <label for="16GB">16 GB</label>
            <input type="radio" id="32GB" name="memory" value="200" />
            <label for="32GB">32 GB</label>
            <input type="radio" id="64GB" name="memory" value="400" />
            <label for="64GB">64 GB</label>
            <input type="radio" id="128GB" name="memory" value="800" />
            <label for="128GB">128 GB</label>
            <br />
            <label>Hard Drive:</label>
            <input type="radio" id="1TB" name="storage" value="0" checked />
            <label for="1TB">1 TB</label>
            <input type="radio" id="2TB" name="storage" value="44.99" />
            <label for="2TB">2 TB</label>
            <input type="radio" id="4TB" name="storage" value="109.99" />
            <label for="4TB">4 TB</label>
            <input type="radio" id="8TB" name="storage" value="229.99" />
            <label for="8TB">8 TB</label>
            <input type="radio" id="10TB" name="storage" value="279.99" />
            <label for="10TB">10 TB</label>
            <br />
            <label>Accessories:</label>
            <input type="checkbox" id="battery" name="accessories[]" value="69" />
            <label for="battery">Battery Backup</label>
            <input type="checkbox" id="webcam" name="accessories[]" value="79" />
            <label for="webcam">Webcam</label>
            <input type="checkbox" id="mouse" name="accessories[]" value="49.99" />
            <label for="mouse">Wireless Mouse</label>
            <input type="checkbox" id="headset" name="accessories[]" value="69" />
            <label for="headset">Headset</label>
            <input type="checkbox" id="clicker" name="accessories[]" value="42.99" />
            <label for="clicker">Presentation Clicker</label>

    </div>
    <br />
    <div id="bottom">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" />
        <br />
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" />
        <br />
        <label for="comments">Comments:</label>
        <textarea id="comments" name="comments"></textarea>
        <br />
        <input type="submit" value="Submit" />
        <input type="reset" value="Cancel" />
        </form>
    </div>
    <div id="output">
        <?php
        
        $os = "";
        if(isset($_REQUEST["os"])) $os = $_REQUEST["os"];
        $processor = ["0" => "Intel Core i5", "300" => "Intel Core i7", "400" => "AMD Ryzen"];
        $memory = ["0" => "8 GB", "100" => "16 GB", "200" => "32 GB", "400" => "64 GB", "800" => "128 GB"];
        $storage = ["0" => "1 TB", "44.99" => "2 TB", "109.99" => "4 TB", "229.99" => "8 TB", "279.99" => "10 TB"];
        $accessories = ["69" => "Battery Backup", "79" => "Webcam", "49.99" => "Wireless Mouse", "59" => "Headset", "42.99" => "Presentation Clicker"];
        $processorCost = 0;
        if(isset($_REQUEST["processor"])) $processorCost = $_REQUEST["processor"];
        $memoryCost = 0;
        if(isset($_REQUEST["memory"])) $memoryCost = $_REQUEST["memory"];
        $storageCost = 0;
        if(isset($_REQUEST["storage"])) $storageCost = $_REQUEST["storage"];
        $accessoriesCost = 0;
        $accessoriesList = "";
        if (isset($_REQUEST["accessories"]) && is_array($_REQUEST["accessories"])) {
            foreach ($_REQUEST["accessories"] as $value) {
                $accessoriesCost += $value;
                $accessoriesList .= $accessories[$value] . ", ";
            }
        }
        $accessoriesList = rtrim($accessoriesList, ", ");
        $name = "";
        if(isset($_REQUEST["name"])) $name = $_REQUEST["name"];
        $email = "";
        if(isset($_REQUEST["email"])) $email = $_REQUEST["email"];
        $comments = "";
        if(isset($_REQUEST["comments"])) $comments = $_REQUEST["comments"];
        $total = 800 + $processorCost + $memoryCost + $storageCost + $accessoriesCost;
        $tax = $total * 0.05;
        $error = false;
        if ($os == "0" || $os == "") {
            echo "<p>Please select an operating system.</p>";
            $error = true;
        }
        if ($name == "") {
            echo "<p>Please enter your name.</p>";
            $error = true;
        }
        if ($email == "") {
            echo "<p>Please enter your email.</p>";
            $error = true;
        }
        if (!$error) {
            echo "<h3>Order Summary</h2>";
            echo "<p>Operating System: $os</p>";
            echo "<p>Processor: " . $processor[$processorCost] . "</p>";
            echo "<p>Memory: " . $memory[$memoryCost] . "</p>";
            echo "<p>Hard Drive: " . $storage[$storageCost] . "</p>";
            echo "<p>Accessories: $accessoriesList</p>";
            echo "<p>Total: $" . number_format($total, 2) . "</p>";
            echo "<p>Tax: $" . number_format($tax, 2) . "</p>";
            echo "<p>Grand Total: $" . number_format($total + $tax, 2) . "</p>";
            echo "<p>Thank you for your order, $name. We will contact you at $email.</p>";
            echo "<p>Your Requests: $comments</p>";
        }

        ?>
    </div>
</body>

</html>