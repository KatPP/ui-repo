package sprint4.objekt;

/**
 * Допишите код класса — бюро находок LostAndFoundOffice. В нём должен быть список things для учёта потерянных вещей,
 * метод put() для добавления вещи в список, метод check() — для проверки её наличия. В зависимости от результата check() должен возвращать true или false.
 * Методы put() и check() должны быть универсальными — принимать в качестве параметра объекты любых классов.
 * Не забудьте предусмотреть ситуацию, если в check() передана пустая ссылка.
 */

import java.util.ArrayList;

public class LostAndFoundOffice {
    ArrayList<Object> things = new ArrayList<>();   // создайте список things

    void put(Object object) { // реализуйте метод put()
        things.add(object);
    }

    // Метод для проверки наличия вещи
    boolean check(Object target) {
        // Проверяем, не передали ли null
        if (target == null) {
            return false;
        }

        // Проверяем каждый элемент в списке
        for (Object object : things) {
            if (target.equals(object)) {
                return true; // нашли совпадение
            }
        }
        return false; // не нашли совпадение
    }
}
