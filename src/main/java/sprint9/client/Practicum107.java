package sprint9.client;

/**
 * Обработка HTTP-ответов с кодами состояния ошибки
 * Напомним, что код ответа типа 2хх свидетельствует об успешной обработке запроса.
 * Если сервер возвращает код в формате 4хх или 5хх, произошла ошибка.
 * Такой ответ необходимо обработать.
 * Воспользуемся сервисом httpbin.org. Он возвращает ответы с указанным в URL кодом состояния.
 * Например, если отправить запрос по адресу http://httpbin.org/status/500, сервер вернёт ответ с кодом
 * состояния 500. Таким образом можно эмулировать ответы от сервера с нужным кодом состояния.
 * Запустите код ниже. Затем поэкспериментируйте с разными кодами состояния: попробуйте поменять
 * значение переменной requestedStatus.
 */

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

class Practicum {
    public static void main(String[] args) {
        /* Попробуйте заменить код статуса на какой-либо другой
           и посмотреть на реакцию вашего HTTP-клиента. */
        int requestedStatus = 400;
        // указываем код состояния как часть URL-адреса
        URI uri = URI.create("http://httpbin.org/status/" + requestedStatus);
        HttpRequest request = HttpRequest.newBuilder().GET().uri(uri).build();

        HttpClient client = HttpClient.newHttpClient();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            int status = response.statusCode();
            // обрабатываем коды успешного состояния
            if(status >= 200 && status <= 299) {
                System.out.println("Сервер успешно обработал запрос. Код состояния: " + status);
                return;
            }
            // обрабатываем коды состояния, сообщающие об ошибке на стороне клиента
            if(status >= 400 && status <= 499) {
                System.out.println("Сервер сообщил о проблеме с запросом. Код состояния: " + status);
                return;
            }
            // обрабатываем коды состояния, сообщающие об ошибке на стороне сервера
            if(status >= 500 && status <= 599) {
                System.out.println("Сервер сообщил о внутренней проблеме и невозможности обработать запрос." +
                        " Код состояния: " + status);
            } else { // обрабатываем остальные коды состояния
                System.out.println("Что-то пошло не так. Сервер вернул код состояния: " + status);
            }
        } catch (IOException | InterruptedException e) { // обрабатываем ошибки отправки запроса
            System.out.println("Во время выполнения запроса ресурса по url-адресу: '" + uri + "' возникла ошибка.\n" +
                    "Проверьте, пожалуйста, адрес и повторите попытку.");
        }
    }
}
