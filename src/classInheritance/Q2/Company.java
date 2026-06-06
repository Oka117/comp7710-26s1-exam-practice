package classInheritance.Q2;

class Company {
    // TODO 8: Declare a private List of Employee objects named 'allEmployees'


    // TODO 9: Write a no-argument constructor that initializes 'allEmployees'
    // as an empty ArrayList.


    // TODO 10: Implement the addEmployeeToCompany method.
    // Requirement: Add the given Employee object to the 'allEmployees' list.
    public void addEmployeeToCompany(Employee e) {
    }

    // TODO 11: Implement the logic to find and return the CEO.
    // Business Rule:
    // - Every employee has exactly one manager, except the CEO.
    // - The CEO is the only Employee in 'allEmployees' who does not appear
    //   in any Manager's employee list.
    // - Return the CEO if one exists; otherwise return null.
    // Hint:
    // - First identify all employees who are managed by someone.
    // - Then find the employee in 'allEmployees' who is not managed.
    // - You may need to use 'instanceof' to identify Manager objects.
    public Employee getCEO() {

        return null; // Replace this line with your return statement
    }
}