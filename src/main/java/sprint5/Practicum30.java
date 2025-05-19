package sprint5;

/**
 * Вам нужно дополнить код класса, представляющего собой усовершенствованную хеш-таблицу, в которой можно хранить два уровня вложенных данных.
 * У данных будут два ключа: они могут быть разных типов данных.
 * Для своей работы усовершенствованная хеш-таблица использует обычную HashMap.
 * У усовершенствованной таблицы должно быть три метода:
 * добавление элементов по двум ключам,
 * получение элемента по двум ключам,
 * получение списка всех элементов по первому ключу (второй ключ при этом не должен учитываться).
 */

import java.util.ArrayList;
import java.util.HashMap;

public class Practicum30 {
    public static void main(String[] args) {
        // создаём двухуровневую хеш-таблицу для хранения расписания уроков
        AdvancedHashMap<String, Integer, String> timetable = new AdvancedHashMap<>();

        // добавляем уроки, с указанием дня недели и номера урока
        timetable.put("Понедельник", 1, "Русский язык");
        timetable.put("Понедельник", 2, "Математика");
        timetable.put("Вторник", 1, "Физкультура");
        timetable.put("Вторник", 2, "Русский язык");

        // выводим первый урок во вторник
        System.out.println(timetable.get("Вторник", 1)); // Выведет: Физкультура

        // получаем и выводим все уроки в понедельник
        ArrayList<String> mondayLessons = timetable.getAll("Понедельник");
        System.out.println(mondayLessons); // Выведет: [Русский язык, Математика]
    }
}

class AdvancedHashMap<K1, K2, V> {
    // данные будем хранить в хеш-таблице из хеш-таблиц
    private final HashMap<K1, HashMap<K2, V>> internalHashMap = new HashMap<>();

    public void put(K1 key1, K2 key2, V value) {
        // получаем хеш-таблицу по первому ключу
        HashMap<K2, V> innerHashMap = internalHashMap.get(key1);
        if (innerHashMap == null) {
            // вложенной хеш-таблицы по первому ключу пока нет — создаём её и добавляем в internalHashMap
            innerHashMap = new HashMap<>();
            internalHashMap.put(key1, innerHashMap);
        }
        // добавляем элемент во вложенную хеш-таблицу
        innerHashMap.put(key2, value);
    }

    public V get(K1 key1, K2 key2) {
        // получаем хеш-таблицу по первому ключу
        HashMap<K2, V> innerHashMap = internalHashMap.get(key1);
        if (innerHashMap == null) {
            return null;
        }
        // получаем элемент из вложенной хеш-таблицы
        return innerHashMap.get(key2);
    }

    public ArrayList<V> getAll(K1 key1) {
        HashMap<K2, V> innerHashMap = internalHashMap.get(key1);
        if (innerHashMap == null) {
            return new ArrayList<>();
        }
        return new ArrayList<>(innerHashMap.values());
    }
}
