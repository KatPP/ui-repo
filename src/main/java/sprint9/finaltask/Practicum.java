package sprint9.finaltask;

/**
 * Вам нужно создать HTTP-сервер для небольшой социальной сети.
 */

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.*;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Обработчик HTTP-запросов для работы с постами и комментариями.
 * Реализует интерфейс HttpHandler для обработки входящих HTTP-запросов.
 */
class PostsHandler implements HttpHandler {
    private static final Charset DEFAULT_CHARSET = StandardCharsets.UTF_8;

    private final List<Post> posts;

    /**
     * Конструктор обработчика постов.
     * @param posts список постов, с которыми будет работать обработчик
     */
    public PostsHandler(List<Post> posts) {
        this.posts = posts;
    }

    /**
     * Основной метод обработки HTTP-запросов.
     * Определяет endpoint по пути и методу запроса, затем делегирует обработку соответствующему методу.
     * @param exchange объект HttpExchange, содержащий информацию о запросе и ответе
     * @throws IOException при ошибках ввода-вывода
     */
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        // Получаем endpoint на основе пути запроса и HTTP-метода
        Endpoint endpoint = getEndpoint(exchange.getRequestURI().getPath(), exchange.getRequestMethod());

        // В зависимости от endpoint вызываем соответствующий обработчик
        switch (endpoint) {
            case GET_POSTS: {
                handleGetPosts(exchange);
                break;
            }
            case GET_COMMENTS: {
                handleGetComments(exchange);
                break;
            }
            case POST_COMMENT: {
                handlePostComments(exchange);
                break;
            }
            default:
                writeResponse(exchange, "Такого эндпоинта не существует", 404);
        }
    }

    /**
     * Обрабатывает POST-запрос для добавления комментария к посту.
     * @param exchange объект HttpExchange
     * @throws IOException при ошибках ввода-вывода
     */
    private void handlePostComments(HttpExchange exchange) throws IOException {
        // Извлекаем идентификатор поста из URL
        Optional<Integer> postIdOpt = getPostId(exchange);
        if (postIdOpt.isEmpty()) {
            writeResponse(exchange, "Некорректный идентификатор поста", 400);
            return;
        }
        int postId = postIdOpt.get();

        // Парсим комментарий из тела запроса
        Optional<Comment> commentOpt = parseComment(exchange.getRequestBody());
        if (commentOpt.isEmpty()) {
            writeResponse(exchange, "Поля комментария не могут быть пустыми", 400);
            return;
        }
        Comment comment = commentOpt.get();

        // Ищем пост с указанным ID и добавляем комментарий
        for (Post post : posts) {
            if (post.getId() == postId) {
                post.addComment(comment);
                writeResponse(exchange, "Комментарий добавлен", 201);
                return;
            }
        }

        // Если пост не найден, возвращаем ошибку 404
        writeResponse(exchange, "Пост с идентификатором " + postId + " не найден", 404);
    }

    /**
     * Парсит комментарий из тела запроса.
     * Формат тела запроса: первая строка - имя пользователя, остальные строки - текст комментария.
     * @param bodyInputStream поток ввода с телом запроса
     * @return Optional с комментарием, если парсинг успешен, или пустой Optional
     * @throws IOException при ошибках чтения потока
     */
    private Optional<Comment> parseComment(InputStream bodyInputStream) throws IOException {
        // Читаем все строки из тела запроса
        String body = new BufferedReader(new InputStreamReader(bodyInputStream))
                .lines()
                .collect(Collectors.joining("\n"));

        // Разбиваем на отдельные строки
        String[] lines = body.split("\n");
        if (lines.length < 2) {
            return Optional.empty();
        }

        // Первая строка - имя пользователя
        String user = lines[0].trim();
        if (user.isEmpty()) {
            return Optional.empty();
        }

        // Остальные строки - текст комментария
        String text = String.join("\n", Arrays.copyOfRange(lines, 1, lines.length)).trim();
        if (text.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(new Comment(user, text));
    }

    /**
     * Обрабатывает GET-запрос для получения списка всех постов.
     * @param exchange объект HttpExchange
     * @throws IOException при ошибках ввода-вывода
     */
    private void handleGetPosts(HttpExchange exchange) throws IOException {
        // Преобразуем все посты в строки и объединяем через перевод строки
        String response = posts.stream()
                .map(Post::toString)
                .collect(Collectors.joining("\n"));
        writeResponse(exchange, response, 200);
    }

    /**
     * Обрабатывает GET-запрос для получения комментариев к конкретному посту.
     * @param exchange объект HttpExchange
     * @throws IOException при ошибках ввода-вывода
     */
    private void handleGetComments(HttpExchange exchange) throws IOException {
        // Получаем ID поста из URL
        Optional<Integer> postIdOpt = getPostId(exchange);
        if (postIdOpt.isEmpty()) {
            writeResponse(exchange, "Некорректный идентификатор поста", 400);
            return;
        }
        int postId = postIdOpt.get();

        // Ищем пост с указанным ID
        for (Post post : posts) {
            if (post.getId() == postId) {
                // Если пост найден, преобразуем его комментарии в строки
                String response = post.getComments().stream()
                        .map(Comment::toString)
                        .collect(Collectors.joining("\n"));
                writeResponse(exchange, response, 200);
                return;
            }
        }

        // Если пост не найден, возвращаем ошибку 404
        writeResponse(exchange, "Пост с идентификатором " + postId + " не найден", 404);
    }

    /**
     * Извлекает ID поста из URL запроса.
     * @param exchange объект HttpExchange
     * @return Optional с ID поста, если он корректный, или пустой Optional
     */
    private Optional<Integer> getPostId(HttpExchange exchange) {
        // Разбиваем путь запроса на части по '/'
        String[] pathParts = exchange.getRequestURI().getPath().split("/");
        try {
            // Пытаемся преобразовать третью часть пути в число (ID поста)
            return Optional.of(Integer.parseInt(pathParts[2]));
        } catch (NumberFormatException exception) {
            return Optional.empty();
        }
    }

    /**
     * Определяет endpoint на основе пути запроса и HTTP-метода.
     * @param requestPath путь запроса
     * @param requestMethod HTTP-метод (GET, POST и т.д.)
     * @return соответствующий endpoint
     */
    private Endpoint getEndpoint(String requestPath, String requestMethod) {
        String[] pathParts = requestPath.split("/");

        // GET /posts - получение всех постов
        if (pathParts.length == 2 && pathParts[1].equals("posts")) {
            return Endpoint.GET_POSTS;
        }
        // GET или POST /posts/{id}/comments - работа с комментариями
        if (pathParts.length == 4 && pathParts[1].equals("posts") && pathParts[3].equals("comments")) {
            if (requestMethod.equals("GET")) {
                return Endpoint.GET_COMMENTS;
            }
            if (requestMethod.equals("POST")) {
                return Endpoint.POST_COMMENT;
            }
        }
        return Endpoint.UNKNOWN;
    }

    /**
     * Отправляет HTTP-ответ клиенту.
     * @param exchange объект HttpExchange
     * @param responseString строка ответа
     * @param responseCode HTTP-код ответа
     * @throws IOException при ошибках ввода-вывода
     */
    private void writeResponse(HttpExchange exchange,
                               String responseString,
                               int responseCode) throws IOException {
        try (OutputStream os = exchange.getResponseBody()) {
            // Отправляем заголовки ответа
            exchange.sendResponseHeaders(responseCode, 0);
            // Записываем тело ответа
            os.write(responseString.getBytes(DEFAULT_CHARSET));
        }
        exchange.close();
    }

    /**
     * Перечисление возможных endpoint'ов API.
     */
    enum Endpoint {GET_POSTS, GET_COMMENTS, POST_COMMENT, UNKNOWN}
}

/**
 * Основной класс приложения, запускающий HTTP-сервер.
 */
public class Practicum {
    private static final int PORT = 8080;

    /**
     * Точка входа в приложение.
     * @param args аргументы командной строки (не используются)
     * @throws IOException при ошибках создания сервера
     */
    public static void main(String[] args) throws IOException {
        // Инициализация начальных данных - создаем три тестовых поста
        List<Post> posts = new ArrayList<>();
        Post post1 = new Post(1, "Это первый пост, который я здесь написал.");
        post1.addComment(new Comment("Пётр Первый", "Я успел откомментировать первым!"));
        posts.add(post1);

        Post post2 = new Post(22, "Это будет второй пост. Тоже короткий.");
        posts.add(post2);

        Post post3 = new Post(333, "Это пока последний пост.");
        posts.add(post3);

        // Настройка и запуск HTTP-сервера
        HttpServer httpServer = HttpServer.create(new InetSocketAddress(PORT), 0);
        // Регистрируем обработчик для пути "/posts"
        httpServer.createContext("/posts", new PostsHandler(posts));
        httpServer.start(); // запускаем сервер

        System.out.println("HTTP-сервер запущен на " + PORT + " порту!");

    }
}

/**
 * Класс, представляющий пост в блоге.
 */
class Post {
    private int id;
    private String text;
    private List<Comment> comments = new ArrayList<>();

    /**
     * Конструктор поста.
     * @param id уникальный идентификатор поста
     * @param text текст поста
     */
    public Post(int id, String text) {
        this.id = id;
        this.text = text;
    }

    /**
     * Возвращает ID поста.
     * @return ID поста
     */
    public int getId() {
        return id;
    }

    /**
     * Добавляет комментарий к посту.
     * @param comment объект комментария
     */
    public void addComment(Comment comment) {
        comments.add(comment);
    }

    /**
     * Возвращает список комментариев к посту.
     * @return список комментариев
     */
    public List<Comment> getComments() {
        return comments;
    }

    /**
     * Преобразует пост в строковое представление.
     * @return строковое представление поста
     */
    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", comments=" + comments +
                '}';
    }
}

/**
 * Класс, представляющий комментарий к посту.
 */
class Comment {
    private String user;
    private String text;

    /**
     * Конструктор комментария.
     * @param user имя пользователя, оставившего комментарий
     * @param text текст комментария
     */
    public Comment(String user, String text) {
        this.user = user;
        this.text = text;
    }

    /**
     * Преобразует комментарий в строковое представление.
     * @return строковое представление комментария
     */
    @Override
    public String toString() {
        return "Comment{" +
                "user='" + user + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}