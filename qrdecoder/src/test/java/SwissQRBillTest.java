import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class SwissQRBillTest {
    
    @Test
    void testValidAccount() {
        SwissQRBill bill = new SwissQRBill();
        bill.setAccount("CH9300762011623852957");
        assertTrue(bill.isValidIBAN());
    }
    
    @Test
    void testInvalidAccount() {
        SwissQRBill bill = new SwissQRBill();
        bill.setAccount("");
        assertFalse(bill.isValidIBAN());
    }
    
    @Test
    void testValidAmount() {
        SwissQRBill bill = new SwissQRBill();
        bill.setAmount("123.45");
        assertTrue(bill.isValidAmount());
    }
    
    @Test
    void testInvalidAmount() {
        SwissQRBill bill = new SwissQRBill();
        bill.setAmount("12A.45");
        assertFalse(bill.isValidAmount());
    }
    
    @Test
    void testValidCurrency() {
        SwissQRBill bill = new SwissQRBill();
        bill.setCurrency("CHF");
        assertTrue(bill.isValidCurrency());
    }
    
    @Test
    void testInvalidCurrency() {
        SwissQRBill bill = new SwissQRBill();
        bill.setCurrency("");
        assertFalse(bill.isValidCurrency());
    }
}
