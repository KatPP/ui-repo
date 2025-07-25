package sprint9.api;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

class HelloHandler3 implements HttpHandler {
    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        /* Получаем заголовки запроса, выводим их в консоль
           и возвращаем в качестве тела ответа. */
        Headers requestHeaders = httpExchange.getRequestHeaders();
        String response = "Request headers: \n" + requestHeaders.entrySet();
        System.out.println(response);

        httpExchange.sendResponseHeaders(200, 0);

        try (OutputStream os = httpExchange.getResponseBody()) {
            os.write(response.getBytes());
        }
    }
}

public class Practicum94 {
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        HttpServer httpServer = HttpServer.create(new InetSocketAddress(PORT), 0);
        httpServer.createContext("/hello", new HelloHandler3());
        httpServer.start();
        System.out.println("HTTP-сервер запущен на " + PORT + " порту!");
    }
}
