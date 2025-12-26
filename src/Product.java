public class Product {
    private int productId;
    private String name;
    private double price;
    private int stockQuantity;

    public Product(int productId, String name, double price, int stockQuantity) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    public Product() {
        this.productId = 0;
        this.name = "Новый товар";
        this.price = 0.0;
        this.stockQuantity = 0;
    }

    // Геттеры и сеттеры
    public int getProductId() { return productId; }
    public void setProductId(int productId) { this.productId = productId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public int getStockQuantity() { return stockQuantity; }
    public void setStockQuantity(int stockQuantity) { this.stockQuantity = stockQuantity; }

    public boolean isInStock() { return stockQuantity > 0; }
    public void restock(int amount) { this.stockQuantity += amount; }

    @Override
    public String toString() {
        return String.format("ID: %d | Товар: %-15s | Цена: %8.2f ₸ | Склад: %d шт.",
                productId, name, price, stockQuantity);
    }
}