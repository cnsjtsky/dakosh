import java.util.ArrayList;

public class Main {
    private static ArrayList<Product> inventory = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(" GROCERY STORE MANAGEMENT SYSTEM \n");

        inventory.add(new Product("Bag", 50.0, 100, "General"));
        inventory.add(new FreshProduct("Orange", 120.0, 50, "Fruits", "2026-01-20"));
        inventory.add(new PackagedProduct("Milk", 450.0, 15, "Dairy", "789456123"));

        System.out.println(" POLYMORPHISM IN ACTION ");
        for (Product p : inventory) {
            p.performAction();

            if (p instanceof FreshProduct) {
                FreshProduct temp = (FreshProduct) p;
                temp.checkQuality();
            }
        }

        System.out.println("\n--------------------------------------\n");

        System.out.println("--- SYSTEM STATUS & TESTS ---");
        Product apple = new Product("Apple", 120.0, 50, "Fruits");
        Product milk = new Product("Milk", 450.0, 0, "Dairy");

        System.out.println(apple);
        System.out.println("Milk in stock? " + milk.isInStock());

        milk.restock(15);
        System.out.println("Milk after restock: " + milk.getQuantity() + " units.");
    }
}