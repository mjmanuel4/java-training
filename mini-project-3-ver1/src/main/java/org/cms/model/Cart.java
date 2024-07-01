package org.cms.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cart extends GenericInventory<CartItem> {
    private double totalPrice;

    public Cart() {
        super(".\\mini-project-3\\src\\main\\resources\\cart.txt");
    }

    public void display(){
        System.out.println("YOUR CART\n");
        if(this.getItems().isEmpty()) {
            System.out.println("Your cart is empty.");
        } else {
            this.getItems().forEach((c) -> {
                System.out.println("----------------------------------------");
                System.out.println("Item No.: " + this.getItems().indexOf(c));
                System.out.println("Product Name: " + c.getProductName());
                System.out.println("Price: " + c.getPrice());
                System.out.println("Count: " + c.getCount());
            });
            System.out.println("----------------------------------------");
            System.out.println("\nTOTAL: " + this.getTotalPrice());
        }
    }

    public void updateTotalPrice() {
        totalPrice = items.stream().mapToDouble(CartItem::getTotalPrice).sum();
    }
}
