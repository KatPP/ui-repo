package sprint1;

import java.util.Random;
import java.util.Scanner;

public class Practicum4 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        // не создавайте объект класса Random
        int randomInt = new Random().nextInt(1000); // генерирует новое число от 0 до 1000

        int userInput = -1; // это нужно, чтобы цикл запустился, если Random выдаст 0
        System.out.println("Я загадал число от 0 до 1000.");
        System.out.println("Ваш ход:");

        // запускаем цикл игры

       // в этой переменной должен сохраняться ввод пользователя
        while (userInput != randomInt) {
            userInput = scanner.nextInt();
            if (userInput > randomInt) { // условие проверяется в цикле
                System.out.println("Меньше");
            } else if (userInput < randomInt) {
                System.out.println("Больше");
            }
        }
        // печатаем, когда число угадано
        System.out.println("Вы великолепны! Именно это я загадал.");
    }
}
