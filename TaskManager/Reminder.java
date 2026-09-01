package TaskManager;

import java.util.Date;

public class Reminder {
    private final String reminderId;
    private final String taskId;
    private final Date reminderTime;
    private final String message;

    public Reminder(String reminderId, String taskId, Date reminderTime, String message) {
        this.reminderId = reminderId;
        this.taskId = taskId;
        this.reminderTime = reminderTime;
        this.message = message;
    }

    public String getReminderId() {
        return reminderId;
    }

    public String getTaskId() {
        return taskId;
    }

    public Date getReminderTime() {
        return reminderTime;
    }

    public String getMessage() {
        return message;
    }
}