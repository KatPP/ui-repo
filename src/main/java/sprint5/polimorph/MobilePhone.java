package sprint5.polimorph;

public class MobilePhone extends Phone {

    public void sendSms(String messageText, int targetNumber) {
        System.out.println("Отправляем сообщение " + messageText + " по номеру " + targetNumber);
    }

    public MobilePhone(String number) {
        super(number);
    }
}
