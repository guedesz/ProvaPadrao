package events;

import interfaces.OrderObserver;

public class OrderConfirmationEvent {
    private String orderId;
    private String deliveryAddress;

    public OrderConfirmationEvent(String orderId, String deliveryAddress) {
        this.orderId = orderId;
        this.deliveryAddress = deliveryAddress;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }
}
