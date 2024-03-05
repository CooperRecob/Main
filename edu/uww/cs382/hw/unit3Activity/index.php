<!DOCTYPE html>
<html lang="en">

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>Online Order Form</title>
    <style type="text/css">
        table {
            border: 1px solid black;
            border-collapse: collapse;
            background: #fff;
        }

        th,
        td {
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

        input[type=text] {
            text-align: right;
            width: 200px;
            color: #000;
        }

        input[type="number"] {
            width: 3em;
        }

        .button {
            border: 1px solid #273746;
            border-radius: 5px;
            padding: 4px;
            background-color: #273746;
            color: #fff;
        }

        .default {
            background-color: #fff;
            color: #000;
        }

        .container {
            margin: 10px;
        }
    </style>
</head>

<body class="container-fluid">

    <h4>Online Order Form</h4>
    <form action="" method="post">
        <table class="table">
            <thead>
                <tr>
                    <th>Product</th>
                    <th>Quantity</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>Milk Chocolate</td>
                    <td><input type="number" name="milkchocolate" /> </td>
                </tr>
                <tr>
                    <td>Assorted Fine Chocolate</td>
                    <td><input type="number" name="assortedfine" /> </td>
                </tr>
                <tr>
                    <td>Assorted Milk and Dark Chocolate</td>
                    <td><input type="number" name="assortedmilk" /> </td>
                </tr>
            </tbody>
        </table>
        <p>
            <input type="submit" value="Submit" class="button">
            <input type="reset" value="Clear" class="button default">
        </p>
    </form>

    <?php
    if ($_SERVER["REQUEST_METHOD"] == "POST") {
        $milkchocolate = $_POST['milkchocolate'];
        $assortedfine = $_POST['assortedfine'];
        $assortedmilk = $_POST['assortedmilk'];

        if ($milkchocolate < 0 || $milkchocolate > 10 || $assortedfine < 0 || $assortedfine > 10 || $assortedmilk < 0 || $assortedmilk > 10) {
            echo "Please enter a valid quantity between 0 and 10";
        } else {
            $cost_milkchocolate = 2.90;
            $cost_assortedfine = 4.59;
            $cost_assortedmilk = 5.25;

            $total_cost = ($cost_milkchocolate * $milkchocolate) + ($cost_assortedfine * $assortedfine) + ($cost_assortedmilk * $assortedmilk);
            $total_items = $milkchocolate + $assortedfine + $assortedmilk;
            $taxes = round($total_cost * 0.05, 2);
            $total_amount = $total_cost + $taxes;

            echo "Number of milk chocolates: $milkchocolate <br>";
            echo "Number of  assorted fine chocolates: $assortedfine <br>";
            echo "Number of assorted milk and dark chocolates: $assortedmilk <br>";
            echo "Total number of items: $total_items <br>";
            echo "Total cost: $$total_cost <br>";
            echo "5% Taxes: $$taxes <br>";
            echo "Total amount: $$total_amount <br>";
        }
    }
    ?>

</body>

</html>