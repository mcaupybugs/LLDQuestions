package TaskManager;

import java.util.*;

public class SortByPriority implements TaskSortStrategy {
    public List<Task> sort(List<Task> tasks ){
        tasks.sort(Comparator.comparingInt(Task::getPriority));
        return tasks;
    }
}
