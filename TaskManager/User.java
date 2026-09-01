package TaskManager;

public class User implements TaskObserver {
    private final int userId;
    private String userName;
    private String email;

    public User(int userId, String userName, String email){
        this.userId=userId;
        this.userName=userName;
        this.email = email;
    }

    public String getName(){
        return this.userName;
    }

    public int getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public void update(Task task, String message) {
        System.out.println("Notification for " + userName + ": " + message + " [Task: " + task.getTitle() + "]");
    }
}
