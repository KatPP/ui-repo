package org.example;

/**
 * Ниже представлен метод season(int number), принимает целое число, которое должно соответствовать одному из порядковых номеров месяцев.
 * Задание: Написать код, выводит в консоль время года, к которому относится этот месяц ("Весна", "Лето", "Осень", "Зима").
 * Если входящее число не соответствует какому-либо месяцу - вывести "Не является месяцем".
 * Например, для числа 9 вывод будет:
 * Осень
 */
public class Task65 {
    public static void season(int number) {
        if (number == 3 || number == 4 || number == 5) {
            System.out.println("Весна");
        } else if (number == 1 || number == 2 || number == 12) {
            System.out.println("Зима");
        } else if (number == 6 || number == 7 || number == 8) {
            System.out.println("Лето");
        } else if (number == 9 || number == 10 || number == 11) {
            System.out.println("Осень");
        } else {
            System.out.println("Не является месяцем");
        }
    }

    public static void main(String[] args) {
        season(13);
    }
}
