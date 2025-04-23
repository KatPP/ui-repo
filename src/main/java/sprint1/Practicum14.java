package sprint1;

import java.util.Arrays;
import java.util.Scanner;

public class Practicum14 {
    public static void main(String[] args) {
        // объявили массив трат за неделю (7 дней)
        double[] expenses = new double[7];

        double expense = 50; // в первый день потрачено 50 рублей

        // заполнили массив, используя цикл for
        for (int i = 0; i < expenses.length; i++) {
            expenses[i] = expense;
            expense = expense + 100;
        }
        System.out.println("Расходы за неделю успешно занесены в приложение!");
        System.out.println(Arrays.toString(expenses));

        Scanner scanner = new Scanner(System.in);
        while (true) { // добавили бесконечный цикл — теперь не страшно ошибаться много раз
            System.out.println("Расходы за какой день вы хотите проверить. Выберите значение от 0 (пн) до 6 (вс).");
            // считайте ввод пользователя из консоли и сохраните в переменной index
            int index = scanner.nextInt();

            // проверьте, не допущена ли ошибка
            if (index < 0) {
                System.out.println("Выбрано неверное значение! Минимальное значение - 0");    // если значение меньше нуля, напечатайте "Выбрано неверное значение! Минимальное значение - 0"
            } else if (index >= expenses.length) {
                System.out.println("Выбрано неверное значение! Максимальное значение - " + (expenses.length-1));
            } else {
                System.out.println("Потрачено " + expenses[index] +" рублей");
                break;
            }
        }
    }
}
