package sprint9.api;

/**
 * Добавьте в код сервера новый обработчик для эндпоинта /day.
 * Сервер должен отвечать случайно выбранным днём недели,
 * то есть одной из строк — “MONDAY", "TUESDAY", "WEDNESDAY" и так далее.
 * Для этого можно использовать стандартное перечисление DayOfWeek  и класс Random.
 */

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.time.DayOfWeek;
import java.util.Random;

public class Practicum91 {
    private static final int PORT = 8080;

    // IOException могут сгенерировать методы create() и bind(...)
    public static void main(String[] args) throws IOException {
        HttpServer httpServer = HttpServer.create();

        httpServer.bind(new InetSocketAddress(PORT), 0);
        httpServer.createContext("/hello", new HelloHandler());
        // добавьте новый обработчик для /day тут
        httpServer.createContext("/day", new HelloHandlerDay());
        httpServer.start(); // запускаем сервер

        System.out.println("HTTP-сервер запущен на " + PORT + " порту!");
    }

    static class HelloHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange httpExchange) throws IOException {
            System.out.println("Началась обработка /hello запроса от клиента.");

            String response = "Hey! Glad to see you on our server.";
            httpExchange.sendResponseHeaders(200, 0);

            try (OutputStream os = httpExchange.getResponseBody()) {
                os.write(response.getBytes());
            }
        }
    }
    // объявите класс-обработчик тут
    static class HelloHandlerDay implements HttpHandler {
        @Override
        public void handle(HttpExchange httpExchange) throws IOException {
            System.out.println("Началась обработка /day запроса от клиента.");

            Random random = new Random(); // Создайте объект Random для генерации случайных чисел
            int randomDayNumber = random.nextInt(7) + 1; // Сгенерируйте случайное число в диапазоне от 1 до 7 (так как в DayOfWeek 7 дней)
            DayOfWeek randomDay = DayOfWeek.of(randomDayNumber); // Преобразуйте число в день недели с помощью DayOfWeek.of()

            String dayName = randomDay.name(); // Например, "MONDAY", "TUESDAY" и т.д.
            httpExchange.sendResponseHeaders(200, 0);

            try (OutputStream os = httpExchange.getResponseBody()) {
                os.write(dayName.getBytes());
            }
        }
    }

}
