package sprint7.alltasks;

/**
 * В отделах кадров часто требуется искать работников по первым буквам фамилии.
 * От перебора бумажных картотек уже отказались — все персональные данные загружены в электронную базу.
 * Вам нужно реализовать метод boolean startsWith(String initial, String other),
 * который возвращает true, если фамилия работника initial начинается с подстроки other, иначе false.
 */

public class SubstringFunctions {
    public boolean startsWith(String initial, String other) {
        return initial != null && other != null && initial.indexOf(other) == 0;
    }
}

/**
 * initial.indexOf(other) ищет подстроку other в строке initial.
 *
 * Если indexOf() возвращает 0, значит, other находится в самом начале initial.
 *
 * Если initial или other — null, метод вернёт false (чтобы избежать NullPointerException).
 */