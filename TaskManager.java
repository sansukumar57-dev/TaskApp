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
            System.out.println("Available Tasks");
            for (int i = 0; i < avilableUser.getAvailableTask().length; i++) {
                if ( avilableUser.getAvailableTask()[i]!=null){
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
                for (int i = 0; i < avilableUser.getAvailableTask().length; i++)
                {
                    if (avilableUser.getAvailableTask()[i] == null)
                    {
                        avilableUser.getAvailableTask()[i] = task1;
                        break;
                    }
                }
                System.out.println("Task is Created");

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

            }
            catch (Exception e)
            {
                exit=true;
                System.out.println("Exit");
            }
            }
            else{
                System.out.println("Exit");
            }
        }
    }

    //show tasks
    public void showTask(User availableUser)
    {
        System.out.println("Show All Task List: ");
        boolean showTaskList=false;
        while(!showTaskList) {
            String option=null;
            try {
                boolean taskIsThere=false;
                for (int i = 0; i < availableUser.getAvailableTask().length; i++) {
                    if (availableUser.getAvailableTask()[i]!=null){
                        taskIsThere=true;
                    }

                }
                if(taskIsThere==true){
                    System.out.println("Pick the Number to  show the task list ");
                    System.out.println("1.Show All Tasks");
                    System.out.println("2.Show All the Todo");
                    System.out.println("3.Show All the In-Progress");
                    System.out.println("4.Show All the Done");
                     option = sc.nextLine();
                    int n=1;

                    Integer optionWantToShow = new Integer(option);


                    if (optionWantToShow == 1) {;
                        System.out.println("Tasks: ");
                        for (int i = 0; i < availableUser.getAvailableTask().length; i++) {
                            if (availableUser.getAvailableTask()[i] != null) {
                                System.out.print(i + 1 + ". ");
                                System.out.println(availableUser.getAvailableTask()[i].getTitle());
                                System.out.print("Description: ");
                                System.out.println(availableUser.getAvailableTask()[i].getDescription());
                                System.out.print("Status: ");
                                System.out.println(availableUser.getAvailableTask()[i].getStatus());
                                System.out.println();
                            }
                        }

                    } else if (optionWantToShow == 2) {
                        System.out.println("All Todo Lists ");
                        //int n=1;
                        for (int i = 0; i < availableUser.getAvailableTask().length; i++) {
                            if (availableUser.getAvailableTask()[i].getStatus().equals("Todo")) {
                                System.out.print(n + ". ");
                                System.out.println(availableUser.getAvailableTask()[i].getTitle());
                                System.out.print("Description: ");
                                System.out.println(availableUser.getAvailableTask()[i].getDescription());
                                System.out.print("Status: ");
                                System.out.println(availableUser.getAvailableTask()[i].getStatus());
                                System.out.println();
                                n++;
                            }
                        }

                    } else if (optionWantToShow == 3) {
                        System.out.println("All In-Progress Lists ");
                        //int n=1;
                        for (int i = 0; i < availableUser.getAvailableTask().length; i++) {
                            if (availableUser.getAvailableTask()[i].getStatus().equals("In-Progress")) {
                                System.out.print(n + ". ");
                                System.out.println(availableUser.getAvailableTask()[i].getTitle());
                                System.out.print("Description: ");
                                System.out.println(availableUser.getAvailableTask()[i].getDescription());
                                System.out.print("Status: ");
                                System.out.println(availableUser.getAvailableTask()[i].getStatus());
                                System.out.println();
                                n++;
                            }

                        }

                    } else if (optionWantToShow == 4) {
                        System.out.println("All Done Lists ");

                        for (int i = 0; i < availableUser.getAvailableTask().length; i++) {
                            if (availableUser.getAvailableTask()[i].getStatus().equals("Done")) {
                                System.out.print(n  + ". ");
                                System.out.println(availableUser.getAvailableTask()[i].getTitle());
                                System.out.print("Description: ");
                                System.out.println(availableUser.getAvailableTask()[i].getDescription());
                                System.out.print("Status: ");
                                System.out.println(availableUser.getAvailableTask()[i].getStatus());
                                System.out.println();
                                n++;
                            }
                        }
                    }

                }
                else{
                    System.out.println("Task is no Tasks To Show");
                    showTaskList=true;
                }
            }
                catch (Exception e) {
                 if (option.equals("exit")) {
                     System.out.println("Exit ");
                     showTaskList=true;
                    }

            }
        }
    }

    //update task

    public void updateTask(User availableUser){
        boolean update=false;
        while (!update) {
            boolean letUpdateTask = false;
            for (int i = 0; i < availableUser.getAvailableTask().length; i++) {
                    if (availableUser.getAvailableTask()[i] != null) {
                        letUpdateTask = true;
                    }
                }
                if (letUpdateTask == true) {
                    String updateChoice =null;
                    try {
                        while(true) {
                            System.out.println("Enter the option to Update");
                            System.out.println("1.Update Title");
                            System.out.println("2.Update Description");
                            System.out.println("3.Update Status");
                            updateChoice = sc.nextLine();
                            Integer updateOption = new Integer(updateChoice);

                            if (updateChoice.equals("exit")) {
                                throw new Exception();
                            }

                            if (updateOption == 1) {
                                for (int i = 0; i < availableUser.getAvailableTask().length; i++) {
                                    if (availableUser.getAvailableTask()[i] != null) {
                                        System.out.print(i + 1 + ". ");
                                        System.out.println(availableUser.getAvailableTask()[i].getTitle());
                                    }
                                }
                                System.out.println("Pick Which Title want to Update ");
                                Integer updateNumber = new Integer(sc.nextLine());
                                System.out.println("Update the New Title");
                                String updateTitle = sc.nextLine();
                                if (updateTitle.equals("exit")) {
                                    throw new Exception();
                                }
                                availableUser.getAvailableTask()[updateNumber - 1].setTitle(updateTitle);
                                System.out.println("Title is updated successfully ");
                                update = true;

                            }
                         else if (updateOption == 2) {
                                for (int i = 0; i < availableUser.getAvailableTask().length; i++) {
                                    if (availableUser.getAvailableTask()[i] != null) {
                                        System.out.print(i + 1 + ". ");
                                        System.out.println(availableUser.getAvailableTask()[i].getDescription());
                                    }
                                }
                                System.out.println("Pick Which Description want to Update ");
                                Integer updateNumber = new Integer(sc.nextLine());
                                System.out.println("Update the New Description");
                                String updateDescription = sc.nextLine();
                                if (updateDescription.equals("exit")) {
                                    throw new Exception();
                                }
                                availableUser.getAvailableTask()[updateNumber - 1].setDescription(updateDescription);
                                System.out.println("In-Progress is updated successfully ");
                                update = true;

                            }
                            else if (updateOption == 3) {
                                for (int i = 0; i < availableUser.getAvailableTask().length; i++) {
                                    if (availableUser.getAvailableTask()[i] != null) {
                                        System.out.print(i + 1 + ". ");
                                        System.out.println(availableUser.getAvailableTask()[i].getStatus());
                                    }
                                }
                                System.out.println("Pick Which Status want to Update");
                                Integer updateNumber = new Integer(sc.nextLine());
                                System.out.println("Update the New Status");
                                System.out.println("1.Todo");
                                System.out.println("2.In-Progress");
                                System.out.println("3.Done");

                                String updateStatus = sc.nextLine();
                                Integer selectStatusChoice=new Integer(updateStatus);
                                if (updateStatus.equals("exit")) {
                                    throw new Exception();
                                }
                                if(selectStatusChoice==1){
                                    String todo="Todo";
                                    availableUser.getAvailableTask()[updateNumber - 1].setStatus(todo);
                                    update = true;
                                }
                                if(selectStatusChoice==2){
                                    String inProgress="In-Progress";
                                    availableUser.getAvailableTask()[updateNumber - 1].setStatus(inProgress);
                                    update = true;
                                }if(selectStatusChoice==3){
                                    String done="Done";
                                    availableUser.getAvailableTask()[updateNumber - 1].setStatus(done);
                                    update = true;
                                }
                                System.out.println("Done is updated successfully ");
                            }
                            else {
                                System.out.println("Invalid option  ");
                                break;
                            }
                        }


                    } catch (Exception e) {
                        System.out.println("Exit");
                        update = true;
                    }
                }
                else {
                    System.out.println("Empty task cannnot be Update for Update enter the list First");
                }
            }

        }


































// showTask
//    public void showTasks(User availableUser)
//    {
//        boolean exitTask = false;
//        while (!exitTask)
//        {
//            try
//            {
//                System.out.println("The available Tasks you created ");
//                for (int i = 0; i < availableUser.getAvailableTask().length; i++) {
//                    if (availableUser.getAvailableTask()[i] != null) {
//                        System.out.println("==== " + availableUser.getAvailableTask()[i].getTitle() + " ====");
//                        System.out.print(i + 1 + ". ");
//                        System.out.println(availableUser.getAvailableTask()[i].getDescription());
//                        System.out.println(availableUser.getAvailableTask()[i].getStatus());
//                    }
//                }
//                String exited = sc.nextLine();
//                if (exited.equals("exit")) {
//                    throw new Exception();
//                }
//                System.out.println("If you want to show the status:");
//                String statusOption=sc.nextLine();
//                if(statusOption.equals("No")){
//                    exitTask=true;
//                }
//                if (exited.equals("exit")) {
//                    throw new Exception();
//                }
//                if(statusOption.equals("Yes")) {
//
//            Integer options = null;
//            boolean correctOption = false;
//while (!correctOption) {
//    System.out.println("Pick any one if you want to show the list of  status 1|2|3");
//    System.out.println("1.ToDo");
//    System.out.println("2.In-Progress");
//    System.out.println("3.Done");
//    options = new Integer(sc.nextLine());
//    if (exited.equals("exit")) {
//        throw new Exception();
//    }
//
//    if (options == 1) {
//        correctOption = true;
//        break;
//    } else if (options == 2) {
//        correctOption = true;
//        break;
//    } else if (options == 3) {
//        correctOption = true;
//        break;
//    }
//    if (options != 1 || options != 2 || options != 3) {
//        System.out.print("Enter the correct Option: ");
//        correctOption = false;
//        break;
//    }
//}
//
//
//            if (correctOption==true) {
//                if (options == 1) {
//                    boolean flag = false;
//                    for (int i = 0; i < availableUser.getAvailableTask().length; i++) {
//                        if (availableUser.getAvailableTask()[i] != null) {
//                            if (availableUser.getAvailableTask()[i].getStatus().equals("ToDo") || availableUser.getAvailableTask()[i].getStatus().equals("ToDo")) {
//                                System.out.print(1 + i + ". ");
//                                System.out.print(availableUser.getAvailableTask()[i].getDescription());
//                                System.out.print("(");
//                                System.out.print(availableUser.getAvailableTask()[i].getStatus());
//                                System.out.println(")");
//                                flag = true;
//                            }
//                        }
//                    }
//                    if (flag == false) {
//                        System.out.println("No todo are here ");
//                    }
//                }
//                else if (options==2 ) {
//                    boolean flag = false;
//                    for (int i = 0; i < availableUser.getAvailableTask().length; i++) {
//                        if (availableUser.getAvailableTask()[i] != null) {
//                            if (availableUser.getAvailableTask()[i].getStatus().equals("In-Progress")) {
//                                System.out.print(1 + i + ". ");
//                                System.out.print(availableUser.getAvailableTask()[i].getDescription());
//                                System.out.print("(");
//                                System.out.print(availableUser.getAvailableTask()[i].getStatus());
//                                System.out.println(")");
//
//                            }
//                        }
//                    }
//                    if (flag == false) {
//                        System.out.println("No In-Progress status are here ");
//                    }
//
//                } else if (options==3) {
//                    boolean flag = false;
//                    for (int i = 0; i < availableUser.getAvailableTask().length; i++) {
//                        if (availableUser.getAvailableTask()[i] != null) {
//                            if (availableUser.getAvailableTask()[i].getStatus().equals("Done")) {
//                                System.out.print(1 + i + ". ");
//                                System.out.print(availableUser.getAvailableTask()[i].getDescription());
//                                System.out.print("(");
//                                System.out.print(availableUser.getAvailableTask()[i].getStatus());
//                                System.out.println(")");
//                                flag = true;
//                            }
//                        }
//                    }
//                    if (flag == false) {
//                        System.out.println("No Done status are here ");
//                    }
//
//                }
//
//            }
//            else {
//                System.out.println("Exited");
//            }
//
//        }
//                {
//                    System.out.println("Enter the number to show the status ");
//                    Integer statusNumber = new Integer(sc.nextLine());
//                    System.out.println(availableUser.getAvailableTask()[statusNumber - 1].getStatus());
//                    System.out.println("Pick any one if you want to show the list of  status 1|2|3");
//                    System.out.println("1.ToDo");
//                    System.out.println("2.In-Progress");
//                    System.out.println("3.Done");
//                    Integer options=new Integer(sc.nextLine());
//                    if(options.equals("1")){
//                        boolean flag = false;
//                        for (int i = 0; i < availableUser.getAvailableTask().length; i++) {
//                            if (availableUser.getAvailableTask()[i] != null) {
//                                if (availableUser.getAvailableTask()[i].getStatus().equals("TODO") || availableUser.getAvailableTask()[i].getStatus().equals("Todo")) {
//                                    System.out.print(1 + i + ". ");
//                                    System.out.print(availableUser.getAvailableTask()[i].getDescription());
//                                    System.out.print("(");
//                                    System.out.print(availableUser.getAvailableTask()[i].getStatus());
//                                    System.out.println(")");
//                                    flag = true;
//                                }
//                            }
//                        }
//                        if (flag == false) {
//                            System.out.println("No todo are here ");
//                        }
//                    } else if (options.equals("2")) {
//                        boolean flag = false;
//                        for (int i = 0; i < availableUser.getAvailableTask().length; i++) {
//                            if (availableUser.getAvailableTask()[i] != null) {
//                                if (availableUser.getAvailableTask()[i].getStatus().equals("In-Progress")) {
//                                    System.out.print(1 + i + ". ");
//                                    System.out.print(availableUser.getAvailableTask()[i].getDescription());
//                                    System.out.print("(");
//                                    System.out.print(availableUser.getAvailableTask()[i].getStatus());
//                                    System.out.println(")");
//
//                                }
//                            }
//                        }
//                        if (flag == false) {
//                            System.out.println("No In-Progress status are here ");
//                        }
//
//                    } else if (options.equals("3")) {
//                        boolean flag = false;
//                        for (int i = 0; i < availableUser.getAvailableTask().length; i++) {
//                            if (availableUser.getAvailableTask()[i] != null) {
//                                if (availableUser.getAvailableTask()[i].getStatus().equals("DONE")) {
//                                    System.out.print(1 + i + ". ");
//                                    System.out.print(availableUser.getAvailableTask()[i].getDescription());
//                                    System.out.print("(");
//                                    System.out.print(availableUser.getAvailableTask()[i].getStatus());
//                                    System.out.println(")");
//                                    flag = true;
//                                }
//                            }
//                        }
//                        if (flag == false) {
//                            System.out.println("No DONE status are here ");
//                        }
//                    }
//
//                }
//    }
//        catch (Exception e) {
//        exitTask = true;
//        System.out.println("Exit");
//    }
//    }
//    }


//    public void updateTasks(User availableUser) {
//        boolean updateTask = false;
//        while (!updateTask) {
//            boolean addTask = false;
//            System.out.println("Enter the number to update the task");
//            for (int i = 0; i < availableUser.getAvailableTask().length; i++)
//            {
//                if (availableUser.getAvailableTask()[i] != null) {
//                    System.out.println("==== " + availableUser.getAvailableTask()[i].getTitle() + " ====");
//                    System.out.print(i + 1 + ". ");
//                    System.out.println(availableUser.getAvailableTask()[i].getDescription());
//                }
//            }
//            System.out.println("what you want to update Title||Description");
//            String option=sc.nextLine();
//            if(option.equals("Title"))
//            {
//                System.out.print("Pick the choice: ");
//                wantToUpdateChoice = new Integer(sc.nextLine());
//                System.out.print("Change the Title: ");
//                wantToUpdateTitle=new String(sc.nextLine());
//                availableUser.getAvailableTask()[wantToUpdateChoice-1].setTitle(wantToUpdateTitle);
//            }
//            if (option.equals("Description")) {
//                System.out.print("Enter the New Description: ");
//                wantToUpdateDescription = sc.nextLine();
//                availableUser.getAvailableTask()[wantToUpdateChoice - 1].setDescription(wantToUpdateDescription);
//            }



//            System.out.println("If you want to update the Status Enter 'Yes ||NO' ");
//           // String updateStatus = sc.nextLine();
//            if ( updateStatus.equals("Yes")) {
//                for (int i = 0; i < availableUser.getAvailableTask().length; i++) {
//                    if (availableUser.getAvailableTask()[i] != null) {
//                        System.out.println("==== " + availableUser.getAvailableTask()[i].getTitle() + " ====");
//                        System.out.print(i + 1 + ". ");
//                        System.out.println(availableUser.getAvailableTask()[i].getDescription());
//                        addTask = true;
//                    }
//                }
//                System.out.print("Enter the Task number to change the Description Status: ");
//             //   Integer statusNumber = new Integer(sc.nextLine());
//
//                System.out.println();
//                System.out.println("Enter the Status");
//                System.out.println("1.ToDo");
//                System.out.println("2.In-Progress");
//                System.out.println("3.Done");
//                System.out.print("Pick the 1|2|3: ");
//           //     Integer statusOption = new Integer(sc.nextLine());
//                if (statusOption == 1) {
//                    String toDo = "ToDo";
//                    availableUser.getAvailableTask()[statusNumber - 1].setStatus(toDo);
//                } else if (statusOption == 2) {
//                    String inProgress = "In-Progress";
//                    availableUser.getAvailableTask()[statusNumber - 1].setStatus(inProgress);
//                } else if (statusOption == 3) {
//                    String doNe = "Done";
//                    availableUser.getAvailableTask()[statusNumber - 1].setStatus(doNe);
//                } else {
//                    System.out.println("Enter the correct StatusOption ");
//                }


//            } else {
//                System.out.println("You Don't want to update the Status");
//            }
//            System.out.println("If you want to exit(yes|no) ");
////       //     String exited = sc.nextLine();
////            if (exited.equals("yes")) {
////                break;
////            }
//        } if (updateTask) {
//            System.out.println("You exit");
//        }
//    }



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
                Scanner sc=new Scanner(System.in);
               Integer wantToDeleteChoice = new Integer(sc.nextLine());
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












//
















/*
=[todo,inprogress,done,todo,inprogress,done,]
   
Todo todo = new Todo();// todo store
Inprogress inProgress=new Inprogress();//inProgress
Done done=new Done();//Done

















 */
