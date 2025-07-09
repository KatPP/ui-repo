package sprint8.data;

import java.time.LocalDateTime;
import static java.time.Month.JUNE;

/**
 * У индонезийской службы доставки JavaDelivery горячий сезон: она работает круглосуточно и ей срочно нужна программа для составления графика работы курьеров.
 * Вам необходимо реализовать метод, который будет выводить на экран график в таком формате:
 *
 * Расписание смен:
 * Cмена 1. Начало: 2025-06-01T08:30, конец: 2025-06-01T13:30
 * Cмена 2. Начало: 2025-06-01T13:30, конец: 2025-06-01T18:30
 * Cмена 3. Начало: 2025-06-01T18:30, конец: 2025-06-01T23:30
 * Cмена 4. Начало: 2025-06-01T23:30, конец: 2025-06-02T04:30
 * Cмена 5. Начало: 2025-06-02T04:30, конец: 2025-06-02T09:30
 * Входные данные для этого метода:
 * время начала рабочей смены (часы, минуты);
 * продолжительность смены в часах;
 * количество смен в графике.
 * Для теста выбрана дата 1 июня 2025 года. Добавьте проверку на то, что продолжительность одной смены — не более 8 часов.
 */

public class Practicum82 {
    public static final int START_YEAR = 2025;
    public static final int START_DAY = 1;
    public static final int MAX_SHIFT = 8;

    public static void main(String[] args) {
        printWorkHours(8, 30, 5, 5);
    }

    private static void printWorkHours(
            int startHours,
            int startMinutes,
            int shiftContinuation,
            int shiftAmount
    ) {
        if (shiftContinuation > MAX_SHIFT) {
            System.out.println("Выбрано слишком большое время для рабочей смены!");
            return;
        }

        System.out.println("Расписание смен:");
        LocalDateTime startTime = LocalDateTime.of(START_YEAR, JUNE, START_DAY, startHours, startMinutes);
        LocalDateTime endTime;

        for (int i = 1; i <= shiftAmount; i++) {
            endTime = startTime.plusHours(shiftContinuation);
            System.out.println("Cмена " + i + ". Начало: " + startTime + ", конец: " + endTime);
            startTime = endTime;
        }
    }
}
