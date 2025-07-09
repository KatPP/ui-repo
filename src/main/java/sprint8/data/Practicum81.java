package sprint8.data;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

/**
 * Фотограф Лёша большой романтик. Он любит встречать и провожать Солнце, наблюдая за ним через объектив камеры. Но у Лёши никак не получается подойти к окну вовремя.
 * В сети Интернет он нашёл сложные формулы по расчёту времени рассвета и заката для разных точек на карте. Помогите Лёше сделать расписание на неделю, чтобы ничего не пропустить.
 * Расписание рассвета и заката на каждый день недели выведите в следующем формате (пример):
 * Рассвет - Закат, график на неделю:
 * 5:13 - 20:15
 * 5:11 - 20:17
 * 5:10 - 20:18
 * 5:08 - 20:20
 * 5:07 - 20:21
 * 5:05 - 20:23
 * 5:05 - 20:25
 */

public class Practicum81 {

    // запросите у пользователя его координаты (долгота и широта) и затем
    // выведите расписание рассветов и закатов на сегодня
    // и ближайшую неделю в формате РАССВЕТ - ЗАКАТ
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите широту:");
        double userLatitude = scanner.nextDouble();

        System.out.println("Введите долготу: ");
        double userLongitude = scanner.nextDouble();

        System.out.println("Введите вашу временную зону: ");
        int userTimezone = scanner.nextInt();

        System.out.println("Введите текущий год в формате unix (10 цифр): ");
        long startOfYear = scanner.nextLong();

        // Инициализация временных моментов
        Instant startOfYearMoment = Instant.ofEpochSecond(startOfYear);
        Instant thisMoment = Instant.now();
        Instant lastMoment = thisMoment.plus(7, ChronoUnit.DAYS);

        System.out.println("Рассвет - Закат, график на неделю:");
        do {
            int day = dayOfYearFromInstant(startOfYearMoment, thisMoment);

            int noonMinutes = localNoonMinutes(day, userTimezone, userLongitude);
            double hourDelta = sunsetTimeHours(day, userLatitude);
            double noonHour = 12 + (noonMinutes / 60.0);
            double sunriseHour = noonHour - hourDelta;
            double sunsetHour = noonHour + hourDelta;

            System.out.printf("%s - %s\n", hhmmFromDouble(sunriseHour), hhmmFromDouble(sunsetHour));

            thisMoment = thisMoment.plus(1, ChronoUnit.DAYS);
        } while (thisMoment.isBefore(lastMoment)); // Выводим график на семь дней
    }

    // Остальные методы остаются без изменений
    private static int dayOfYearFromInstant(Instant startOfYear, Instant time) {
        long fromStartOfYear = time.toEpochMilli() - startOfYear.toEpochMilli();
        return (int) (fromStartOfYear / 24 / 60 / 60 / 1000);
    }

    static double sunsetTimeHours(int dayOfYear, double latitude) {
        double rad = (Math.PI / 180);
        double factor = -1 * Math.tan(rad * latitude) * Math.tan(23.44 * rad * Math.sin(rad * (360 / 365.0) * (dayOfYear + 284.0)));
        if (factor <= -1 || factor >= 1) {
            return 0.0;
        }
        return Math.abs(Math.acos(factor)) / (rad * 15);
    }

    static int equationOfTimeMinutes(int dayOfYear) {
        return (int) Math.round(-7.655 * Math.sin(2 * Math.PI * dayOfYear / 365) + 9.873 * Math.sin(4 * Math.PI * dayOfYear / 365 + 3.588));
    }

    static int localNoonMinutes(int dayOfYear, int timeZone, double longitude) {
        return (int) Math.round(4.0 * (longitude - (15 * (timeZone - 1)))) - equationOfTimeMinutes(dayOfYear);
    }

    static String hhmmFromDouble(double hour) {
        return String.format("%d:%02d", (int) Math.floor(hour), (int) Math.round(60 * (hour - Math.floor(hour))));
    }

}
