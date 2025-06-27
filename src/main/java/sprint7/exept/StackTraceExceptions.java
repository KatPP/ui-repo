package sprint7.exept;

import java.util.Scanner;

/**
 * Программа по преобразованию строки в целое число немного изменилась. Теперь при исключении в блоках catch происходит вызов метода printException().
 * Сейчас этот метод работает неправильно — вам нужно доработать его реализацию.
 * Во-первых, printException() должен принимать не только сообщение об ошибке, но и само исключение.
 * Во-вторых, нужно сделать так, чтобы помимо основного сообщения он выводил информацию об ошибке.
 * Если у исключения есть короткое описание, то нужно вывести его, если нет, то полный стек-трейс ошибки.
 */

public class StackTraceExceptions {
    public static void main(String[] args) {
        System.out.print("Введите целое число => ");
        Scanner scanner = new Scanner(System.in);
        final String inputValue = scanner.next();
        try {
            final int parsedValue = IntegerParser.parseInt(inputValue);
            System.out.println(parsedValue);
        } catch (NullStringException | EmptyStringException exception) {
            printException("Введена пустая строка.", exception);
        } catch (StringNotNumberException exception) {
            printException("Вы ввели не целое число.", exception);
        } catch (StringIsTooBigNumberException exception) {
            printException("Введённое число слишком большое.", exception);
        } catch (StringIsTooSmallNumberException exception) {
            printException("Введённое число слишком маленькое.", exception);
        }
    }

    private static void printException(final String message, final Throwable throwable) { // добавлено Throwable throwable
        System.out.println(message);

        if (throwable.getMessage() != null) {
            System.out.println("Описание ошибки: " + throwable.getMessage());  // короткое описание вывод
        } else {
            System.out.println("Стек-трейс ошибки:");  // полный стэктрейс
            throwable.printStackTrace();
        }
    }
}
