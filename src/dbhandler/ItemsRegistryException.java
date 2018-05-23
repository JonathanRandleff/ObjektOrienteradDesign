package dbhandler;

/**
 * Thrown when something goes wrong in the ItemsRegistry.
 */
public class ItemsRegistryException extends RuntimeException {

    /**
     * Creates a new instance with a specified error message.
     * @param msg The message relevant to the current error.
     */
    public ItemsRegistryException(String msg) {
        super(msg);
    }
}
