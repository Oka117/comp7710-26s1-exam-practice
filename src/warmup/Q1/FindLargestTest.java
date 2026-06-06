package warmup.Q1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FindLargestTest {

    @Test
    public void testExampleFromSpecification() {
        int[] in = {10, 3, 2, 20};

        assertEquals(
                3,
                FindLargest.findLargest(
                        in,
                        4,
                        20
                )
        );
    }

    @Test
    public void testInvalidRangeReturnsStart() {
        int[] in = {1, 2, 3, 4};

        assertEquals(
                10,
                FindLargest.findLargest(
                        in,
                        10,
                        5
                )
        );
    }

    @Test
    public void testNoValuesOutsideRangeReturnsEnd() {
        int[] in = {5, 6, 7, 8};

        assertEquals(
                10,
                FindLargest.findLargest(
                        in,
                        5,
                        10
                )
        );
    }

    @Test
    public void testLargestOutsideRangeBelowRange() {
        int[] in = {1, 2, 3, 10};

        assertEquals(
                3,
                FindLargest.findLargest(
                        in,
                        5,
                        10
                )
        );
    }

    @Test
    public void testLargestOutsideRangeAboveRange() {
        int[] in = {1, 2, 20, 30};

        assertEquals(
                30,
                FindLargest.findLargest(
                        in,
                        5,
                        10
                )
        );
    }

    @Test
    public void testLargestOutsideRangeCanAppearOnBothSides() {
        int[] in = {-10, 3, 15, 20};

        assertEquals(
                20,
                FindLargest.findLargest(
                        in,
                        4,
                        10
                )
        );
    }

    @Test
    public void testBoundaryValuesAreInsideRange() {
        int[] in = {4, 10, 3};

        assertEquals(
                3,
                FindLargest.findLargest(
                        in,
                        4,
                        10
                )
        );
    }

    @Test
    public void testNegativeNumbers() {
        int[] in = {-20, -15, -5, 0};

        assertEquals(
                0,
                FindLargest.findLargest(
                        in,
                        -10,
                        -1
                )
        );
    }

    @Test
    public void testSingleElementOutsideRange() {
        int[] in = {100};

        assertEquals(
                100,
                FindLargest.findLargest(
                        in,
                        0,
                        50
                )
        );
    }

    @Test
    public void testSingleElementInsideRangeReturnsEnd() {
        int[] in = {10};

        assertEquals(
                20,
                FindLargest.findLargest(
                        in,
                        5,
                        20
                )
        );
    }
}