package sprint7.alltasks;

/**
 * Добавьте обработку исключений при преобразовании строки в URL в метод parseStringToURI(). При ошибке возвращайте значение null.
 */

import java.net.URI;

public class Practicum75 {
    public static void main(String[] args) {
        System.out.println(parseStringToURI("https://ya.ru"));
        System.out.println(parseStringToURI("\\\\"));
        System.out.println(parseStringToURI(null));
    }

    public static URI parseStringToURI(final String input) {
        try {
            return new URI(input);
        } catch (Throwable throwable) {
            System.out.println("Ошибка");
        }
        return null;
    }
}