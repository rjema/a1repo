package assignment1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.shop.PaymentValidator;

class PaymentValidatorTest {

    private PaymentValidator validator;

    @BeforeEach
    void setUp() {
        validator = new PaymentValidator();
    }

    @Test
    void testNullPaymentMethodReturnsFalse() {
        assertFalse(validator.isPaymentMethodValid(null));
    }

    @Test
    void testCardIsValid() {
        assertTrue(validator.isPaymentMethodValid("card"));
    }

    @Test
    void testPaypalIsValid() {
        assertTrue(validator.isPaymentMethodValid("paypal"));
    }

    @Test
    void testCaseInsensitiveValidation() {
        assertTrue(validator.isPaymentMethodValid("CARD"));
        assertTrue(validator.isPaymentMethodValid("PayPal"));
    }

    @Test
    void testCryptoReturnsFalse() {
        assertFalse(validator.isPaymentMethodValid("crypto"));
    }

    @Test
    void testUnknownPaymentMethodThrowsException() {
        assertThrows(UnsupportedOperationException.class, () -> {
            validator.isPaymentMethodValid("cash");
        });
    }
}