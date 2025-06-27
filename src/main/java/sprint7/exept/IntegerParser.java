package sprint7.exept;

public class IntegerParser {
    public static int parseInt(String input) throws NullStringException,
            EmptyStringException,
            StringNotNumberException,
            StringIsTooBigNumberException,
            StringIsTooSmallNumberException {
        if (input == null) {
            throw new NullStringException();
        }
        if (input.isEmpty()) {
            throw new EmptyStringException();
        }

        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            // Проверяем, можно ли преобразовать в long
            try {
                long num = Long.parseLong(input);
                if (num > Integer.MAX_VALUE) {
                    throw new StringIsTooBigNumberException();
                }
                if (num < Integer.MIN_VALUE) {
                    throw new StringIsTooSmallNumberException();
                }
                // Если попадаем сюда, значит число в пределах int, но содержит нечисловые символы
                throw new StringNotNumberException();
            } catch (NumberFormatException ex) {
                throw new StringNotNumberException();
            }
        }
    }
}