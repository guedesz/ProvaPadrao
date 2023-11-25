import interfaces.Item;

public class CartItem {

    public Item item;
    public int quantity;

    public CartItem(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    };

    public double getAllPrice(){
        return item.getPrice() * quantity;
    }


}
