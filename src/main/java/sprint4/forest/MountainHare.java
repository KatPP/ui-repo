package sprint4.forest;

class MountainHare {
    int age;
    double weight;
    int jumpLength;
    static String color;

    public MountainHare(int age, double weight, int jumpLength) {
        this.age = age;
        this.weight = weight;
        this.jumpLength = jumpLength;
    }

    @Override
    public String toString() {
        return "Заяц-беляк: age=" + age + ", weight=" + weight + ", jumpLength=" + jumpLength + ", color=" + color;
    }
}