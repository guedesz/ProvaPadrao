import Items.Product;
import interfaces.Item;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private static ShoppingCart instance;
    private List<CartItem> items = new ArrayList<>();

    private ShoppingCart() {
        // Construtor privado para evitar instanciação direta
    }

    public static synchronized ShoppingCart getInstance() {
        if (instance == null) {
            instance = new ShoppingCart();
        }
        return instance;
    }

    public void addItem(Item item, int quantity) {
        // Verifica se o item já está no carrinho
        for (CartItem cartItem : items) {
            if (cartItem.item.equals(item)) {
                // Atualiza a quantidade se o item já estiver no carrinho
                cartItem.setQuantity(cartItem.quantity + quantity);
                return;
            }
        }

        // Adiciona um novo CartItem se o item não estiver no carrinho
        items.add(new CartItem(item, quantity));
    }

    public double calculateTotal() {
        double total = 0;
        for (CartItem cartItem : items) {
            total += cartItem.getAllPrice();
        }
        return total;
    }

    public void displayItems() {
        for (CartItem cartItem : items) {
            System.out.println(cartItem.item.getName() + " - Quantity: " + cartItem.quantity);
        }
    }
}
