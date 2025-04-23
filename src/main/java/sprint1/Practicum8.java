package sprint1;

import java.util.Scanner;

public class Practicum8 {
    public static void main(String[] args) {
        String[] currencies = {"USD", "EUR", "JPY", "RUB"};

        System.out.println("В вашем тревел-кошельке доступны следующие валюты:");
        System.out.println(currencies[0]);
        System.out.println(currencies[1]);
        System.out.println(currencies[2]);
        System.out.println(currencies[3]);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Если вы планируете поездку в Данию, введите 1, а если в Китай, введите 2");

        int country = scanner.nextInt();  // Считайте из консоли ввод пользователя

        if (country == 1) {
            currencies[1] = "DKK"; // Если выбрана Дания, измените значение элемента евро на кроны DKK
        }
        if (country == 2) {
            currencies[2] = "CNY";
        }

        System.out.println("В вашем тревел-кошельке доступны следующие валюты:");
        System.out.println(currencies[0]);
        System.out.println(currencies[1]);
        System.out.println(currencies[2]);
        System.out.println(currencies[3]);
    }
}
