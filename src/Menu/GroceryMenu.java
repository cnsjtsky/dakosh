package menu;

import model.*;
import java.util.ArrayList;
import java.util.Scanner;

public class GroceryMenu implements Menu {
    private ArrayList<Product> inventory = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void displayMenu() {
        System.out.println("\n--- GROCERY STORE MANAGEMENT ---");
        System.out.println("1. Add Fresh Product (Fruits/Veg)");
        System.out.println("2. Add Packaged Product (Canned/Boxed)");
        System.out.println("3. View All Inventory");
        System.out.println("0. Exit");
    }

    @Override
    public void run() {
        int choice = -1;
        while (choice != 0) {
            displayMenu();
            try {
                System.out.print("Enter choice: ");
                choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1: addFreshProduct(); break;
                    case 2: addPackagedProduct(); break;
                    case 3: viewAll(); break;
                    case 0: System.out.println("Exiting..."); break;
                    default: System.out.println("Invalid choice!");
                }
            } catch (Exception e) {
                // This catches NumberFormatException and our Custom Exceptions
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private void addFreshProduct() {
        System.out.print("Enter Product Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Price: ");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter Quantity: ");
        int qty = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter Category: ");
        String cat = scanner.nextLine();
        System.out.print("Enter Expiry Date (YYYY-MM-DD): ");
        String expiry = scanner.nextLine();

        // Adding the user's specific input to the list
        inventory.add(new FreshProduct(name, price, qty, cat, expiry));
        System.out.println(name + " added successfully!");
    }

    private void addPackagedProduct() {
        System.out.print("Enter Product Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Price: ");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter Quantity: ");
        int qty = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter Category: ");
        String cat = scanner.nextLine();
        System.out.print("Enter Barcode: ");
        String barcode = scanner.nextLine();

        inventory.add(new PackagedProduct(name, price, qty, cat, barcode));
        System.out.println(name + " added successfully!");
    }

    private void viewAll() {
        System.out.println("\n--- CURRENT INVENTORY ---");
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            for (Product p : inventory) {
                System.out.println(p); // Calls toString()
                p.performAction();      // Demonstrates Polymorphism
            }
        }
    }
}