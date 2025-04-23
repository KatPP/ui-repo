package sprint2;

public class Practicum2 {
    public static void main(String[] args) {
        // ниже вызовите новый метод
        String highestGrossingFilm = findHighestGrossingFilm();
        System.out.println("Самый кассовый фильм: " + highestGrossingFilm);
    }

    public static String findHighestGrossingFilm() {
        String film1 = "Титаник";
        int income1 = 2194;

        String film2 = "Аватар";
        int income2 = 2810;

        String film3 = "Тёмный рыцарь";
        int income3 = 1084;


        String result = null;
        if (income1 > income2 && income1 > income3) {
                result = film1;
            } else if (income2 > income1 && income2 > income3) {
                result = film2;
            } else if (income3 > income1 && income3 > income2) {
                result = film3;
        } 
        return result;
    }


}
