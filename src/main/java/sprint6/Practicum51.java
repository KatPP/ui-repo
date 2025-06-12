package sprint6;

import java.util.HashMap;
import java.util.Map;

/**
 * Ваш лучший друг решил открыть свою пиццерию и доставлять пиццу на дом.
 * Он хочет автоматизировать все процессы, но для этого нужно собрать подробную аналитику по заказам.
 * Давайте поможем ему в этом! Нужно найти самых активных клиентов — тех, кто заказывает пиццу чаще всего.
 */

public class Practicum51 {
    // Создадим хеш-таблицу для хранения заказов.
    // В качестве ключа будет имя клиента.
    // В качестве значения — количество заказов от этого клиента.
    private Map<String, Integer> orders = new HashMap<>();

    public static void main(String[] args) {
        Practicum51 pizzeria = new Practicum51();
        pizzeria.openPizzeria();
        pizzeria.printStatistics();
    }

    // Начинаем принимать заказы! 🍕
    private void openPizzeria() {
        newOrder("Леонардо");
        newOrder("Донателло");
        newOrder("Рафаэль");
        newOrder("Леонардо");
        newOrder("Микеланджело");
        newOrder("Шреддер");
        newOrder("Донателло");
    }

    private void newOrder(String clientName) {
        // Проверяем, есть ли уже такой клиент в нашей хеш-таблице
        if (orders.containsKey(clientName)) {
            // Если клиент уже есть - увеличиваем его счетчик заказов на 1
            int currentOrders = orders.get(clientName);
            orders.put(clientName, currentOrders + 1);
        } else {
            // Если клиента нет - добавляем его с 1 заказом
            orders.put(clientName, 1);
        }
    }


        private void printStatistics() {
            int total = 0;  // Общее количество заказов

            // Перебираем всех клиентов и их заказы
            for (String name : orders.keySet()) {
                int count = orders.get(name);
                System.out.println("Заказов от " + name + ": " + count);
                total += count;  // Считаем общую сумму
            }

            System.out.println("Всего заказов: " + total);
        }
        // Выведите собранную статистику в консоль и посчитайте общее количество заказов.
        //
        // Формат для вывода данных в консоль:
        //     Заказов от Микеланджело: 15
        //     Заказов от Леонардо: 4
        //     Всего заказов: 19
    }
