package dbhandler;

import org.junit.Test;

import static org.junit.Assert.*;

public class ItemsDTOTest {

    @Test
    public void testEquals() {
        String itemID = "1";
        double price = 600;
        String itemDescription = "apple";
        double discountedPrice = 500;
        ItemsDTO instance = new ItemsDTO(itemID, price, itemDescription, discountedPrice);
        ItemsDTO equalInstance = new ItemsDTO(itemID, price, itemDescription, discountedPrice);
        boolean expResult = true;
        boolean result = instance.equals(equalInstance);
        assertEquals("ItemsDTO instances with same input values are not the same",
                expResult, result);
    }

    @Test
    public void testNotEqualsID() {
        String itemID = "1";
        double price = 600;
        String itemDescription = "apple";
        double discountedPrice = 500;
        ItemsDTO instance = new ItemsDTO("wrong", price, itemDescription, discountedPrice);
        ItemsDTO notEqualInstance = new ItemsDTO(itemID, price, itemDescription, discountedPrice);
        boolean expResult = false;
        boolean result = instance.equals(notEqualInstance);
        assertEquals("ItemsDTO instances with different itemID are equal.",
                expResult, result);
    }
    @Test
    public void testNotEqualsPrice() {
        String itemID = "1";
        double price = 600;
        String itemDescription = "apple";
        double discountedPrice = 500;
        ItemsDTO instance = new ItemsDTO(itemID, 1, itemDescription, discountedPrice);
        ItemsDTO notEqualInstance = new ItemsDTO(itemID, price, itemDescription, discountedPrice);
        boolean expResult = false;
        boolean result = instance.equals(notEqualInstance);
        assertEquals("ItemsDTO instances with different price are equal.",
                expResult, result);
    }
    @Test
    public void testNotEqualsDescription() {
        String itemID = "1";
        double price = 600;
        String itemDescription = "apple";
        double discountedPrice = 500;
        ItemsDTO instance = new ItemsDTO(itemID, price, "wrong", discountedPrice);
        ItemsDTO notEqualInstance = new ItemsDTO(itemID, price, itemDescription, discountedPrice);
        boolean expResult = false;
        boolean result = instance.equals(notEqualInstance);
        assertEquals("ItemsDTO instances with different itemDescription are equal.",
                expResult, result);
    }
    @Test
    public void testNotEqualsDiscountedPrice() {
        String itemID = "1";
        double price = 600;
        String itemDescription = "apple";
        double discountedPrice = 500;
        ItemsDTO instance = new ItemsDTO(itemID, price, itemDescription, 1);
        ItemsDTO notEqualInstance = new ItemsDTO(itemID, price, itemDescription, discountedPrice);
        boolean expResult = false;
        boolean result = instance.equals(notEqualInstance);
        assertEquals("ItemsDTO instances with different discountedPrice are equal.",
                expResult, result);
    }
    @Test
    public void testNullItemID() {
        String itemID = "1";
        double price = 600;
        String itemDescription = "apple";
        double discountedPrice = 500;
        ItemsDTO instance = new ItemsDTO(null, price, itemDescription, discountedPrice);
        ItemsDTO notEqualInstance = new ItemsDTO(itemID, price, itemDescription, discountedPrice);
        boolean expResult = false;
        boolean result = instance.equals(notEqualInstance);
        assertEquals("CarDTO instances with different itemID are equal.",
                expResult, result);
    }
    @Test
    public void testNullItemDescription() {
        String itemID = "1";
        double price = 600;
        String itemDescription = "apple";
        double discountedPrice = 500;
        ItemsDTO instance = new ItemsDTO(itemID, price, null, discountedPrice);
        ItemsDTO notEqualInstance = new ItemsDTO(itemID, price, itemDescription, discountedPrice);
        boolean expResult = false;
        boolean result = instance.equals(notEqualInstance);
        assertEquals("CarDTO instances with different itemDescription are equal.",
                expResult, result);
    }
}