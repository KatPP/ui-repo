package sprint5.animaltask;

public abstract class Pet {
    private int pawsCount = 4;

    public Pet(int pawsCount) {
        this.pawsCount = pawsCount;
    }

    public void sleep() {
        System.out.println("Сплю");
    }

    public void play() {
        System.out.println("Играю");
    }

    public void giveVoice() {}

    public int getPawsCount() {
        return pawsCount;
    }
}
