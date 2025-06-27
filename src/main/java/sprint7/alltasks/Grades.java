package sprint7.alltasks;

/**
 * Настройте программу по учёту школьных оценок. На вход подаётся строка, один элемент которой имеет вид <имя, фамилия, предмет, оценка>. Между собой элементы разделяются с помощью символа ";".
 * К примеру:
 * "вероника,чехова,ФИЗИКА,5;анна,строкова,МАТЕМАТИКА,4;иван,петров,ГЕОМЕТРИЯ,5"
 * Нужно вывести на экран отдельные строки вида "Имя Фамилия предмет — Оценка". При этом нужно учесть, что
 * Имя и фамилия должны начинаться с большой буквы — здесь вам поможет метод String capitalize(String str), который вы написали ранее.
 * Название предмета должно состоять из строчных букв.
 * Оценка должна быть преобразована в текст. Соответствующий метод String gradeToString(String grade) уже реализован в прекоде.
 * Оценка должна быть отделена от предмета длинным тире '—'. Скопируйте символ в код и не забудьте добавить по пробелу с каждой стороны.
 * Выходные данные должны получиться такими:
 * Вероника Чехова физика — Безупречно
 * Анна Строкова математика — Потрясающе
 * Иван Петров геометрия — Безупречно
 */

public class Grades {

    private String capitalize(String str) {
        return str.substring(0,1).toUpperCase() + str.substring(1);
    }

    private String gradeToString(String grade) {
        switch (grade) {
            case "5" -> {
                return "Безупречно";
            }
            case "4" -> {
                return "Потрясающе";
            }
            case "3" -> {
                return "Восхитительно";
            }
            case "2" -> {
                return "Прекрасно";
            }
            default -> {
                return "Очаровательно";
            }
        }
    }

    // grades - строка вида "имя,фамилия,предмет,оценка;имя,фамилия,предмет,оценка;"
    public void gradeBeautifier(String grades) {
        if (grades == null || grades.isEmpty()) {
            return;
        }

        // Разделяем записи о разных студентах
        String[] students = grades.split(";");

        for (String student : students) {
            if (student.isEmpty()) continue;

            // Разделяем данные студента
            String[] data = student.split(",");
            if (data.length < 4) continue;

            // Обрабатываем каждое поле
            String firstName = capitalize(data[0].trim());
            String lastName = capitalize(data[1].trim());
            String subject = data[2].trim().toLowerCase();
            String grade = gradeToString(data[3].trim());

            // Формируем итоговую строку
            System.out.println(firstName + " " + lastName + " " + subject + " — " + grade);
        }
    }


}
