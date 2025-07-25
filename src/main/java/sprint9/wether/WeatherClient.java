package sprint9.wether;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * Клиент для получения данных о погоде с внешнего API
 */
public class WeatherClient {
    private final HttpClient client;
    private final Gson gson;
    private static final String WEATHER_SERVICE_URL = "https://functions.yandexcloud.net/d4eo3a1nvqedpic89160";

    /**
     * Конструктор по умолчанию, инициализирует HTTP клиент и парсер JSON
     */
    public WeatherClient() {
        this.client = HttpClient.newHttpClient();
        this.gson = new Gson();
    }

    /**
     * Получает данные о погоде для указанного города
     *
     * @param cityCode трёхбуквенный код города (например: "MOW", "LED")
     * @return строка с информацией о погоде или сообщение об ошибке
     */
    public String getWeatherData(String cityCode) {
        try {
            // Формируем URL запроса с параметрами
            String url = WEATHER_SERVICE_URL + "?scale=C&city=" + cityCode;

            // Создаем HTTP запрос
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .timeout(Duration.ofSeconds(5))
                    .GET()
                    .build();

            // Отправляем запрос и получаем ответ
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Проверяем код ответа
            if (response.statusCode() != 200) {
                return "Что-то пошло не так. Сервер вернул код состояния: " + response.statusCode();
            }

            // Парсим JSON ответ с помощью Gson
            JsonObject jsonResponse = JsonParser.parseString(response.body()).getAsJsonObject();
            JsonObject cities = jsonResponse.getAsJsonObject("cities");

            // Проверяем наличие данных для запрошенного города
            if (!cities.has(cityCode)) {
                return "Данные о погоде не найдены";
            }

            // Извлекаем данные о погоде
            JsonObject cityData = cities.getAsJsonObject(cityCode);
            String cityName = cityData.get("city").getAsString();
            String conditions = cityData.get("conditions").getAsString();
            String temperature = cityData.get("temperature").getAsString();

            // Форматируем результат
            return String.format("Город: %s. %s, %s", cityName, conditions, temperature);
        } catch (Exception e) {
            return "Во время выполнения запроса возникла ошибка.\n" +
                    "Проверьте, пожалуйста, параметры запроса и повторите попытку.";
        }
    }
}