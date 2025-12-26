public class Customer {
    private int customerId;
    private String name;
    private String membershipLevel;
    private double totalPurchases;

    public Customer(int customerId, String name, String membershipLevel, double totalPurchases) {
        this.customerId = customerId;
        this.name = name;
        this.membershipLevel = membershipLevel;
        this.totalPurchases = totalPurchases;
    }

    public Customer() {
        this.name = "Новый клиент";
        this.membershipLevel = "Обычный";
    }

    // Геттеры и сеттеры
    public int getCustomerId() { return customerId; }
    public void setCustomerId(int customerId) { this.customerId = customerId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getMembershipLevel() { return membershipLevel; }
    public void setMembershipLevel(String membershipLevel) { this.membershipLevel = membershipLevel; }
    public double getTotalPurchases() { return totalPurchases; }
    public void setTotalPurchases(double totalPurchases) { this.totalPurchases = totalPurchases; }

    public boolean isVIP() { return totalPurchases > 1000.0 || membershipLevel.equalsIgnoreCase("Gold"); }
    public void addPurchase(double amount) { this.totalPurchases += amount; }

    @Override
    public String toString() {
        return String.format("ID: %d | Клиент: %-15s | Статус: %-8s | Сумма покупок: %.2f ₸",
                customerId, name, membershipLevel, totalPurchases);
    }
}