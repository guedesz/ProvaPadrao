package PaymentProviders;

import interfaces.PaymentProvider;

public class CreditCardPaymentProvider implements PaymentProvider {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing payment of $" + amount + " via credit card");
    }
}
