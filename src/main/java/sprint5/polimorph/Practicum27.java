package sprint5.polimorph;

import java.util.Scanner;

/**
 * Помогите пользователю вашего приложения связаться с другом через виртуальную АТС. Допишите модуль АТС, используя принципы полиморфизма.
 * Способ связи будет зависеть от модели телефона, принимающего вызов пользователя.
 * Если у пользователя стационарный или мобильный телефон, то позвонить ему можно только по сотовой связи (в этом случае необходимо вывести сообщение Набираем номер <targetNumber> и звоним по сотовой связи).
 * Любой смартфон — это мобильный телефон, но не любой мобильный телефон — смартфон!
 * У смартфона есть возможность принимать звонки и сообщения как по сотовой связи, так и через сторонние приложения — в этом случае перед звонком нужно вывести сообщение
 * Позвоним через приложение <appName> по номеру <targetNumber>.
 * Если у пользователя мобильный телефон, ему можно отправить SMS: Отправляем сообщение <messageText> по номеру <targetNumber>.
 * А пользователь смартфона может отправлять не только SMS, но и email — в этом случае нужно вывести сообщение Напишем другу сообщение <messageText> по email <email>.
 */

public class Practicum27 {
    public static void main(String[] args) {
        System.out.println("Вас приветствует виртуальная АТС!");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ваш номер телефона:");
        String number = scanner.next();
        System.out.println("Введите номер пользователя, которому хотите позвонить:");
        String friendNumber = scanner.next();
        System.out.println("Выберите модель телефона собеседника, 1 - стационарный телефон, 2 - мобильный телефон, 3 - смартфон:");
        int type = scanner.nextInt();

        if (type < 1 || type > 3) {
            System.out.println("Введена неверная модель телефона");
            return;
        }

        getPhone(type, number).makeCall(friendNumber);
    }

    public static Phone getPhone(int type, String number) {
        if (type == 1) {
            // если выбран стационарный телефон, создайте объект класса LandlinePhone
            return new LandlinePhone(number);
        } else if (type == 2) {
            // если выбран мобильный телефон, создайте объект класса MobilePhone
            return new MobilePhone(number);
        } else {
            // иначе создайте экземпляр класса Smartphone
            return new Smartphone(number);
        }
    }
}
