package sprint4.forest;

/**
 * Перед вами кусок кода компьютерной игры про Средневековье.
 * В ней есть много разных локаций, в том числе — смешанные леса с хвойными и лиственными деревьями.
 * Вам нужно создать симулятор такого леса, поселить в нём зайцев-беляков.
 * Обратите внимание, что цвет шерсти у всех зайцев  color меняется в зависимости от времени года season: зимой — белый, летом — серо-рыжий.
 */

import java.util.ArrayList;

public class Practicum18 {
    public static void main(String[] args) {
        ArrayList<MountainHare> hares = new ArrayList<>();
        hares.add(new MountainHare(4, 4.4, 120));
        hares.add(new MountainHare(7, 3.6, 150));
        hares.add(new MountainHare(1, 2.3, 100));

        System.out.println("В лесу лето!");
        Forest.setSeason("лето");
        Forest forest = new Forest(hares);
        System.out.println("Список зайцев:");
        forest.printHares();

        System.out.println("В лесу зима!");
        Forest.setSeason("зима");
        System.out.println("Список зайцев:");
        forest.printHares();
    }

}
