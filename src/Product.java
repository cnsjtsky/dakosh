public class Product {
    protected String name;
    protected double price;
    protected int quantity;
    protected String category;

    public Product(String name, double price, int quantity, String category) {
        this.name = name;
        setPrice(price);
        setQuantity(quantity);
        this.category = category;
    }

    public Product() {
        this.name = "Unknown";
        this.price = 0;
        this.quantity = 0;
        this.category = "General";
    }

    public void setPrice(double price) {
        if (price >= 0) this.price = price;
        else this.price = 0;
    }

    public void setQuantity(int quantity) {
        if (quantity >= 0) this.quantity = quantity;
        else this.quantity = 0;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public String getCategory() { return category; }

    public void restock(int amount) {
        if (amount > 0) {
            this.quantity += amount;
            System.out.println("Product restocked: " + name);
        }
    }

    public boolean isInStock() {
        return this.quantity > 0;
    }

    public void performAction() {
        System.out.println("Processing general product: " + name);
    }

    @Override
    public String toString() {
        return "Product: " + name + " | Price: " + price + " | Qty: " + quantity + " | Cat: " + category;
    }
}