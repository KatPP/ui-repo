package sprint7.alltasks;

/***
 * Задача усложняется! Ограничений на количество символов в строках наименования товара, количества и цены больше нет.
 * При этом самая длинная строка с наименованием товара и его количеством должна разделяться ровно двумя пробелами. То же самое между количеством и ценой.
 * Для входных данных мы предлагаем вам использовать данный набор строк:
 * String[]{"Пицца, 1 шт., 310.50", "Чай, 2 шт., 113.30", "Печенье, 1 уп., 75.75"}
 * Данные строки, по очереди введите в консоль программы после того, как вы задали число строк.
 * Такой вывод программы корректен:
 * Пицца         1003 шт.  311431.50
 * Чай           12 шт.    1359.60
 * Печенье       1 уп.     75.75
 * Нить красная  1 клубок  12.23
 */

import java.util.Scanner;

public class CheckPrinterImproved {

    private static int findMaxLength(String[] elements) {
        int max = 0;
        for (String e : elements) {
            if (e.length() > max) {
                max = e.length();
            }
        }
        return max;
    }

    public static void printCheck(String[] items) {
        // Создаем массивы для каждого компонента
        String[] names = new String[items.length];
        String[] quantities = new String[items.length];
        String[] prices = new String[items.length];

        // Заполняем массивы компонентами
        for (int i = 0; i < items.length; i++) {
            String[] parts = items[i].split(", ");
            names[i] = parts[0];
            quantities[i] = parts[1];
            prices[i] = parts[2];
        }

        // Находим максимальные длины
        int maxNameLength = findMaxLength(names);
        int maxQuantityLength = findMaxLength(quantities);

        // Формируем и выводим чек
        for (int i = 0; i < items.length; i++) {
            String formattedLine = String.format("%-" + (maxNameLength + 2) + "s%-" + (maxQuantityLength + 2) + "s%s",
                    names[i], quantities[i], prices[i]);
            System.out.println(formattedLine);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество записей:");
        int n = Integer.parseInt(scanner.nextLine());
        String[] values = new String[n];
        for (int i = 0; i < n; ++i)
            values[i] = scanner.nextLine();
        printCheck(values);
    }
}
