package warmup.Q4;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class FindIntersectTest {

    private void assertSetEquals(
            int[] expected,
            int[] actual
    ) {
        int[] expectedCopy = expected.clone();
        int[] actualCopy = actual.clone();

        Arrays.sort(expectedCopy);
        Arrays.sort(actualCopy);

        assertArrayEquals(
                expectedCopy,
                actualCopy
        );
    }

    @Test
    public void testNoIntersection() {
        int[] a = {1, 2, 3};
        int[] b = {4, 5, 6};

        assertSetEquals(
                new int[]{},
                FindIntersect.find(a, b)
        );
    }

    @Test
    public void testSingleCommonElement() {
        int[] a = {1, 2, 3};
        int[] b = {3, 4, 5};

        assertSetEquals(
                new int[]{3},
                FindIntersect.find(a, b)
        );
    }

    @Test
    public void testMultipleCommonElements() {
        int[] a = {1, 2, 3, 4};
        int[] b = {2, 4, 6, 8};

        assertSetEquals(
                new int[]{2, 4},
                FindIntersect.find(a, b)
        );
    }

    @Test
    public void testIdenticalSets() {
        int[] a = {1, 2, 3};
        int[] b = {1, 2, 3};

        assertSetEquals(
                new int[]{1, 2, 3},
                FindIntersect.find(a, b)
        );
    }

    @Test
    public void testSubsetIntersection() {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {2, 4};

        assertSetEquals(
                new int[]{2, 4},
                FindIntersect.find(a, b)
        );
    }

    @Test
    public void testEmptyFirstSet() {
        int[] a = {};
        int[] b = {1, 2, 3};

        assertSetEquals(
                new int[]{},
                FindIntersect.find(a, b)
        );
    }

    @Test
    public void testEmptySecondSet() {
        int[] a = {1, 2, 3};
        int[] b = {};

        assertSetEquals(
                new int[]{},
                FindIntersect.find(a, b)
        );
    }

    @Test
    public void testBothSetsEmpty() {
        int[] a = {};
        int[] b = {};

        assertSetEquals(
                new int[]{},
                FindIntersect.find(a, b)
        );
    }

    @Test
    public void testNegativeNumbers() {
        int[] a = {-5, -3, 0, 4};
        int[] b = {-3, 1, 4};

        assertSetEquals(
                new int[]{-3, 4},
                FindIntersect.find(a, b)
        );
    }

    @Test
    public void testIntersectionAtDifferentPositions() {
        int[] a = {10, 20, 30, 40};
        int[] b = {40, 30, 50};

        assertSetEquals(
                new int[]{30, 40},
                FindIntersect.find(a, b)
        );
    }
}