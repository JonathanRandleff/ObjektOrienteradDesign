package dbhandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Contains all calls to the data store with items that may be purchased.
 */
public class ItemsRegistry {
    private List<ItemsData> Items = new ArrayList<>();
    private boolean idNotFound;

    public ItemsRegistry() {
        addItems();
    }

    /**
     * Adds items to the "database".
     */
    private void addItems() {
        Items.add(new ItemsData("1",10,"A green apple",8));
        Items.add(new ItemsData("2",10,"A red apple", 8));
        Items.add(new ItemsData("3",15,"A banana", 10));
        Items.add(new ItemsData("4",100,"A small pillow", 75));
        Items.add(new ItemsData("5",150,"A big pillow", 120));
        Items.add(new ItemsData("6",5499,"A TV", 4999));
        Items.add(new ItemsData("7",6999,"A computer", 5999));
        Items.add(new ItemsData("8",1999,"A wooden desk", 1499));
        Items.add(new ItemsData("9",699,"A computer keyboard", 599));
        Items.add(new ItemsData("10",8999,"A comfortable king size bed", 6999));
        Items.add(new ItemsData("11",20,"An avocado", 15));
    }

    /**
     * Get the price of item being purchased.
     * @param item The item being purchased.
     * @return the price of the item.
     */
    public double getItemPrice(ItemsDTO item) {
        ItemsData itemGetInfo = findItemsByItemId(item);
        return itemGetInfo.price;
    }

    /**
     * Get the description of item being purchased.
     * @param item The item being purchased.
     * @return the description of the item.
     */
    public String getItemDescription(ItemsDTO item) {
        ItemsData itemGetInfo = findItemsByItemId(item);
        return itemGetInfo.itemDescription;
    }

    /**
     * Get the discounted price of item being purchased.
     * @param item The item being purchased.
     * @return the discounted price of the item.
     */
    public double getDiscountedPrice(ItemsDTO item) {
        ItemsData itemGetInfo = findItemsByItemId(item);
        return itemGetInfo.discountedPrice;
    }

    public boolean itemIdNotFound (ItemsDTO item) {
        ItemsData itemGetInfo = findItemsByItemId(item);
        return idNotFound;
    }

    /**
     * Searching for item matching the given itemID.
     * @param searchedItem The object containing the search criteria.
     * @return An item matching the given itemID or otherwise null
     */
    private ItemsData findItemsByItemId (ItemsDTO searchedItem) throws ItemsRegistryException {
        if (searchedItem.getItemID().equals("0")) {
            throw new ItemsRegistryException("Database not reachable");
        }
        for (ItemsData Item : Items) {
            if (Item.itemID.equals(searchedItem.getItemID())) {
                idNotFound = false;
                return Item;
            }
        }
        idNotFound = true;
        return null;
    }

    public static class ItemsData {
        private String itemID;
        private double price;
        private String itemDescription;
        private double discountedPrice;

        /**
         *
         * @param itemID The item identifier.
         * @param price The price of the item.
         * @param itemDescription The description of the item.
         * @param discountedPrice The discounted price of the item.
         */
        public ItemsData(String itemID, double price, String itemDescription, double discountedPrice) {
            this.itemID = itemID;
            this.price = price;
            this.itemDescription = itemDescription;
            this.discountedPrice = discountedPrice;
        }
    }
}