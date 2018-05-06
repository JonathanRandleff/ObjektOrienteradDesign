package dbhandler;

import java.util.Objects;

public class CustomerDTO {
    private final String name;
    private final String customerID;
    private final boolean discountEligible;

    /**
     *
     * @param name The Customers name
     * @param customerID The customers ID
     * @param discountEligible If the customer is Eligible for discount or not.
     */
    public CustomerDTO(String name, String customerID, boolean discountEligible) {
        this.name = name;
        this.customerID = customerID;
        this.discountEligible = discountEligible;
    }

    /**
     * Get the value of name
     * @return the value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Get the value of customerID
     * @return the value of customerID
     */
    public String getCustomerID() {
        return customerID;
    }

    /**
     * Get the value of discountEligible
     * @return the value of discountEligible
     */
    public boolean isDiscountEligible() {
        return discountEligible;
    }

    /**
     * Compares two object of CustomerDTO and checks if they are equal
     * @param otherObj The object to compare against.
     * @return if they are equal or not
     */
    public boolean equals(Object otherObj) {
        if (otherObj == null) {
            return false;
        }
        if (getClass() != otherObj.getClass()) {
            return false;
        }
        final CustomerDTO other = (CustomerDTO) otherObj;

        if (!Objects.equals(this.customerID, other.customerID)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.discountEligible, other.discountEligible)) {
            return false;
        }
        return true;
    }
}
