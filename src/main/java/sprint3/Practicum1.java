package sprint3;

/**
 * Доработайте код программы, которая анализирует погоду за месяц и определяет, был ли он дождливым. Сейчас поля класса WeatherCalendar инициализируются некорректно.
 * Исправьте это. Следует учесть, что:
 *
 * Значения полей month и numberOfDays должны присваиваться в конструкторе. Для этого объявите его с двумя параметрами — monthName и monthNumberOfDays,
 * а при вызове передайте в качестве аргументов значения «Октябрь» и «31».
 *
 * Полям rainyDays и isRainyMonth должны присваиваться значения по умолчанию (сейчас они инициализируются явно).
 *
 * Поле year должно быть проинициализировано при объявлении на уровне класса. Сохраните в него значение 2020.
 *
 * Внутри WeatherCalendar допишите метод addRainyDay() — он увеличивает переменную rainyDays на единицу. Также нужно дописать код условных выражений.
 *
 * Если дождливых дней в месяце больше 15, необходимо присвоить переменной isRainyMonth значение true. Чтобы напечатать сообщение-вывод, нужно обратиться к этой переменной.
 */

public class Practicum1 {
    public static void main(String[] args) {
        WeatherCalendar calendar = new WeatherCalendar("Октябрь", 31);

        String[] octoberWeather = new String[]{
                "Солнечно",
                "Дождь",
                "Пасмурно",
                "Дождь",
                "Дождь",
                "Облачно",
                "Солнечно",
                "Дождь",
                "Пасмурно",
                "Солнечно",
                "Солнечно",
                "Облачно",
                "Солнечно",
                "Дождь",
                "Пасмурно",
                "Солнечно",
                "Солнечно",
                "Облачно",
                "Облачно",
                "Облачно",
                "Облачно",
                "Дождь",
                "Дождь",
                "Облачно",
                "Солнечно",
                "Дождь",
                "Пасмурно",
                "Дождь",
                "Солнечно",
                "Солнечно",
                "Солнечно",
                "Солнечно",
                "Облачно"
        };

        for (int i = 0; i < calendar.numberOfDays; i++) {
            if (octoberWeather[i].equals("Дождь")) {
                calendar.addRainyDay();
            }
        }

        // проверить, был ли месяц дождливым. Если да — установить значение isRainyMonth
        if (calendar.rainyDays > 15 ){
            calendar.isRainyMonth = true;
        }

        System.out.println(calendar.month + " " + calendar.year + " года. "
                + calendar.rainyDays + " дней шёл дождь.");

        // проверить значение isRainyMonth
        if (calendar.isRainyMonth){
            System.out.println("Это был дождливый месяц.");
        } else{
            System.out.println("Этот месяц был довольно сухим.");
        }
    }
}

class WeatherCalendar {
    String month;
    int numberOfDays;
    int year = 2020;
    int rainyDays;
    boolean isRainyMonth;

    public WeatherCalendar(String month, int numberOfDays) {
        this.month = month;
        this.numberOfDays = numberOfDays;
    }

    // увеличить переменную rainyDays на единицу
    public void addRainyDay() {
        rainyDays = rainyDays + 1;
    }
}
