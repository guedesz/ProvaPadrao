package interfaces;

import events.OrderCancellationEvent;
import events.OrderConfirmationEvent;

public interface OrderObserver {
    void updateOrderConfirmation(OrderConfirmationEvent event);
    void updateOrderCancellation(OrderCancellationEvent event);

}
