<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
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
    <?php
    $products = [
        [
            'type' => 'electronics',
            'name' => 'Audio Technica ATH-M50x',
            'price' => 119.99,
            'quantity' => 2
        ],
        [
            'type' => 'electronics',
            'name' => 'Sennheiser HD 202 II',
            'price' => 24.50,
            'quantity' => 5
        ],
        [
            'type' => 'electronics',
            'name' => 'GPX HM3817DTBK Micro System',
            'price' => 135.99,
            'quantity' => 1
        ],
        [
            'type' => 'electronics',
            'name' => 'Samsung MX-J630 2.0 Channel 230 Watt System',
            'price' => 117.99,
            'quantity' => 4
        ],
        [
            'type' => 'electronics',
            'name' => 'M-Audio Bass Traveler',
            'price' => 29.00,
            'quantity' => 9
        ],
        [
            'type' => 'electronics',
            'name' => 'HLED Strip light kit',
            'price' => 17.95,
            'quantity' => 5
        ],
        ['type' => 'movies', 'name' => 'Spectre', 'price' => '19.99', 'quantity' => 0],
        [
            'type' => 'movies',
            'name' => 'Finding Dory',
            'price' => 19.99,
            'quantity' => 4
        ],

        [
            'type' => 'movies',
            'name' => 'Terminator: Genisys',
            'price' => 14.95,
            'quantity' => 3
        ],
        [
            'type' => 'movies',
            'name' => 'Interstellar',
            'price' => 12.00,
            'quantity' => 4
        ],
        [
            'type' => 'movies',
            'name' => 'Transformers: Age of Extinction',
            'price' => 9.95,
            'quantity' => 7
        ],
        [
            'type' => 'movies',
            'name' => 'Eye in the Sky',
            'price' => 14.95,
            'quantity' => 6
        ],
        ['type' => 'movies', 'name' => 'Venom', 'price' => '22.99', 'quantity' => 0],
        [
            'type' => 'movies',
            'name' => 'The spy who dumped me',
            'price' => 29.00,
            'quantity' => 8
        ],
        [
            'type' => 'movies',
            'name' => 'Mamma Mia, Here We Go Again',
            'price' => 22.99,
            'quantity' => 4
        ],
        [
            'type' => 'electronics',
            'name' => 'M-Audio Bass Traveler',
            'price' => 29.00,
            'quantity' => 5
        ],
        [
            'type' => 'video-games',
            'name' => 'Battlefield 1',
            'price' => 59.99,
            'quantity' => 3
        ],
        [
            'type' => 'video-games',
            'name' => 'Overwatch',
            'price' => 40.00,
            'quantity' => 1
        ],
        [
            'type' => 'video-games',
            'name' => 'Gears of War 4',
            'price' => 59.99,
            'quantity' => 8
        ],
        [
            'type' => 'video-games',
            'name' => 'Titanfall 2',
            'price' => 59.99,
            'quantity' => 7
        ],
        [
            'type' => 'video-games',
            'name' => 'Sid Meier\'s Civilization VI ',
            'price' => 59.99,
            'quantity' => 4
        ],
        [
            'type' => 'video-games',
            'name' => 'The Sims 4',
            'price' => 39.99,
            'quantity' => 2
        ],
        [
            'type' => 'video-games',
            'name' => 'Grand Theft Auto V',
            'price' => 59.99,
            'quantity' => 7
        ]
    ];
    ?>

    <h1>Products</h1>
    <h2>Name, type, and price of each product.</h2>
    <table>
        <tr>
            <th>Name</th>
            <th>Type</th>
            <th>Price</th>
        </tr>
        <?php
        foreach ($products as $product) {
            echo "<tr>";
            echo "<td>" . $product['name'] . "</td>";
            echo "<td>" . $product['type'] . "</td>";
            echo "<td>" . $product['price'] . "</td>";
            echo "</tr>";
        }
        ?>
    </table>
    <h2>Name, type, and price of each product with a price greater than 30.</h2>
    <table>
        <tr>
            <th>Name</th>
            <th>Type</th>
            <th>Price</th>
        </tr>
        <?php
        foreach ($products as $product) {
            if ($product['price'] > 30) {
                echo "<tr>";
                echo "<td>" . $product['name'] . "</td>";
                echo "<td>" . $product['type'] . "</td>";
                echo "<td>" . $product['price'] . "</td>";
                echo "</tr>";
            }
        }
        ?>
    </table>
    <h2>Name, type, and price of each electronic item with a price greater than 30.</h2>
    <table>
        <tr>
            <th>Name</th>
            <th>Type</th>
            <th>Price</th>
        </tr>
        <?php
        foreach ($products as $product) {
            if ($product['type'] == 'electronics' && $product['price'] > 30) {
                echo "<tr>";
                echo "<td>" . $product['name'] . "</td>";
                echo "<td>" . $product['type'] . "</td>";
                echo "<td>" . $product['price'] . "</td>";
                echo "</tr>";
            }
        }
        ?>
    </table>
    <h2>Revenue generated by each product is calculated by multiplying price and quantity: revenue = price * quantity.
        Display the revenue generated by each item ( display name, price, quantity, revenue) and the total revenue
        (revenue generated by selling all the items).</h2>
    <table>
        <tr>
            <th>Name</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Revenue</th>
        </tr>
        <?php
        $totalRevenue = 0;
        foreach ($products as $product) {
            $revenue = $product['price'] * $product['quantity'];
            $totalRevenue += $revenue;
            echo "<tr>";
            echo "<td>" . $product['name'] . "</td>";
            echo "<td>" . $product['price'] . "</td>";
            echo "<td>" . $product['quantity'] . "</td>";
            echo "<td>" . $revenue . "</td>";
            echo "</tr>";
        }
        ?>
        <tr>
            <td colspan="3">Total Revenue</td>
            <td>
                <?php echo $totalRevenue; ?>
            </td>
        </tr>
    </table>
    <h2>Find the revenue generated by electronics items (display name, type, price, quantity, revenue). Determine the
        total revenue genetrated by electronic items</h2>
    <table>
        <tr>
            <th>Name</th>
            <th>Type</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Revenue</th>
        </tr>
        <?php
        $totalRevenueElectronics = 0;
        foreach ($products as $product) {
            if ($product['type'] == 'electronics') {
                $revenue = $product['price'] * $product['quantity'];
                $totalRevenueElectronics += $revenue;
                echo "<tr>";
                echo "<td>" . $product['name'] . "</td>";
                echo "<td>" . $product['type'] . "</td>";
                echo "<td>" . $product['price'] . "</td>";
                echo "<td>" . $product['quantity'] . "</td>";
                echo "<td>" . $revenue . "</td>";
                echo "</tr>";
            }
        }
        ?>
        <tr>
            <td colspan="4">Total Revenue</td>
            <td>
                <?php echo $totalRevenueElectronics; ?>
            </td>
        </tr>
    </table>
</body>

</html>