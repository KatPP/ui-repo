package sprint5.animaltask;

public class Hamster extends Pet {
    protected Hamster() {
        super(4);
    }

    public void hideFood(){
        System.out.println("Вся еда — в щёчках!");
    }
}
