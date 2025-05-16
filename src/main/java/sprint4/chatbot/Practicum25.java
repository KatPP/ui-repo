package sprint4.chatbot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Practicum25 {
    // объявите поле для ссылки на карту (англ. map link)
    public static final String MAP_LINK = "https://recyclemap.ru/";
    final static int MAX_COEF = 15;
    final static int MIN_COEF = 10;
    public static final ArrayList<RecyclableMaterial> materials = getMaterials();
    public static final HashMap<MaterialType, String> containers = getContainers();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        printMenu();


        String commandValue = scanner.nextLine().trim();
        /* в зависимости от команды выполните следующие действия:
           map - вывести на экран ссылку на карту;
           recyclability - 1. напечатать сообщение "Введите код переработки:",
                           2. добавить ввод кода (целое число),
                           3. вызвать метод isRecycled;
           bonus - 1. напечатать сообщение "Введите количество вторсырья, кг:",
                   2. добавить ввод значения,
                   3. рассчитать бонус, умножив вес на коэффициент:
                       если вес меньше 10 кг, то коэффициент 10, иначе - 15,
                   4. вывести сообщение "Количество бонусных баллов: <баллы>."
        */
        if(commandValue.equalsIgnoreCase(ChatCommand.MAP.name())) {
            System.out.println(MAP_LINK);
        } else if (commandValue.equalsIgnoreCase(ChatCommand.RECYCLABILITY.name())) {
            System.out.println("Введите код переработки:");
            int code = scanner.nextInt();
            isRecycled(code);
        } else if (commandValue.equalsIgnoreCase(ChatCommand.BONUS.name())) {
            System.out.println("Введите количество вторсырья, кг:");
            int weight = Integer.parseInt(scanner.nextLine());
            int res;
            if (weight < 10) {
                res = weight * MIN_COEF;
            } else {
                res = weight * MAX_COEF;
            }
            System.out.println("Количество бонусных баллов: " + res + ".");
        }

    }

    // добавьте модификаторы в заголовок метода
    public static void isRecycled(int code) {
        for (RecyclableMaterial material : materials) {
            if (material.getCode() == code) {
                System.out.print("Это " + material.getDescription() + ". ");
                if (material.isRecyclable()) {
                    System.out.println("Положите его в контейнер с типом «" + containers.get(material.getType()) + "».");
                } else {
                    System.out.println("Он не подходит для вторичной переработки.");
                }
                return;
            }
        }
        System.out.println("Материал с таким кодом не найден.");
    }

    // добавьте модификаторы в заголовок метода
    public static HashMap<MaterialType, String> getContainers() {
        HashMap<MaterialType, String> containers = new HashMap<>();
        containers.put(MaterialType.PLASTIC, "Пластик");
        containers.put(MaterialType.METAL, "Металл");
        containers.put(MaterialType.GLASS, "Стекло");
        containers.put(MaterialType.PAPER, "Бумага");
        containers.put(MaterialType.UNSORTED_WASTE, "Общий мусор");

        return containers;
    }

    public static void printMenu() {
        System.out.println("Введите одну из команд: ");
        System.out.println(ChatCommand.MAP + " - посмотреть карту с пунктами приёма вторсырья.");
        System.out.println(ChatCommand.RECYCLABILITY + " - проверить по коду на упаковке, подходит ли материал для переработки.");
        System.out.println(ChatCommand.BONUS + " - рассчитать количество бонусных баллов.");
    }

    public static ArrayList<RecyclableMaterial> getMaterials() {
        ArrayList<RecyclableMaterial> materials = new ArrayList<>();

        materials.add(new RecyclableMaterial(1, MaterialType.PLASTIC, true, "полиэтилентерфталат"));
        materials.add(new RecyclableMaterial(2, MaterialType.PLASTIC, true, "полиэтилен высокой плотности"));
        materials.add(new RecyclableMaterial(3, MaterialType.PLASTIC, false, "поливинилхлорид"));
        materials.add(new RecyclableMaterial(4, MaterialType.PLASTIC, true, "полиэтилен низкой плотности"));
        materials.add(new RecyclableMaterial(5, MaterialType.PLASTIC, true, "полипропилен"));
        materials.add(new RecyclableMaterial(6, MaterialType.PLASTIC, false, "полистирол"));
        materials.add(new RecyclableMaterial(7, MaterialType.PLASTIC, false, "другие виды пластика"));
        materials.add(new RecyclableMaterial(20, MaterialType.PAPER, true, "гофрированный картон"));
        materials.add(new RecyclableMaterial(21, MaterialType.PAPER, true, "прочий картон"));
        materials.add(new RecyclableMaterial(22, MaterialType.PAPER, true, "бумага"));
        materials.add(new RecyclableMaterial(
                23, MaterialType.PAPER, false, "полиграфический картон (открытки, обложки книг и т.д.)"));
        materials.add(new RecyclableMaterial(40, MaterialType.METAL, true, "железо"));
        materials.add(new RecyclableMaterial(41, MaterialType.METAL, true, "алюминий"));
        materials.add(new RecyclableMaterial(70, MaterialType.GLASS, true, "бесцветное стекло"));
        materials.add(new RecyclableMaterial(71, MaterialType.GLASS, true, "зеленое стекло"));
        materials.add(new RecyclableMaterial(72, MaterialType.GLASS, true, "коричневое стекло"));
        materials.add(new RecyclableMaterial(73, MaterialType.GLASS, true, "бутылочное стекло (тёмно-коричневое)"));
        materials.add(new RecyclableMaterial(74, MaterialType.GLASS, true, "бутылочное стекло (светло-коричневое)"));
        materials.add(new RecyclableMaterial(75, MaterialType.GLASS, false, "стекло с малым содержанием свинца"));
        materials.add(new RecyclableMaterial(76, MaterialType.GLASS, false, "хрусталь"));
        materials.add(new RecyclableMaterial(
                77, MaterialType.GLASS, false, "стекло, покрытое медью (электроника, часы)"));
        materials.add(new RecyclableMaterial(
                78, MaterialType.GLASS, false, "стекло, покрытое серебром (зеркало, посуда для сервировки)"));
        materials.add(new RecyclableMaterial(
                79, MaterialType.GLASS, false, "позолоченное стекло (посуда для сервировки)"));

        return materials;
    }
}
