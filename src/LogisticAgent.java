import events.OrderCancellationEvent;
import events.OrderConfirmationEvent;
import interfaces.OrderObserver;

public class LogisticAgent implements OrderObserver {

    @Override
    public void updateOrderConfirmation(OrderConfirmationEvent event) {
        String orderId = event.getOrderId();
        String deliveryAddress = event.getDeliveryAddress();
        System.out.println("Pedido " + orderId + " confirmado para entrega no endereço: " + deliveryAddress);
    }

    @Override
    public void updateOrderCancellation(OrderCancellationEvent event) {
        String orderId = event.getOrderId();
        System.out.println("Pedido " + orderId + " cancelado. Proceder à devolução dos produtos ou cancelar a ordem de transporte.");
    }

}
