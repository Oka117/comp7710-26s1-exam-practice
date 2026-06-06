package classInheritance.Q1;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

public class NumberTest {
    @Test
    public void testClassExists() throws Exception {
        Class<?> clazzInt = Class.forName("classInheritance.Q1.Int");
        Class<?> clazzFloat = Class.forName("classInheritance.Q1.Float");

        assertNotNull(clazzInt);
        assertTrue(Number.class.isAssignableFrom(clazzInt));
        assertNotNull(clazzFloat);
        assertTrue(Number.class.isAssignableFrom(clazzFloat));
    }

    @Test
    public void testConstructorExists() throws Exception {
        Class<?> clazzInt = Class.forName("classInheritance.Q1.Int");
        Class<?> clazzFloat = Class.forName("classInheritance.Q1.Float");

        assertNotNull(clazzInt.getConstructor(int.class));
        assertNotNull(clazzFloat.getConstructor(double.class));
    }

    @Test
    public void testValueGetter() throws Exception {

        Class<?> clazzInt = Class.forName("classInheritance.Q1.Int");
        Class<?> clazzFloat = Class.forName("classInheritance.Q1.Float");

        Object intObj =
                clazzInt.getConstructor(int.class)
                        .newInstance(42);

        Method intGtter =
                clazzInt.getMethod("getValue");

        Object floatObj1 =
                clazzFloat.getConstructor(float.class)
                        .newInstance( (float) 35.3);
        Object floatObj2 =
                clazzFloat.getConstructor(double.class)
                        .newInstance(35.3);

        Method floatGtter =
                clazzFloat.getMethod("getValue");

        assertEquals(42, intGtter.invoke(intObj));
        assertEquals((float) 35.3, floatGtter.invoke(floatObj1));
        assertEquals((float) 35.3, floatGtter.invoke(floatObj2));
    }
    private Number createInt(int value) throws Exception {
        Class<?> clazz =
                Class.forName("classInheritance.Q1.Int");

        return (Number)
                clazz.getConstructor(int.class)
                        .newInstance(value);
    }

    private Number createFloat(float value) throws Exception {
        Class<?> clazz =
                Class.forName("classInheritance.Q1.Float");

        return (Number)
                clazz.getConstructor(float.class)
                        .newInstance(value);
    }

    @Test
    public void testNumberEqualTo() throws Exception {

        assertTrue(
                createFloat(5.0f)
                        .equalTo(createInt(5))
        );

        assertFalse(
                createInt(5)
                        .equalTo(createFloat(5.1f))
        );

        assertTrue(
                createFloat(5.0f)
                        .equalTo(createFloat(5.0f))
        );

        assertTrue(
                createInt(5)
                        .equalTo(createInt(5))
        );

        assertTrue(
                createInt(5)
                        .equalTo(createFloat(5.0f))
        );
    }

    @Test
    public void testNumberComparedTo() throws Exception {

        assertEquals(
                0,
                createInt(5)
                        .comparedTo(createFloat(5.0f))
        );

        assertTrue(
                createInt(4)
                        .comparedTo(createFloat(5.0f))
                        < 0
        );

        assertTrue(
                createFloat(6.0f)
                        .comparedTo(createInt(5))
                        > 0
        );
    }
}
