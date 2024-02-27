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
    /*Create a PHP script  that does the following:

    1. Read the input data into appropriate variables and validate the data

    2. Calculate and display the quantity of each product, total cost, the total number of items, 5% taxes, and the total amount (total cost + taxes):

    Use the following values:
    cost of milk chocolate: $2.90
    cost of assorted fine chocolate: $4.59,
    cost of assorted milk and dark chocolate: $5.25.

    Total cost = (cost of milk chocolate)  *  (milk chocolate quantity)
    +  (cost of assorted fine chocolate) * (assorted fine chocolate quantity )
    +  (cost of assorted milk and dark chocolate) *  (assorted milk and dark chocolate quantity)

    Requirement:
    Each quantity should be an integer between 0 and 10.

    Display an appropriate error message if the input values are invalid.
    If the input values are valid, then calculate and display the output.

    Sample Output:
    Number of milk chocolates: 6
    Number of  assorted fine chocolates: 5
    Number of assorted milk and dark chocolates: 10
    Total number of items: 21
    Total cost: $92.85
    5% Taxes: $4.64
    Total amount: $97.49

    You may use the PHP round(variable, precision)  method to round values to two decimal places ( e.g. round($amount, 2))

    Note: you may use the postback method and include both HTML and PHP codes in a single .php file.
    */

        

    ?>

</body>

</html>