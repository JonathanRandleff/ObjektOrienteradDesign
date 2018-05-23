package view;

import controller.Controller;
import dbhandler.ItemsRegistryException;
import model.ItemNotFoundException;
import model.PaymentNotEnoughException;
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
        contr.addSaleObserver(new TotalRevenueView());
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
            handleException("Item ID not found, was the correct ID entered?\n", exc);
        } catch (ItemsRegistryException exc) {
            handleException("Database not reachable\n", exc);
        }
        try {
            System.out.println("Trying to add item, (Wrong itemID)");
            contr.inputItem("21",2);
            System.out.println("Item successfully added\n");
            System.out.println(contr.getSaleInfo());
        } catch (ItemNotFoundException exc) {
            handleException("Item ID not found, was the correct ID entered?\n", exc);
        } catch (ItemsRegistryException exc) {
            handleException("Database not reachable\n", exc);
        }
        try {
            System.out.println("Trying to add item, (successful run)");
            contr.inputItem("10",2);
            System.out.println("Item successfully added\n");
            System.out.println(contr.getSaleInfo());
        } catch (ItemNotFoundException exc) {
            handleException("Item ID not found, was the correct ID entered?\n", exc);
        } catch (ItemsRegistryException exc) {
            handleException("Database not reachable\n", exc);
        }
        System.out.println("Total With Taxes: " + contr.priceToPay());
        contr.discountRequest("6");
        System.out.println("Total With Taxes and Discount: " + contr.priceToPay());
        double paidAmount = 18000;
        try {
            contr.payment(paidAmount);
        } catch (PaymentNotEnoughException exc) {
            handleException("Not enough money paid",exc);
        }
        System.out.println("----------------- Exception log follows --------------");
        System.out.println(logger.getLog());
        System.out.println("----------------- Exception log ends --------------");
    }

    /**
     * Handles exceptions, creates user error message and logs error message for developers.
     * @param uiMsg The error message sent to user.
     * @param exc The error message logged for developers.
     */
    private void handleException(String uiMsg, Exception exc) {
        System.out.println(uiMsg);
        logger.createExceptionLog(exc);
    }
}