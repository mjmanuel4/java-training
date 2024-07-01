package org.cms.service;

import org.cms.model.Cart;
import org.cms.model.Product;

import java.util.Optional;

/**
 * Contains the business logic for the cart management system.
 */
public class CartServiceImpl implements CartService{
    Cart cart = new Cart();

    /**
     * Adds a product to cart. This method accepts an object of type Product object as argument and does not return
     * any value.
     *
     * @param product
     * @see Product
     */
    @Override
    public void addProduct(Product product) {
        cart.getProductList().add(product);
    }

    /**
     * Removes product from cart. The argument accepted is the product ID of type String, which is used to filter the
     * cart items. If a match is found, the instance of type Product is referenced by an optional object. If the
     * optional object points to an existing product, it is removed, otherwise an error message is displayed.
     * @param productId
     */
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

    /**
     * Displays the cart items in a tabular manner followed by the total price.
     */
    @Override
    public void viewCart() {
        System.out.printf("%n%-20s %-10s %-36s%n", "Product Name", "Price", "Product ID");
        System.out.println("-------------------------------------------------------------------------------");
        cart.getProductList().forEach(System.out::println);
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("Total Price: " + getTotalPrice());
    }

    /**
     * Returns the total price of all the items in the cart.
     *
     * @return total price
     */
    @Override
    public double getTotalPrice() {
        return cart.getProductList().stream().mapToDouble(Product::getPrice).sum();
    }
}
