<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <?php
    $num1 = 10;
    $num2 = 20;
    $sum = $num1 + $num2;
    $difference = $num1 - $num2;
    $product = $num1 * $num2;
    echo "The sum of $num1 and $num2 is $sum";
    echo "<br>";
    echo "The difference of $num1 and $num2 is $difference";
    echo "<br>";
    echo "The product of $num1 and $num2 is $product";

    $array = array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    echo "<br>";
    for ($i = 0; $i < count($array); $i++) {
        echo "The square of $array[$i] is " . $array[$i] * $array[$i] . "<br>";
    }

    $array2 = array(-10, 10, -25, 30, 30, 45, -43, 20, 20, 20);

    echo "original array:<br>";
    print_r($array2);
    echo "<br>sorted array:<br>";
    sort($array2);
    print_r($array2);
    echo "<br>reversed array:<br>";
    rsort($array2);
    print_r($array2);

    echo "<br>unique array:<br>";
    $unique = array_unique($array2);
    print_r($unique);

    $total = 0;

    for ($i = 0; $i < count($unique); $i++) {
        if ($unique[$i] > 0) {
            $total += $unique[$i];
        }
    }
    echo "<br>The sum of all positive numbers in the unique array is $total";

        ?>
</body>
</html>