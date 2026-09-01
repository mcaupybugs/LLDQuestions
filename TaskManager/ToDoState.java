package TaskManager;

public class ToDoState implements TaskState {
    @Override
    public void moveToToDo(Task task) {
        throw new IllegalStateException("Task is already in TODO state");
    }

    @Override
    public void moveToInProgress(Task task) {
        task.changeState(new InProgressState());
    }

    @Override
    public void moveToDone(Task task) {
        throw new IllegalStateException("Cannot move directly from TODO to DONE");
    }

    @Override
    public String getName() {
        return "TODO";
    }
}