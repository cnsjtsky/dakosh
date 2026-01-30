package Model;

public class PackagedProduct extends Product {
    private String barcode;

    public PackagedProduct(String name, double price, int quantity, String category, String barcode) {
        super(name, price, quantity, category);
        this.barcode = barcode;
    }

    @Override
    public void performAction() {
        System.out.println("Scanning barcode [" + barcode + "] for: " + name);
    }
}