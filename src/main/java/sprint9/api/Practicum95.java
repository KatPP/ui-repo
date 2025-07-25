package sprint9.api;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

class HelloHandler5 implements HttpHandler {
    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        // получаем путь, на который пришел запрос
        String path = httpExchange.getRequestURI().getPath();
        // разбиваем путь на компоненты и берём последний
        String name = path.split("/")[2];
        // выводим полученное имя в консоль и в качестве ответа
        System.out.println("Имя: " + name);
        httpExchange.sendResponseHeaders(200, 0);

        try (OutputStream os = httpExchange.getResponseBody()) {
            String response = "Привет, " + name + "!";
            os.write(response.getBytes());
        }
    }
}

public class Practicum95 {
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        HttpServer httpServer = HttpServer.create(new InetSocketAddress(PORT), 0);
        httpServer.createContext("/hello", new HelloHandler5());
        httpServer.start();
        System.out.println("HTTP-сервер запущен на " + PORT + " порту!");
    }
}