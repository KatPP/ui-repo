package org.example;

/**
 * Ниже представлен метод transform(int number), который принимает целое трехзначное число.
 * Задание: Написать код, который выполняет следующее:
 * - Если число четное - все четные цифры этого числа увеличиваются на 1, а нечетные - уменьшаются на 1.
 * Если увеличение/уменьшение невозможно (например, увеличить 9), то оставить эту цифру без изменения.
 * - Если число нечетное, то все изменения произвести наоборот - четные цифры уменьшить на 1, нечетные - увеличить на 1.
 * Получившееся число вывести в консоль.
 * Например, для числа 309 вывод будет:
 * 409
 */

public class Task54 {

    public static void transform(int number) {
        boolean isNegative = number < 0;
        number = Math.abs(number);

        int hundreds = number / 100;
        int tens = (number / 10) % 10;
        int ones = number % 10;

        boolean isEven = number % 2 == 0;

        hundreds = modifyDigit(hundreds, isEven);
        tens = modifyDigit(tens, isEven);
        ones = modifyDigit(ones, isEven);

        int result = hundreds * 100 + tens * 10 + ones;
        System.out.println(isNegative ? "-" + result : result);
    }

    private static int modifyDigit(int digit, boolean isEven) {
        if (isEven) {
            if (digit % 2 == 0 && digit < 9) {
                return digit + 1;
            } else if (digit % 2 != 0 && digit > 0) {
                return digit - 1;
            }
        } else {
            if (digit % 2 == 0 && digit > 0) {
                return digit - 1;
            } else if (digit % 2 != 0 && digit < 9) {
                return digit + 1;
            }
        }
        return digit;
    }
}


