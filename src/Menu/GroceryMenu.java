import java.util.Scanner;

public class GroceryMenu {
    private ProductDAO dao = new ProductDAO();
    private Scanner scanner = new Scanner(System.in);

    public void run() {
        while (true) {
            System.out.println("\n=== GROCERY STORE SYSTEM (Assignment 4) ===");
            System.out.println("1. Add Product");
            System.out.println("2. Show All Inventory");
            System.out.println("3. Update Price/Qty");
            System.out.println("4. Delete Product");
            System.out.println("5. Search by Name");
            System.out.println("6. Filter by Min Price");
            System.out.println("7. Filter by Price Range");
            System.out.println("0. Exit");
            System.out.print("Action: ");

            String choice = scanner.nextLine();
            if (choice.equals("0")) break;

            try {
                switch (choice) {
                    case "1":
                        System.out.print("Name: "); String n = scanner.nextLine();
                        System.out.print("Category: "); String c = scanner.nextLine();
                        System.out.print("Expiry (YYYY-MM-DD): "); String ex = scanner.nextLine();
                        System.out.print("Barcode: "); String b = scanner.nextLine();
                        System.out.print("Price: "); double p = Double.parseDouble(scanner.nextLine());
                        System.out.print("Quantity: "); int q = Integer.parseInt(scanner.nextLine());
                        dao.create(n, p, q, c, ex, b);
                        break;
                    case "2":
                        dao.readAll();
                        break;
                    case "3":
                        System.out.print("ID: "); int uid = Integer.parseInt(scanner.nextLine());
                        System.out.print("New Price: "); double np = Double.parseDouble(scanner.nextLine());
                        System.out.print("New Qty: "); int nq = Integer.parseInt(scanner.nextLine());
                        dao.update(uid, np, nq);
                        break;
                    case "4":
                        System.out.print("ID to remove: "); int did = Integer.parseInt(scanner.nextLine());
                        System.out.print("Are you sure? (y/n): ");
                        if (scanner.nextLine().equalsIgnoreCase("y")) dao.delete(did);
                        break;
                    case "5":
                        System.out.print("Search Name: ");
                        dao.searchByName(scanner.nextLine());
                        break;
                    case "6":
                        System.out.print("Min Price: ");
                        dao.searchByMinPrice(Double.parseDouble(scanner.nextLine()));
                        break;
                    case "7":
                        System.out.print("Min: "); double min = Double.parseDouble(scanner.nextLine());
                        System.out.print("Max: "); double max = Double.parseDouble(scanner.nextLine());
                        dao.searchByPriceRange(min, max);
                        break;
                    default:
                        System.out.println("Invalid selection.");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter numbers for Price, Quantity, and ID.");
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        scanner.close(); // Clean up scanner before exiting
    }
}