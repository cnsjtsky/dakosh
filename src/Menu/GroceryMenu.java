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
            System.out.println("6. Search (By Min Price)");
            System.out.println("0. Exit");
            System.out.print("Action: ");

            String choice = scanner.nextLine();
            if (choice.equals("0")) break;

            try {
                switch (choice) {
                    case "1":

                        break;
                    case "2":
                        dao.readAll();
                        break;
                    case "3":

                        break;
                    case "4":

                        break;
                    case "5":
                        System.out.print("Search Name: ");
                        dao.searchByName(scanner.nextLine());
                        break;
                    case "6":
                        System.out.print("Enter minimum price: ");
                        double min = Double.parseDouble(scanner.nextLine());
                        dao.searchByMinPrice(min);
                        break;
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}