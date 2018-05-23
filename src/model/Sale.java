package model;

import dbhandler.ItemsDTO;
import dbhandler.ItemsRegistry;
import dbhandler.CustomerDTO;
import dbhandler.Printer;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


/**
 * Collects all information regarding a particular sale.
 */
public class Sale {
    private LocalDateTime saleTime;
    private ItemsDTO item;
    private ItemsRegistry itemsRegistry;
    private String itemDescription;
    private CustomerDTO customer;
    private Discount discount;
    private double itemPrice;
    private double runningTotal;
    private double discountedRunningTotal;
    private double totalWithTaxes;
    private boolean discountAvailable;
    private double changeAmount;
    private double paidAmount;
    private StringBuilder builder = new StringBuilder();
    private List<SaleObserver> saleObservers = new ArrayList<>();

    private static final double TAX_PERCENTAGE = 1.25;

    /**
     * Creates a new instance, and records the time it was created. This will be the time recorded
     * on the receipt.
     */
    public Sale() {
        this.saleTime = LocalDateTime.now();
    }

    /**
     * Adds items to the current sale, and calculates and retrieves information about the current item.
     * @param item The item which is being purchased.
     * @param quantity The amount of "item" is being purchased.
     * @throws ItemNotFoundException when searched item is not found in inventory catalog.
     */
    public void addItem(ItemsDTO item, int quantity) throws ItemNotFoundException {
        this.item = item;
        itemsRegistry = new ItemsRegistry();
            if (itemsRegistry.itemIdNotFound(item)) {
                throw new ItemNotFoundException(item);
            }
        itemPrice = (itemsRegistry.getItemPrice(item));
        itemDescription = (itemsRegistry.getItemDescription(item));
        runningTotal += itemPrice * quantity;
        discountedRunningTotal += (itemsRegistry.getDiscountedPrice(item) * quantity);
        builder.append(quantity + " of: " + itemDescription + "     Price: " + itemPrice * quantity  + "\n");
    }

    /**
     *
     * @return Item information used in receipt
     */
    public String getItemInfo() {
        return builder.toString();
    }

    /**
     *
     * @return The current total price.
     */
    public double getRunningTotal () {
        return runningTotal;
    }

    /**
     *
     * @return The description of the item.
     */
    public String getItemDescription () {
        return itemDescription;
    }

    /**
     *
     * @return The price of the item.
     */
    public double getItemPrice() {
        return itemPrice;
    }

    /**
     *
     * @return Information about the item which was just added to the current sale.
     */
    public String getSaleInfo() {
        StringBuilder builder = new StringBuilder();
        builder.append("Item Description: " + itemDescription + "\n");
        builder.append("Item Price: " + itemPrice + "\n");
        builder.append("Running Total: " + runningTotal + "\n");
        return builder.toString();
    }

    /**
     * Calculates a new total price including taxes and possible discount.
     * @return The total price including taxes.
     */
    public double getTotalWithTaxes() {
        if (discountAvailable) {
            totalWithTaxes = discountedRunningTotal * TAX_PERCENTAGE;
            return totalWithTaxes;
        }
        else {
            totalWithTaxes = runningTotal * TAX_PERCENTAGE;
            return totalWithTaxes;
        }
    }

    /**
     * Checking if this customer can have discounted prices.
     * @param customer The customer asking for discount.
     */
    public void discountAvailable(CustomerDTO customer) {
        this.customer = customer;
        discount = new Discount(customer);
        discountAvailable = discount.isDiscountAvailable(customer);
    }

    /**
     * This sale is paid using the specified payment.
     * Notifies observer that sale is completed.
     * @param paidAmount The amount paid by the customer
     */
    public void pay(double paidAmount) throws PaymentNotEnoughException {
        this.paidAmount = paidAmount;
        if (paidAmount < getTotalWithTaxes()) {
            throw new PaymentNotEnoughException();
        }
        notifyObservers();
    }

    /**
     * Calculates the amount of change to be returned to the customer
     * @param paidAmount The amount paid by the customer.
     * @return The amount of change to be returned to the customer
     */
    public double changeAmount(double paidAmount) {
        changeAmount = paidAmount - getTotalWithTaxes();
        return getChangeAmount();
    }

    /**
     *
     * @return The amount of change to be returned to the customer
     */
    public double getChangeAmount() {
        return changeAmount;
    }

    /**
     *
     * @return The time of the sale.
     */
    public LocalDateTime getTimeStamp() {
        return saleTime;
    }

    /**
     * Prints a receipt for the current sale.
     * @param printer The printer where the receipt is printed.
     */
    public void printReceipt(Printer printer) {
        Receipt receipt = new Receipt(this);
        printer.printReceipt(receipt);
    }

    /**
     * Will notify the observer when called upon
     */
    private void notifyObservers() {
        for (SaleObserver obs : saleObservers) {
            obs.newSale(this);
        }
    }

    /**
     * All the specified observers will be notified when this sale has been finalized.
     *
     * @param observers The observers to notify.
     */
    public void addSaleObservers(List<SaleObserver> observers) {
        saleObservers.addAll(observers);
    }
}
