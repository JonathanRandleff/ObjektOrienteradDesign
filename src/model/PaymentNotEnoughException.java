package model;

public class PaymentNotEnoughException extends Exception {
    public PaymentNotEnoughException () {
        super("Payment made is not enough");
    }
}
