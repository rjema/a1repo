package assignment1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.example.shop.OrderItem;

class OrderItemTest {

    @Test
    void testValidOrderItemCreation() {
        OrderItem item = new OrderItem("Book", 2, 15.0);

        assertEquals(2, item.getQuantity());
        assertEquals(30.0, item.getTotalPrice(), 0.0001);
    }

    @Test
    void testGetTotalPriceCalculation() {
        OrderItem item = new OrderItem("Pen", 3, 2.5);

        assertEquals(7.5, item.getTotalPrice(), 0.0001);
    }

    @Test
    void testZeroQuantityThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new OrderItem("Notebook", 0, 10.0);
        });
    }

    @Test
    void testNegativeQuantityThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new OrderItem("Notebook", -1, 10.0);
        });
    }

    @Test
    void testNegativeUnitPriceThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new OrderItem("Notebook", 1, -5.0);
        });
    }
}