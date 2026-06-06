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

    @Test
    public void testNumberEqualTo() {
        assertTrue(new Float(5.0f).equalTo(new Int(5)));
        assertFalse(new Int(5).equalTo(new Float(5.1f)));
        assertTrue(new Float(5.000).equalTo(new Float(5.0f)));
        assertTrue(new Int(5).equalTo(new Int(5)));
        assertTrue(new Int(5).equalTo(new Float(5.0f)));
    }

    @Test
    public void testNumberComparedTo(){
        assertEquals(0, new Int(5).comparedTo(new Float(5.0f)));
        assertTrue(new Int(4).comparedTo(new Float(5.0f)) < 0);
        assertTrue(new Float(6.0f).comparedTo(new Int(5)) > 0);
    }
}
