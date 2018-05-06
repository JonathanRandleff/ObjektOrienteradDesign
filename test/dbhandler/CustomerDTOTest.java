package dbhandler;

import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerDTOTest {

    @Test
    public void testEquals() {
        String name = "Per Alfredsson";
        String customerID = "50";
        boolean discountEligible = false;
        CustomerDTO instance = new CustomerDTO(name, customerID, discountEligible);
        CustomerDTO equalInstance = new CustomerDTO(name, customerID, discountEligible);
        boolean expResult = true;
        boolean result = instance.equals(equalInstance);
        assertEquals("CustomerDTO instances with same input values are not the same",
                expResult, result);
    }
    @Test
    public void testNotEqualsName() {
        String name = "Per Alfredsson";
        String customerID = "50";
        boolean discountEligible = true;
        CustomerDTO instance = new CustomerDTO("wrong name", customerID, discountEligible);
        CustomerDTO notEqualInstance = new CustomerDTO(name, customerID, discountEligible);
        boolean expResult = false;
        boolean result = instance.equals(notEqualInstance);
        assertEquals("CustomerDTO instances with different name are equal.",
                expResult, result);
    }
    @Test
    public void testNotEqualsCustomerID() {
        String name = "Per Alfredsson";
        String customerID = "50";
        boolean discountEligible = true;
        CustomerDTO instance = new CustomerDTO(name, "wrong ID", discountEligible);
        CustomerDTO notEqualInstance = new CustomerDTO(name, customerID, discountEligible);
        boolean expResult = false;
        boolean result = instance.equals(notEqualInstance);
        assertEquals("CustomerDTO instances with different ID are equal.",
                expResult, result);
    }
    @Test
    public void testNotEqualsDiscountEligible() {
        String name = "Per Alfredsson";
        String customerID = "50";
        boolean discountEligible = true;
        CustomerDTO instance = new CustomerDTO(name, customerID, false);
        CustomerDTO notEqualInstance = new CustomerDTO(name, customerID, discountEligible);
        boolean expResult = false;
        boolean result = instance.equals(notEqualInstance);
        assertEquals("CustomerDTO instances with different discountEligible are equal.",
                expResult, result);
    }
    @Test
    public void testNullName() {
        String name = "Per Alfredsson";
        String customerID = "50";
        boolean discountEligible = true;
        CustomerDTO instance = new CustomerDTO(null, customerID, discountEligible);
        CustomerDTO notEqualInstance = new CustomerDTO(name, customerID, discountEligible);
        boolean expResult = false;
        boolean result = instance.equals(notEqualInstance);
        assertEquals("CustomerDTO instances with different name are equal.",
                expResult, result);
    }
    @Test
    public void testNullCustomerID() {
        String name = "Per Alfredsson";
        String customerID = "50";
        boolean discountEligible = true;
        CustomerDTO instance = new CustomerDTO(name, null, discountEligible);
        CustomerDTO notEqualInstance = new CustomerDTO(name, customerID, discountEligible);
        boolean expResult = false;
        boolean result = instance.equals(notEqualInstance);
        assertEquals("CustomerDTO instances with different customer ID are equal.",
                expResult, result);
    }
}