import java.util.Scanner;

public class GroceryMenu {
    private ProductDAO dao = new ProductDAO();
    private Scanner scanner = new Scanner(System.in);

    public void run() {
        while (true) {
            System.out.println("\n=== GROCERY STORE SYSTEM (Week 8) ===");
            System.out.println("1. Create (Add Product)");
            System.out.println("2. Read   (Show All)");
            System.out.println("3. Update (Price/Qty)");
            System.out.println("4. Delete (Remove)");
            System.out.println("5. Search (By Name)");
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
                        System.out.print("ID to update: "); int uid = Integer.parseInt(scanner.nextLine());
                        System.out.print("New Price: "); double np = Double.parseDouble(scanner.nextLine());
                        System.out.print("New Quantity: "); int nq = Integer.parseInt(scanner.nextLine());
                        dao.update(uid, np, nq);
                        break;
                    case "4":
                        System.out.print("ID to delete: "); int did = Integer.parseInt(scanner.nextLine());
                        System.out.print("Confirm deletion? (y/n): ");
                        if (scanner.nextLine().equalsIgnoreCase("y")) dao.delete(did);
                        break;
                    case "5":
                        System.out.print("Search Name: ");
                        dao.searchByName(scanner.nextLine());
                        break;
                }
            } catch (Exception e) {
                System.out.println("Input Error: Please enter numbers for ID, Price, and Quantity.");
            }
        }
    }
}