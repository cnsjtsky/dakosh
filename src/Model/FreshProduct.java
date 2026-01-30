package Model;

public class FreshProduct extends Product {
    private String expiry;

    public FreshProduct(String name, double price, int qty, String category, String expiry) {
        super(name, price, qty, category);
        this.expiry = expiry;
    }

    @Override
    public void performAction() {
        System.out.println("Checking freshness for " + name + ". Expires: " + expiry);
    }
}