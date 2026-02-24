package assignment1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.example.shop.DiscountService;

class DiscountServiceTest {

    private DiscountService service;

    @BeforeEach
    void setUp() {
        service = new DiscountService();
    }

    @Test 
    void testNoCodeReturnsSubtotal() {
        double subtotal = 100.0;
        assertEquals(subtotal, service.applyDiscount(subtotal, null), 0.0001);
        assertEquals(subtotal, service.applyDiscount(subtotal, ""), 0.0001);
        assertEquals(subtotal, service.applyDiscount(subtotal, "   "), 0.0001);
    }

    @Test
    void testStudent10Discount() {
        double subtotal = 200.0;
        double expected = subtotal * 0.9;
        assertEquals(expected, service.applyDiscount(subtotal, "STUDENT10"), 0.0001);
        assertEquals(expected, service.applyDiscount(subtotal, "student10"), 0.0001);
    }

    @Test
    void testBlackFridayDiscount() {
        double subtotal = 50.0;
        double expected = subtotal * 0.7;
        assertEquals(expected, service.applyDiscount(subtotal, "BLACKFRIDAY"), 0.0001);
        assertEquals(expected, service.applyDiscount(subtotal, "blackfriday"), 0.0001);
    }

    @Test
    void testUnknownCodeNoDiscount() {
        double subtotal = 75.0;
        assertEquals(subtotal, service.applyDiscount(subtotal, "NOCODE"), 0.0001);
    }

    @Test
    void testInvalidCodeThrows() {
        assertThrows(IllegalArgumentException.class,
            () -> service.applyDiscount(10.0, "INVALID"));
    }
}