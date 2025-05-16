package sprint4.proriter;

public class Task {
    TaskPriority priority;// добавьте переменную priority с приоритетом задачи
    private final String description;

    public Task(TaskPriority priority, String description) {
        this.priority = priority;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public TaskPriority getPriority() {
        return priority;
    }
}
