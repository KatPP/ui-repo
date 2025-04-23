package sprint3;

import java.util.Scanner;

/**
 * Прочитайте код приложения онлайн-банка, в котором пользователь может по желанию завести счета в трёх валютах.
 * В программу забрался баг — вне зависимости от выбора пользователя сразу открываются все три счёта.
 * С помощью классов-обёрток и их свойств исправьте код так, чтобы открывались счета только в тех валютах, которые выберет пользователь.
 * Счета необходимо создавать с нулевым балансом.
 */

public class Practicum2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя пользователя:");
        String name = scanner.nextLine();
        PersonAccount user = new PersonAccount(name);

        System.out.println("Хотите открыть счёт в RUB?");
        System.out.println("1 - Да");
        System.out.println("2 - Нет");
        int command = scanner.nextInt();
        if (command == 1) {
            user.moneyRUB = 0.0;
        }

        System.out.println("Хотите открыть счёт в USD?");
        System.out.println("1 - Да");
        System.out.println("2 - Нет");
        command = scanner.nextInt();
        if (command == 1) {
            user.moneyUSD = 0.0;
        }

        System.out.println("Хотите открыть счёт в EUR?");
        System.out.println("1 - Да");
        System.out.println("2 - Нет");
        command = scanner.nextInt();
        if (command == 1) {
            user.moneyEUR = 0.0;
        }

        System.out.println("Поздравляем, аккаунт для пользователя " + user.name + " создан.");
        System.out.println("Открытые счета:");
        if (user.moneyRUB != null) {
            System.out.println("- RUB");
        }
        if (user.moneyRUB != null) {
            System.out.println("- USD");
        }
        if (user.moneyRUB != null) {
            System.out.println("- EUR");
        }

    }
}

class PersonAccount {
    String name;      // имя и фамилия
    Double moneyRUB;  // счёт в рублях
    Double moneyUSD;  // счёт в долларах
    Double moneyEUR;  // счёт в евро


    PersonAccount(String userName) {
        name = userName;
    }
}
