package TaskManager;

public interface TaskObserver {
    void update(Task task, String message);
}