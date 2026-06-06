package warmup.Q2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HighProductTest {

    @Test
    public void testExampleFromSpecification() {
        int[] array = {15, 4, 10, 2, 24};

        assertEquals(
                15,
                HighProduct.findProduct(
                        array,
                        5
                )
        );
    }

    @Test
    public void testNoMatchingFactorReturnsMinusOne() {
        int[] array = {15, 4, 10, 2, 24};

        assertEquals(
                -1,
                HighProduct.findProduct(
                        array,
                        7
                )
        );
    }

    @Test
    public void testLargestMatchReturnedNotFirstMatch() {
        int[] array = {6, 18, 12, 24};

        assertEquals(
                24,
                HighProduct.findProduct(
                        array,
                        6
                )
        );
    }

    @Test
    public void testSingleMatchingElement() {
        int[] array = {3, 5, 7, 20};

        assertEquals(
                20,
                HighProduct.findProduct(
                        array,
                        10
                )
        );
    }

    @Test
    public void testFactorOneMatchesEverything() {
        int[] array = {2, 100, 7, 50};

        assertEquals(
                100,
                HighProduct.findProduct(
                        array,
                        1
                )
        );
    }

    @Test
    public void testArrayContainsFactorItself() {
        int[] array = {5, 10, 15};

        assertEquals(
                15,
                HighProduct.findProduct(
                        array,
                        5
                )
        );
    }

    @Test
    public void testLargestElementNotFactorMatch() {
        int[] array = {100, 18, 24, 30};

        assertEquals(
                30,
                HighProduct.findProduct(
                        array,
                        6
                )
        );
    }

    @Test
    public void testPrimeFactor() {
        int[] array = {14, 21, 35, 50};

        assertEquals(
                35,
                HighProduct.findProduct(
                        array,
                        7
                )
        );
    }

    @Test
    public void testSingleElementArrayMatch() {
        int[] array = {20};

        assertEquals(
                20,
                HighProduct.findProduct(
                        array,
                        5
                )
        );
    }

    @Test
    public void testSingleElementArrayNoMatch() {
        int[] array = {20};

        assertEquals(
                -1,
                HighProduct.findProduct(
                        array,
                        3
                )
        );
    }
}