package sprint9.client;

/**
 * Напишите HTTP-клиент, который будет работать с API с адресом functions.yandexcloud.net и получать
 * от него курсы валют.
 * Клиент должен отправлять GET-запрос по адресу https://functions.yandexcloud.net/d4ed1i6t3f80hf0p7mer.
 * Необходимо добавить два параметра:
 * base — параметр, указывающий базовую валюту для конвертации;
 * symbols — параметр, в котором через запятую перечислены все необходимые валюты для конвертации.
 * Параметр base должен быть равен RUB, а параметр symbols — USD,EUR. Ответ от сервера нужен в формате JSON.
 */

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Practicum109 {

    public static void main(String[] args) {
        HttpClient client = HttpClient.newHttpClient();

        // укажите URL запроса, включая его параметры
        URI url = URI.create("https://functions.yandexcloud.net/d4ed1i6t3f80hf0p7mer?base=RUB&symbols=USD,EUR");

        // создайте объект, описывающий запрос с необходимой информацией
        HttpRequest request = HttpRequest.newBuilder()
                .uri(url)
                .header("Accept", "application/json")
                .GET()
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Код статуса: " + response.statusCode());
            System.out.println("Ответ: " + response.body());
        } catch (IOException | InterruptedException e) { // обработка ошибки отправки запроса
            System.out.println("Во время выполнения запроса ресурса по URL-адресу: '" + url + "' возникла ошибка.\n" +
                    "Проверьте, пожалуйста, адрес и повторите попытку.");
        }
    }
}
