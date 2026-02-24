package division;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    private Divide d = new Divide();

    /**
     * Rigorous Test :-)
     */

    @Test
    public void testDivisionByZero() {
        assertThrows(ArithmeticException.class, () -> {
            d.divide(2, 0);
        });
    }

    @Test
    public void testPositiveDividedByPositive(){
        assertEquals(2, d.divide(4,2));
    }

    @Test 
    public void testNegativeDividedByPositive() {
        assertEquals(-2, d.divide(-4,2));
    }

    @Test
    public void testDivideDecimals(){
        assertEquals(2, d.divide(2.5, 1.25));
    }

    @Test
    public void testZeroDividedByValue(){
        assertEquals(0, d.divide(0, 2));
    }

    @Test
    public void testDivideByPositiveInfinity(){
        assertEquals(0, d.divide(2, Double.POSITIVE_INFINITY));
    }

    @Test
    public void testDivideByNegativeInfinity(){
        assertEquals(0, d.divide(2, Double.NEGATIVE_INFINITY));
    }
}
