package Some.TODO;
import java.util.Scanner;

public class TaskManager {
    Scanner sc = new Scanner(System.in);
    private Task task;
    private Integer wantToUpdateChoice, wantToDeleteChoice;
    private String title, description, wantToUpdateDescription,wantToUpdateTitle;

    //Add task

    public void addTask(User availableUser){
        boolean exist=false;
        while (!exist) {
            boolean taskFill=false;
            for (int i = 0; i < availableUser.getAvailableTask().length; i++) {
                if (availableUser.getAvailableTask()[i] == null) {
                    taskFill = true;
                    break;
                }
            }
            if(taskFill==false){
                System.out.println("Task is already full");
                return;
            }
                try {
                    System.out.println("Enter the Title");
                    String title = sc.nextLine();
                    if (title.equals("exit")) {
                        throw new Exception();
                    }
                    if (title.isEmpty()) {
                        continue;
                    }
                    task = new Task(title);

                    for (int i = 0; i < availableUser.getAvailableTask().length; i++) {
                        if (availableUser.getAvailableTask()[i] == null) {
                            availableUser.getAvailableTask()[i] = task;
                            System.out.println("Title added sucess");
                            taskFill = true;
                            break;
                        }
                    }
                    boolean addDescription = false;
                    while (!addDescription)
                    {
                        try
                        {
                            System.out.println("If you wanna enter description || exit ");
                            System.out.println("yes|| no");
                            String option = sc.nextLine();

                            if (option.equals("yes")) {
                                System.out.println("Enter the description:");
                                description = sc.nextLine();
                                if (description.equals("exit")) {
                                    throw new Exception();
                                }
                                if (description.isEmpty()) {
                                    continue;
                                }
                                task.setDescription(description);
                                System.out.println("Description added ");
                                addDescription = true;
                            } else if (option.equals("no")) {
                                addDescription = true;
                                throw new Exception();
                            } else if (option.equals("exit")) {
                                addDescription = true;
                                throw new Exception();
                            } else {
                                addDescription = true;
                            }

                        }
                        catch (Exception e) {
                            System.out.println("Exited ");
                            throw new Exception();
                        }


                    }
                    System.out.println("Your Task is created Success fully ");
                    for (int i = 0; i < availableUser.getAvailableTask().length; i++) {
                        if (availableUser.getAvailableTask()[i] != null) {
                            System.out.println("==== " + availableUser.getAvailableTask()[i].getTitle() + " ====");
                            System.out.print((i + 1) + ". ");
                            System.out.println(availableUser.getAvailableTask()[i].getDescription());
                        }
                    }
                    exist = true;

                }

                catch (Exception e)
                {

                    System.out.println(e.getMessage());
                }

        }
        if (exist) {
            System.out.println("You exit");
        }
    }

// showTask
    public void showTask(User availableUser) {
        boolean exitTask = false;
        while (!exitTask) {
            boolean addTask = false;
            System.out.println("The available Tasks you created ");
            for (int i = 0; i < availableUser.getAvailableTask().length; i++) {
                if (availableUser.getAvailableTask()[i] != null) {
                    System.out.println("==== " + availableUser.getAvailableTask()[i].getTitle() + " ====");
                    System.out.print(i + 1 + ". ");
                    System.out.println(availableUser.getAvailableTask()[i].getDescription());
                    System.out.println(availableUser.getAvailableTask()[i].getStatus());
                    addTask = true;
                }
            }
            if (addTask) {
                System.out.println("If you want to exit(yes|no) ");
                String exited = sc.nextLine();
                if (exited.equals("yes")) {
                    exitTask = true;
                    break;
                }
            }
        }
        if(exitTask){
            System.out.println("Exit ");
        }

        //System.out.println(availableUser.getAvailableTask()[].getStatus());

        System.out.println("Pick any one if you want to show the list of  status 1|2|3");
        System.out.println("1.ToDo");
        System.out.println("2.In-Progress");
        System.out.println("3.Done");
        Integer options=new Integer(sc.nextLine());
        if(options== 1 ){
            boolean flag = false;
            for (int i = 0; i < availableUser.getAvailableTask().length; i++) {
                if (availableUser.getAvailableTask()[i] != null) {
                    if (availableUser.getAvailableTask()[i].getStatus().equals("TODO") || availableUser.getAvailableTask()[i].getStatus().equals("Todo")) {
                        System.out.print(1 + i + ". ");
                        System.out.print(availableUser.getAvailableTask()[i].getDescription());
                        System.out.print("(");
                        System.out.print(availableUser.getAvailableTask()[i].getStatus());
                        System.out.println(")");
                        flag = true;
                    }
                }
            }
            if (flag == false) {
                System.out.println("No todo are here ");
            }
        }
        else if (options.equals("2")) {
            boolean flag = false;
            for (int i = 0; i < availableUser.getAvailableTask().length; i++) {
                if (availableUser.getAvailableTask()[i] != null) {
                    if (availableUser.getAvailableTask()[i].getStatus().equals("In-Progress")) {
                        System.out.print(1 + i + ". ");
                        System.out.print(availableUser.getAvailableTask()[i].getDescription());
                        System.out.print("(");
                        System.out.print(availableUser.getAvailableTask()[i].getStatus());
                        System.out.println(")");

                    }
                }
            }
            if (flag == false) {
                System.out.println("No In-Progress status are here ");
            }

        } else if (options.equals("3")) {
            boolean flag = false;
            for (int i = 0; i < availableUser.getAvailableTask().length; i++) {
                if (availableUser.getAvailableTask()[i] != null) {
                    if (availableUser.getAvailableTask()[i].getStatus().equals("DONE")) {
                        System.out.print(1 + i + ". ");
                        System.out.print(availableUser.getAvailableTask()[i].getDescription());
                        System.out.print("(");
                        System.out.print(availableUser.getAvailableTask()[i].getStatus());
                        System.out.println(")");
                        flag = true;
                    }
                }
            }
            if (flag == false)
            {
                System.out.println("No DONE status are here ");
            }
        }
    }

    public void updateTask(User availableUser) {
        boolean updateTask = false;
        while (!updateTask) {
            boolean addTask = false;
            System.out.println("Enter the number to update the task");
            for (int i = 0; i < availableUser.getAvailableTask().length; i++)
            {
                if (availableUser.getAvailableTask()[i] != null) {
                    System.out.println("==== " + availableUser.getAvailableTask()[i].getTitle() + " ====");
                    System.out.print(i + 1 + ". ");
                    System.out.println(availableUser.getAvailableTask()[i].getDescription());
                }
            }
            System.out.println("what you want to update Title||Description");
            String option=sc.nextLine();
            if(option.equals("Title"))
            {
                System.out.print("Pick the choice: ");
                wantToUpdateChoice = new Integer(sc.nextLine());
                System.out.print("Change the Title: ");
                wantToUpdateTitle=new String(sc.nextLine());
                availableUser.getAvailableTask()[wantToUpdateChoice-1].setTitle(wantToUpdateTitle);
            } else if (option.equals("Description")) {

                System.out.print("Enter the New Description: ");
                wantToUpdateDescription = sc.nextLine();
                availableUser.getAvailableTask()[wantToUpdateChoice - 1].setDescription(wantToUpdateDescription);
            }
            else{
                System.out.println("");
            }

            System.out.println();
            System.out.println("If you want to update the Status Enter 'YES||NO' ");
            String updateStatus = sc.nextLine();
            if (updateStatus.equals("YES") || updateStatus.equals("yes") || updateStatus.equals("Yes")) {
                for (int i = 0; i < availableUser.getAvailableTask().length; i++) {
                    if (availableUser.getAvailableTask()[i] != null) {
                        System.out.println("==== " + availableUser.getAvailableTask()[i].getTitle() + " ====");
                        System.out.print(i + 1 + ". ");
                        System.out.println(availableUser.getAvailableTask()[i].getDescription());
                        addTask = true;
                    }
                }
                System.out.print("Enter the Task number to change the Description Status: ");
                Integer statusNumber = new Integer(sc.nextLine());
                statusNumber = statusNumber - 1;
                System.out.println();
                System.out.println("Enter the Status");
                System.out.println("1.ToDo");
                System.out.println("2.In-Progress");
                System.out.println("3.Done");
                System.out.print("Pick the 1|2|3: ");
                Integer statusOption = new Integer(sc.nextLine());
                if (statusOption == 1) {
                    String toDo = "ToDo";
                    availableUser.getAvailableTask()[statusNumber].setStatus(toDo);
                } else if (statusOption == 2) {
                    String inProgress = "In-Progress";
                    availableUser.getAvailableTask()[statusNumber].setStatus(inProgress);
                } else if (statusOption == 3) {
                    String doNe = "Done";
                    availableUser.getAvailableTask()[statusNumber].setStatus(doNe);
                } else {
                    System.out.println("Enter the correct StatusOption ");
                }
                {
                    System.out.println(availableUser.getAvailableTask()[statusNumber].getStatus());

                    System.out.println("Pick any one if you want to show the list of  status 1|2|3");
                    System.out.println("1.ToDo");
                    System.out.println("2.In-Progress");
                    System.out.println("3.Done");
                    Integer options=new Integer(sc.nextLine());
                    if(options.equals("1")){
                        boolean flag = false;
                        for (int i = 0; i < availableUser.getAvailableTask().length; i++) {
                            if (availableUser.getAvailableTask()[i] != null) {
                                if (availableUser.getAvailableTask()[i].getStatus().equals("TODO") || availableUser.getAvailableTask()[i].getStatus().equals("Todo")) {
                                    System.out.print(1 + i + ". ");
                                    System.out.print(availableUser.getAvailableTask()[i].getDescription());
                                    System.out.print("(");
                                    System.out.print(availableUser.getAvailableTask()[i].getStatus());
                                    System.out.println(")");
                                    flag = true;
                                }
                            }
                        }
                        if (flag == false) {
                            System.out.println("No todo are here ");
                        }
                    } else if (options.equals("2")) {
                        boolean flag = false;
                        for (int i = 0; i < availableUser.getAvailableTask().length; i++) {
                            if (availableUser.getAvailableTask()[i] != null) {
                                if (availableUser.getAvailableTask()[i].getStatus().equals("In-Progress")) {
                                    System.out.print(1 + i + ". ");
                                    System.out.print(availableUser.getAvailableTask()[i].getDescription());
                                    System.out.print("(");
                                    System.out.print(availableUser.getAvailableTask()[i].getStatus());
                                    System.out.println(")");

                                }
                            }
                        }
                        if (flag == false) {
                            System.out.println("No In-Progress status are here ");
                        }

                    } else if (options.equals("3")) {
                        boolean flag = false;
                        for (int i = 0; i < availableUser.getAvailableTask().length; i++) {
                            if (availableUser.getAvailableTask()[i] != null) {
                                if (availableUser.getAvailableTask()[i].getStatus().equals("DONE")) {
                                    System.out.print(1 + i + ". ");
                                    System.out.print(availableUser.getAvailableTask()[i].getDescription());
                                    System.out.print("(");
                                    System.out.print(availableUser.getAvailableTask()[i].getStatus());
                                    System.out.println(")");
                                    flag = true;
                                }
                            }
                        }
                        if (flag == false) {
                            System.out.println("No DONE status are here ");
                        }
                    }

                }

            } else {
                System.out.println("You Don't want to update the Status");
            }
            System.out.println("If you want to exit(yes|no) ");
            String exited = sc.nextLine();
            if (exited.equals("yes")) {
                break;
            }
        } if (updateTask) {
            System.out.println("You exit");
        }
    }
    public void deleteTask(User availableUser) {
        boolean exitTask = false;
        while (!exitTask) {
            Task[] newTasks = new Task[availableUser.getAvailableTask().length];
            System.out.println("Enter the number to delete the task");
            for (int i = 0; i < availableUser.getAvailableTask().length; i++) {
                if (availableUser.getAvailableTask()[i] != null) {
                  //  System.out.println("==== " + availableUser.getAvailableTask()[i].getTitle() + " ====");
                    System.out.print(i + 1 + ". ");
                    System.out.println(availableUser.getAvailableTask()[i].getDescription());

                }
            }
            System.out.print("Pick any one: ");
            wantToDeleteChoice = new Integer(sc.nextLine());
            int wantDel = wantToDeleteChoice - 1;
            availableUser.getAvailableTask()[wantDel] = null;
            if (availableUser.getAvailableTask()[wantDel] == null && wantDel < 0) {
                System.out.println("Invalid choice");
                continue;
            }
            int num = 0;
            for (int i = 0; i < availableUser.getAvailableTask().length; i++) {
                if (availableUser.getAvailableTask()[i] != null) {
                    newTasks[num] = availableUser.getAvailableTask()[i];
                    num++;
                    availableUser.getAvailableTask()[i] = newTasks[i];
                }
            }
            //availableUser.setAvailableTask(newTasks);
            for (int i = 0; i < availableUser.getAvailableTask().length; i++) {
                if (newTasks[i] != null) {
                    System.out.println("==== " + availableUser.getAvailableTask()[i].getTitle() + " ====");
                    System.out.print((i + 1) + ". ");
                    System.out.println(availableUser.getAvailableTask()[i].getDescription());
                    System.out.print("  CurrentStatus: ");
                    System.out.println(availableUser.getAvailableTask()[i].getStatus());
                }
            }

            System.out.println("If you want to exit(yes|no) ");
            String exited = sc.nextLine();
            if (exited.equals("yes")) {
                exitTask = true;
                break;
            }
        }
        if (exitTask) {
            System.out.println("You exit");
        }
    }
}

