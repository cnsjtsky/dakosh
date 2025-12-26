public class Sale {
    private int saleId;
    private String customerName;
    private double totalAmount;
    private String date;

    public Sale(int saleId, String customerName, double totalAmount, String date) {
        this.saleId = saleId;
        this.customerName = customerName;
        this.totalAmount = totalAmount;
        this.date = date;
    }

    public Sale() {}

    // Геттеры и сеттеры
    public int getSaleId() { return saleId; }
    public void setSaleId(int saleId) { this.saleId = saleId; }
    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }
    public double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }
    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public void applyDiscount(double percentage) { this.totalAmount -= (totalAmount * percentage / 100); }

    @Override
    public String toString() {
        return String.format("Чек №%d | Дата: %s | Покупатель: %-12s | Итого: %.2f ₸",
                saleId, date, customerName, totalAmount);
    }
}