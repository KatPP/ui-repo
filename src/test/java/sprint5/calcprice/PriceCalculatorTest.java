package sprint5.calcprice;

/**
 *
 * Вам нужно доработать тесты для класса PriceCalculator по расчёту стоимости доставки в зависимости от расстояния и типа транспорта.
 * Когда класс только разрабатывался, поддерживался единственный тип транспорта — велосипед (BIKE). К сожалению, тестированию тогда внимания не уделялось, и был написан всего один тест.
 * Теперь к обрабатываемым типам транспорта добавились легковая машина (CAR) и фура (TRUCK). Также есть пока что неиспользуемый тип транспорта — квадрокоптер (DRONE).
 * Вам нужно доработать тесты для велосипеда, машины, фуры и квадрокоптера в соответствии с правилами:
 * Доставка осуществляется только на расстояния больше 0 км.
 * На велосипеде можно доставлять грузы на расстояние до 20 км (включительно). Стоимость доставки задана через переменную-константу BIKE_PRICE_PER_KM.
 * Машина может доставлять грузы на расстояние до 1000 км (включительно). Стоимость доставки задана через переменную-константу CAR_PRICE_PER_KM.
 * Грузовик может доставлять грузы на любые расстояния. Стоимость доставки задана через переменную-константу TRUCK_PRICE_PER_KM.
 * В случае выхода за границы доставки для определённого транспорта возвращаем отрицательное значение.
 * Доставка на квадрокоптере не поддерживается. В случае попытки рассчитать для него доставку возвращаем null.
 * Вам требуется определить необходимый минимальный набор тестов, чтобы полностью проверить корректность программы и написать эти тесты.
 *
 *
 * Объяснение тестов:
 * Для велосипеда (BIKE):
 * Проверка нулевой дистанции (должен вернуть отрицательное значение)
 * Проверка дистанции больше максимальной (21 км)
 * Проверка корректного расчета для граничного значения (20 км)
 *
 * Для автомобиля (CAR):
 * Проверка нулевой дистанции
 * Проверка дистанции больше максимальной (1001 км)
 * Проверка корректного расчета для граничного значения (1000 км)
 *
 * Для грузовика (TRUCK):
 * Проверка нулевой дистанции
 * Проверка корректного расчета для большой дистанции (1000 км)
 * (Не включен тест для дистанции > 1000 км, так как для грузовика нет ограничений)
 *
 * Для квадрокоптера (DRONE):
 * Проверка что возвращается null для любого расстояния
 * Все тесты используют:
 * assertEquals для проверки точных значений в позитивных сценариях
 * assertTrue(< 0) для проверки ошибок при недопустимых расстояниях
 * assertNull для проверки неподдерживаемого типа транспорта
 * Граничные значения выбраны согласно требованиям:
 * Для велосипеда: 0, 20, 21
 * Для автомобиля: 0, 1000, 1001
 * Для грузовика: 0 и большое значение (1000)
 */

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PriceCalculatorTest {
    private final PriceCalculator priceCalculator = new PriceCalculator();

    // Bike tests
    @Test
    public void shouldBeNegativeWhenBikeAndDistanceIs0Km() {
        Assertions.assertTrue(priceCalculator.calculatePrice(TransportType.BIKE, 0) < 0);
    }

    @Test
    public void shouldBeNegativeWhenBikeAndDistanceIs21Km() {
        Assertions.assertTrue(priceCalculator.calculatePrice(TransportType.BIKE, 21) < 0);
    }

    @Test
    public void shouldReturn200ForBikeAndDistanceIs20Km() {
        int price = priceCalculator.calculatePrice(TransportType.BIKE, 20);
        Assertions.assertEquals(200, price);
    }

    // Car tests
    @Test
    public void shouldBeNegativeWhenCarAndDistanceIs0Km() {
        Assertions.assertTrue(priceCalculator.calculatePrice(TransportType.CAR, 0) < 0);
    }

    @Test
    public void shouldBeNegativeWhenCarAndDistanceIs1001Km() {
        Assertions.assertTrue(priceCalculator.calculatePrice(TransportType.CAR, 1001) < 0);
    }

    @Test
    public void shouldReturn7000ForCarAndDistanceIs1000Km() {
        int price = priceCalculator.calculatePrice(TransportType.CAR, 1000);
        Assertions.assertEquals(7000, price);
    }

    // Truck tests
    @Test
    public void shouldBeNegativeWhenTruckAndDistanceIs0Km() {
        Assertions.assertTrue(priceCalculator.calculatePrice(TransportType.TRUCK, 0) < 0);
    }

    @Test
    public void shouldReturn5000ForTruckAndDistanceIs1000Km() {
        int price = priceCalculator.calculatePrice(TransportType.TRUCK, 1000);
        Assertions.assertEquals(5000, price);
    }

    // Drone test
    @Test
    public void shouldReturnNullForDrone() {
        Integer price = priceCalculator.calculatePrice(TransportType.DRONE, 10);
        Assertions.assertNull(price);
    }
}