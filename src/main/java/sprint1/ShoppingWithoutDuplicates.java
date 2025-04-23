package sprint1;

/**
 * Задача №2
 * Расширьте возможности приложения. Ваша задача — проверить список на наличие дубликатов перед добавлением нового товара. Используйте цикл и сравнение, чтобы найти товар с таким же названием.
 * Логика следующая. Допустим, забывчивый пользователь пытается внести в список продуктов товар, который уже был добавлен ранее.
 * В этом случае вам нужно предварительно пройти по всему списку товаров в цикле, сравнивая каждый товар shoppingList[i] с тем, что ввёл пользователь в переменную productName.
 * Разместите проверку в секции if(actionNumber == 1). Результат проверки запишите в отдельную переменную типа boolean.
 * Этот флаг вы сможете использовать для дальнейшего действия: либо добавить товар в список, либо сообщить пользователю о том, что товар уже введён ранее.
 */

import java.util.Scanner;

public class ShoppingWithoutDuplicates {
    public static void main(String[] args) {
        System.out.println("Вас приветствует список покупок!");

        String[] shoppingList = new String[8];
        int productCount = 0;

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

                    boolean productAlreadyExist = false;

                    for (int i = 0; i < productCount; i++) { // productCount - текущее количество товаров
                        if (shoppingList[i] != null && shoppingList[i].equals(productName)) {
                            productAlreadyExist = true;
                            break; // Товар найден, можно прервать цикл
                        }
                    }

                    if (productAlreadyExist) {
                        System.out.println("Такой товар уже есть в списке!");
                    } else {
                        shoppingList[productCount] = productName;
                        productCount++;
                        System.out.println("Товар " + productName + " добавлен в список под номером " + productCount);
                    }
                }
            } else if (actionNumber == 2) {
                for (int i = 0; i < productCount; i++) {
                    System.out.println(i + 1 + ". " + shoppingList[i]);
                }
            } else if (actionNumber == 3) {
                for (int i = 0; i < productCount; i++) {
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
