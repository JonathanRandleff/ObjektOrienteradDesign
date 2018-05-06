package model;

import dbhandler.CustomerDTO;
import dbhandler.CustomerRegistry;

/**
 * The class responsible for checking if customer is eligible for discount.
 */
public class Discount {
    private CustomerDTO customer;
    private CustomerRegistry customerRegistry;

    /**
     * Creates a new instance.
     * @param customer The customer requesting discount.
     */
    public Discount(CustomerDTO customer) {
        this.customer = customer;
        customerRegistry = new CustomerRegistry();
    }

    /**
     * Checking if customer is eligible or not.
     * @param customer The customer requesting discount.
     * @return If the customer is eligible or not
     */
    public boolean isDiscountAvailable(CustomerDTO customer) {
        return customerRegistry.getCustomerDiscountEligibility(customer);
    }
}
