package sprint9.api;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;

class HelloHandler8 implements HttpHandler {
    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        // считываем тело запроса и преобразуем в строку
        InputStream inputStream = httpExchange.getRequestBody();
        String name = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
        System.out.println("Тело запроса:\n" + name);

        httpExchange.sendResponseHeaders(200, 0);

        try (OutputStream os = httpExchange.getResponseBody()) {
            String response = "Привет " + name + "! Рады видеть на нашем сервере.";
            os.write(response.getBytes());
        }
    }
}

public class Practicum92 {
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        HttpServer httpServer = HttpServer.create(new InetSocketAddress(PORT), 0);
        httpServer.createContext("/hello", new HelloHandler8());
        httpServer.start();
        System.out.println("HTTP-сервер запущен на " + PORT + " порту!");
    }
}
