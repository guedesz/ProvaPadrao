package PaymentProviders;

import interfaces.PaymentProvider;

public class PixPaymentProvider implements PaymentProvider {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing payment of $" + amount + " via Pix");
    }
}
