package warmup.Q3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EqualCountTest {

    @Test
    public void testExampleFromSpecification() {
        String[] a = {"yes", "blue", "no"};
        String[] b = {"maybe", "red", "no"};

        assertEquals(
                1,
                EqualCount.equalCount(a, b)
        );
    }

    @Test
    public void testAllElementsEqual() {
        String[] a = {"a", "b", "c"};
        String[] b = {"a", "b", "c"};

        assertEquals(
                3,
                EqualCount.equalCount(a, b)
        );
    }

    @Test
    public void testNoElementsEqual() {
        String[] a = {"a", "b", "c"};
        String[] b = {"x", "y", "z"};

        assertEquals(
                0,
                EqualCount.equalCount(a, b)
        );
    }

    @Test
    public void testSomeElementsEqual() {
        String[] a = {"a", "b", "c", "d"};
        String[] b = {"a", "x", "c", "y"};

        assertEquals(
                2,
                EqualCount.equalCount(a, b)
        );
    }

    @Test
    public void testDifferentLengthsReturnMinusOne() {
        String[] a = {"a", "b", "c"};
        String[] b = {"a", "b"};

        assertEquals(
                -1,
                EqualCount.equalCount(a, b)
        );
    }

    @Test
    public void testEmptyArrays() {
        String[] a = {};
        String[] b = {};

        assertEquals(
                0,
                EqualCount.equalCount(a, b)
        );
    }

    @Test
    public void testNullFirstArrayThrowsException() {
        String[] b = {"a", "b"};

        assertThrows(
                NullPointerException.class,
                () -> EqualCount.equalCount(null, b)
        );
    }

    @Test
    public void testNullSecondArrayThrowsException() {
        String[] a = {"a", "b"};

        assertThrows(
                NullPointerException.class,
                () -> EqualCount.equalCount(a, null)
        );
    }

    @Test
    public void testNullElementInFirstArrayThrowsException() {
        String[] a = {"a", null, "c"};
        String[] b = {"a", "b", "c"};

        assertThrows(
                NullPointerException.class,
                () -> EqualCount.equalCount(a, b)
        );
    }

    @Test
    public void testNullElementInSecondArrayThrowsException() {
        String[] a = {"a", "b", "c"};
        String[] b = {"a", null, "c"};

        assertThrows(
                NullPointerException.class,
                () -> EqualCount.equalCount(a, b)
        );
    }

    @Test
    public void testNullElementsInSamePositionStillThrowException() {
        String[] a = {"a", null};
        String[] b = {"a", null};

        assertThrows(
                NullPointerException.class,
                () -> EqualCount.equalCount(a, b)
        );
    }
}