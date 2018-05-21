package view;

import controller.Controller;
import dbhandler.ItemsRegistryException;
import model.ItemNotFoundException;
import util.LogHandler;

/**
 * This is a placeholder for the view. It contains only hardcoded calls to the controller.
 */
public class View {
    private Controller contr;
    private LogHandler logger;
    
    /**
     * Constructs a new view, using the specified controller.
     * 
     * @param contr This controller will be used for all system operations.
     */
    public View(Controller contr) {
        this.contr = contr;
        this.logger = new LogHandler();
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
            //System.out.println("Item ID not found, was the correct ID entered?\n");
            handleException("Item ID not found, was the correct ID entered?\n", exc);
        } catch (ItemsRegistryException exc) {
            //System.out.println("Database not reachable\n");
            handleException("Database not reachable\n", exc);
        }
        try {
            System.out.println("Trying to add item, (Wrong itemID)");
            contr.inputItem("21",2);
            System.out.println("Item successfully added\n");
            System.out.println(contr.getSaleInfo());
        } catch (ItemNotFoundException exc) {
            //System.out.println("Item ID not found, was the correct ID entered?\n");
            handleException("Item ID not found, was the correct ID entered?\n", exc);
        } catch (ItemsRegistryException exc) {
            //System.out.println("Database not reachable\n");
            handleException("Database not reachable\n", exc);
        }
        try {
            System.out.println("Trying to add item, (successful run)");
            contr.inputItem("10",2);
            System.out.println("Item successfully added\n");
            System.out.println(contr.getSaleInfo());
        } catch (ItemNotFoundException exc) {
            //System.out.println("Item ID not found, was the correct ID entered?\n");
            handleException("Item ID not found, was the correct ID entered?\n", exc);
        } catch (ItemsRegistryException exc) {
            //System.out.println("Database not reachable\n");
            handleException("Database not reachable\n", exc);
        }

        System.out.println("Total With Taxes: " + contr.priceToPay());
        contr.discountRequest("6");
        System.out.println("Total With Taxes and Discount: " + contr.priceToPay());
        double paidAmount = 18000;
        System.out.println("----------------- Receipt follows --------------");
        contr.payment(paidAmount);
        System.out.println("----------------- Receipt ends --------------\n");
        System.out.println("----------------- Exception log follows --------------");
        System.out.println(logger.printLog());
        System.out.println("----------------- Exception log ends --------------");

    }
    private void handleException(String uiMsg, Exception exc) {
        System.out.println(uiMsg);
        logger.createLog(exc);
    }
}