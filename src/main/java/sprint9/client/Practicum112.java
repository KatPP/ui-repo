package sprint9.client;

/**
 * Доработайте код клиента для получения курса валют из прошлого урока.
 * Извлеките из ответа сервера текущие курсы рубля к доллару и к евро.
 * Запишите их в переменные rateUSD и rateEUR и выведите на экран.
 * Сервер возвращает JSON-данные со следующей структурой:
 * {"rates": {"<название_валюты1>": <курс_валюты1>, "название_валюты2": <курс_валюты2>}}
 */

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Practicum112 {
    public static void main(String[] args) {
        HttpClient client = HttpClient.newHttpClient();

        URI url = URI.create("https://functions.yandexcloud.net/d4ed1i6t3f80hf0p7mer?base=RUB&symbols=USD,EUR");
        HttpRequest request = HttpRequest.newBuilder()
                .uri(url)
                .GET()
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            // проверяем, успешно ли обработан запрос
            if (response.statusCode() == 200) {
                JsonElement jsonElement = JsonParser.parseString(response.body());
                if(!jsonElement.isJsonObject()) { // проверяем, точно ли мы получили JSON-объект
                    System.out.println("Ответ от сервера не соответствует ожидаемому.");
                    return;
                }
                // получите курс доллара и евро и запишите в переменные rateUSD и rateEUR

                // Получаем основной JSON-объект
                JsonObject jsonObject = jsonElement.getAsJsonObject();
                // Получаем объект "rates" из основного объекта
                JsonObject ratesObject = jsonObject.getAsJsonObject("rates");

                // Извлекаем курсы для USD и EUR
                double rateUSD = ratesObject.get("USD").getAsDouble();
                double rateEUR = ratesObject.get("EUR").getAsDouble();

                System.out.println("Стоимость рубля в долларах: " + rateUSD + " USD");
                System.out.println("Стоимость рубля в евро: " + rateEUR + " EUR");
            } else {
                System.out.println("Что-то пошло не так. Сервер вернул код состояния: " + response.statusCode());
            }
        } catch (IOException | InterruptedException e) { // обрабатываем ошибки отправки запроса
            System.out.println("Во время выполнения запроса возникла ошибка.\n" +
                    "Проверьте, пожалуйста, адрес и повторите попытку.");
        }
    }
}
