package controller;

import dbhandler.*;
import model.ItemNotFoundException;
import model.PaymentNotEnoughException;
import model.Sale;
import model.SaleObserver;

import java.util.ArrayList;
import java.util.List;

/**
 * This is the application's only controller. All calls to the model pass through here.
 */
public class Controller {
    private Sale sale;
    private ItemsRegistry itemsRegistry;
    private ItemsDTO item;
    private CustomerRegistry customerRegistry;
    private CustomerDTO customer;
    private Printer printer;
    private AccountingSystem accountingSystem;
    private InventorySystem inventorySystem;
    private List<SaleObserver> saleObservers = new ArrayList<>();

    /**
     * Creates a new instance.
     * @param regCreator Used to get all classes that handle database calls.
     * @param printer    Interface to printer.
     */
    public Controller(RegistryCreator regCreator, Printer printer) {
        this.itemsRegistry = regCreator.getItemsRegistry();
        this.customerRegistry = regCreator.getCustomerRegistry();
        this.printer = printer;
    }

    /**
     * Creates an empty instance of {@link Sale}, which will be used for all information regarding
     * the sale that is now started.
     *
     * Adds a sale observer.
     */
    public void startSale() {
        sale = new Sale();
        sale.addSaleObservers(saleObservers);
    }

    /**
     * Inputs an item to be purchased into the system.
     * @param itemID The itemID number entered to find the purchased item in the system.
     * @param quantity The amount of same values being purchased.
     * @throws ItemNotFoundException if the item is not found in database.
     */
    public void inputItem(String itemID, int quantity) throws ItemNotFoundException {
        item = new ItemsDTO(itemID,0,null,0);
        sale.addItem(item, quantity);
    }

    /**
     * Returns with sale information for the newly added item.
     * @return The sale information (price, description and running total of sale)
     */
    public String getSaleInfo() {
       return sale.getSaleInfo();
    }

    /**
     * Gives the final price to be paid.
     * @return The total price of all the purchased items.
     */
    public double priceToPay() {
        return sale.getTotalWithTaxes();
    }

    /**
     * Handles the discount request and creates a customer in the system.
     * @param customerID The identification number of the customer.
     */
    public void discountRequest(String customerID) {
        customer = new CustomerDTO(null,customerID,false);
        sale.discountAvailable(customer);
    }

    /**
     *  Handles payment.
     *  Sends sale information to the Accounting System and inventory System.
     *  Prints the receipt.
     * @param paidAmount The paid amount.
     */
    public void payment(double paidAmount) throws PaymentNotEnoughException {
        sale.pay(paidAmount);
        sale.changeAmount(paidAmount);
        accountingSystem = new AccountingSystem(sale);
        inventorySystem = new InventorySystem(sale);
        sale.printReceipt(printer);
    }

    /**
     * The observer will be notified when a sale has been finalized.
     * @param obs The observer
     */
    public void addSaleObserver(SaleObserver obs) {
        saleObservers.add(obs);
    }
}
