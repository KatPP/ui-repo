package sprint4.forest;

import java.util.ArrayList;

class Forest {
    private ArrayList<MountainHare> hares;
    private static String season;

    public Forest(ArrayList<MountainHare> hares) {
        this.hares = hares;
    }

    public static void setSeason(String newSeason) {
        season = newSeason;
        if ("зима".equals(newSeason)) {
            MountainHare.color = "белый";
        } else {
            MountainHare.color = "серо-рыжий";
        }
    }

    void printHares() {
        for (MountainHare hare : hares) {
            System.out.println(hare);
        }
    }
}
