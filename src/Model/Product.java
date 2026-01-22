package model;

public abstract class Product {
    protected String name;
    protected double price;
    protected int quantity;
    protected String category; // Added back to match children

    public Product(String name, double price, int quantity, String category) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
    }

    public abstract void performAction();

    public void setPrice(double price) {
        if (price < 0) throw new IllegalArgumentException("Negative price!");
        this.price = price;
    }

    @Override
    public String toString() {
        return name + " ($" + price + ") - Qty: " + quantity;
    }
}