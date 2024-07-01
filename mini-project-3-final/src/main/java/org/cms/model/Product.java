package org.cms.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Product {
    private UUID productId;
    private String productName;
    private double price;

    @NonNull
    public Product(String productName, double price) {
        this.productId = UUID.randomUUID();
        this.productName = productName;
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("%-20s %-10s %-36s", productName, price, productId.toString());
    }
}
