package TaskManager;

import java.util.Date;
import java.util.List;

public class TaskManagementApp {
    public static void main(String[] args) {
        TaskManagerSystem taskManagerSystem = TaskManagerSystem.getInstance();

        User alice = taskManagerSystem.createUser(1, "Alice", "alice@example.com");
        User bob = taskManagerSystem.createUser(2, "Bob", "bob@example.com");

        taskManagerSystem.createTaskList("Engineering", "Engineering Work");

        Date now = new Date();
        Date tomorrow = new Date(now.getTime() + 24L * 60 * 60 * 1000);

        Task task = taskManagerSystem.createTask("T-1", "Design API", "Prepare task manager API design", tomorrow, 1, alice);
        taskManagerSystem.assignTask("T-1", bob);
        taskManagerSystem.addTaskToList("Engineering", "T-1");
        taskManagerSystem.addComment("T-1", "C-1", alice, "Initial draft created");
        taskManagerSystem.addReminder("R-1", "T-1", tomorrow, "Review API design");

        task.moveToInProgress();
        task.moveToDone();

        TaskSearchCriteria criteria = new TaskSearchCriteria();
        criteria.setAssignedUserId("Bob");

        List<Task> bobTasks = taskManagerSystem.searchTasks(criteria, new SortByDueDate());
        System.out.println("Tasks assigned to Bob: " + bobTasks.size());

        System.out.println("Activity log for task T-1:");
        for (ActivityLog log : taskManagerSystem.getTaskHistory("T-1")) {
            System.out.println(log.getTimestamp() + " - " + log.getDescription());
        }

        System.out.println("Due reminders count: " + taskManagerSystem.getDueReminders(new Date(tomorrow.getTime() + 1000)).size());
    }
}