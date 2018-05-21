package model;

import dbhandler.ItemsDTO;

public interface SaleObserver {

    void newSale(ItemsDTO item);
}