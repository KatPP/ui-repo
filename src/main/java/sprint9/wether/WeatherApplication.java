package sprint9.wether;

/**
 * Приложение для отображения погоды в различных городах
 */
public class WeatherApplication {
    private WeatherClient weatherClient;

    /**
     * Конструктор, инициализирует клиент для работы с API погоды
     */
    public WeatherApplication() {
        this.weatherClient = new WeatherClient();
    }

    /**
     * Отображает погоду для указанного города
     *
     * @param city трёхбуквенный код города
     */
    public void displayWeather(String city) {
        String weatherData = weatherClient.getWeatherData(city);
        System.out.println(weatherData);
    }
}