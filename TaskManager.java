package Some.TODO;
import java.util.Scanner;

public class TaskManager {
    Scanner sc = new Scanner(System.in);
    //private Task task;
    private Integer wantToUpdateChoice, wantToDeleteChoice;
    private String title, description, wantToUpdateDescription,wantToUpdateTitle;

    //Add task
    public void addTask(User avilableUser){
        boolean exit=false;
        while(!exit)
        {
            boolean taskIsNotFull=false;
            for (int i = 0; i < avilableUser.getAvailableTask().length; i++) {
                if (avilableUser.getAvailableTask()[i]==null){
                   taskIsNotFull=true;
                    break;
                }
            }
            if(taskIsNotFull==false){
                System.out.println("task is already fill");
            }

            for (int i = 0; i < avilableUser.getAvailableTask().length; i++) {
                if ( avilableUser.getAvailableTask()[i]!=null){
                    System.out.println("Available Tasks");
                    System.out.print(i+1+" ");
                    System.out.println( avilableUser.getAvailableTask()[i].getTitle());
                }
            }

            if(taskIsNotFull){
            try {
                System.out.println("Enter the Title");
                String title = sc.nextLine();

                if (title.equals("exit")) {
                    throw new Exception();
                }
                if (title.isEmpty()) {
                    System.out.println("Enter valid Title First");
                    continue;
                }

                Task task1 = new Task(title);
                boolean correctDescriptionOption=false;

                while(!correctDescriptionOption)
                {
                System.out.println("If you want to Enter the Description Yes or No");
                String desChoice = sc.nextLine();

                if (desChoice.equals("No")) {
                    correctDescriptionOption=true;
                }
                if (desChoice.equals("exit")) {
                    throw new Exception();
                }
                else if (desChoice.equals("Yes")) {
                    System.out.println("Enter the Description:");
                    String des = sc.nextLine();

                        if (des.isEmpty()) {
                            System.out.println("Enter the Description first ");
                            continue;
                        }
                        if (des.equals("exit")) {
                            throw new Exception();
                        }
                        task1.setDescription(des);

                    correctDescriptionOption = true;
                }
                else{
                    System.out.println("Enter only Yes||No");
                }
            }
                    for (int i = 0; i < avilableUser.getAvailableTask().length; i++)
                    {
                        if (avilableUser.getAvailableTask()[i] == null)
                        {
                            avilableUser.getAvailableTask()[i] = task1;
                            break;
                        }
                    }
                    System.out.println("Task is Created");
            }
            catch (Exception e)
            {
                exit=true;
                System.out.println("Exit");
            }
            }
            else{
                exit=true;
                System.out.println("Exit");
            }
        }
    }


// showTask
    public void showTask(User availableUser)
    {
        boolean exitTask = false;
        while (!exitTask)
        {
            try
            {
                System.out.println("The available Tasks you created ");
                for (int i = 0; i < availableUser.getAvailableTask().length; i++) {
                    if (availableUser.getAvailableTask()[i] != null) {
                        System.out.println("==== " + availableUser.getAvailableTask()[i].getTitle() + " ====");
                        System.out.print(i + 1 + ". ");
                        System.out.println(availableUser.getAvailableTask()[i].getDescription());
                        System.out.println(availableUser.getAvailableTask()[i].getStatus());
                    }
                }
                String exited = sc.nextLine();
                if (exited.equals("exit")) {
                    throw new Exception();
                }
                System.out.println("If you want to show the status:");
                String statusOption=sc.nextLine();
                if(statusOption.equals("No")){
                    exitTask=true;
                }
                if (exited.equals("exit")) {
                    throw new Exception();
                }
                if(statusOption.equals("Yes")) {

            Integer options = null;
            boolean correctOption = false;
while (!correctOption) {
    System.out.println("Pick any one if you want to show the list of  status 1|2|3");
    System.out.println("1.ToDo");
    System.out.println("2.In-Progress");
    System.out.println("3.Done");
    options = new Integer(sc.nextLine());
    if (exited.equals("exit")) {
        throw new Exception();
    }

    if (options == 1) {
        correctOption = true;
        break;
    } else if (options == 2) {
        correctOption = true;
        break;
    } else if (options == 3) {
        correctOption = true;
        break;
    }
    if (options != 1 || options != 2 || options != 3) {
        System.out.print("Enter the correct Option: ");
        correctOption = false;
        break;
    }
}


            if (correctOption==true) {
                if (options == 1) {
                    boolean flag = false;
                    for (int i = 0; i < availableUser.getAvailableTask().length; i++) {
                        if (availableUser.getAvailableTask()[i] != null) {
                            if (availableUser.getAvailableTask()[i].getStatus().equals("ToDo") || availableUser.getAvailableTask()[i].getStatus().equals("ToDo")) {
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
                else if (options==2 ) {
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

                } else if (options==3) {
                    boolean flag = false;
                    for (int i = 0; i < availableUser.getAvailableTask().length; i++) {
                        if (availableUser.getAvailableTask()[i] != null) {
                            if (availableUser.getAvailableTask()[i].getStatus().equals("Done")) {
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
                        System.out.println("No Done status are here ");
                    }

                }

            }
            else {
                System.out.println("Exited");
            }

        }
    }
        catch (Exception e) {
        exitTask = true;
        System.out.println("Exit");
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
            }
            if (option.equals("Description")) {
                System.out.print("Enter the New Description: ");
                wantToUpdateDescription = sc.nextLine();
                availableUser.getAvailableTask()[wantToUpdateChoice - 1].setDescription(wantToUpdateDescription);
            }



            System.out.println("If you want to update the Status Enter 'Yes ||NO' ");
            String updateStatus = sc.nextLine();
            if ( updateStatus.equals("Yes")) {
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



    /// delete
    public void deleteTask(User availableUser) {
        boolean exitTask = false;
        while (!exitTask) {
            Task[] newTasks = new Task[availableUser.getAvailableTask().length];
            System.out.println("Enter the number to delete the task");
            for (int i = 0; i < availableUser.getAvailableTask().length; i++) {
                if (availableUser.getAvailableTask()[i] != null) {
                    System.out.print(i + 1 + ". ");
                    System.out.println(availableUser.getAvailableTask()[i].getDescription());

                }
            }


            try {
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

                System.out.println("If you want to exit(yes|no) ");
                String exited = sc.nextLine();
                if (exited.equals("yes")) {
                    exitTask = true;
                    break;
                }
            }
            catch (Exception e) {
                System.out.println("Invalid choice");
            }
            for (int i = 0; i < availableUser.getAvailableTask().length; i++) {
                if (newTasks[i] != null) {
                    System.out.println("==== " + availableUser.getAvailableTask()[i].getTitle() + " ====");
                    System.out.print((i + 1) + ". ");
                    System.out.println(availableUser.getAvailableTask()[i].getDescription());
                    System.out.print("  CurrentStatus: ");
                    System.out.println(availableUser.getAvailableTask()[i].getStatus());
                }
            }



        }
        if (exitTask) {
            System.out.println("You exit");
        }
    }
}

