package TaskManager;

import java.util.*;

public class ActivityLog {
    private final String description;
    private final Date timestamp;

    public ActivityLog(String description, Date timestamp){
        this.description = description;
        this.timestamp = timestamp;
    }

    public String getDescription() {
        return description;
    }

    public Date getTimestamp() {
        return timestamp;
    }
}
