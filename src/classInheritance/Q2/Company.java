package classInheritance.Q2;

class Company {
    // TODO 8: Declare a private List of Employee objects named 'allEmployees'


    // TODO 9: Write a no-argument constructor that initializes 'allEmployees'
    // as an empty ArrayList.


    // Provided method: Adds an employee to the company roster
    public void addEmployeeToCompany(Employee e) {
        this.allEmployees.add(e);
    }

    public Employee getCEO() {
        // TODO 10: Implement the logic to find and return the CEO.
        // Business Rule: Every employee has a manager EXCEPT the CEO.
        // Therefore, the CEO is the single Employee in 'allEmployees' who does NOT
        // appear in any Manager's 'employees' list.
        // Hint: You may need to use 'instanceof' to find the Managers in the list.



        return null; // Replace this line with your return statement
    }
}