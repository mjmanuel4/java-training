package org.cms;

import org.cms.model.Product;
import org.cms.service.CartServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Initialize cart service
        CartServiceImpl cartService = new CartServiceImpl();

        // Initialize inventory
        List<Product> inventory = new ArrayList<>();
        try {
            inventory.add(new Product("Notebook", 199));
            inventory.add(new Product("Pen", 75));
            inventory.add(new Product("Correction Tape", 88));
            inventory.add(new Product("Sticky Notes", 120));
        } catch (NullPointerException e) {
            System.out.println("Invalid input: product fields cannot be null.");
        }

        // Add products to cart and get total price
        cartService.addProduct(inventory.get(0));
        cartService.addProduct(inventory.get(1));
        cartService.addProduct(inventory.get(2));
        cartService.addProduct(inventory.get(0));
        cartService.addProduct(inventory.get(3));
        cartService.viewCart();

        // Remove products from cart and get updated total price
        cartService.removeProduct(inventory.get(0).getProductId().toString());
        cartService.removeProduct(inventory.get(3).getProductId().toString());
        cartService.viewCart();
    }
}