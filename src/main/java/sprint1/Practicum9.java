package sprint1;

import java.util.Scanner;

public class Practicum9 {
    public static void main(String[] args) {
        String[] currencies = {"USD", "EUR", "JPY", "RUB"};
        System.out.println("Валюты в вашем портфеле:");
        System.out.println(currencies[0] + " - индекс 0"); // Печатаем валюты и их индексы
        System.out.println(currencies[1] + " - индекс 1");
        System.out.println(currencies[2] + " - индекс 2");
        System.out.println(currencies[3] + " - индекс 3");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите индекс валюты, которую хотите поменять:");
        int index = scanner.nextInt(); // Даём возможность ввести индекс выбранной валюты

        System.out.println("Выберите новую валюту:");
        String currency = scanner.next(); // Даём возможность ввести новое значение валюты

        String previousCurrency = currencies[index]; // Сохраняем старое значение
        currencies[index] = currency; // Присваиваем выбранному элементу новое значение

        System.out.println("Мы заменили " + previousCurrency + " на: " + currencies[index]);

        System.out.println("Теперь в вашем портфеле такие валюты:");
        System.out.println(currencies[0]);
        System.out.println(currencies[1]);
        System.out.println(currencies[2]);
        System.out.println(currencies[3]);
    }
}
