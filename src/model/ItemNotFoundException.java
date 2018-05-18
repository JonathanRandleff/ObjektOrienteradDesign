package model;

import dbhandler.ItemsDTO;

public class ItemNotFoundException extends Exception {

    public ItemNotFoundException (ItemsDTO item) {
        super("Item with ID " + item.getItemID() + " does not exist in inventory catalog");
    }



}
