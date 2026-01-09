import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Product> inventory = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        inventory.add(new Product("Bag", 50.0, 100, "General"));
        inventory.add(new FreshProduct("Apple", 120.0, 50, "Fruits", "2026-01-20"));
        inventory.add(new PackagedProduct("Milk", 450.0, 15, "Dairy", "789456123"));

        int choice;
        do {
            System.out.println("GROCERY STORE MANAGEMENT SYSTEM");
            System.out.println("1. Add Product (General)");
            System.out.println("2. Add Fresh Product (Child Type 1)");
            System.out.println("3. Add Packaged Product (Child Type 2)");
            System.out.println("4. View All Objects (toString)");
            System.out.println("5. Demonstrate Polymorphism (performAction)");
            System.out.println("6. View by Type (instanceof Filter)");
            System.out.println("0. Exit");
            System.out.print(" Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addGeneralProduct();
                    break;
                case 2:
                    addFreshProduct();
                    break;
                case 3:
                    addPackagedProduct();
                    break;
                case 4:
                    viewAllObjects();
                    break;
                case 5:
                    demoPolymorphism();
                    break;
                case 6:
                    viewByType();
                    break;
                case 0:
                    System.out.println("Exiting system...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 0);
    }

    private static void addGeneralProduct() {
        System.out.print("Name: "); String n = scanner.nextLine();
        System.out.print("Price: "); double p = scanner.nextDouble();
        System.out.print("Quantity: "); int q = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Category: "); String c = scanner.nextLine();
        inventory.add(new Product(n, p, q, c));
    }

    private static void addFreshProduct() {
        System.out.print("Name: "); String n = scanner.nextLine();
        System.out.print("Price: "); double p = scanner.nextDouble();
        System.out.print("Quantity: "); int q = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Category: "); String c = scanner.nextLine();
        System.out.print("Expiry Date (YYYY-MM-DD): "); String e = scanner.nextLine();
        inventory.add(new FreshProduct(n, p, q, c, e));
    }

    private static void addPackagedProduct() {
        System.out.print("Name: "); String n = scanner.nextLine();
        System.out.print("Price: "); double p = scanner.nextDouble();
        System.out.print("Quantity: "); int q = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Category: "); String c = scanner.nextLine();
        System.out.print("Barcode: "); String b = scanner.nextLine();
        inventory.add(new PackagedProduct(n, p, q, c, b));
    }

    private static void viewAllObjects() {
        System.out.println("\n--- ALL STORE OBJECTS ---");
        for (Product p : inventory) {
            System.out.println(p.toString());
        }
    }

    private static void demoPolymorphism() {
        System.out.println("\n--- POLYMORPHISM IN ACTION ---");
        for (Product p : inventory) {
            p.performAction();
        }
    }

    private static void viewByType() {
        System.out.println("\nSelect Type: 1. Fresh | 2. Packaged");
        int type = scanner.nextInt();
        for (Product p : inventory) {
            if (type == 1 && p instanceof FreshProduct) {
                System.out.println(p);
                ((FreshProduct) p).checkQuality(); // Downcasting demo
            } else if (type == 2 && p instanceof PackagedProduct) {
                System.out.println(p);
            }
        }
    }
}