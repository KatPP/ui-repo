package sprint7.taskfiles;

/**
 * Вам нужно создать файловый менеджер. Приложение должно уметь:
 * просматривать содержимое директории;
 * создавать файлы и директории;
 * переименовывать файлы или директории;
 * полностью перемещать файлы или директории;
 * удалять файлы или директории.
 * Пользователю необходимо выбрать, какую операцию он хочет выполнить с файлом или папкой,
 * а затем ввести путь к нужному файлу, дополнительные данные, если они требуются для выполнения программы.
 * Программа должна обрабатывать случаи, когда указанный файл или директория не существуют.
 */

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class Practicum78 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            String command = scanner.nextLine();

            if (command.equals("exit")) {
                System.out.println("Выход.");
                break;
            }

            System.out.println("Введите путь к файлу/директории: ");
            String enteredPath = scanner.nextLine();
            Path path = Paths.get(enteredPath);

            switch (command) {
                case "ls":
                    if (Files.exists(path) && Files.isDirectory(path)) {
                        try {
                            for (String element : path.toFile().list()) {
                                System.out.println(element);
                            }
                        } catch (Exception e) {
                            System.out.println("Ошибка при запросе содержимого директории.");
                        }
                    } else {
                        System.out.println("Указанная директория не существует.");
                    }
                    break;

                case "mkdir":
                    try {
                        Files.createDirectory(path);
                        System.out.println("Директория успешно создана.");
                    } catch (IOException e) {
                        System.out.println("Ошибка при создании директории.");
                    }
                    break;

                case "touch":
                    if (Files.exists(path)) {
                        System.out.println("Файл уже существует.");
                    } else {
                        try {
                            Files.createFile(path);
                            System.out.println("Файл успешно создан.");
                        } catch (IOException e) {
                            System.out.println("Ошибка при создании файла.");
                        }
                    }
                    break;

                case "rename":
                    if (Files.exists(path)) {
                        System.out.println("Введите новое имя файла/директории: ");
                        String newName = scanner.nextLine();
                        Path newPath = path.resolveSibling(newName);

                        try {
                            Files.move(path, newPath, StandardCopyOption.REPLACE_EXISTING);
                            System.out.println("Файл/директория успешно переименованы.");
                        } catch (IOException e) {
                            System.out.println("Ошибка при переименовании.");
                        }
                    } else {
                        System.out.println("Файл/директория не найдены.");
                    }
                    break;

                case "rm_file":
                    try {
                        if (!Files.isDirectory(path)) {
                            Files.deleteIfExists(path);
                            System.out.println("Файл удалён.");
                        } else {
                            System.out.println("Эта команда удаляет только файлы!");
                        }
                    } catch (IOException e) {
                        System.out.println("Ошибка при удалении файла.");
                    }
                    break;

                default:
                    System.out.println("Неизвестная команда.");
            }
        }
        scanner.close();
    }

    public static void printMenu() {
        System.out.println("Что вы хотите сделать? ");
        System.out.println("ls - посмотреть содержимое директории.");
        System.out.println("mkdir - создать директорию.");
        System.out.println("touch - создать файл.");
        System.out.println("rename - переименовать директорию/файл.");
        System.out.println("rm_file - удалить файл.");
        System.out.println("exit - выход.");
    }
}