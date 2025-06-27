package sprint7.capital;

/**
 * Маленькие дети часто забывают, что нужно начинать новое предложение с большой буквы.
 * Помогите им! Реализуйте метод capitalize().
 * Он должен переводить первый символ в переданной строке в верхний регистр при помощи метода toUpperCase() и возвращать полученную строку.
 */

public class Capitalizator {
    public String capitalize(String str) {
        if (str == null || str.isEmpty()) {
            return str; // возвращаем как есть, если строка пустая или null
        }

        // Берем первый символ, переводим в верхний регистр и добавляем остаток строки
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}
