package sprint1;

/**
 * Накопления — дело серьёзное. Ваш друг уже накопил 5000 рублей и решил замахнуться на миллион.
 * Для этого он положил свои сбережения на накопительный счёт под 5% годовых.
 * Допишите программу с циклом while, которая посчитает, через сколько лет на счету будет нужная сумма.
 * Предполагается, что стартовый баланс счёта (сумма сбережений) вводится с консоли.
 */

import java.util.Scanner;

public class Practicum3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Сколько денег у вас сейчас: ");
        double balance = scanner.nextDouble(); // ваши сбережения
        int years = 0;

        while (balance <= 1000000) {
            balance = balance + (balance * 0.05);
            years = years + 1;
        }

        System.out.println("Через " + years + " лет у вас будет миллион!");
    }
}
