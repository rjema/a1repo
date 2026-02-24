package assignment1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.shop.Order;
import com.example.shop.OrderItem;
import com.example.shop.OrderStatus;

class OrderTest {

    private Order order;

    @BeforeEach
    void setUp() {
        order = new Order();
    }

    @Test
    void testInitialStatusIsCreated() {
        assertEquals(OrderStatus.CREATED, order.getStatus());
    }

    @Test
    void testAddItemWhenCreated() {
        OrderItem item = new OrderItem("Book", 2, 15.0);

        order.addItem(item);

        assertEquals(1, order.getItems().size());
        assertTrue(order.getItems().contains(item));
    }

    @Test
    void testAddMultipleItems() {
        order.addItem(new OrderItem("Pen", 3, 2.0));
        order.addItem(new OrderItem("Notebook", 1, 5.0));

        assertEquals(2, order.getItems().size());
    }

    @Test
    void testGetItemsReturnsSameListInstance() {
        OrderItem item = new OrderItem("Mouse", 1, 25.0);
        order.addItem(item);

        assertSame(order.getItems(), order.getItems());
    }
}