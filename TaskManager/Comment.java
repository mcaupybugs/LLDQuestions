package TaskManager;

import java.util.*;

public class Comment {
    private final String commentId;
    private User addedBy;
    private String content;
    private Date date;
    public Comment(String commentId, User addedBy, String content, Date date){
        this.commentId = commentId;
        this.addedBy = addedBy;
        this.content = content;
        this.date = date;
    }

    public String getCommentId() {
        return commentId;
    }

    public User getAddedBy() {
        return addedBy;
    }

    public String getContent() {
        return content;
    }

    public Date getDate() {
        return date;
    }
}
