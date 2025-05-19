package sprint5.ipoteka;

// Дополните базовый класс для всех правил валидации
public abstract class ValidationRule<T> {

        protected final T value;
        private final String errorMessage; // Исправлено: errorMessage должен быть String

        protected ValidationRule(T value, String errorMessage) { // Исправлено: errorMessage должен быть String
            this.value = value;
            this.errorMessage = errorMessage;
        }


    public abstract boolean isValid();

    public String getErrorMessage() {
        return errorMessage;
    }
}