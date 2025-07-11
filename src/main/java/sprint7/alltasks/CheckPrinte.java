package sprint7.alltasks;

/**
 * Допишите программу для вывода на экран информации из чека.
 * На вход подаётся массив строк вида {"Пицца, 1 шт., 310.50", "Чай, 2 шт., 113.30", "Печенье, 1 уп., 75.75"}. Наименование товара состоит не более чем из восьми символов, количество не более чем из пяти, а цена не более чем из шести символов.
 * В результате исполнения метода на экран должен напечататься чек. Все его элементы должны быть выровнены по левому краю. Между ними должно быть минимум два пробела.
 * Ограничений на максимальный вывод нет, равно как и ограничений на количество пробелов между наименованием / количеством / ценой.
 * Пример обработанных данных (оба варианты корректны):
 * Пицца    1 шт.  310.50
 * Чай      2 шт.  113.30
 * Печенье  1 уп.  75.75
 * Пицца       1 шт.     310.50
 * Чай         2 шт.     113.30
 * Печенье     1 уп.     75.75
 */

import java.util.Scanner;

public class CheckPrinte {
    public static void printCheck(String[] items) {
        for (String item: items) {

        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество записей:");
        int n = Integer.parseInt(scanner.nextLine());
        String[] values = new String[n];
        for (int i=0; i<n; ++i)
            values[i] = scanner.nextLine();
        printCheck(values);
    }
}
