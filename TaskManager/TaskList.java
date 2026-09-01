package TaskManager;

import java.util.*;

public class TaskList {
    private final String taskListId;
    private List<Task> tasks;
    private String name;
    public TaskList(String taskListId, List<Task> tasks, String name){
        this.taskListId = taskListId;
        this.tasks = tasks == null ? new ArrayList<>() : tasks;
        this.name = name;
    }

    public String getTaskListId() {
        return taskListId;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public String getName() {
        return name;
    }

    public void addTask(Task task) {
        if (task != null && !contains(task.getTaskId())) {
            tasks.add(task);
        }
    }

    public boolean contains(String taskId){
        for(Task task: tasks){
            if(task.getTaskId().equals(taskId)){
                return true;
            }
        }
        return false;
    }

    public void remove(String taskId){
        Task removeTask = null;
        for(Task task: tasks){
            if(task.getTaskId().equals(taskId)){
                removeTask = task;
            }
        }
        tasks.remove(removeTask);
    }
}
