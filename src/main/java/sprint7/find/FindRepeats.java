package sprint7.find;

/**
 * Команда Ctrl/Alt + F (⌘ + F для Mac) — пожалуй, самый известный пример организации поиска подстрок и символов внутри текста.
 * При нажатии открывается небольшое окошко, куда вбивается текст,
 * и в результате вы получаете количество повторов искомого текста или символа.
 * Попробуйте реализовать такой подсчёт на Java. Напишите метод int numberOfRepeats(String text, String substring),
 * который будет возвращать число повторения подстроки substring в переданном тексте text.
 * Пример:
 * numberOfRepeats("раз два три, раз два три", "раз"); // вернёт 2
 * numberOfRepeats("Hello, world!", "goodbye"); // вернёт 0
 */

public class FindRepeats {
    int numberOfRepeats(String text, String substring) {
        if (text == null || substring == null || substring.isEmpty()) {
            return 0;
        }

        int count = 0;
        int index = 0;

        while ((index = text.indexOf(substring, index)) != -1) {
            count++;
            index += substring.length();
        }

        return count;
    }
}

/**
 * Объяснение:
 * Проверка на null и пустую подстроку:
 *
 * Если text или substring равны null, или substring пустая, возвращаем 0.
 *
 * Поиск вхождений:
 *
 * Используем indexOf(substring, fromIndex), который ищет подстроку начиная с позиции fromIndex.
 *
 * Каждый раз, когда находим подстроку, увеличиваем счётчик count и смещаем index на длину подстроки, чтобы избежать повторного учёта пересекающихся вхождений.
 *
 * Возврат результата:
 *
 * Возвращаем общее количество найденных вхождений.
 */

