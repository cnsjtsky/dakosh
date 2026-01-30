package Menu;

import Model.*;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.out;

public class GroceryMenu implements Menu {
    private ArrayList<Product> inventory = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void displayMenu() {
        System.out.println("\n GROCERY STORE MANAGEMENT");
        System.out.println("1. Add Fresh Product (Fruits/Veg)");
        System. out.println("2. Add Packaged Product (Canned/Boxed)");
        System.out.println("3. View All Inventory");
        System.out.println("0. Exit");
    }

    @Override
    public void run(){
        int choice = -1;
        while (choice != 0){
            displayMenu();

        }try {
            System.out.print("entr choice");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice){
                case 1 : addFreshProduct();break;
                case 2: addPackagedProduct();break;
                case 3: viewAll();break;
                case 0:
                    System.out.print("exit");
                default:
                    System.out.print("invalid choice");

            }
        }catch (Exception e ) {
            System.out.print("error" + e.getMessage());

        }
    }
    private void addFreshProduct(){
        System.out.print("enter prod name");
        String name = scanner.nextLine();
        System.out.print("product price");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.print("enter quantity");
        int qty = Integer.parseInt(scanner.nextLine());
        System.out.print("enter categiry");
        String cat = scanner.nextLine();
        System.out.print("enter expirt date YYYY-MM-DD");
        String expiry = scanner.nextLine();

        inventory.add(new FreshProduct(name,price,qty,cat, expiry));
        System.out.print(name + "added");

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