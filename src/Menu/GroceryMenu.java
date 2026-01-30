import java.util.Scanner;

public class GroceryMenu {
    private ProductDAO dao = new ProductDAO();
    private Scanner scanner = new Scanner(System.in);

    public void run() {
        while (true) {
            System.out.println("\n--- CRUD GROCERY SYSTEM ---");
            System.out.println("1. Add Product (Create)");
            System.out.println("2. View All (Read)");
            System.out.println("3. Update Product (Update)");
            System.out.println("4. Delete Product (Delete)");
            System.out.println("5. Search by Name");
            System.out.println("0. Exit");
            System.out.print("Choice: ");

            String choice = scanner.nextLine();
            if (choice.equals("0")) break;

            switch (choice) {
                case "1":
                    System.out.print("Name: "); String n = scanner.nextLine();
                    System.out.print("Price: "); double p = Double.parseDouble(scanner.nextLine());
                    System.out.print("Qty: "); int q = Integer.parseInt(scanner.nextLine());
                    dao.create(n, p, q);
                    break;
                case "2":
                    dao.readAll();
                    break;
                case "3":
                    System.out.print("ID to update: "); int uid = Integer.parseInt(scanner.nextLine());
                    System.out.print("New Price: "); double np = Double.parseDouble(scanner.nextLine());
                    System.out.print("New Qty: "); int nq = Integer.parseInt(scanner.nextLine());
                    dao.update(uid, np, nq);
                    break;
                case "4":
                    System.out.print("ID to delete: "); int did = Integer.parseInt(scanner.nextLine());
                    System.out.print("Confirm (y/n): ");
                    if (scanner.nextLine().equalsIgnoreCase("y")) dao.delete(did);
                    break;
                case "5":
                    System.out.print("Search: "); dao.searchByName(scanner.nextLine());
                    break;
            }
        }
    }
}