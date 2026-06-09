package classInheritance.Q2;
import java.util.ArrayList;
import java.util.List;

class Manager extends Employee {
    // TODO 4: Declare a private List of Employee objects named 'employees'
    private List<Employee> employees;

    // TODO 5: Write a constructor that accepts 'firstName' and 'lastName'.
    // Requirement A: It must explicitly call the superclass constructor.
    // Requirement B: It must initialize the 'employees' list as an empty ArrayList.
    public Manager(String firstName, String lastName){
        super(firstName, lastName);
        employees = new ArrayList<>();
    }


    // TODO 6: Write a method named 'addEmployee' that takes an Employee as a parameter
    // and adds it to the 'employees' list.
    public void addEmployee(Employee e){
        this.employees.add(e);
    }

    // TODO 7: Write a method named 'getEmployeeList' that returns the 'employees' list.
    public List<Employee> getEmployeeList(){
        return this.employees;
    }

}
