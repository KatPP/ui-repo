package sprint7.alltasks;

/**
 * Пользователи веб-сайта часто вставляют лишние пробелы в поля ввода.
 * Напишите метод fixString() для обрезки ненужных пробелов.
 * Он должен возвращать текст "Вы ничего не ввели!", если входная строка пустая или состоит из пробельных символов.
 */

public class CleanInput {
    public String fixString(String str) {
        if(str.isBlank()) {
            System.out.println("Вы ничего не ввели!");
        }
        return str.trim();
    }
}



