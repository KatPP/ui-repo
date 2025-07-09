package sprint8.data;

/**
 * Компания по производству часов ОАО «Счастливые» попросила вас написать серверную составляющую для их новой модели. В ней должно быть пять кнопок:
 * Меняющая временную зону на следующую по списку (список должен проходиться по кругу).
 * Сдвигающая время на 10 часов вперёд.
 * Сдвигающая время на 1 час вперёд.
 * Сдвигающая время на 10 минут вперёд.
 * Сдвигающая время на 1 минуту вперёд.
 * Реализуйте указанные методы и выставьте с помощью них следующее время: 18 часов, 26 минут, московский часовой пояс.
 */

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;

class Watch {
    private ZonedDateTime currentTime;
    private int numOfZone;
    private final List<String> zones = Arrays.asList("America/New_York", "Asia/Vladivostok", "Europe/Moscow");

    public Watch() {
        numOfZone = 0;
        ZoneId zone = ZoneId.of(zones.get(numOfZone));
        LocalDateTime dateTime = LocalDateTime.of(2021, 1, 26, 0, 0);
        currentTime = ZonedDateTime.of(dateTime, zone);
    }

    public void changeTimeZone() {
        numOfZone = (numOfZone + 1) % zones.size();
        ZoneId newZone = ZoneId.of(zones.get(numOfZone));
        // смена временной зоны с сохранением локального времени
        currentTime = currentTime.withZoneSameLocal(newZone);
    }

    public void setTime(int hours, int minutes) {
        currentTime = currentTime.plusHours(hours).plusMinutes(minutes);
    }

    public ZonedDateTime getCurrentTime() {
        return currentTime;
    }
}

class Practicum {
    public static void main(String[] args) {
        Watch watch = new Watch();

        // Устанавливаем московский часовой пояс
        while (!watch.getCurrentTime().getZone().getId().equals("Europe/Moscow")) {
            watch.changeTimeZone();
        }

        // Устанавливаем время 18:26
        watch.setTime(18, 26);

        System.out.println(watch.getCurrentTime());
    }
}
