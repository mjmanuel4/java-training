package org.cms;

import org.cms.model.Cart;
import org.cms.model.CartItem;
import org.cms.model.Inventory;
import org.cms.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    private static Inventory inventory;
    private static Cart cart;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // ----------------INITIALIZATION OF INVENTORY---------------------
        inventory = new Inventory();

        // initialize inventory
        inventory.genericLoad();
        if (inventory.getItems().isEmpty()){
            System.out.println("The inventory is empty. Please initialize the product list.");
            List<Product> products = new ArrayList<Product>();
            inventory.setItems(initializeInventory(products));

            // update inventory
            inventory.genericUpdate();
        }

        // ----------------SERVICE SELECTION---------------------



        // ----------------INITIALIZATION OF CART---------------------
        cart = new Cart();
        cart.genericLoad();
        boolean cartSysActive = true;

        while (cartSysActive) {
            switch (cartServiceInput()) {
                case 1:
                    cart.setItems(cartAdditionService());
                    cart.genericUpdate();
                    break;
                case 2:
                    break;
                case 3:

            }
        }

        scanner.close();
    }

    public static List<Product> initializeInventory(List<Product> products) {
        Scanner scanner = new Scanner(System.in);
        boolean initializeInventory = true;

        while (initializeInventory) {
            try {
                System.out.print("Product name: ");
                String name = scanner.nextLine();
                System.out.print("Count: ");
                int count = Integer.parseInt(scanner.nextLine());
                System.out.print("Price: ");
                double price = Double.parseDouble(scanner.nextLine());

                products.add(new Product(name,count,price));
                System.out.print("Would you like to add more items? [y/n] ");
                initializeInventory = Objects.equals("y", scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid input, please try again.");
            }
        }

        scanner.close();
        return products;
    }

    public static int cartServiceInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please choose a cart service:");
        System.out.println("[1] Add to Cart");
        System.out.println("[2] Remove from Cart");
        System.out.println("[3] View Cart");
        System.out.println("[4] View Inventory");
        System.out.println("[4] Exit");
        int result = Integer.parseInt(scanner.nextLine());
        scanner.close();
        return result;
    }

    public static List<CartItem> cartAdditionService(){
        Scanner scanner = new Scanner(System.in);
        boolean updatingCart = true;

        System.out.println("Displaying inventory for reference:");
        inventory.display();


        while (updatingCart) {
            System.out.print("\nEnter product no. to add to cart: ");
            int index = Integer.parseInt(scanner.nextLine());
            Product product = inventory.getItems().get(index);
            boolean inCart = cart.getItems()
                                .stream()
                                .anyMatch(c -> Objects.equals(product.getProductName(),c.getProductName()));
            if (inCart) {
                int cartIndex = cart.getItems().indexOf(); // TODO: get existing cart item
                cart.getItems().get(cartIndex).setCount(cart.getItems().get(cartIndex).getCount() + 1);
            } else
                cart.addItem(new CartItem(product.getProductName(),1, product.getPrice()));

            inventory.getItems().get(index).setCount(inventory.getItems().get(index).getCount() - 1);
            System.out.println("Item added to cart.");
            System.out.print("Add more to cart? [y/n] ");
            updatingCart = Objects.equals("y", scanner.nextLine());
        }

        scanner.close();
        return cart.getItems();
    }
}