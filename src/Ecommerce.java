import Items.Product;
import events.OrderCancellationEvent;
import events.OrderConfirmationEvent;
import interfaces.Item;
import interfaces.PaymentProvider;

import java.util.Observable;
import java.util.Observer;

public class Ecommerce extends Observable {
    private PaymentProvider paymentProvider;
    private ShoppingCart shoppingCart;


    // DI para injetar o provedor de pagamento
    public Ecommerce(PaymentProvider paymentProvider, ShoppingCart shoppingCart) {
        this.paymentProvider = paymentProvider;
        this.shoppingCart = shoppingCart;
    }

    public void registerObserver(Observer observer) {
        addObserver(observer);
    }

    public void processOrder(String orderId, String deliveryAddress) {
        shoppingCart.displayItems();
        checkout();

        setChanged();
        notifyObservers(new OrderConfirmationEvent(orderId, deliveryAddress));
    }

    public void cancelOrder(String orderId) {

        setChanged();
        notifyObservers(new OrderCancellationEvent(orderId));
    }

    public void addToCart(Item item, int quantity) {
        shoppingCart.addItem(item, quantity);
    }

    public void checkout() {
        double totalAmount = shoppingCart.calculateTotal();
        paymentProvider.processPayment(totalAmount);
        System.out.println("Order placed successfully!");
    }
}
