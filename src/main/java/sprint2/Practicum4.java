package sprint2;

/**
 * Объявите и реализуйте метод findMaxExpense — он должен находить в списке расходов за неделю самую большую трату и возвращать её значение.
 * В качестве единственного параметра этого метода укажите массив расходов expenses.
 */

public class Practicum4 {
    public static void main(String[] args) {
        double[] expenses = {1772.5, 367.0, 120.6, 2150.2, 874.0, 1.0, 1459.4};
        double maxExpense = findMaxExpense(expenses); // вызовите метод и присвойте maxExpense значение его результата
        System.out.println("Самая большая трата недели " + maxExpense);
    }

    public static double findMaxExpense(double[] doubles) {
        double maxExpense = doubles[0]; // Принимаем первый элемент за максимальный

        // Перебираем все элементы массива, начиная со второго
        for (int i = 1; i < doubles.length; i++) {
            // Если текущий элемент больше сохранённого максимума
            if (doubles[i] > maxExpense) {
                // Обновляем значение максимума
                maxExpense = doubles[i];
            }
        }
        return maxExpense;
    }
}
