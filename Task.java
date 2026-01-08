package Todo_APP_System;

public class Task {
    private String taskDescription;

    public Task(String taskDescription){
        this.taskDescription = taskDescription;
    }
    public String getTaskDescription(){
        return this.taskDescription;
    }
}
