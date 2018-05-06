package startup;

import controller.Controller;
import view.View;
import dbhandler.RegistryCreator;
import dbhandler.Printer;

/**
 * Starts the entire application.
 */
public class Main {
    /**
     * @param args The program does not take any command line parameters. 
     */
    public static void main(String[] args) {
        RegistryCreator creator = new RegistryCreator();
        Printer printer = new Printer();
        Controller contr = new Controller(creator, printer);
        View view = new View(contr);
        view.sampleExecution();
    }
}
