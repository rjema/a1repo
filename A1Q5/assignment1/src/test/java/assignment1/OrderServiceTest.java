package assignment1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.shop.*;

class OrderServiceTest {

    private OrderService orderService;
    private Order order;

    @BeforeEach
    void setUp() {
        orderService = new OrderService();
        order = new Order();
    }

    @Test
    void testInvalidPaymentCancelsOrder() {
        order.addItem(new OrderItem("Book", 1, 10.0));

        double result = orderService.processOrder(order, null, "crypto");

        assertEquals(0, result);
        assertEquals(OrderStatus.CANCELLED, order.getStatus());
    }

    @Test
    void testUnknownPaymentMethodThrows() {
        order.addItem(new OrderItem("Book", 1, 10.0));

        assertThrows(UnsupportedOperationException.class, () -> {
            orderService.processOrder(order, null, "cash");
        });
    }

    @Test
    void testValidPaymentNoDiscount() {
        order.addItem(new OrderItem("Book", 2, 10.0)); // subtotal = 20

        double result = orderService.processOrder(order, null, "card");

        double expectedSubtotal = 20.0;
        double expectedTax = expectedSubtotal * 0.2; // 4.0
        double expectedTotal = expectedSubtotal + expectedTax; // 24.0

        assertEquals(expectedTotal, result, 0.0001);
        assertEquals(OrderStatus.PAID, order.getStatus());
    }

    @Test
    void testValidPaymentWithStudentDiscount() {
        order.addItem(new OrderItem("Book", 2, 10.0)); // subtotal = 20

        double result = orderService.processOrder(order, "STUDENT10", "card");

        double subtotal = 20.0;
        double discounted = subtotal * 0.9; // 18
        double tax = discounted * 0.2; // 3.6
        double expectedTotal = discounted + tax; // 21.6

        assertEquals(expectedTotal, result, 0.0001);
        assertEquals(OrderStatus.PAID, order.getStatus());
    }

    @Test
    void testValidPaymentWithBlackFridayDiscount() {
        order.addItem(new OrderItem("Book", 2, 10.0)); // subtotal = 20

        double result = orderService.processOrder(order, "BLACKFRIDAY", "paypal");

        double subtotal = 20.0;
        double discounted = subtotal * 0.7; // 14
        double tax = discounted * 0.2; // 2.8
        double expectedTotal = discounted + tax; // 16.8

        assertEquals(expectedTotal, result, 0.0001);
        assertEquals(OrderStatus.PAID, order.getStatus());
    }
}