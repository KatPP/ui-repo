package org.example;

/**
 * Ниже представлен метод isRising(int number), который принимает целое трехзначное число, состоящее из 3 разных цифр.
 * Задание: Написать код, который проверяет, располагаются ли цифры этого числа в порядке возрастания (первая - наименьшая, третья - наибольшая, все цифры разные),
 * и выводит в консоль "Да", если располагаются, и "Нет", если не располагаются.
 * Например, для числа 156 вывод будет:
 * Да
 */

public class Task62 {
    public static void isRising(int number) {
        // Извлекаем цифры из числа
        int firstDigit = number / 100;   // Сотни
        int secondDigit = (number / 10) % 10;   // Десятки
        int thirdDigit = number % 10;   // Единицы

        // Проверяем, что цифры разные и идут в порядке возрастания
        if (firstDigit < secondDigit && secondDigit < thirdDigit) {
            System.out.println("Да");
        } else {
            System.out.println("Нет");
        }
    }

    public static void main(String[] args) {
        isRising(123);
        isRising(351);
    }
}
