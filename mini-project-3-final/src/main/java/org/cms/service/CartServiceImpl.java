package org.cms.service;

import org.cms.model.Cart;
import org.cms.model.Product;

import java.util.Optional;

public class CartServiceImpl implements CartService{
    Cart cart = new Cart();

    @Override
    public void addProduct(Product product) {
        cart.getProductList().add(product);
    }

    @Override
    public void removeProduct(String productId) {
        Optional<Product> forRemoval =  cart.getProductList()
                                            .stream()
                                            .filter(product -> product.getProductId().toString().equals(productId))
                                            .findFirst();
        forRemoval.ifPresentOrElse(
                cart.getProductList()::remove,
                () -> System.out.println("This product is not in cart."));
    }

    @Override
    public void viewCart() {
        System.out.printf("%n%-20s %-10s %-36s%n", "Product Name", "Price", "Product ID");
        System.out.println("-------------------------------------------------------------------------------");
        cart.getProductList().forEach(System.out::println);
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("Total Price: " + getTotalPrice());
    }

    @Override
    public double getTotalPrice() {
        return cart.getProductList().stream().mapToDouble(Product::getPrice).sum();
    }
}
