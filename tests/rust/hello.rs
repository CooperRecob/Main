fn main() {
    println!("Hello, world!");

    let mut x = 5;
    let y = 6;

    println!("{}", x + y);

    if x == 5 {
        println!("x is five!");
    } else {
        println!("x is not five :(");
    }

    while x < 10 {
        println!("{}", x);
        x += 1;
    }

    for i in 0..10 {
        println!("{}", i);
    }
}