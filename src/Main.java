import Items.Product;
import Items.Service;
import PaymentProviders.BoletoPaymentProvider;
import interfaces.Item;
import interfaces.PaymentProvider;

import java.util.Observer;

public class Main {
    public static void main(String[] args) {

        Item product1 = new Product("Laptop", 100, 3);
        Item product2 = new Product("Laptop", 100, 1);
        Item product3 = new Product("Laptop", 100, 2);
        Item service1 = new Service("Instalation", 50, 1);

        // Criando instância do carrinho de compras
        ShoppingCart shoppingCart = ShoppingCart.getInstance();

        // Escolhendo um provedor de pagamento
        PaymentProvider boletoPaymentProvider = new BoletoPaymentProvider();

        // Criando instância do sistema de comércio eletrônico
        Ecommerce eCommerce = new Ecommerce(boletoPaymentProvider, shoppingCart);

        // Criando instância do agente logístico
        LogisticAgent agenteLogístico = new LogisticAgent();
        Observer logisticAgentObserver = new ObserverAdapter(agenteLogístico);

        eCommerce.registerObserver(logisticAgentObserver);

        eCommerce.addToCart(product1);
        eCommerce.addToCart(product2);
        eCommerce.addToCart(product3);
        eCommerce.addToCart(service1);

        String orderId = "123";
        String deliveryAddress = "Rua Principal, 123";
        eCommerce.processOrder(orderId, deliveryAddress);

        // Simulando o cancelamento da compra
        String orderIdToCancel = "124";
        eCommerce.cancelOrder(orderIdToCancel);


    }
}