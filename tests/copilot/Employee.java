package tests.copilot;

public class Employee {
    private String name;
    private int age;
    private int salary;
    private int id;

    public Employee(String name, int age, int salary, int id) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.id = id;
    }

    //taxes
    public int taxes() {
        return (int) (salary * 0.25);
    }

    //pay
    public int pay() {
        return salary - taxes();
    }

    //give raise
    public void giveRaise(int raise) {
        salary += raise;
    }

    //calculate pension
    public int pension() {
        return (int) (salary * 0.05);
    }

    //calculate retirement
    public int retirement() {
        return (int) (salary * 0.06);
    }

    //calculate health insurance
    public int healthInsurance() {
        return (int) (salary * 0.03);
    }

    //calculate social security
    public int socialSecurity() {
        return (int) (salary * 0.06);
    }

    //getid and setid
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getSalary() {
        return salary;
    }

    //tostring
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }

}
