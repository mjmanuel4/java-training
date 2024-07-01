package org.cms.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Cart {
    private List<Product> productList;

    public Cart() {
        this.productList = new ArrayList<Product>();
    }
}
