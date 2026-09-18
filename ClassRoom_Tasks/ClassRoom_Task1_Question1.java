import java.util.function.Consumer;

class Employee {
    void calculateSalary() {
        System.out.println("Employee salary");
    }
}

class Developer extends Employee {
    @Override
    void calculateSalary() {
        System.out.println("Developer salary");
    }
}

class Manager extends Employee {
    @Override
    void calculateSalary() {
        System.out.println("Manager salary");
    }
}

class Tester extends Employee {
    @Override
    void calculateSalary() {
        System.out.println("Tester salary");
    }
}

public class ClassRoom_Task1_Question1 {
    public static void main(String[] args) {

        Employee e1 = new Developer();
        Employee e2 = new Manager();
        Employee e3 = new Tester();

        Consumer<Employee> salary = Employee::calculateSalary;

        salary.accept(e1);
        salary.accept(e2);
        salary.accept(e3);
    }
}