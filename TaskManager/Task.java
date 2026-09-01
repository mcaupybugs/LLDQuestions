package TaskManager;

import java.util.*;

public class Task {
    private final String taskId;
    private String title;
    private String description;
    private Date dueDate;
    private int priority;
    private TaskState taskState;
    private List<Task> subTasks;
    private List<ActivityLog> activityLogs;
    private List<Comment> comments;
    private User createdBy;
    private User assignedTo;
    private List<TaskObserver> observers;

    public Task(String task, String title, String description, Date dueDate, int priority){
        this.taskState = new ToDoState();
        this.taskId = task;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.priority = priority;
        this.subTasks = new ArrayList<>();
        this.activityLogs = new ArrayList<>();
        this.comments = new ArrayList<>();
        this.observers = new ArrayList<>();
    }

    public void addObserver(TaskObserver observer) {
        if (observer != null && !observers.contains(observer)) {
            observers.add(observer);
        }
    }

    public void removeObserver(TaskObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers(String message) {
        for (TaskObserver observer : observers) {
            observer.update(this, message);
        }
    }

    public void addActivity(String description) {
        activityLogs.add(new ActivityLog(description, new Date()));
    }

    public User getAssignedUser(){
        return assignedTo;
    }

    public String getTaskId() {
        return taskId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        addActivity("Task title updated");
        notifyObservers("Task title updated");
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
        addActivity("Task description updated");
        notifyObservers("Task description updated");
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
        addActivity("Task due date updated");
        notifyObservers("Task due date updated");
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
        addActivity("Task priority updated to " + priority);
        notifyObservers("Task priority updated to " + priority);
    }

    public TaskState getTaskState() {
        return taskState;
    }

    public void changeState(TaskState taskState) {
        this.taskState = taskState;
        addActivity("Task state changed to " + taskState.getName());
        notifyObservers("Task state changed to " + taskState.getName());
    }

    public void moveToToDo() {
        taskState.moveToToDo(this);
    }

    public void moveToInProgress() {
        taskState.moveToInProgress(this);
    }

    public void moveToDone() {
        taskState.moveToDone(this);
    }

    public List<Task> getSubTasks() {
        return subTasks;
    }

    public void setSubTasks(List<Task> subTasks) {
        this.subTasks = subTasks;
    }

    public void addSubTask(Task subTask) {
        if (subTask != null) {
            subTasks.add(subTask);
            addActivity("Subtask added: " + subTask.getTaskId());
        }
    }

    public List<ActivityLog> getActivityLogs() {
        return activityLogs;
    }

    public void setActivityLogs(List<ActivityLog> activityLogs) {
        this.activityLogs = activityLogs;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public void addComment(Comment comment) {
        if (comment != null) {
            comments.add(comment);
            addActivity("Comment added by " + comment.getAddedBy().getName());
            notifyObservers("New comment added to task");
        }
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
        addObserver(createdBy);
        addActivity("Task creator set to " + createdBy.getName());
        notifyObservers("Task creator set to " + createdBy.getName());
    }

    public User getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(User assignedTo) {
        this.assignedTo = assignedTo;
        addObserver(assignedTo);
        addActivity("Task assigned to " + assignedTo.getName());
        notifyObservers("Task assigned to " + assignedTo.getName());
    }

    public List<TaskObserver> getObservers() {
        return observers;
    }

    public void setObservers(List<TaskObserver> observers) {
        this.observers = observers;
    }
}