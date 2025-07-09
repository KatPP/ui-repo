package sprint8.data.air;

/**
 * Сервис по продаже авиабилетов LeTumbler просит вас помочь дописать метод по выводу информации о рейсе.
 * Входные параметры:
 * Время и дата вылета в виде строки 12:30 25.12.21
 * Код аэропорта вылета
 * Код аэропорта прибытия
 * Количество минут, на которое задерживается рейс
 * Продолжительность полёта:
 * Отдельно часы
 * Отдельно минуты
 * По указанным параметрам необходимо вычислить актуальное время вылета рейса и время его прибытия с учётом задержки. Вычисленные значения необходимо передать в метод printTickets(...).
 * Также необходимо с помощью оператора switch-case дополнить метод getAirportByCode(String airportCode). Для неверного кода аэропорта выбросить
 * исключение IllegalStateException с текстом «Неизвестный код аэропорта: [переданный код]». Данное исключение необходимо обработать в коде: выполнение программы не должно на нём прерываться.
 */

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

class Practicum {
    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm dd.MM.yy");
    public static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm");

    public static void main(String[] args) {
        System.out.println("Тест №1:");
        printFlightInformation("12:15 02.11.21", "VKO", "LED", 30, 1, 55);

        System.out.println("\nТест №2:");
        printFlightInformation("14:00 03.10.21", "SVX", "VVO", 0, 9, 5);

        System.out.println("\nТест №3:");
        printFlightInformation("06:00 12.12.21", "DME", "VVO", 0, 12, 0);

        System.out.println("\nТест №4:");
        printFlightInformation("23:00 29.03.22", "LED", "SVX", 0, 2, 55);
    }

    private static void printFlightInformation(
            String formattedDepartureTime,
            String departureAirportCode,
            String arrivalAirportCode,
            int delay,
            int flightDurationHours,
            int flightDurationMinutes
    ) {
        Airport departureAirport;
        Airport arrivalAirport;

        try {
            departureAirport = AirportDatabase.getAirportByCode(departureAirportCode);
            arrivalAirport = AirportDatabase.getAirportByCode(arrivalAirportCode);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
            return;
        }

        LocalDateTime localDeparture = LocalDateTime.parse(formattedDepartureTime, DATE_TIME_FORMATTER);
        ZoneId departureZoneId = ZoneId.of(departureAirport.getZone());
        ZonedDateTime departure = ZonedDateTime.of(localDeparture, departureZoneId);

        System.out.println("Ваш билет на рейс " + departureAirport.getCity() + " - " + arrivalAirport.getCity() + ": ");

        Duration flightDuration = Duration.ofHours(flightDurationHours).plusMinutes(flightDurationMinutes);

        ZoneId arrivalZoneId = ZoneId.of(arrivalAirport.getZone());
        ZonedDateTime arrival = departure.plus(flightDuration).withZoneSameInstant(arrivalZoneId);

        String departureCity = departureAirport.getCityForTicket();
        String arrivalCity = arrivalAirport.getCityForTicket();
        String formattedArrivalTime = arrival.format(DATE_TIME_FORMATTER);
        String departureTimeOnly = departure.format(TIME_FORMATTER);

        printTicket(
                formattedDepartureTime,
                departureAirportCode,
                arrivalAirportCode,
                departureCity,
                arrivalCity,
                formattedArrivalTime,
                departureTimeOnly
        );

        if (delay > 0) {
            Duration delayDuration = Duration.ofMinutes(delay);
            ZonedDateTime departureWithDelay = departure.plus(delayDuration);
            ZonedDateTime arrivalWithDelay = departureWithDelay.plus(flightDuration).withZoneSameInstant(arrivalZoneId);

            System.out.println("Ваш вылет задерживается.");
            System.out.println("Задержка: " + delayDuration.toHours() + ":" + String.format("%02d", delayDuration.toMinutesPart()));
            System.out.println("Обновлённое время вылета: " + departureWithDelay.format(DATE_TIME_FORMATTER));
            System.out.println("Обновлённое время прилёта: " + arrivalWithDelay.format(DATE_TIME_FORMATTER));
        } else {
            System.out.println("Удачного полёта!");
        }
    }

    private static void printTicket(
            String departureTime,
            String departureAirportCode,
            String arrivalAirportCode,
            String departureCity,
            String arrivalCity,
            String arrivalTime,
            String departureTimeOnly
    ) {
        System.out.println(
                " _______________________________________________________\n" +
                        "|                                            |          |\n" +
                        "|  " + departureCity + "|" + departureAirportCode + "      "
                        + departureTime + "  |   " + departureAirportCode + "    |\n" +
                        "|  " + arrivalCity + "|" + arrivalAirportCode + "      "
                        + arrivalTime + "  |   " + arrivalAirportCode + "    |\n" +
                        "|                                            |          |\n" +
                        "|  BOARDING TIME   --:--      SEAT  1A       |   " + departureTimeOnly + "  |\n" +
                        "|  GATE  23                                  |   1A     |\n" +
                        "|____________________________________________|__________|");
    }
}

