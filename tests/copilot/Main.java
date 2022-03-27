package tests.copilot;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        // Create a new instance of Dog
        Dog dog = new Dog("Fido", 3);
        // Call bark() on the dog
        dog.bark();
        // Call birthday() on the dog
        dog.birthday();

        System.out.println(dog);

        //create a butt ton of employees
        //edit these employees to have a 4 digit id
        Employee employee1 = new Employee("John", 30, 100000, 1234);
        Employee employee2 = new Employee("Jane", 25, 100000, 2345);
        Employee employee3 = new Employee("Joe", 35, 100000, 3456);
        Employee employee4 = new Employee("Jack", 40, 100000, 4567);
        Employee employee5 = new Employee("Jill", 45, 100000, 5678);
        Employee employee6 = new Employee("Jim", 50, 100000, 6789);
        Employee employee7 = new Employee("Jenny", 55, 100000, 7890);
        Employee employee8 = new Employee("Jared", 60, 100000, 8901);
        Employee employee9 = new Employee("Jenny", 65, 100000, 9012);




        //print all employees
        System.out.println(employee1);
        System.out.println(employee2);
        System.out.println(employee3);
        System.out.println(employee4);
        System.out.println(employee5);
        System.out.println(employee6);
        System.out.println(employee7);
        System.out.println(employee8);
        System.out.println(employee9);

        //create a hashmap of employees and their 4 digit ID
        HashMap<Integer, Employee> employeeMap = new HashMap<Integer, Employee>();
        employeeMap.put(employee1.getId(), employee1);
        employeeMap.put(employee2.getId(), employee2);
        employeeMap.put(employee3.getId(), employee3);
        
        //print the hashmap
        System.out.println(employeeMap);

        //call every method on the employees
        System.out.println(employee1.pay());
        System.out.println(employee2.pay());
        System.out.println(employee3.pay());
        System.out.println(employee4.pay());
        System.out.println(employee5.pay());
        System.out.println(employee6.pay());
        System.out.println(employee7.pay());
        System.out.println(employee8.pay());
        System.out.println(employee9.pay());

        //call every method on the employees
        System.out.println(employee1.pension());
        System.out.println(employee2.pension());
        System.out.println(employee3.pension());

        //call every method on the employees
        System.out.println(employee1.retirement());
        System.out.println(employee2.retirement());
        System.out.println(employee3.retirement());

        //call every method on the employees
        System.out.println(employee1.healthInsurance());
        System.out.println(employee2.healthInsurance());


        //call every method on the employees
        System.out.println(employee1.socialSecurity());
        System.out.println(employee2.socialSecurity());
        System.out.println(employee3.socialSecurity());

        //call every method on the employees
        employee1.giveRaise(1000);
        employee2.giveRaise(1000);
    }
}