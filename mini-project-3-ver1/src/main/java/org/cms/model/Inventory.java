package org.cms.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class Inventory extends GenericInventory<Product>{

    public Inventory() {
        super(".\\mini-project-3\\src\\main\\resources\\inventory.txt");
    }

    public void display(){
        System.out.println("INVENTORY\n");
        if(this.getItems().isEmpty()) {
            System.out.println("The inventory is empty.");
        } else {
            this.getItems().forEach((p) -> {
                System.out.println("----------------------------------------");
                System.out.println("Item No.: " + this.getItems().indexOf(p));
                System.out.println("Product Name: " + p.getProductName());
                System.out.println("Price: " + p.getPrice());
                if (Objects.equals(0, p.getCount()))
                    System.out.println("Status: Out of Stock");
                else
                    System.out.println("Status: In Stock");
            });
            System.out.println("----------------------------------------");
        }
    }
}
