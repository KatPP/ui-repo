package sprint7.alltasks;

/**
 * Реализуйте методы capsLock() и print().
 * Первый устанавливает флаг isCapsLock в true или false.
 * Второй выводит строку в верхнем или оставляет регистр как есть в зависимости от этого флага.
 */

public class TextEditor {
    private boolean isCapsLock = false;


    public void capsLock() {
        isCapsLock = !isCapsLock;
    } // Здесь нужно изменить значение флага isCapsLock на противоположное
    public void print(String str) {
        if (!isCapsLock) {
            System.out.println(str);
        } else {
            System.out.println(str.toUpperCase());
        }// а здесь нужно распечатать строку или в верхнем регистре, или без изменений, учитывая флаг
    }
}
