package classInheritance.Q2;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ManagerTest {

    @Test
    public void testManagerExtendsEmployee() {
        assertEquals(
                Employee.class,
                Manager.class.getSuperclass()
        );
    }

    @Test
    public void testEmployeesFieldExists() throws Exception {

        Field employees =
                Manager.class.getDeclaredField("employees");

        assertNotNull(employees);
    }

    @Test
    public void testEmployeesFieldIsPrivate() throws Exception {

        Field employees =
                Manager.class.getDeclaredField("employees");

        assertTrue(
                Modifier.isPrivate(employees.getModifiers())
        );
    }

    @Test
    public void testEmployeesFieldIsAList() throws Exception {

        Field employees =
                Manager.class.getDeclaredField("employees");

        assertTrue(
                List.class.isAssignableFrom(
                        employees.getType()
                )
        );
    }

    @Test
    public void testConstructorExists() throws Exception {

        Constructor<?> constructor =
                Manager.class.getConstructor(
                        String.class,
                        String.class
                );

        assertNotNull(constructor);
    }

    @Test
    public void testConstructorInitializesInheritedFields()
            throws Exception {

        Constructor<?> constructor =
                Manager.class.getConstructor(
                        String.class,
                        String.class
                );

        Object manager =
                constructor.newInstance(
                        "John",
                        "Smith"
                );

        Method getFirstName =
                Employee.class.getMethod(
                        "getFirstName"
                );

        Method getLastName =
                Employee.class.getMethod(
                        "getLastName"
                );

        assertEquals(
                "John",
                getFirstName.invoke(manager)
        );

        assertEquals(
                "Smith",
                getLastName.invoke(manager)
        );
    }

    @Test
    public void testEmployeesListInitializedEmpty()
            throws Exception {

        Constructor<?> constructor =
                Manager.class.getConstructor(
                        String.class,
                        String.class
                );

        Object manager =
                constructor.newInstance(
                        "John",
                        "Smith"
                );

        Field employees =
                Manager.class.getDeclaredField(
                        "employees"
                );

        employees.setAccessible(true);

        Object value =
                employees.get(manager);

        assertNotNull(value);

        assertTrue(value instanceof List);

        assertEquals(
                0,
                ((List<?>) value).size()
        );
    }

    @Test
    public void testAddEmployeeMethodExists()
            throws Exception {

        Method method =
                Manager.class.getMethod(
                        "addEmployee",
                        Employee.class
                );

        assertEquals(
                void.class,
                method.getReturnType()
        );
    }

    @Test
    public void testGetEmployeeListMethodExists()
            throws Exception {

        Method method =
                Manager.class.getMethod(
                        "getEmployeeList"
                );

        assertTrue(
                List.class.isAssignableFrom(
                        method.getReturnType()
                )
        );
    }

    @Test
    public void testAddEmployeeActuallyAddsEmployee()
            throws Exception {

        Constructor<?> managerCtor =
                Manager.class.getConstructor(
                        String.class,
                        String.class
                );

        Constructor<?> employeeCtor =
                Employee.class.getConstructor(
                        String.class,
                        String.class
                );

        Object manager =
                managerCtor.newInstance(
                        "Boss",
                        "Man"
                );

        Object employee =
                employeeCtor.newInstance(
                        "Alice",
                        "Brown"
                );

        Method addEmployee =
                Manager.class.getMethod(
                        "addEmployee",
                        Employee.class
                );

        Method getEmployeeList =
                Manager.class.getMethod(
                        "getEmployeeList"
                );

        addEmployee.invoke(
                manager,
                employee
        );

        List<?> list =
                (List<?>) getEmployeeList.invoke(
                        manager
                );

        assertEquals(
                1,
                list.size()
        );

        assertSame(
                employee,
                list.get(0)
        );
    }

    @Test
    public void testMultipleEmployeesAddedInOrder()
            throws Exception {

        Constructor<?> managerCtor =
                Manager.class.getConstructor(
                        String.class,
                        String.class
                );

        Constructor<?> employeeCtor =
                Employee.class.getConstructor(
                        String.class,
                        String.class
                );

        Object manager =
                managerCtor.newInstance(
                        "Boss",
                        "Man"
                );

        Object e1 =
                employeeCtor.newInstance(
                        "Alice",
                        "Brown"
                );

        Object e2 =
                employeeCtor.newInstance(
                        "Bob",
                        "Smith"
                );

        Method addEmployee =
                Manager.class.getMethod(
                        "addEmployee",
                        Employee.class
                );

        Method getEmployeeList =
                Manager.class.getMethod(
                        "getEmployeeList"
                );

        addEmployee.invoke(manager, e1);
        addEmployee.invoke(manager, e2);

        List<?> list =
                (List<?>) getEmployeeList.invoke(
                        manager
                );

        assertEquals(2, list.size());

        assertSame(e1, list.get(0));
        assertSame(e2, list.get(1));
    }
}