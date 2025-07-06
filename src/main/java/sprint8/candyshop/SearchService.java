package sprint8.candyshop;

import java.util.Comparator;
import java.util.Objects;
import java.util.Optional;

public class SearchService {
    // Создаём объект класса, отвечающий за склад магазина
    private final Warehouse warehouse = new Warehouse();
    // Создаём объект класса, отвечающий за работу с поставщиками
    public final SRM srm = new SRM();

    // Основной метод поиска
    // Проверяет наличие товара с указанным именем на складе магазина
    // Если товар отсутствует, то проверяются склады поставщиков,
    // предпочтение отдаётся тому поставщику, у которого наименьшая цена товара.
    // Для поиска товара на складе поставщиков используется метод supplierSearch
    // Если товар нигде не найден, то возвращается пустой Optional
    public Optional<Candy> search(String candyName) {
        // Сначала ищем на складе магазина, если не найдено - ищем у поставщиков
        return warehouse.search(candyName)
                .or(() -> supplierSearch(candyName));
    }

    private Optional<Candy> supplierSearch(String candyName) {
        // Получаем список всех поставщиков
        // Для каждого поставщика пытаемся найти конфету
        // Фильтруем null-значения (когда конфета не найдена)
        // Находим конфету с минимальной ценой
        return srm.listSuppliers().stream()
                .map(supplier -> srm.getProduct(supplier, candyName))
                .filter(Objects::nonNull)
                .min(Comparator.comparingDouble(candy -> candy.price));
    }
}
