package classInheritance.Q1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OperationTest {

    private static final double EPSILON = 0.0001;

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
    public void testSumIntIntReturnsInt() {
        Operation op = new Sum();

        Number result =
                op.execute(new Int(3), new Int(4));

        assertTrue(result instanceof Int);
        assertEquals(7, ((Int) result).getValue());
    }

    @Test
    public void testSumIntFloatReturnsFloat() {
        Operation op = new Sum();

        Number result =
                op.execute(new Int(3), new Float(4.5f));

        assertTrue(result instanceof Float);
        assertEquals(7.5f, ((Float) result).getValue(), EPSILON);
    }

    @Test
    public void testSubtractIntIntReturnsInt() {
        Operation op = new Subtract();

        Number result =
                op.execute(new Int(10), new Int(4));

        assertTrue(result instanceof Int);
        assertEquals(6, ((Int) result).getValue());
    }

    @Test
    public void testSubtractFloatIntReturnsFloat() {
        Operation op = new Subtract();

        Number result =
                op.execute(new Float(10.5f), new Int(4));

        assertTrue(result instanceof Float);
        assertEquals(6.5f, ((Float) result).getValue(), EPSILON);
    }

    @Test
    public void testMultiplyIntIntReturnsInt() {
        Operation op = new Multiply();

        Number result =
                op.execute(new Int(6), new Int(7));

        assertTrue(result instanceof Int);
        assertEquals(42, ((Int) result).getValue());
    }

    @Test
    public void testMultiplyIntFloatReturnsFloat() {
        Operation op = new Multiply();

        Number result =
                op.execute(new Int(6), new Float(2.5f));

        assertTrue(result instanceof Float);
        assertEquals(15.0f, ((Float) result).getValue(), EPSILON);
    }

    @Test
    public void testDivideIntIntReturnsFloatWithPrecision() {
        Operation op = new Divide();

        Number result =
                op.execute(new Int(5), new Int(2));

        assertTrue(result instanceof Float);
        assertEquals(2.5f, ((Float) result).getValue(), EPSILON);
    }

    @Test
    public void testDivideFloatIntReturnsFloat() {
        Operation op = new Divide();

        Number result =
                op.execute(new Float(9.0f), new Int(2));

        assertTrue(result instanceof Float);
        assertEquals(4.5f, ((Float) result).getValue(), EPSILON);
    }

    @Test
    public void testNestedSumThenMultiply() {
        Operation sum = new Sum();
        Operation multiply = new Multiply();

        // (3 + 4) * 2 = 14
        Number intermediate =
                sum.execute(new Int(3), new Int(4));

        Number result =
                multiply.execute(intermediate, new Int(2));

        assertTrue(result instanceof Int);
        assertEquals(14, ((Int) result).getValue());
    }

    @Test
    public void testNestedDivideThenSumReturnsFloat() {
        Operation divide = new Divide();
        Operation sum = new Sum();

        // (5 / 2) + 3 = 5.5
        Number intermediate =
                divide.execute(new Int(5), new Int(2));

        Number result =
                sum.execute(intermediate, new Int(3));

        assertTrue(result instanceof Float);
        assertEquals(5.5f, ((Float) result).getValue(), EPSILON);
    }

    @Test
    public void testNestedMultiplyThenSubtractReturnsFloat() {
        Operation multiply = new Multiply();
        Operation subtract = new Subtract();

        // (2.5 * 4) - 3 = 7.0
        Number intermediate =
                multiply.execute(new Float(2.5f), new Int(4));

        Number result =
                subtract.execute(intermediate, new Int(3));

        assertTrue(result instanceof Float);
        assertEquals(7.0f, ((Float) result).getValue(), EPSILON);
    }

    @Test
    public void testComplexNestedExpression() {
        Operation sum = new Sum();
        Operation subtract = new Subtract();
        Operation multiply = new Multiply();
        Operation divide = new Divide();

        // ((8 + 2) * (7 - 3)) / 5 = 8.0
        Number left =
                sum.execute(new Int(8), new Int(2));

        Number right =
                subtract.execute(new Int(7), new Int(3));

        Number product =
                multiply.execute(left, right);

        Number result =
                divide.execute(product, new Int(5));

        assertTrue(result instanceof Float);
        assertEquals(8.0f, ((Float) result).getValue(), EPSILON);
    }

    @Test
    public void testComplexNestedExpressionWithFloatPromotion() {
        Operation sum = new Sum();
        Operation subtract = new Subtract();
        Operation multiply = new Multiply();
        Operation divide = new Divide();

        // ((3 + 2.5) * (10 - 4)) / 2 = 16.5
        Number left =
                sum.execute(new Int(3), new Float(2.5f));

        Number right =
                subtract.execute(new Int(10), new Int(4));

        Number product =
                multiply.execute(left, right);

        Number result =
                divide.execute(product, new Int(2));

        assertTrue(result instanceof Float);
        assertEquals(16.5f, ((Float) result).getValue(), EPSILON);
    }
}