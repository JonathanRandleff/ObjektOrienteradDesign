package dbhandler;

import model.Sale;

/**
 * This is a placeholder for the AccountingSystem. It mimics an external system.
 */
public class AccountingSystem {
    private Sale sale;

    /**
     * Creates an instance.
     * @param sale The completed sale to save in the Accounting System.
     */
    public AccountingSystem (Sale sale) {
        this.sale = sale;
    }

}
