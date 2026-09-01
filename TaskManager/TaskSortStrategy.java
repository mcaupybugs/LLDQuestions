package TaskManager;

import java.util.*;

public interface TaskSortStrategy {
    List<Task> sort(List<Task> tasks);
}
