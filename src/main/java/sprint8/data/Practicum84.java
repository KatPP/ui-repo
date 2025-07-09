package sprint8.data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * Игорь придумал «Шифр Игоря» — это как шифр Цезаря, только Игоря. И без букв.
 * В его шифре числа кодируются с помощью даты и времени. Игорь написал метод по декодированию, но случайно стёр его и теперь не может восстановить пароль от архива с домашней работой.
 * К счастью, входные данные у него сохранились. Помогите Игорю восстановить пароль от важного архива!
 * Инструкция по декодированию:
 * Объединить экземпляр даты и экземпляр времени в экземпляр LocalDateTime.
 * От полученного момента времени вычесть 2 месяца, 25 дней и 100 минут.
 * В полученном результате перемножить порядковый номер дня в году и число часов.
 */

public class Practicum84 {
    public static void main(String[] args) {
        LocalDate secretDate = LocalDate.of(2020, 1, 10);
        LocalTime secretTime = LocalTime.of(12, 30);

        int result = decode(secretDate, secretTime);
        System.out.println(result);
    }

    private static int decode(LocalDate secretDate, LocalTime secretTime) {
        // Объединяем дату и время
        LocalDateTime newTime = LocalDateTime.of(secretDate, secretTime);

        // Вычитаем 2 месяца, 25 дней и 100 минут
        LocalDateTime secretMoment = newTime
                .minusMonths(2)
                .minusDays(25)
                .minusMinutes(100);

        // Находим произведение порядкового номера дня в году и часов
        return secretMoment.getDayOfYear() * secretMoment.getHour();
    }
}

