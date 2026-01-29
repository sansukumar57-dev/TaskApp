package Some.TODO;

public class Task {
    private  String description;
    private String Status;
    private String title;
    public  Task(){}
    public Task(String title){
        this.description=null;
        this.title=title;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
