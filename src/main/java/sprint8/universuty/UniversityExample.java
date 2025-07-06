package sprint8.universuty;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Частный университет решил автоматизировать процесс завершения студентами обучения.
 * Для студентов, которые не планируют дальше учиться, выполняются следующие действия:
 * Проверяется, сдал ли студент экзамен.
 * Указывается группа, где учился студент (на основе года начала обучения).
 * В список клуба выпускников добавляется email студента.
 * Для решения этой задачи используются стрим и лямбда-функции.
 * Ваша задача — реализовать недостающие функции так, чтобы поддержать логику кода.
 * Обратите внимание — вам придётся использовать механизм замыканий, поскольку список названий групп и
 * список клуба выпускников, с которыми вам придётся работать в лямбда-функциях, определены в теле метода main.
 */

public class UniversityExample {

    public static void main(String[] args) {
        //множество студентов, успешно сдавших экзамен
        Set<String> examPassedNames = new HashSet<>();
        examPassedNames.add("Иванов Иван");
        examPassedNames.add("Практикумова Яна");

        //соответствие года поступления и названия группы
        Map<Integer, String> groupNames = new HashMap<>();
        groupNames.put(2020, "2020-ГР1");
        groupNames.put(2021, "2021-ГР0");

        //список с адресами email выпускников
        List<String> graduatesClub = new ArrayList<>();

        //студенты, планирующие завершить обучение
        List<Student> students = new ArrayList<>();
        students.add(new Student("Практикумова", "Яна", "yana@yandex.ru", 2021));
        students.add(new Student("Иванов", "Иван", "ivan_ivanov@mail.ru", 2020));
        students.add(new Student("Сергеев", "Дмитрий", "iamdmitry@gmail.com", 2021));

        List<Student> graduatedStudents = students.stream()
                // 1. Оставить только сдавших экзамен
                .filter(student -> examPassedNames.contains(student.surname + " " + student.name))
                // 2. Добавить название группы
                .map(student -> {
                    student.groupName = groupNames.get(student.entranceYear);
                    return student;
                })
                // 3. Добавить email в клуб выпускников
                .peek(student -> graduatesClub.add(student.email))
                // 4. Собрать результат
                .collect(Collectors.toList());

        for (Student student : graduatedStudents) {
            System.out.println(student);
        }

        for (String email : graduatesClub) {
            System.out.println(email);
        }

    }
}

class Student {
    String surname;
    String name;
    String email;
    int entranceYear;
    String groupName;

    public Student(String surname, String name, String email, int entranceYear) {
        this.surname = surname;
        this.name = name;
        this.email = email;
        this.entranceYear = entranceYear;
    }

    @Override
    public String toString() {
        return "Student{" +
                "surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", entranceYear=" + entranceYear +
                ", groupName='" + groupName + '\'' +
                '}';
    }
}
