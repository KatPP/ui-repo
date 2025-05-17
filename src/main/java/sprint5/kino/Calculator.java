package sprint5.kino;

import java.util.List;

public class Calculator {
    private static final double MINUTES_IN_DAY = 1440.0;

    private Calculator() {}

    public static double calculate(List<MediaItem> mediaItems) {
        int totalMinutes = 0;

        for (MediaItem item : mediaItems) {
            if (item instanceof Movie) {
                // Для фильма просто добавляем длительность
                totalMinutes += item.getRuntime();
            } else if (item instanceof Series) {
                // Для сериала умножаем среднюю длительность на количество серий
                Series series = (Series) item; // Явное приведение типа
                totalMinutes += series.getRuntime() * series.getSeriesCount();
            }
        }

        return totalMinutes / MINUTES_IN_DAY;
    }
}