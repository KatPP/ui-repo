package sprint9.api;

/**
 * Реализуйте API со следующей логикой:
 * Для метода GET /hello всегда возвращается один ответ — «Здравствуйте!».
 * Для метода POST /hello/{профессия}/{имя}:
 * Тело запроса считается приветствием.
 * <p>
 * Если передан заголовок X-Wish-Good-Day=true,
 * возвращается ответ вида «[приветствие, профессия имя]! Хорошего дня!».
 * <p>
 * Например, на запрос /hello/программист/Егор, заголовок wishGoodDay=true и тело
 * запроса Доброе утро корректный ответ — «Доброе утро, программист Егор! Хорошего дня!».
 * <p>
 * Если заголовок отсутствует, возвращается ответ вида «[приветствие, профессия имя]!».
 * <p>
 * Для любого другого метода выводится сообщение об ошибке — «Некорректный метод!».
 * <p>
 * <p>
 * <p>
 * Будьте внимательны: при возникновении ошибки (например, NullPointerException)
 * в консоли не будет отображаться никакой информации. Тестируйте аккуратно!
 */

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.List;

class HelloHandler10 implements HttpHandler {
    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        String response;

        // извлекаем метод из запроса
        String method = httpExchange.getRequestMethod();

        switch (method) {
            case "POST":
                response = handlePostRequest(httpExchange);
                break;
            case "GET":
                response = handleGetRequest(httpExchange);
                break;
            default:
                response = "Некорректный метод!";
        }

        httpExchange.sendResponseHeaders(200, response.getBytes().length);
        try (OutputStream os = httpExchange.getResponseBody()) {
            os.write(response.getBytes());
        }
    }

    private static String handleGetRequest(HttpExchange httpExchange) {
        // Для GET /hello всегда возвращаем "Здравствуйте!"
        return "Здравствуйте!";
    }

    private static String handlePostRequest(HttpExchange httpExchange) throws IOException {
        // извлекаем path из запроса
        String path = httpExchange.getRequestURI().getPath();
        String[] pathParts = path.split("/");

        // извлекаем профессию и имя из пути (индексы 2 и 3)
        String profession = pathParts[2];
        String name = pathParts[3];

        // извлекаем тело запроса (приветствие)
        InputStream inputStream = httpExchange.getRequestBody();
        String greeting = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);

        // формируем базовый ответ
        String response = greeting + ", " + profession + " " + name + "!";

        // проверяем заголовок X-Wish-Good-Day
        Headers headers = httpExchange.getRequestHeaders();
        List<String> wishGoodDay = headers.get("X-Wish-Good-Day");
        if ((wishGoodDay != null) && (wishGoodDay.contains("true"))) {
            response += " Хорошего дня!";
        }

        return response;
    }
}


public class Practicum96 {
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        HttpServer httpServer = HttpServer.create(new InetSocketAddress(PORT), 0);
        httpServer.createContext("/hello", new HelloHandler10());
        httpServer.start();
        System.out.println("HTTP-сервер запущен на " + PORT + " порту!");
    }
}

