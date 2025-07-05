package sprint7;

import java.util.Arrays;
import java.util.List;

public class Practicum79 {
    public static void main(String[] args) {
        List<Circle> circles = Arrays.asList(
                new Circle(3, 5, 12),
                new Circle(1, -2, 4),
                new Circle(8, 8, 8),
                new Circle(5, 1, 8)
        );

        circles.sort((Circle circle1, Circle circle2) -> {
            // Сначала сравниваем радиусы
            if (circle1.getRadius() < circle2.getRadius()) {
                return -1; // первый круг должен быть раньше
            } else if (circle1.getRadius() > circle2.getRadius()) {
                return 1; // первый круг должен быть позже
            } else {
                // Если радиусы равны, сравниваем сумму координат
                int sum1 = circle1.getCenterX() + circle1.getCenterY();
                int sum2 = circle2.getCenterX() + circle2.getCenterY();
                if (sum1 < sum2) {
                    return -1;
                } else if (sum1 > sum2) {
                    return 1;
                } else {
                    return 0; // если суммы координат тоже равны
                }
            }
        });

        for (Circle circle : circles) {
            System.out.println(circle);
        }
    }
}

class Circle {
    private int centerX;
    private int centerY;
    private int radius;

    public Circle(int centerX, int centerY, int radius) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public int getCenterX() {
        return centerX;
    }

    public int getCenterY() {
        return centerY;
    }

    @Override
    public String toString() {
        return "Радиус окружности: " + radius
                + ", координаты: "
                + centerX
                + ", "
                + centerY;
    }
}