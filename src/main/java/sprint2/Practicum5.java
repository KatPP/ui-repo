package sprint2;

/**
 * Кот Пиксель очень любит играть с мячиками — всего их у него 15. Днём он повсюду их прячет (число спрятанных мячиков считывается из консоли), но вечером всегда возвращает на место.
 * Расставьте переменные balls и hiddenBalls в коде так, чтобы программа смогла правильно посчитать количество мячиков у Пикселя до начала игры, во время неё и в конце дня.
 */

import java.util.Scanner;

public class Practicum5 {

    public static void main(String[] args) {
        int balls = 15; // сохраните общее число мячиков Пикселя в переменной balls

        System.out.println("У Пикселя " + balls + " мячиков");

        playPixel(balls);// поиграйте с Пикселем, вызвав метод playPixel

        // после игры Пиксель должен вернуть все мячики на место!
        System.out.println("Пиксель вернул все мячики");
        System.out.println("Их снова " + balls);
    }

    public static void playPixel(int balls) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Сколько мячиков спрятал Пиксель?");
        int hiddenBalls = scanner.nextInt();  // сохраните количество мячиков, которые спрятал Пиксель, в переменную hiddenBalls

        balls = balls - hiddenBalls; // посчитайте, сколько у Пикселя осталось мячиков
        System.out.println("Осталось " + balls);
    }
}
