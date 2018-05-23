package dbhandler;

/**
 * Responsible for creating instances of the registries.
 */
public class RegistryCreator {
    private ItemsRegistry ItemsRegistry = new ItemsRegistry();
    private CustomerRegistry CustomerRegistry = new CustomerRegistry();

    /**
     * Get the value of ItemRegistry
     * @return the value of ItemRegistry
     */
    public ItemsRegistry getItemsRegistry() {
        return ItemsRegistry;
    }

    /**
     * Get the value of CustomerRegistry
     * @return the value of CustomerRegistry
     */
    public CustomerRegistry getCustomerRegistry() {
        return CustomerRegistry;
    }
}
