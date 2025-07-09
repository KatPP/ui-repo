package sprint8.data;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * В компании ООО «Ретроградный Меркурий» для улучшения планирования решили использовать ретроанализ: определять, сколько по времени будет выполняться задача,
 * если известно, во сколько она была начата и закончена в прошлый раз. Восстановите пропущенные участки кода. Воспользуйтесь классом DateTimeFormatter,
 * чтобы выводить время в формате часы:минуты (например, 12:34).
 */

public class Practicum85 {
    public static void main(String[] args) {
        // время начала работы над задачей — 9:00
        LocalTime taskStart = LocalTime.of(9, 0);
        // время окончания работы над задачей — 11:30
        LocalTime taskFinish = LocalTime.of(11, 30);

        // опишите формат вывода в виде часы:минуты
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        // найдите продолжительность между двумя единицами времени
        Duration duration = Duration.between(taskStart, taskFinish);

        // taskStart должен быть выведен в указанном формате
        System.out.println("В прошлый раз задача была начата в " + taskStart.format(formatter) + ",");
        // taskFinish должен быть выведен в указанном формате
        System.out.println("а закончена в " + taskFinish.format(formatter) + ".");

        LocalTime now = LocalTime.now();
        // now должен быть выведен в указанном формате
        System.out.println("Сейчас " + now.format(formatter) + ".");

        // прибавьте к текущему моменту вычисленную продолжительность
        LocalTime finishTime = now.plus(duration);

        // finishTime должен быть выведен в указанном формате
        System.out.println("Значит, задача будет выполнена к " + finishTime.format(formatter) + ".");
    }
}
