package sprint1;

/**
 * Задача №3
 * Для простоты вы указали размер массива равным восьми. В реальном мире списки покупок не ограничиваются фиксированным количеством товаров, ведь это неудобно.
 * Особенно если нужно закупить продукты на неделю вперёд.
 * Уберите ограничение. Доработайте программу так, чтобы при попытке добавить в массив элемент, выходящий за его пределы, массив списка покупок пересоздавался в большем размере.
 * Массив, размер которого можно изменить во время выполнения программы, называется динамическим.
 * Разберём логику усовершенствования. Когда товаров в списке становится больше восьми, то при попытке добавить ещё один программа пересчитывает размер внутреннего массива, удваивая его.
 * Это позволяет обеспечить корректное взаимодействие пользователя с приложением.
 * Код по удвоению массива поместите в блок обработки команды «Добавить товар». Будьте осторожны: не удалите текущий список товаров и не забудьте скопировать из него все имеющиеся товары.
 * Алгоритм действий такой:
 * Проверьте, пора ли увеличивать массив. Проверку выполните до добавления нового товара. Для этого сравните длину массива и переменную с количеством товаров. Если они равны, то массив заполнен.
 * Создайте новый массив удвоенной длины. Здесь пригодится переменная с количеством товаров.
 * Пройдите по старому массиву shoppingList, копируя из него по одной ячейке в новый массив newShoppingList по тому же адресу i.
 * Присвойте значение newShoppingList переменной shoppingList. Важно помнить, что сначала нужно скопировать имеющийся массив товаров и только потом записывать его в переменную со списком,
 * иначе вы потеряете данные.
 */

import java.util.Scanner;

public class ShoppingDynamic {
    public static void main(String[] args) {
        System.out.println("Вас приветствует список покупок!");

        int currentListSize = 8;
        String[] shoppingList = new String[currentListSize];
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
                if (shoppingList.length == productCount) {
                    int newListSize = currentListSize * 2;
                    String[] newShoppingList = new String[newListSize];
                    for (int i = 0; i < shoppingList.length; i++) {
                        newShoppingList[i] = shoppingList[i];
                    }
                    shoppingList = newShoppingList;
                    currentListSize = newListSize;
                }
                System.out.println("Введите название товара:");
                String productName = scanner.next();
                shoppingList[productCount] = productName;
                productCount++;
                System.out.println("Товар " + productName + " добавлен в список под номером " + productCount);
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
