package Some.TODO;

public class Task {
    private  String description;
    private String Status;

    public  Task(){}
    public Task(String description){
        this.description=description;
        this.Status="ToDo";
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }
}
