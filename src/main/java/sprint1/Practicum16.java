package sprint1;

/**
 * По мнению Джеффа Безоса, основателя и главы компании Amazon, идеальная встреча — это встреча, для проведения которой хватит двух пицц.
 * Помогите Джеффу вычислить, сколько человек можно позвать на встречу, исходя из количества кусочков пиццы на каждого.
 * Также определите, останется ли ещё пицца после того, как все разойдутся.
 * Исходные данные узнайте у пользователя: на сколько кусков порезана одна пицца и сколько кусков пиццы съедает один участник встречи.
 * Вам нужно дополнить реализацию программы с учётом этих данных.
 */

import java.util.Scanner;

public class Practicum16 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("На сколько кусков порезана пицца?");
        int slicesInPizza = scanner.nextInt();
        System.out.println("Сколько кусков съедает один участник встречи?");
        int slicesToPerson = scanner.nextInt();
        int numOfPizzas = 2;
        int totalSlices = numOfPizzas * slicesInPizza;
        int maximumPeopleToMeeting = totalSlices / slicesToPerson; // получим максимальное кол-во людей
        int leftSlices = totalSlices % maximumPeopleToMeeting;
        System.out.println("Максимальное число участников идеальной встречи: " + maximumPeopleToMeeting);
        System.out.println("Останется кусков пиццы: " + leftSlices);
    }
}
