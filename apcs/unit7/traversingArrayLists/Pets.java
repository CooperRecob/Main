package apcs.unit7.traversingArrayLists;

public class Pets {
    private String name;
    private String type;
    private int age;

    public Pets(String name, String type, int age) {
        this.name = name;
        this.type = type;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
    public String getType() {
        return type;
    }

    public String toString() {
        return "Your " + type + " named " + name + " is " + age + " years old";
    }
}
