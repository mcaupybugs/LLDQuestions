package TaskManager;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class TaskManagerSystem {
    private final Map<String, User> users;
    private final Map<String, Task> tasks;
    private final Map<String, TaskList> taskLists;
    private final ReminderService reminderService;
    private static TaskManagerSystem taskManagerSystem;

    private TaskManagerSystem(){
        this.users = new ConcurrentHashMap<>();
        this.tasks = new ConcurrentHashMap<>();
        this.taskLists = new ConcurrentHashMap<>();
        this.reminderService = new ReminderService();
    }

    public static synchronized TaskManagerSystem getInstance(){
        if(taskManagerSystem == null){
            taskManagerSystem = new TaskManagerSystem();
        }
        return taskManagerSystem;
    }

    public User createUser(int userId, String userName, String email) {
        User user = new User(userId, userName, email);
        users.put(userName, user);
        return user;
    }

    public User getUser(String userName) {
        return users.get(userName);
    }

    public List<Task> listTaskByUser(String user){
        List<Task> assignedTasks = new ArrayList<>();
        for(Task task : tasks.values()){
            if(task.getAssignedUser() != null && user.equals(task.getAssignedUser().getName())){
                assignedTasks.add(task);
            }
        }
        return assignedTasks;
    }

    public TaskList createTaskList(String taskListId, String taskListName){
        TaskList tsl = new TaskList(taskListId, new ArrayList<>(), taskListName);
        taskLists.put(taskListName, tsl);
        return tsl;
    }

    public List<Task> searchTasks(TaskSearchCriteria taskSearchCriteria, TaskSortStrategy taskSortStrategy){
        List<Task> finalTaskList = new ArrayList<>();
        for(Task task : tasks.values()){
            if(taskSearchCriteria.getAssignedUserId() != null) {
                if(task.getAssignedUser() == null || !taskSearchCriteria.getAssignedUserId().equals(task.getAssignedUser().getName())) {
                    continue;
                }
            }

            if(taskSearchCriteria.getDueDate() != null && !taskSearchCriteria.getDueDate().equals(task.getDueDate())){
                continue;
            }

            if(taskSearchCriteria.getTaskStateName() != null && !task.getTaskState().getName().equalsIgnoreCase(taskSearchCriteria.getTaskStateName())){
                continue;
            }

            if(taskSearchCriteria.getPriority() != null && task.getPriority() != taskSearchCriteria.getPriority()){
                continue;
            }

            if(taskSearchCriteria.getTitleKeyword() != null && !task.getTitle().toLowerCase().contains(taskSearchCriteria.getTitleKeyword().toLowerCase())){
                continue;
            }

            finalTaskList.add(task);
        }

        if(taskSortStrategy != null){
            taskSortStrategy.sort(finalTaskList);
        }

        return finalTaskList;
    }

    public Task createTask(String taskId, String taskTitle, String taskDescription, Date dueDate, int priority, User createdBy){
        Task newTask = new Task(taskId, taskTitle, taskDescription, dueDate, priority);
        if (createdBy != null) {
            newTask.setCreatedBy(createdBy);
        }
        tasks.put(taskId, newTask);
        newTask.addActivity("Task created");
        return newTask;
    }

    public void updateTask(String taskId, String title, String description, Date dueDate, Integer priority) {
        Task task = getTaskOrThrow(taskId);
        if (title != null) {
            task.setTitle(title);
        }
        if (description != null) {
            task.setDescription(description);
        }
        if (dueDate != null) {
            task.setDueDate(dueDate);
        }
        if (priority != null) {
            task.setPriority(priority);
        }
    }

    public void assignTask(String taskId, User user) {
        Task task = getTaskOrThrow(taskId);
        task.setAssignedTo(user);
    }

    public void addComment(String taskId, String commentId, User addedBy, String content) {
        Task task = getTaskOrThrow(taskId);
        task.addComment(new Comment(commentId, addedBy, content, new Date()));
    }

    public void addSubTask(String parentTaskId, Task subTask) {
        Task task = getTaskOrThrow(parentTaskId);
        task.addSubTask(subTask);
    }

    public void addTaskToList(String taskListName, String taskId) {
        TaskList taskList = getTaskListOrThrow(taskListName);
        taskList.addTask(getTaskOrThrow(taskId));
    }

    public void removeTaskFromList(String taskListName, String taskId) {
        TaskList taskList = getTaskListOrThrow(taskListName);
        taskList.remove(taskId);
    }

    public void addReminder(String reminderId, String taskId, Date reminderTime, String message) {
        getTaskOrThrow(taskId).addActivity("Reminder added for task");
        reminderService.addReminder(new Reminder(reminderId, taskId, reminderTime, message));
    }

    public List<Reminder> getDueReminders(Date currentTime) {
        return reminderService.getDueReminders(currentTime);
    }

    public List<ActivityLog> getTaskHistory(String taskId) {
        return new ArrayList<>(getTaskOrThrow(taskId).getActivityLogs());
    }

    public void deleteTask(String taskId){
        Task removedTask = tasks.remove(taskId);
        for(TaskList taskList: taskLists.values()){
            if(taskList.contains(taskId)){
                taskList.remove(taskId);
            }
        }
        if (removedTask != null) {
            removedTask.addActivity("Task deleted");
        }
    }

    private Task getTaskOrThrow(String taskId) {
        Task task = tasks.get(taskId);
        if (task == null) {
            throw new IllegalArgumentException("Task not found: " + taskId);
        }
        return task;
    }

    private TaskList getTaskListOrThrow(String taskListName) {
        TaskList taskList = taskLists.get(taskListName);
        if (taskList == null) {
            throw new IllegalArgumentException("Task list not found: " + taskListName);
        }
        return taskList;
    }
}
