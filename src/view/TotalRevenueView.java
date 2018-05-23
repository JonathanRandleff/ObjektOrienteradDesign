package view;

import model.Sale;
import model.SaleObserver;

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

    private void addNewSale(Sale sale) {
        totalIncome += sale.getTotalWithTaxes();
    }

    private void printOut(double totalIncome) {
        System.out.println("\n#############################################");
        System.out.println("Total income since program start: " + totalIncome);
        System.out.println("#############################################\n");
    }
}
