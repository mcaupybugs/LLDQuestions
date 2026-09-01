package TaskManager;

public interface TaskState {
    void moveToToDo(Task task);
    void moveToInProgress(Task task);
    void moveToDone(Task task);
    String getName();
}