package classInheritance.Q2;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeTest {

    @Test
    public void testFirstNameFieldExistsAndIsPrivateString() throws Exception {
        Field field = Employee.class.getDeclaredField("firstName");

        assertEquals(String.class, field.getType());
        assertTrue(Modifier.isPrivate(field.getModifiers()));
    }

    @Test
    public void testLastNameFieldExistsAndIsPrivateString() throws Exception {
        Field field = Employee.class.getDeclaredField("lastName");

        assertEquals(String.class, field.getType());
        assertTrue(Modifier.isPrivate(field.getModifiers()));
    }

    @Test
    public void testConstructorExists() throws Exception {
        Constructor<?> constructor =
                Employee.class.getConstructor(String.class, String.class);

        assertNotNull(constructor);
    }

    @Test
    public void testGetterMethodsExist() throws Exception {
        Method getFirstName = Employee.class.getMethod("getFirstName");
        Method getLastName = Employee.class.getMethod("getLastName");

        assertEquals(String.class, getFirstName.getReturnType());
        assertEquals(String.class, getLastName.getReturnType());

        assertEquals(0, getFirstName.getParameterCount());
        assertEquals(0, getLastName.getParameterCount());
    }

    @Test
    public void testConstructorInitializesFieldsCorrectly() throws Exception {
        Constructor<?> constructor =
                Employee.class.getConstructor(String.class, String.class);

        Object employee =
                constructor.newInstance("John", "Smith");

        Field firstNameField =
                Employee.class.getDeclaredField("firstName");

        Field lastNameField =
                Employee.class.getDeclaredField("lastName");

        firstNameField.setAccessible(true);
        lastNameField.setAccessible(true);

        assertEquals("John", firstNameField.get(employee));
        assertEquals("Smith", lastNameField.get(employee));
    }

    @Test
    public void testGetterMethodsReturnCorrectValues() throws Exception {
        Constructor<?> constructor =
                Employee.class.getConstructor(String.class, String.class);

        Object employee =
                constructor.newInstance("Alice", "Brown");

        Method getFirstName =
                Employee.class.getMethod("getFirstName");

        Method getLastName =
                Employee.class.getMethod("getLastName");

        assertEquals("Alice", getFirstName.invoke(employee));
        assertEquals("Brown", getLastName.invoke(employee));
    }

    @Test
    public void testMultipleEmployeesStoreIndependentValues() throws Exception {
        Constructor<?> constructor =
                Employee.class.getConstructor(String.class, String.class);

        Object e1 =
                constructor.newInstance("John", "Smith");

        Object e2 =
                constructor.newInstance("Alice", "Brown");

        Method getFirstName =
                Employee.class.getMethod("getFirstName");

        Method getLastName =
                Employee.class.getMethod("getLastName");

        assertEquals("John", getFirstName.invoke(e1));
        assertEquals("Smith", getLastName.invoke(e1));

        assertEquals("Alice", getFirstName.invoke(e2));
        assertEquals("Brown", getLastName.invoke(e2));
    }
}