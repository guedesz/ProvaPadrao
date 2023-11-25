package events;

public class OrderCancellationEvent {
    private String orderId;

    public OrderCancellationEvent(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderId() {
        return orderId;
    }

}
