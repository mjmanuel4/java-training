package org.cms.model;

public class CartItem extends Product{

    public CartItem(String productName, int count, double price) {
        super(productName, count, price);
    }

    public double getTotalPrice(){
        return count * price;
    }
}
