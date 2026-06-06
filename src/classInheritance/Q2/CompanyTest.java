package classInheritance.Q2;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CompanyTest {

    @Test
    public void testAllEmployeesFieldExistsAndIsPrivateList() throws Exception {
        Field field =
                Company.class.getDeclaredField("allEmployees");

        assertTrue(
                Modifier.isPrivate(field.getModifiers()),
                "allEmployees should be private"
        );

        assertTrue(
                List.class.isAssignableFrom(field.getType()),
                "allEmployees should be a List"
        );
    }

    @Test
    public void testNoArgumentConstructorExists() throws Exception {
        Constructor<?> constructor =
                Company.class.getConstructor();

        assertNotNull(constructor);
    }

    @Test
    public void testConstructorInitializesAllEmployeesAsEmptyList() throws Exception {
        Constructor<?> constructor =
                Company.class.getConstructor();

        Object company =
                constructor.newInstance();

        Field field =
                Company.class.getDeclaredField("allEmployees");

        field.setAccessible(true);

        Object value =
                field.get(company);

        assertNotNull(
                value,
                "allEmployees should be initialized"
        );

        assertTrue(
                value instanceof List,
                "allEmployees should be a List"
        );

        assertEquals(
                0,
                ((List<?>) value).size(),
                "allEmployees should initially be empty"
        );
    }

    @Test
    public void testAddEmployeeToCompanyMethodExists() throws Exception {
        Method method =
                Company.class.getMethod(
                        "addEmployeeToCompany",
                        Employee.class
                );

        assertEquals(
                void.class,
                method.getReturnType()
        );
    }

    @Test
    public void testGetCEOMethodExists() throws Exception {
        Method method =
                Company.class.getMethod("getCEO");

        assertEquals(
                Employee.class,
                method.getReturnType()
        );
    }

    @Test
    public void testAddEmployeeToCompanyActuallyAddsEmployee() throws Exception {
        Object company =
                Company.class.getConstructor().newInstance();

        Object employee =
                Employee.class
                        .getConstructor(String.class, String.class)
                        .newInstance("Alice", "Brown");

        Method addEmployee =
                Company.class.getMethod(
                        "addEmployeeToCompany",
                        Employee.class
                );

        addEmployee.invoke(company, employee);

        Field field =
                Company.class.getDeclaredField("allEmployees");

        field.setAccessible(true);

        List<?> employees =
                (List<?>) field.get(company);

        assertEquals(1, employees.size());
        assertSame(employee, employees.get(0));
    }

    @Test
    public void testGetCEOWithSingleEmployee() throws Exception {
        Object company =
                Company.class.getConstructor().newInstance();

        Object ceo =
                Employee.class
                        .getConstructor(String.class, String.class)
                        .newInstance("Alice", "CEO");

        Method addEmployee =
                Company.class.getMethod(
                        "addEmployeeToCompany",
                        Employee.class
                );

        Method getCEO =
                Company.class.getMethod("getCEO");

        addEmployee.invoke(company, ceo);

        Object result =
                getCEO.invoke(company);

        assertSame(
                ceo,
                result,
                "If there is only one employee, that employee should be the CEO"
        );
    }

    @Test
    public void testGetCEOWithManagerAndEmployee() throws Exception {
        Object company =
                Company.class.getConstructor().newInstance();

        Object ceo =
                Manager.class
                        .getConstructor(String.class, String.class)
                        .newInstance("Alice", "CEO");

        Object employee =
                Employee.class
                        .getConstructor(String.class, String.class)
                        .newInstance("Bob", "Worker");

        Method managerAddEmployee =
                Manager.class.getMethod(
                        "addEmployee",
                        Employee.class
                );

        Method companyAddEmployee =
                Company.class.getMethod(
                        "addEmployeeToCompany",
                        Employee.class
                );

        Method getCEO =
                Company.class.getMethod("getCEO");

        managerAddEmployee.invoke(ceo, employee);

        companyAddEmployee.invoke(company, ceo);
        companyAddEmployee.invoke(company, employee);

        Object result =
                getCEO.invoke(company);

        assertSame(
                ceo,
                result,
                "The manager who does not appear in another manager's employee list should be CEO"
        );
    }

    @Test
    public void testGetCEOWithMultipleLevelsOfManagement() throws Exception {
        Object company =
                Company.class.getConstructor().newInstance();

        Object ceo =
                Manager.class
                        .getConstructor(String.class, String.class)
                        .newInstance("Alice", "CEO");

        Object middleManager =
                Manager.class
                        .getConstructor(String.class, String.class)
                        .newInstance("Bob", "Manager");

        Object employee =
                Employee.class
                        .getConstructor(String.class, String.class)
                        .newInstance("Charlie", "Worker");

        Method managerAddEmployee =
                Manager.class.getMethod(
                        "addEmployee",
                        Employee.class
                );

        Method companyAddEmployee =
                Company.class.getMethod(
                        "addEmployeeToCompany",
                        Employee.class
                );

        Method getCEO =
                Company.class.getMethod("getCEO");

        managerAddEmployee.invoke(ceo, middleManager);
        managerAddEmployee.invoke(middleManager, employee);

        companyAddEmployee.invoke(company, ceo);
        companyAddEmployee.invoke(company, middleManager);
        companyAddEmployee.invoke(company, employee);

        Object result =
                getCEO.invoke(company);

        assertSame(
                ceo,
                result,
                "CEO should be the only employee not managed by anyone"
        );
    }

    @Test
    public void testGetCEONotSimplyFirstEmployee() throws Exception {
        Object company =
                Company.class.getConstructor().newInstance();

        Object worker =
                Employee.class
                        .getConstructor(String.class, String.class)
                        .newInstance("Worker", "One");

        Object ceo =
                Manager.class
                        .getConstructor(String.class, String.class)
                        .newInstance("CEO", "Person");

        Method managerAddEmployee =
                Manager.class.getMethod(
                        "addEmployee",
                        Employee.class
                );

        Method companyAddEmployee =
                Company.class.getMethod(
                        "addEmployeeToCompany",
                        Employee.class
                );

        Method getCEO =
                Company.class.getMethod("getCEO");

        managerAddEmployee.invoke(ceo, worker);

        companyAddEmployee.invoke(company, worker);
        companyAddEmployee.invoke(company, ceo);

        Object result =
                getCEO.invoke(company);

        assertSame(
                ceo,
                result,
                "getCEO should not simply return the first employee in allEmployees"
        );
    }

    @Test
    public void testGetCEOWithEmptyCompanyReturnsNull() throws Exception {
        Object company =
                Company.class.getConstructor().newInstance();

        Method getCEO =
                Company.class.getMethod("getCEO");

        Object result =
                getCEO.invoke(company);

        assertNull(
                result,
                "Empty company should return null"
        );
    }
}