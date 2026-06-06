package classInheritance.Q1;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

public class OperationTest {

    private static final double EPSILON = 0.0001;

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

    private Operation createOperation(String operationName) throws Exception {
        Class<?> clazz =
                Class.forName("classInheritance.Q1." + operationName);

        return (Operation)
                clazz.getConstructor()
                        .newInstance();
    }

    private int getIntValue(Number n) throws Exception {
        Method method =
                n.getClass().getMethod("getValue");

        return (Integer) method.invoke(n);
    }

    private float getFloatValue(Number n) throws Exception {
        Method method =
                n.getClass().getMethod("getValue");

        return (java.lang.Float) method.invoke(n);
    }

    private void assertIsInt(Number n) {
        assertEquals(
                "classInheritance.Q1.Int",
                n.getClass().getName()
        );
    }

    private void assertIsFloat(Number n) {
        assertEquals(
                "classInheritance.Q1.Float",
                n.getClass().getName()
        );
    }

    @Test
    public void testOperationExists() throws Exception {
        String[] stringClass = new String[]{
                "Sum",
                "Subtract",
                "Multiply",
                "Divide",
        };

        for (String op : stringClass) {
            Class<?> clazz =
                    Class.forName("classInheritance.Q1." + op);

            assertTrue(
                    Operation.class.isAssignableFrom(clazz),
                    op + " does not implement Operation"
            );
        }
    }

    @Test
    public void testSumIntIntReturnsInt() throws Exception {
        Operation op = createOperation("Sum");

        Number result =
                op.execute(createInt(3), createInt(4));

        assertIsInt(result);
        assertEquals(7, getIntValue(result));
    }

    @Test
    public void testSumIntFloatReturnsFloat() throws Exception {
        Operation op = createOperation("Sum");

        Number result =
                op.execute(createInt(3), createFloat(4.5f));

        assertIsFloat(result);
        assertEquals(7.5f, getFloatValue(result), EPSILON);
    }

    @Test
    public void testSubtractIntIntReturnsInt() throws Exception {
        Operation op = createOperation("Subtract");

        Number result =
                op.execute(createInt(10), createInt(4));

        assertIsInt(result);
        assertEquals(6, getIntValue(result));
    }

    @Test
    public void testSubtractFloatIntReturnsFloat() throws Exception {
        Operation op = createOperation("Subtract");

        Number result =
                op.execute(createFloat(10.5f), createInt(4));

        assertIsFloat(result);
        assertEquals(6.5f, getFloatValue(result), EPSILON);
    }

    @Test
    public void testMultiplyIntIntReturnsInt() throws Exception {
        Operation op = createOperation("Multiply");

        Number result =
                op.execute(createInt(6), createInt(7));

        assertIsInt(result);
        assertEquals(42, getIntValue(result));
    }

    @Test
    public void testMultiplyIntFloatReturnsFloat() throws Exception {
        Operation op = createOperation("Multiply");

        Number result =
                op.execute(createInt(6), createFloat(2.5f));

        assertIsFloat(result);
        assertEquals(15.0f, getFloatValue(result), EPSILON);
    }

    @Test
    public void testDivideIntIntReturnsFloatWithPrecision() throws Exception {
        Operation op = createOperation("Divide");

        Number result =
                op.execute(createInt(5), createInt(2));

        assertIsFloat(result);
        assertEquals(2.5f, getFloatValue(result), EPSILON);
    }

    @Test
    public void testDivideFloatIntReturnsFloat() throws Exception {
        Operation op = createOperation("Divide");

        Number result =
                op.execute(createFloat(9.0f), createInt(2));

        assertIsFloat(result);
        assertEquals(4.5f, getFloatValue(result), EPSILON);
    }

    @Test
    public void testNestedSumThenMultiply() throws Exception {
        Operation sum = createOperation("Sum");
        Operation multiply = createOperation("Multiply");

        // (3 + 4) * 2 = 14
        Number intermediate =
                sum.execute(createInt(3), createInt(4));

        Number result =
                multiply.execute(intermediate, createInt(2));

        assertIsInt(result);
        assertEquals(14, getIntValue(result));
    }

    @Test
    public void testNestedDivideThenSumReturnsFloat() throws Exception {
        Operation divide = createOperation("Divide");
        Operation sum = createOperation("Sum");

        // (5 / 2) + 3 = 5.5
        Number intermediate =
                divide.execute(createInt(5), createInt(2));

        Number result =
                sum.execute(intermediate, createInt(3));

        assertIsFloat(result);
        assertEquals(5.5f, getFloatValue(result), EPSILON);
    }

    @Test
    public void testNestedMultiplyThenSubtractReturnsFloat() throws Exception {
        Operation multiply = createOperation("Multiply");
        Operation subtract = createOperation("Subtract");

        // (2.5 * 4) - 3 = 7.0
        Number intermediate =
                multiply.execute(createFloat(2.5f), createInt(4));

        Number result =
                subtract.execute(intermediate, createInt(3));

        assertIsFloat(result);
        assertEquals(7.0f, getFloatValue(result), EPSILON);
    }

    @Test
    public void testComplexNestedExpression() throws Exception {
        Operation sum = createOperation("Sum");
        Operation subtract = createOperation("Subtract");
        Operation multiply = createOperation("Multiply");
        Operation divide = createOperation("Divide");

        // ((8 + 2) * (7 - 3)) / 5 = 8.0
        Number left =
                sum.execute(createInt(8), createInt(2));

        Number right =
                subtract.execute(createInt(7), createInt(3));

        Number product =
                multiply.execute(left, right);

        Number result =
                divide.execute(product, createInt(5));

        assertIsFloat(result);
        assertEquals(8.0f, getFloatValue(result), EPSILON);
    }

    @Test
    public void testComplexNestedExpressionWithFloatPromotion() throws Exception {
        Operation sum = createOperation("Sum");
        Operation subtract = createOperation("Subtract");
        Operation multiply = createOperation("Multiply");
        Operation divide = createOperation("Divide");

        // ((3 + 2.5) * (10 - 4)) / 2 = 16.5
        Number left =
                sum.execute(createInt(3), createFloat(2.5f));

        Number right =
                subtract.execute(createInt(10), createInt(4));

        Number product =
                multiply.execute(left, right);

        Number result =
                divide.execute(product, createInt(2));

        assertIsFloat(result);
        assertEquals(16.5f, getFloatValue(result), EPSILON);
    }
}