package TaskManager;

public class InProgressState implements TaskState {
    @Override
    public void moveToToDo(Task task) {
        task.changeState(new ToDoState());
    }

    @Override
    public void moveToInProgress(Task task) {
        throw new IllegalStateException("Task is already in IN_PROGRESS state");
    }

    @Override
    public void moveToDone(Task task) {
        task.changeState(new DoneState());
    }

    @Override
    public String getName() {
        return "IN_PROGRESS";
    }
}