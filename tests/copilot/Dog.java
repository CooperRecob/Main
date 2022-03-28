package tests.copilot;

public class Dog extends Animal {
    public Dog(String name, int age) {
        super(name, age);
    }

    public void birthday() {
        setAge(getAge() + 1);
    }

    public void bark() {
        System.out.println("Woof!");
    }

    // toString method
    public String toString() {
        return "Dog{" +
                "name='" + getName() + '\'' +
                ", age=" + getAge() +
                '}';
    }
}
