package classInheritance.Q2;

public class Employee {
    // TODO 1: Declare two private String fields: 'firstName' and 'lastName'
    private final String firstName;
    private final String lastName;

    // TODO 2: Write a constructor that accepts 'firstName' and 'lastName' and assigns them
    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // TODO 3: Write public getter methods for both fields
    public String getFirstName(){ return this.firstName; }
    public String getLastName() { return this.lastName; }
}
