package sprint6;

import java.util.List;
import java.util.Set;
import java.util.HashSet;

/**
 * Работа у программистов весьма разнообразна, и сегодня ваш новый проект — приложение для ведения списка покупок! Часть кода уже написана, вам нужно дописать недостающие части.
 * В переменной allPurchases хранятся все покупки, которые семья сделала за последний месяц. Некоторые товары были приобретены несколько раз.
 * Вам нужно выявить уникальные товары, которые покупала семья. Для этого реализуйте метод findUniquePurchases(List<String> allPurchases) и допишите недостающие части кода.
 * Также посчитайте, сколько уникальных товаров приобретено за последний месяц, и выведите эту информацию на консоль.
 */

class Practicum53 {
    private static List<String> allPurchases = List.of(
            "яблоки",
            "молоко",
            "колбаса",
            "огурцы",
            "сок",
            "хлеб",
            "виноград",
            "молоко",
            "йогурт",
            "хлеб",
            "пельмени"
    );

    public static void main(String[] args) {
        // Получаем множество уникальных товаров
        Set<String> uniquePurchases = findUniquePurchases(allPurchases);

        // Выводим количество уникальных товаров
        System.out.println("За месяц было куплено " + uniquePurchases.size() + " уникальных товаров.");
    }

    // Метод для нахождения уникальных покупок
    public static Set<String> findUniquePurchases(List<String> allPurchases) {
        // Используем HashSet для автоматического удаления дубликатов
        return new HashSet<>(allPurchases);
    }
}