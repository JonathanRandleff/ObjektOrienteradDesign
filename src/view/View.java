package view;

import controller.Controller;

/**
 * This is a placeholder for the view. It contains only hardcoded calls to the controller.
 */
public class View {
    private Controller contr;
    
    /**
     * Constructs a new view, using the specified controller.
     * 
     * @param contr This controller will be used for all system operations.
     */
    public View(Controller contr) {
        this.contr = contr;
    }
    
    /**
     * Simulates a sample execution containing calls to all system operations.
     */
    public void sampleExecution() {
        System.out.println("Starting sample execution." + "\n");
        contr.startSale();
        contr.inputItem("10",2);
        System.out.println(contr.getSaleInfo());
        contr.inputItem("11",1);
        System.out.println(contr.getSaleInfo());
        System.out.println("Total With Taxes: " + contr.priceToPay());
        contr.discountRequest("6");
        System.out.println("Total With Taxes and Discount: " + contr.priceToPay());
        double paidAmount = 18000;
        System.out.println("----------------- Receipt follows --------------");
        contr.payment(paidAmount);
        System.out.println("----------------- Receipt ends --------------");
    }
}