package TaskManager;

import java.util.*;

public class SortByDueDate implements TaskSortStrategy {
    public List<Task> sort(List<Task> tasks){
        tasks.sort(Comparator.comparing(Task::getDueDate));
        return tasks;
    }    
}
