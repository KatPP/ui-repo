package sprint6;

/**
 * Представьте, что вы работаете в крупной компании над программой для учёта всей входящей корреспонденции.
 * В эту систему попадает информация о каждом письме, которое поступает в компанию. Письма хранятся в порядке занесения информации о них в систему.
 * Вам нужно добавить новую функцию printOrderedByDateReceived — возможность отсортировать письма по дате их получения (от ранних к поздним).
 * Используйте тот же формат вывода на консоль, что уже используется в программе.
 */

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Practicum54 {
    private static Set<Letter> letters = new LinkedHashSet<>();

    public static void main(String[] args) {
        letters.add(new Letter("Джон Смит", LocalDate.of(2021, 7, 7), "текст письма №1 ..."));
        letters.add(new Letter("Аманда Линс", LocalDate.of(2021, 6, 17), "текст письма №2 ..."));
        letters.add(new Letter("Джо Кью", LocalDate.of(2021, 7, 5), "текст письма №3 ..."));
        letters.add(new Letter("Мишель Фернандес", LocalDate.of(2021, 8, 23), "текст письма №4 ..."));

        printOrderedById(letters);
        printOrderedByDateReceived(letters);
    }

    private static void printOrderedById(Set<Letter> letters) {
        System.out.println("Все письма с сортировкой по ID: ");
        for (Letter letter : letters) {
            System.out.println("    * Письмо от " + letter.authorName + " поступило " + letter.dateReceived);
        }
    }

    private static void printOrderedByDateReceived(Set<Letter> letters) {
        System.out.println("Все письма с сортировкой по дате получения: ");

        // Преобразуем Set в List для сортировки
        List<Letter> letterList = new ArrayList<>(letters);

        // Сортируем по дате получения
        Collections.sort(letterList, new Comparator<Letter>() {
            @Override
            public int compare(Letter l1, Letter l2) {
                return l1.dateReceived.compareTo(l2.dateReceived);
            }
        });

        // Выводим отсортированный список
        for (Letter letter : letterList) {
            System.out.println("    * Письмо от " + letter.authorName + " поступило " + letter.dateReceived);
        }
    }

    static class Letter {
        public String authorName;
        public LocalDate dateReceived;
        public String text;

        public Letter(String senderName, LocalDate dateReceived, String text) {
            this.authorName = senderName;
            this.dateReceived = dateReceived;
            this.text = text;
        }
    }
}
