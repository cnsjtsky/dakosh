import menu.Menu;
import menu.GroceryMenu;

public class Main {
    public static void main(String[] args) {
        Menu myMenu = new GroceryMenu();
        myMenu.run();
    }
}