package sprint10.lombok;

// Интерфейс для сохранения и получения данных о пользователе
public interface Storage {
    void put(User user);
    User get(String email);
}