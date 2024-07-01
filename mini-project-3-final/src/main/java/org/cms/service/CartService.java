package org.cms.service;

import org.cms.model.Product;

public interface CartService {
    public void addProduct(Product product);
    public void removeProduct(String productId);
    public void viewCart();
    public double getTotalPrice();
}
