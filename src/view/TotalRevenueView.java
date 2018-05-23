package view;

import model.Sale;
import model.SaleObserver;

/**
 * Handles the display for the total amount of all sales.
 */
public class TotalRevenueView implements SaleObserver {

    private double totalIncome;

    /**
     * Creates a new instance and calls methods.
     * @param sale The current sale
     */
    @Override
    public void newSale(Sale sale) {
        addNewSale(sale);
        printOut(totalIncome);
    }

    /**
     * Adds a new sale and calculates the new total of all completed sales.
     * @param sale The sale to add.
     */
    private void addNewSale(Sale sale) {
        totalIncome += sale.getTotalWithTaxes();
    }

    /**
     * Prints out the total income of program.
     * @param totalIncome The total of all sold items.
     */
    private void printOut(double totalIncome) {
        System.out.println("\n#############################################");
        System.out.println("Total income since program start: " + totalIncome);
        System.out.println("#############################################\n");
    }
}
