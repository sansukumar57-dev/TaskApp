

public class User {
    private String userName;
    private Task[] task=new Task[5];
    public User(String userName){
        this.userName=userName;
    }

    public String getUserName() {
        return userName;
    }

    public Task[] getTask() {
        return task;
    }

    public void setTask(Task[] task) {
        this.task = task;
    }

//    public void setUserName(String userName) {
//        this.userName = userName;
//    }
//    public String getUserName(){
//        return this.userName();
//    }
}
