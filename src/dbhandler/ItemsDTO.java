package dbhandler;

import java.util.Objects;

/**
 * Contains information about one specific item.
 */
public class ItemsDTO {
    private final String itemID;
    private final double price;
    private final String itemDescription;
    private final double discountedPrice;

    /**
     * Creates an instance of one specific item.
     * @param itemID The item identifier
     * @param price The price of the item
     * @param itemDescription A description of the item
     * @param discountedPrice A discounted price of the item
     */
    public ItemsDTO (String itemID, double price, String itemDescription, double discountedPrice) {
        this.itemID = itemID;
        this.price = price;
        this.itemDescription = itemDescription;
        this.discountedPrice = discountedPrice;
    }

    /**
     * Get the value of price.
     * @return the value of price.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Get the value of itemID
     * @return the value of item ID.
     */
    public String getItemID() {
        return itemID;
    }

    /**
     * Get the value of itemDescription
     * @return the value of itemDescription
     */
    public String getItemDescription() {
        return itemDescription;
    }

    /**
     * Get the value of discountedPrice
     * @return the value of discountedPrice.
     */
    public double getDiscountedPrice() {
        return discountedPrice;
    }

    /**
     * Compares two object of ItemsDTO and checks if they are equal
     * @param otherObj The object to compare against.
     * @return if they are equal or not
     */
    public boolean equals(Object otherObj) {
        if (otherObj == null) {
            return false;
        }
        if (getClass() != otherObj.getClass()) {
            return false;
        }
        final ItemsDTO other = (ItemsDTO) otherObj;

        if (!Objects.equals(this.itemID, other.itemID)) {
            return false;
        }
        if (!Objects.equals(this.price, other.price)) {
            return false;
        }
        if (!Objects.equals(this.itemDescription, other.itemDescription)) {
            return false;
        }
        if (!Objects.equals(this.discountedPrice, other.discountedPrice)) {
            return false;
        }
        return true;
    }
}
