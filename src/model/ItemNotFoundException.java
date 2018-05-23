package model;

import dbhandler.ItemsDTO;

/**
 * Thrown when the scanned item is not found in database/inventory catalog.
 */
public class ItemNotFoundException extends Exception {

    /**
     * Creates an instance with an error message relevant to this instance.
     * @param item The item which could nog be found.
     */
    public ItemNotFoundException (ItemsDTO item) {
        super("Item with ID " + item.getItemID() + " does not exist in inventory catalog");
    }
}
