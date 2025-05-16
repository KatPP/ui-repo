package sprint5.math;

public class Square extends Rectangle {
    // Длина стороны квадрата
    private final double a;

    public Square(double a) {
        super(a, a);
        this.a = a;
    }

    @Override
    public double getArea() {
        return a * a;
    }
}
