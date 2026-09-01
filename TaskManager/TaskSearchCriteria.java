package TaskManager;

import java.util.*;

public class TaskSearchCriteria {
    private String assignedUserId;
    private String taskStateName;
    private Date dueDate;
    private Integer priority;
    private String titleKeyword;

    public String getAssignedUserId() {
        return assignedUserId;
    }

    public void setAssignedUserId(String assignedUserId) {
        this.assignedUserId = assignedUserId;
    }

    public String getTaskStateName() {
        return taskStateName;
    }

    public void setTaskStateName(String taskStateName) {
        this.taskStateName = taskStateName;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getTitleKeyword() {
        return titleKeyword;
    }

    public void setTitleKeyword(String titleKeyword) {
        this.titleKeyword = titleKeyword;
    }
    
}
