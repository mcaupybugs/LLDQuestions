package TaskManager;

public class DoneState implements TaskState {
    @Override
    public void moveToToDo(Task task) {
        task.changeState(new ToDoState());
    }

    @Override
    public void moveToInProgress(Task task) {
        throw new IllegalStateException("Completed task cannot move back to IN_PROGRESS directly");
    }

    @Override
    public void moveToDone(Task task) {
        throw new IllegalStateException("Task is already in DONE state");
    }

    @Override
    public String getName() {
        return "DONE";
    }
}