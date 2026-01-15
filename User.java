package Task;

public class User {
    private  String userName;
private Task[] task=new Task[10];
    public User(String userName){
        this.userName = userName;
    }
    public String getUserName(){
        return userName;
    }

    public Task[] getTask() {
        return task;
    }

    public void setTask(Task[] task) {
        this.task = task;
    }
}
