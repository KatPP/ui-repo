package sprint5.polimorph;

// допишите реализацию класса Smartphone
public class Smartphone extends MobilePhone {

    public void sendEmail(String messageText, String email) {
        System.out.println("Напишем другу сообщение " + messageText + " по email " + email);
    }
    public Smartphone(String number) {
        super(number);
    }

    public void makeCall(String targetNumber, String appName)  {
        System.out.println("Позвоним через приложение " + appName + " по номеру " + targetNumber);
        System.out.println("Набираем номер " + targetNumber + " и звоним по сотовой связи");
        System.out.println("Привет!");
    }
}
