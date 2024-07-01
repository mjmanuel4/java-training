package org.cms.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Product implements Serializable {
    protected String productName;
    protected int count;
    protected double price;

    @NonNull
    public Product(String productName, int count, double price){
        this.productName = productName;
        this.count = count;
        this.price = price;
    }
}
