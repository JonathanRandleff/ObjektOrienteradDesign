package view;

import controller.Controller;
import dbhandler.ItemsRegistryException;
import model.ItemNotFoundException;

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


        try {
            System.out.println("Trying to add item, (Database will be down)");
            contr.inputItem("0",2);
            System.out.println("Item successfully added\n");
            System.out.println(contr.getSaleInfo());
        } catch (ItemNotFoundException exc) {
            System.out.println("Item ID not found, was the correct ID entered?\n");
        } catch (ItemsRegistryException exc) {
            System.out.println("Database not reachable\n");
        }
        try {
            System.out.println("Trying to add item, (Wrong itemID)");
            contr.inputItem("21",2);
            System.out.println("Item successfully added\n");
            System.out.println(contr.getSaleInfo());
        } catch (ItemNotFoundException exc) {
            System.out.println("Item ID not found, was the correct ID entered?\n");
        } catch (ItemsRegistryException exc) {
            System.out.println("Database not reachable\n");
        }
        try {
            System.out.println("Trying to add item, (successful run)");
            contr.inputItem("10",2);
            System.out.println("Item successfully added\n");
            System.out.println(contr.getSaleInfo());
        } catch (ItemNotFoundException exc) {
            System.out.println("Item ID not found, was the correct ID entered?\n");
        } catch (ItemsRegistryException exc) {
            System.out.println("Database not reachable\n");
        }

        System.out.println("Total With Taxes: " + contr.priceToPay());
        contr.discountRequest("6");
        System.out.println("Total With Taxes and Discount: " + contr.priceToPay());
        double paidAmount = 18000;
        System.out.println("----------------- Receipt follows --------------");
        contr.payment(paidAmount);
        System.out.println("----------------- Receipt ends --------------");
    }
}