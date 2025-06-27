package sprint7.userpassword;

/**
 * Доработайте код приложения для хранения и обработки паролей пользователей.
 * Оба класса должны наследовать от ValidateException и принимать короткое сообщение об ошибке.
 * В методах класса PasswordMemoryStorage пропущены предупреждения об исключении IOException — добавьте их.
 * Допишите код класса NameValidator — он должен реализовывать интерфейс Validator и проверять, не передана ли пустая строка. В обратном случае — генерировать исключение ValidateNameException с сообщением «Имя не должно быть пустым».
 * Добавьте реализованный экземпляр класса NameValidator в список nameValidators.
 * Добавьте отлов исключений ValidateNameException и ValidatePasswordException в методы класса Practicum. При этом выведите сообщения формата:
 * Ошибка валидации имени: + короткое описание ошибки.
 * Ошибка валидации пароля: + короткое описание ошибки.
 * Организуйте закрытие хранилища storage при помощи метода close() при любом развитии событий в методах addUser() и showUserPassword() класса Practicum.
 */

import sprint7.userpassword.exceptions.ValidateException;
import sprint7.userpassword.exceptions.ValidateNameException;
import sprint7.userpassword.exceptions.ValidatePasswordException;
import sprint7.userpassword.storage.PasswordMemoryStorage;
import sprint7.userpassword.storage.PasswordStorage;
import sprint7.userpassword.validator.NameValidator;
import sprint7.userpassword.validator.PasswordLengthValidator;
import sprint7.userpassword.validator.PasswordStrengthValidator;
import sprint7.userpassword.validator.Validator;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

class Practicum80 {

    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Validator> passwordValidators = List.of(
            new PasswordLengthValidator(5), new PasswordStrengthValidator()
    );

    private static final List<Validator> nameValidators = List.of(new NameValidator());

    public static void main(String[] args) {
        loop();
    }

    public static void loop() {
        while (true) {
            final String action = getAction();
            if ("1".equals(action)) {
                addUser();
            } else if ("2".equals(action)) {
                showUserPassword();
            } else {
                break;
            }
        }
    }

    private static void checkValidatorRules(
            final List<Validator> validators, final String value
    ) throws ValidateException {
        for (Validator validator: validators) {
            validator.validate(value);
        }
    }

    private static void addUser() {
        final PasswordStorage storage = new PasswordMemoryStorage();
        try {
            storage.open();
            System.out.println("Введите имя пользователя => ");
            final String name = scanner.nextLine();
            checkValidatorRules(nameValidators, name);

            System.out.println("Введите пароль пользователя => ");
            final String password = scanner.nextLine();
            checkValidatorRules(passwordValidators, password);

            storage.store(name, password);
        } catch (ValidateNameException e) {
            System.out.println("Ошибка валидации имени: " + e.getMessage());
        } catch (ValidatePasswordException e) {
            System.out.println("Ошибка валидации пароля: " + e.getMessage());
        } catch (ValidateException e) {
            System.out.println("Ошибка валидации: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Ошибка работы с хранилищем: " + e.getMessage());
        } finally {
            storage.close();
        }
    }

    private static void showUserPassword() {
        final PasswordStorage storage = new PasswordMemoryStorage();
        try {
            storage.open();
            System.out.println("Введите имя пользователя => ");
            final String name = scanner.nextLine();
            checkValidatorRules(nameValidators, name);

            final String password = storage.get(name);
            System.out.printf("Пароль пользователя %s = %s%n", name, password);
        } catch (ValidateNameException e) {
            System.out.println("Ошибка валидации имени: " + e.getMessage());
        } catch (ValidateException e) {
            System.out.println("Ошибка валидации: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Ошибка работы с хранилищем: " + e.getMessage());
        } finally {
            storage.close();
        }
    }

    private static String getAction() {
        System.out.println("1 - добавить пользователя с паролем");
        System.out.println("2 - отобразить пароль пользователя");
        System.out.println("другие символы - выход");
        System.out.println("Выберите действие => ");
        return scanner.nextLine();
    }
}
