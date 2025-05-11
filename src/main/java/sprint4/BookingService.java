package sprint4;

/**
 * Напишите программу для бронирования комнаты с завтраком в мини-отеле “Royal Java Bed and Breakfast”. В нём 10 номеров.
 * Реализуйте методы для заселения book() и выезда free() гостей. Расставьте нужные модификаторы доступа: переменные capacity (вместимость) и full (заполненность),
 * а также метод printRooms() нужно скрыть — доступ к ним должен остаться только внутри класса BedAndBreakfast.
 * Сам класс BedAndBreakfast и другие методы в нём должны иметь максимальный уровень доступа.
 * Не забудьте, что когда вы закроете переменные, к ним нельзя будет обратиться — нужно будет обращаться к методам.
 */

import java.util.Scanner;


public class BookingService {
    public static void main(String[] args) {
        // можно забронировать одну из комнат
        BedAndBreakfast hotel = new BedAndBreakfast();
        Scanner scanner = new Scanner(System.in);

        /* Обратите внимание, здесь для удобства мы используем
        другую конструкцию для оформления цифрового меню.*/

        while (true) {
            System.out.println("Что вы хотите сделать?");
            System.out.println("1 - Забронировать номер");
            System.out.println("2 - Освободить номер");
            System.out.println("3 - Проверить наличие свободных номеров");
            System.out.println("0 — Выход");

            int command = scanner.nextInt();
            /* switch-case конструкция заменяет if-else условия,
            код получается компактнее и быстрее читается */
            switch (command) {
                case 1:
                    // используется публичный метод
                    hotel.book();
                    // break позволяет выйти из условия, иначе - идём дальше
                    break;
                case 2:
                    hotel.free();
                    break;
                case 3:
                    if (hotel.full) {
                        System.out.println("Больше нет мест¯\\_(ツ)_/¯");
                    } else {
                        System.out.println("Есть свободные номера!");
                    }
                    break;
                case 0:
                    System.out.println("Выход");

                    /* Метод exit() останавливает работу JVM, завершая программу.
                    В качестве аргумента принимает число — код ошибки.
                    Если оно не равно 0 — программа завершилась некорректно.*/
                    System.exit(0); // код равен 0, программа была завершена намеренно
                    // break в этом случае не нужен
                default:
                    System.out.println("Извините, такой команды пока нет.");
                    break;
            }
        }
    }
}
