package view;

import dbhandler.ItemsDTO;
import model.Sale;
import model.SaleObserver;

public class TotalRevenueView implements SaleObserver {

    private double totalIncome;

    public TotalRevenueView () {
    }

    @Override
    public void newSale(Sale sale) {
        addNewSale(sale);
        printOut(totalIncome);
    }

    private void addNewSale(Sale sale) {
        totalIncome += sale.getTotalWithTaxes();
    }

    private void printOut(double totalIncome) {
        System.out.println("#############################################");
        System.out.println("Total income since program start: " + totalIncome);
        System.out.println("#############################################\n");
    }
}
