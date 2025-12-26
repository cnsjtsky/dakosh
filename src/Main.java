public class Main {
    public static void main(String[] args) {

        System.out.println("   СИСТЕМА УПРАВЛЕНИЯ ПРОДУКТОВЫМ МАГАЗИНОМ   ");


        // 1. Создание объектов
        Product p1 = new Product(1, "молоко", 450.0, 5);
        Product p2 = new Product();
        Customer c1 = new Customer(101, "Нурали", "Обычный", 1200.0);
        Customer c2 = new Customer(102, "Дакош", "Gold", 5000.0);
        Sale s1 = new Sale(5001, "Дакош", 6000.0, "2024-05-20");

        // 2. Начальное состояние
        System.out.println("ТЕКУЩЕЕ СОСТОЯНИЕ БАЗЫ ДАННЫХ:");
        System.out.println("Товары:");
        System.out.println("  " + p1);
        System.out.println("  " + p2);
        System.out.println("Клиенты:");
        System.out.println("  " + c1);
        System.out.println("  " + c2);
        System.out.println("Продажи:");
        System.out.println("  " + s1);
        System.out.println();

        // 3. Тестирование геттеров
        System.out.println("ПРОВЕРКА ДАННЫХ (GETTERS):");
        System.out.println("Выбран товар: " + p1.getName());
        System.out.println("Уровень лояльности клиента " + c1.getName() + ": " + c1.getMembershipLevel());
        System.out.println();

        // 4. Тестирование сеттеров
        System.out.println(" ОБНОВЛЕНИЕ ИНФОРМАЦИИ (SETTERS):");
        System.out.println("Редактируем карточку товара p2");
        p2.setProductId(102);
        p2.setName("Свежий хлеб");
        p2.setPrice(200.0);
        p2.setStockQuantity(10);
        System.out.println("Обновлено: " + p2);
        System.out.println();

        // 5. Логические методы
        System.out.println(" ВЫПОЛНЕНИЕ ОПЕРАЦИЙ:");
        System.out.print("Проверка наличия '" + p1.getName() + "': ");
        System.out.println(p1.isInStock() ? "Есть на складе" : "Нет в наличии");

        System.out.println("Проверка VIP-статуса для клиента " + c1.getName() + "");
        if(c1.isVIP()) {
            System.out.println("  Результат: Клиент является VIP-персоной.");
        }

        System.out.println("Применение скидки 15% к чеку №" + s1.getSaleId() + "");
        s1.applyDiscount(15);
        System.out.println("  Новая сумма к оплате: " + s1.getTotalAmount() + " ₸");
        System.out.println();

        // 6. Итоговый отчет
        System.out.println(" ИТОГОВЫЙ ОТЧЕТ:");
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(s1);


    }
}