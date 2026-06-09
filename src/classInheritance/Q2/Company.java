package classInheritance.Q2;
import java.util.ArrayList;
import java.util.List;
class Company {
    // TODO 8: Declare a private List of Employee objects named 'allEmployees'
    private List<Employee> allEmployees;

    // TODO 9: Write a no-argument constructor that initializes 'allEmployees'
    // as an empty ArrayList.
    public Company(){
        this.allEmployees = new ArrayList<>();
    }

    // TODO 10: Implement the addEmployeeToCompany method.
    // Requirement: Add the given Employee object to the 'allEmployees' list.
    public void addEmployeeToCompany(Employee e) {
        this.allEmployees.add(e);
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
        if (allEmployees == null || allEmployees.isEmpty()) {
            return null;
        }

        List<Employee> managedEmployees = new ArrayList<>();

        for (Employee employee : allEmployees) {
            if (employee instanceof Manager manager) {
                managedEmployees.addAll(manager.getEmployeeList());
            }
        }

        for (Employee employee : allEmployees) {
            if (!managedEmployees.contains(employee)) {
                return employee;
            }
        }

        return null;
//        List<Manager> managers = new ArrayList<>();
//        for(Employee e : this.allEmployees){
//            if (e instanceof Manager m){
//                managers.add(m);
//            }
//        }
//        int ceoIndex = 0;
//        if(this.allEmployees == null) return null;
//        if(this.allEmployees.size() == 1) return allEmployees.getFirst();
//        if(this.allEmployees.isEmpty()) return null;
//
//        for(int i = 0; i < allEmployees.size(); i++){
//            for(Manager m : managers){
//                if(!m.getEmployeeList().contains(allEmployees.get(i))){
//                    ceoIndex = i;
//                } else{
//                    ceoIndex = 0;
//                }
//            }
//        }
//        return this.allEmployees.get(ceoIndex); // Replace this line with your return statement
    }
}