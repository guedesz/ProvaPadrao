import Items.Product;
import interfaces.Item;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private static ShoppingCart instance;
    private List<Item> items = new ArrayList<>();

    private ShoppingCart() {
        // Construtor privado para evitar instanciação direta
    }

    public static synchronized ShoppingCart getInstance() {
        if (instance == null) {
            instance = new ShoppingCart();
        }
        return instance;
    }

    public void addItem(Item item) {
        // Verifica se o item já está no carrinho
        boolean itemExists = false;
        for (Item existingItem : items) {
            if (existingItem.getName().equals(item.getName())) {
                existingItem.setQuantity(existingItem.getQuantity() + item.getQuantity());
                itemExists = true;
                break;
            }
        }

        // Se o item não existir, adiciona ao carrinho
        if (!itemExists) {
            items.add(item);
        }
    }

    public double calculateTotal() {
        return items.stream().mapToDouble(item -> item.getPrice() * item.getQuantity()).sum();
    }

    public void displayItems() {
        System.out.println("Items:");
        for (Item item : items) {
            System.out.println(item.getName() + " - Quantity: " + item.getQuantity() + " - $" + item.getPrice());
        }

        System.out.println("Total: $" + calculateTotal());
    }
}
