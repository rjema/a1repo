package assignment1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.shop.*;

class PricingServiceTest {

    private PricingService pricingService;
    private Order order;

    @BeforeEach
    void setUp() {
        pricingService = new PricingService();
        order = new Order();
    }

    // -------- calculateSubtotal Tests --------

    @Test
    void testCalculateSubtotalEmptyOrder() {
        assertEquals(0.0, pricingService.calculateSubtotal(order), 0.0001);
    }

    @Test
    void testCalculateSubtotalSingleItem() {
        order.addItem(new OrderItem("Book", 2, 10.0)); // total = 20

        assertEquals(20.0, pricingService.calculateSubtotal(order), 0.0001);
    }

    @Test
    void testCalculateSubtotalMultipleItems() {
        order.addItem(new OrderItem("Book", 2, 10.0));     // 20
        order.addItem(new OrderItem("Pen", 3, 2.0));       // 6
        order.addItem(new OrderItem("Notebook", 1, 5.0));  // 5
        // total = 31

        assertEquals(31.0, pricingService.calculateSubtotal(order), 0.0001);
    }

    // -------- calculateTax Tests --------

    @Test
    void testCalculateTaxNegativeSubtotalThrows() {
        assertThrows(IllegalArgumentException.class, () -> {
            pricingService.calculateTax(-10.0);
        });
    }

    @Test
    void testCalculateTaxZeroSubtotal() {
        assertEquals(0.0, pricingService.calculateTax(0.0), 0.0001);
    }

    @Test
    void testCalculateTaxPositiveSubtotal() {
        double subtotal = 50.0;
        double expectedTax = 50.0 * 0.2; // 10

        assertEquals(expectedTax, pricingService.calculateTax(subtotal), 0.0001);
    }
}