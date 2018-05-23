package model;

/**
 * A listener interface for receiving notifications about sales.
 */
public interface SaleObserver {
    /**
     * Invoked when a sale is completed.
     * @param sale The sale which is completed.
     */
    void newSale(Sale sale);
}