import events.OrderCancellationEvent;
import events.OrderConfirmationEvent;
import interfaces.OrderObserver;

public class ObserverAdapter implements java.util.Observer {
    private OrderObserver orderObserver;

    public ObserverAdapter(OrderObserver orderObserver) {
        this.orderObserver = orderObserver;
    }

    @Override
    public void update(java.util.Observable o, Object arg) {
        if (arg instanceof OrderConfirmationEvent confirmationEvent) {
            orderObserver.updateOrderConfirmation(confirmationEvent);
        } else if (arg instanceof OrderCancellationEvent cancellationEvent) {
            orderObserver.updateOrderCancellation(cancellationEvent);
        }
    }
}
