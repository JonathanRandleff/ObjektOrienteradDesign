package dbhandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Contains all calls to the data store with customers that may request discount.
 */
public class CustomerRegistry {
    private List<CustomerData> Customers = new ArrayList<>();

    public CustomerRegistry () {
        addCustomers();
    }

    /**
     * Adds customers to the "database".
     */
    private void addCustomers() {
        Customers.add(new CustomerData("Karl Svensson","1",false));
        Customers.add(new CustomerData("Johan Nilsson","2",true));
        Customers.add(new CustomerData("Anna Haglund","3",false));
        Customers.add(new CustomerData("Lisa Olsson","4",true));
        Customers.add(new CustomerData("Bengt Olofsson","5",true));
        Customers.add(new CustomerData("Hilda Broman","6",true));
    }

    /**
     * Checks if customer in "database" is eligibile for discount
     * @param customer The customer requesting discount
     * @return If the customer is eligible or not
     */
    public boolean getCustomerDiscountEligibility(CustomerDTO customer) {
        CustomerData customerGetInfo = findCustomerByID(customer);
        return customerGetInfo.discountEligible;
    }

    /**
     * Searching for customer matching the given ID.
     * @param searchedCustomer The object containing the search criteria.
     * @return A customer matching the given ID or otherwise null
     */
    private CustomerData findCustomerByID (CustomerDTO searchedCustomer) {
        for (CustomerData Customer : Customers) {
            if (Customer.customerID.equals(searchedCustomer.getCustomerID())) {
                return Customer;
            }
        }
        return null;
    }

    public static class CustomerData {
        private String name;
        private String customerID;
        private boolean discountEligible;

        /**
         *
         * @param name The name of the customer.
         * @param customerID The ID of the customer.
         * @param discountEligible IF the customer is eligible for discount.
         */
        public CustomerData(String name, String customerID, boolean discountEligible) {
            this.name = name;
            this.customerID = customerID;
            this.discountEligible = discountEligible;
        }
    }
}