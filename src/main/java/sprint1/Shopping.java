package sprint1;

import java.util.Scanner;

/**
 * Задача №1
 * Разработайте цифровой список покупок с консольным интерфейсом. Программа должна уметь выполнять четыре действия:
 * добавлять товар в список;
 * показывать список;
 * очищать список;
 * завершать работу.
 * Для реализации консольного интерфейса используйте бесконечный цикл. На каждой итерации пользователю предлагается список всех доступных команд,
 * после чего он выбирает одну из них. С помощью Scanner программа считывает номер команды из консоли в переменную actionNumber.
 * Нужное действие выполняется в отдельной ветке if — else.
 * Если пользователь ввёл значение actionNumber, которого нет в списке, на экран должно быть выведено сообщение Неизвестная команда!.
 * Список покупок храните в массиве shoppingList с заранее заданным размером. Для простоты установите ограничение: в список можно добавлять не более восьми товаров.
 * Если нужно купить больше, пользователь должен будет выбрать восемь наиболее важных из них.
 * При вызове команды «Добавить товар в список» нужно проверить, есть ли ещё свободное место, или все слоты закончились.
 * Для этого удобно вести подсчёт количества добавленных продуктов в отдельной переменной. Назовите её productCount.
 */

public class Shopping {
    public static void main(String[] args) {

        System.out.println("Вас приветствует список покупок!");

        String[] shoppingList = new String[8]; // Массив для хранения товаров *- Максимальное количество товаров 8!!!
        int productCount = 0; // Счётчик текущего количества товаров

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Выберите одну из команд:");
            System.out.println("1. Добавить товар в список");
            System.out.println("2. Отобразить список");
            System.out.println("3. Очистить список");
            System.out.println("4. Завершить программу");

            int actionNumber = scanner.nextInt();

            if (actionNumber == 1) {
                if (productCount == 8) {
                    System.out.println("Извините, список полон!");
                } else {
                    System.out.println("Введите название товара:");
                    String productName = scanner.next();
                    shoppingList[productCount] = productName;
                    productCount++;
                    System.out.println("Товар " + productName + " добавлен в список под номером " + productCount);
                }
            } else if (actionNumber == 2) {
                for (int i = 0; i < productCount; i++) {
                    System.out.println((i + 1) + ". " + shoppingList[i]);
                }
            } else if (actionNumber == 3) {
                for (int i = 0; i < shoppingList.length; i++) {
                    shoppingList[i] = null;
                }
                productCount = 0;
                System.out.println("Список очищен!");
            } else if (actionNumber == 4) {
                break;
            } else {
                System.out.println("Неизвестная команда!");
            }
        }
    }
}
