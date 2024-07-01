package org.cms.service;

import org.cms.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CartServiceImplTest {
    private CartServiceImpl cartService;
    private List<Product> products;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        cartService = new CartServiceImpl();
        products = new ArrayList<>();
        products.add(new Product("Item 0", 11));
        products.add(new Product("Item 1", 12));
        products.add(new Product("Item 2", 13));
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void testAddProduct() {
        cartService.addProduct(products.get(1));
        assertEquals(cartService.cart.getProductList().get(0).getProductName(),products.get(1).getProductName());
        assertEquals(cartService.cart.getProductList().get(0).getPrice(),products.get(1).getPrice());
        assertEquals(cartService.cart.getProductList().get(0).getProductId(),products.get(1).getProductId());
    }

    @Test
    public void testRemoveProductInCart() {
        cartService.addProduct(products.get(0));
        cartService.addProduct(products.get(2));

        cartService.removeProduct(products.get(0).getProductId().toString());

        assertEquals(cartService.cart.getProductList().get(0).getProductName(),products.get(2).getProductName());
        assertEquals(cartService.cart.getProductList().get(0).getPrice(),products.get(2).getPrice());
        assertEquals(cartService.cart.getProductList().get(0).getProductId(),products.get(2).getProductId());
    }

    @Test
    public void testRemoveProductNotInCart() {
        cartService.addProduct(products.get(2));
        cartService.removeProduct(products.get(0).getProductId().toString());
        assertEquals("This product is not in cart.", outputStreamCaptor.toString().trim());
    }

    @Test
    public void testGetTotalPrice() {
        cartService.addProduct(products.get(0));
        cartService.addProduct(products.get(2));
        assertEquals(24,cartService.getTotalPrice());
        cartService.removeProduct(products.get(0).getProductId().toString());
        assertEquals(13, cartService.getTotalPrice());
        cartService.addProduct(products.get(1));
        assertEquals(25, cartService.getTotalPrice());
    }
}