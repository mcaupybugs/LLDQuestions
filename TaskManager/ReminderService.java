package TaskManager;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ReminderService {
    private final Map<String, List<Reminder>> remindersByTask = new ConcurrentHashMap<>();

    public void addReminder(Reminder reminder) {
        remindersByTask
            .computeIfAbsent(reminder.getTaskId(), key -> new ArrayList<>())
            .add(reminder);
    }

    public List<Reminder> getRemindersForTask(String taskId) {
        return new ArrayList<>(remindersByTask.getOrDefault(taskId, new ArrayList<>()));
    }

    public List<Reminder> getDueReminders(Date currentTime) {
        List<Reminder> dueReminders = new ArrayList<>();
        for (List<Reminder> reminders : remindersByTask.values()) {
            for (Reminder reminder : reminders) {
                if (!reminder.getReminderTime().after(currentTime)) {
                    dueReminders.add(reminder);
                }
            }
        }
        return dueReminders;
    }
}