package sprint3;

/**
 * Усовершенствуйте приложение для зоопарка: добавьте возможность добавлять и удалять животных из списка, а также проверять, живёт ли указанное пользователем животное в зоопарке.
 * Вам нужно реализовать следующие команды цифрового меню приложения:
 * 1 — Показать список всех животных в зоопарке.
 * 2 — Добавить животное в список.
 * 3 — Удалить животное из списка.
 * Учтите, что удалить элемент из списка можно только в том случае, если он не пуст.
 * 4 — Очистить список.
 * Логика при очистке списка должна быть следующей: если список пуст, то делать ничего не нужно, в противном случае — удалить все элементы.
 * 5 — Проверить, есть ли в зоопарке указанное пользователем животное.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Practicum6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> animals = new ArrayList<>();
        animals.add("Шиншилла");
        animals.add("Крокодил");
        animals.add("Лев");
        animals.add("Медведь");
        animals.add("Слон");

        while (true) {
            printMenu();
            int command = scanner.nextInt();
            if (command == 1) {
                System.out.println("Сейчас в зоопарке можно увидеть " + animals.size() + " животных:");
                for (String exp : animals) {
                    System.out.println(exp); // напечатайте животных
                }
            } else if (command == 2) {
                System.out.println("Какое животное хотите добавить?");
                String animal = scanner.next();
                animals.add(animal); // добавьте животное
            } else if (command == 3) {
                System.out.println("Какое животное нужно удалить?");
                String animal = scanner.next();
                if (!animals.isEmpty()) {
                    animals.remove(animal); // удалите животное, если список не пуст
                }
            } else if (command == 4) {
                if (!animals.isEmpty()) {
                     animals.clear();
                }
                System.out.println("Все животные перевезены в другой зоопарк. Список пуст.");// очистите список

            } else if (command == 5) {
                System.out.println("Какое животное вы хотите увидеть в зоопарке?");
                String animal = scanner.next();
                if (animals.contains(animal)) {
                    animals.add(animal);
                    System.out.println(animal + " на месте! Приходите посмотреть.");
                } else {
                    System.out.println("Такого животного сейчас нет в нашем зоопарке.");
                }
            } else {
                break;
            }
        }
    }

    public static void printMenu() {
        System.out.println("1 - Показать список животных в зоопарке.");
        System.out.println("2 - Добавить животное в список.");
        System.out.println("3 - Удалить животное из списка.");
        System.out.println("4 - Очистить список.");
        System.out.println("5 - Проверить, есть ли в зоопарке животное.");
        System.out.println("Любая другая цифра - Выйти из приложения.");
    }
}





