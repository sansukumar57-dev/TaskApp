package Todo_APP_System;

public class User {
    private String userName;
    public Task[] taskArray=new Task[5];

    public User() {

    }

    public User(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return this.userName;
    }
    public Task[] getTaskArray(){
        return this.taskArray;
    }

}