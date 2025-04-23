package sprint1;

import java.util.Scanner;

/**
 В конце прошлого урока вы написали фрагмент кода приложения для планирования путешествия из Москвы в Париж. Доработайте его с учётом новых инструкций.
 Номер месяца должен быть в диапазоне от 1 до 12
 В Москве рекомендуется остаться не только в летние, но и в зимние месяцы.
 Если задать сезон “Зима” по-умолчанию, то вычислить сезон можно более простым ветвлением.
 Сравнение стоимости билетов и проверку наличия визы нужно сохранить в отдельные булевы переменные.
 Проверить наличие дешёвых билетов и визы в ветвлении нужно одним условием.
 */


public class Practicum17 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int monthNumber;

        while (true) {
            System.out.println("Когда планируется путешествие? Введите номер месяца от 1 до 12.");
            monthNumber = scanner.nextInt();

            if (monthNumber >= 1 && monthNumber <= 12) { // Номер месяца должен быть в диапазоне от 1 до 12
                break;
            } else {
                System.out.println("Некорректный номер месяца. Введите ещё раз.");
            }
        }

        String season = "Зима";
        // Допишите условия ветвления в виде утверждений
        if (monthNumber == 3 || monthNumber == 4 || monthNumber == 5) {
            season = "Весна";
        } else if (monthNumber == 6 || monthNumber == 7 || monthNumber == 8) {
            season = "Лето";
        } else if (monthNumber == 9 || monthNumber == 10 || monthNumber == 11) {
            season = "Осень";
        }

        if (season.equals("Лето") || season.equals("Зима")) { // Не рекомендуем лететь в Париж в летние и зимние месяцы
            System.out.println("В этом сезоне лучше остаться в Москве.");
            return;
        }


        System.out.println("Укажите стоимость прямых билетов из Москвы в Париж:");
        int ticketMoscowParis = scanner.nextInt();
        System.out.println("Укажите стоимость билетов из Москвы в Париж с пересадкой в Лондоне:");
        int ticketMoscowLondonParis = scanner.nextInt();
        System.out.println("У вас есть британская виза?");
        System.out.println("1 - да, виза есть");
        System.out.println("0 - визы нет");
        int britainVisa = scanner.nextInt();

        boolean directTicketsCheaper = ticketMoscowParis > ticketMoscowLondonParis; // Сравнение стоимости билетов
        boolean hasBritainVisa = britainVisa == 1; // Проверка наличия визы

        if (directTicketsCheaper && hasBritainVisa) { // Проверить в одном условии наличие дешёвых билетов и визы
            System.out.println("Летим через Лондон!");
        } else {
            System.out.println("Летим через Париж!");
        }
    }
}
