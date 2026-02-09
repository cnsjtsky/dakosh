import java.sql.*;

public class ProductDAO {


    public void create(String name, double price, int qty, String cat, String expiry, String barcode) {
        String sql = "INSERT INTO products (name, price, quantity, category, expiry_date, barcode) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setDouble(2, price);
            pstmt.setInt(3, qty);
            pstmt.setString(4, cat);
            pstmt.setString(5, expiry);
            pstmt.setString(6, barcode);
            pstmt.executeUpdate();
            System.out.println(">> Database: Product added successfully.");
        } catch (SQLException e) {
            System.out.println(">> Database Error (Create): " + e.getMessage());
        }
    }

    public void readAll() {
        String sql = "SELECT * FROM products";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("\n--- FULL INVENTORY REPORT ---");
            boolean hasData = false;
            while (rs.next()) {
                hasData = true;
                System.out.println("ID: " + rs.getInt("product_id") +
                        " | Name: " + rs.getString("name") +
                        " | Cat: " + rs.getString("category") +
                        " | Exp: " + rs.getString("expiry_date") +
                        " | Barcode: " + rs.getString("barcode") +
                        " | Price: $" + rs.getDouble("price") +
                        " | Qty: " + rs.getInt("quantity"));
            }
            if (!hasData) System.out.println("Inventory is empty.");
        } catch (SQLException e) {
            System.out.println(">> Database Error (Read): " + e.getMessage());
        }
    }


    public void update(int id, double newPrice, int newQty) {
        String sql = "UPDATE products SET price = ?, quantity = ? WHERE product_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDouble(1, newPrice);
            pstmt.setInt(2, newQty);
            pstmt.setInt(3, id);
            if (pstmt.executeUpdate() > 0) System.out.println(">> Database: Update complete.");
            else System.out.println(">> Database: ID not found.");
        } catch (SQLException e) {
            System.out.println(">> Database Error (Update): " + e.getMessage());
        }
    }

    // 4. DELETE
    public void delete(int id) {
        String sql = "DELETE FROM products WHERE product_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            if (pstmt.executeUpdate() > 0) System.out.println(">> Database: Product removed.");
            else System.out.println(">> Database: ID not found.");
        } catch (SQLException e) {
            System.out.println(">> Database Error (Delete): " + e.getMessage());
        }
    }


    public void searchByName(String name) {
        String sql = "SELECT * FROM products WHERE name ILIKE ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "%" + name + "%");
            ResultSet rs = pstmt.executeQuery();
            boolean found = false;
            while (rs.next()) {
                found = true;
                System.out.println(">> Found: " + rs.getString("name") + " (Barcode: " + rs.getString("barcode") + ")");
            }
            if (!found) System.out.println(">> No products found matching: " + name);
        } catch (SQLException e) {
            System.out.println(">> Database Error (Search): " + e.getMessage());
        }
    }


    public void searchByMinPrice(double minPrice) {
        String sql = "SELECT * FROM products WHERE price >= ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDouble(1, minPrice);
            ResultSet rs = pstmt.executeQuery();
            boolean found = false;
            while (rs.next()) {
                found = true;
                System.out.println(">> " + rs.getString("name") + " | Price: $" + rs.getDouble("price"));
            }
            if (!found) System.out.println(">> No products found above $" + minPrice);
        } catch (SQLException e) {
            System.out.println(">> Database Error (Min Search): " + e.getMessage());
        }
    }


    public void searchByPriceRange(double min, double max) {
        String sql = "SELECT * FROM products WHERE price BETWEEN ? AND ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDouble(1, min);
            pstmt.setDouble(2, max);
            ResultSet rs = pstmt.executeQuery();
            boolean found = false;
            System.out.println("\n--- Range: $" + min + " to $" + max + " ---");
            while (rs.next()) {
                found = true;
                System.out.println(">> " + rs.getString("name") + " | Price: $" + rs.getDouble("price"));
            }
            if (!found) System.out.println("No products found in this range.");
        } catch (SQLException e) {
            System.out.println(">> Database Error (Range Search): " + e.getMessage());
        }
    }
}