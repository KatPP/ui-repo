package sprint8.data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

/**
 * Внешний API магазина присылает время оплаты в странном формате. С помощью методов LocalDateTime и DateTimeFormatter приведите его к корректному виду.
 * Входные данные:
 * 14 часов 09 минут. Месяц: 02, День: 14, Год: 1966.
 * Выходные данные должны быть такими:
 * 14_02_1966|14:09
 */

public class Practicum83 {
    public static void main(String[] args) {
        String input = "14 часов 09 минут. Месяц: 02, День: 14, Год: 1966.";
        printCorrectDateTime(input);
    }

    private static void printCorrectDateTime(String input) {
        // Определяем входной формат с помощью DateTimeFormatterBuilder
        DateTimeFormatter inputFormatter = new DateTimeFormatterBuilder()
                .appendPattern("H часов mm минут. Месяц: MM, День: dd, Год: yyyy.")
                .parseDefaulting(ChronoField.SECOND_OF_MINUTE, 0)
                .toFormatter();

        // Парсим строку в LocalDateTime
        LocalDateTime dateTime = LocalDateTime.parse(input, inputFormatter);

        // Определяем выходной формат
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd_MM_yyyy|HH:mm");

        // Выводим результат
        System.out.println(dateTime.format(outputFormatter));
    }
}
