package Some.TODO;
import java.util.Scanner;

public class TaskManager  implements TaskInterface {
    Scanner sc = new Scanner(System.in);
    public TaskManager(){}

    private Integer wantToUpdateChoice, wantToDeleteChoice;
    private String title, description, wantToUpdateDescription, wantToUpdateTitle;

    //Add task
    public void addTask(User avilableUser) {
        boolean exit = false;
        while (!exit) {
            boolean taskIsNotFull = false;
            for (int i = 0; i < avilableUser.getAvailableTask().length; i++) {
                if (avilableUser.getAvailableTask()[i] == null) {
                    taskIsNotFull = true;
                    break;
                }
            }
            System.out.println("Available Tasks");
            TaskManagerUtils.displayTitle(avilableUser);

            if (taskIsNotFull) {

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
                    for (int i = 0; i < avilableUser.getAvailableTask().length; i++) {
                        if (avilableUser.getAvailableTask()[i] == null) {
                            avilableUser.getAvailableTask()[i] = task1;
                            break;
                        }
                    }
                    System.out.println("Task is Created");

                    boolean correctDescriptionOption = false;
                    while (!correctDescriptionOption) {
                        System.out.println("If you want to Enter the Description Yes or No");
                        String desChoice = sc.nextLine();
                        if (desChoice.equals("No")) {
                            correctDescriptionOption = true;
                        }
                        if (desChoice.equals("exit")) {
                            throw new Exception();
                        } else if (desChoice.equals("Yes")) {
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
                        } else {
                            System.out.println("Enter only Yes||No");
                        }
                    }

                } catch (Exception e) {
                    exit = true;
                    System.out.println("Exit");
                }
            } else {
                System.out.println("Maximum Tasks limit is Reached ");
            }
        }
    }

    //show tasks
    public void showTask(User availableUser) {
        System.out.println("Show All Task List: ");
        boolean showTaskList = false;
        while (!showTaskList) {
            String option = null;

            try {
                boolean taskIsThere = false;
                for (int i = 0; i < availableUser.getAvailableTask().length; i++) {
                    if (availableUser.getAvailableTask()[i] != null) {
                        taskIsThere = true;
                    }
                }
                if (taskIsThere == true) {
                    System.out.println("Pick the Number to  show the task list ");
                    System.out.println("1.Show All Tasks");
                    System.out.println("2.Show All the Todo");
                    System.out.println("3.Show All the In-Progress");
                    System.out.println("4.Show All the Done");

                    boolean corretOption = false;


                    while (!corretOption) {

                        try {
                            option = sc.nextLine();
                            if (option.equals("exit")) {
                                throw new Exception();
                            }
                            if (option.isEmpty()) {
                                System.out.println("Enter valid Option First");

                                continue;
                            }

                        } catch (Exception e) {
                            if (option.isEmpty()) {
                                System.out.println("=== Enter the valid option first ===");
                                break;
                            }
                            if (option.equals("exit")) {
                                showTaskList = true;
                                System.out.println("Exit");
                                break;
                            }
                        }


                        if (option.equals("1")) {
                            System.out.println("Tasks: ");
                            TaskManagerUtils.displayTitle(availableUser);
                            corretOption = true;
//

                        } else if (option.equals("2")) {
                            System.out.println("All Todo Lists ");
                            TaskManagerUtils.displayStatus(availableUser, "Todo");
                            corretOption = true;

                        } else if (option.equals("3")) {
                            System.out.println("All In-Progress Lists ");
                            TaskManagerUtils.displayStatus(availableUser, "In-progress");
                            corretOption = true;
                        } else if (option.equals("4")) {
                            System.out.println("All Done Lists ");
                            TaskManagerUtils.displayStatus(availableUser, "Done");
                            corretOption = true;
                        } else {
                            System.out.println("Enter the correct number");

                        }

                    }
                } else {
                    System.out.println("Task is not here To Show");
                    showTaskList = true;
                }
            } catch (Exception e) {
                if (option.equals("exit")) {
                    System.out.println("Exit ");
                    showTaskList = true;
                }
            }
        }
    }


    //update task

    public void updateTask(User availableUser) {
        boolean update = false;
        String updateChoice = null;
        while (!update) {
            boolean letUpdateTask = false;
            for (int i = 0; i < availableUser.getAvailableTask().length; i++) {
                if (availableUser.getAvailableTask()[i] != null) {
                    letUpdateTask = true;
                }
            }
            try {
                if (letUpdateTask == true) {
                    boolean updatetitle = false;

                    while (!updatetitle) {
                        System.out.println("Enter the option to Update");
                        System.out.println("1.Update Title");
                        System.out.println("2.Update Description");
                        System.out.println("3.Update Status");
                        updateChoice = sc.nextLine();
                        if (updateChoice.equals("exit")) {
                            throw new Exception();
                        }
                        if (updateChoice.isEmpty()) {
                            System.out.println("Enter Option First");
                            continue;
                        }

                        if (updateChoice.equals("1")) {
                            boolean titleFg = false;
                            for (int i = 0; i < availableUser.getAvailableTask().length; i++) {
                                if (availableUser.getAvailableTask()[i] != null) {
                                    titleFg = true;
                                    System.out.print(i + 1 + ". ");
                                    System.out.println(availableUser.getAvailableTask()[i].getTitle());
                                }
                            }
                            if (!titleFg) {
                                System.out.println("Title is Empty Here ");
                                break;
                            }
                            if (titleFg == true) {
                                System.out.println("Pick Which Title want to Update ");
                                String updateNumber = sc.nextLine();
                                Integer updateNumbers = 0;

                                try {
                                    updateNumbers = new Integer(updateNumber);
                                    if (updateNumber.equals("exit")) {
                                        throw new Exception();
                                    }
                                    if (updateNumber.isEmpty()) {
                                        System.out.println("Enter Title First");
                                        continue;
                                    }

                                } catch (Exception e) {
                                    if (updateNumber.equals("exit")) {
                                        System.out.println("Exit");
                                        updatetitle = true;
                                        update = true;
                                        continue;
                                    }

                                }


                                System.out.println("Update the New Title");
                                String updateTitle = null;
                                try {
                                    updateTitle = sc.nextLine();
                                    if (updateTitle.equals("exit")) {
                                        throw new Exception();
                                    }
                                    if (updateTitle.isEmpty()) {
                                        System.out.println("Enter Title First");
                                        continue;
                                    }

                                } catch (Exception e) {
                                    if (updateTitle.equals("exit")) {
                                        System.out.println("Exit");
                                        updatetitle = true;
                                        update = true;
                                    }
                                }
                                availableUser.getAvailableTask()[updateNumbers - 1].setTitle(updateTitle);
                                System.out.println("Title is updated successfully ");
                                update = true;
                            }

                        } else if (updateChoice.equals("2")) {
                            boolean descritionFg = false;
                            for (int i = 0; i < availableUser.getAvailableTask().length; i++) {
                                if (availableUser.getAvailableTask()[i] != null) {
                                    descritionFg = true;
                                    System.out.print(i + 1 + ". ");
                                    System.out.println(availableUser.getAvailableTask()[i].getDescription());
                                }
                            }
                            if (!descritionFg) {
                                System.out.println("Description is Empty Here");
                            }
                            if (descritionFg == true) {
                                System.out.println("Pick Which Description want to Update ");
                                String updateNumber = sc.nextLine();
                                Integer updateNumbers = 0;
                                try {
                                    updateNumbers = new Integer(updateNumber);
                                    if (updateNumber.equals("exit")) {
                                        throw new Exception();
                                    }
                                    if (updateNumber.isEmpty()) {
                                        System.out.println("Enter Description First");
                                        continue;
                                    }
                                } catch (Exception e) {
                                    if (updateNumber.equals("exit")) {
                                        System.out.println("Exit");
                                        updatetitle = true;
                                        update = true;
                                        continue;
                                    }
                                }


                                System.out.println("Update the New Description");
                                String updateDescription = null;
                                try {
                                    updateDescription = sc.nextLine();
                                    if (updateDescription.equals("exit")) {
                                        throw new Exception();
                                    }
                                    if (updateDescription.isEmpty()) {
                                        System.out.println("Enter Description First");
                                        continue;
                                    }
                                } catch (Exception e) {
                                    if (updateDescription.equals("exit")) {
                                        System.out.println("Exit");
                                        updatetitle = true;
                                        update = true;
                                    }
                                }

                                availableUser.getAvailableTask()[updateNumbers - 1].setDescription(updateDescription);
                                System.out.println("In-Progress is updated successfully ");
                                update = true;
                            }
                        } else if (updateChoice.equals("3")) {
                            boolean statusFg = false;
                            System.out.println("Select the any number to add the status ");
                            for (int i = 0; i < availableUser.getAvailableTask().length; i++) {
                                if (availableUser.getAvailableTask()[i] != null) {
                                    statusFg = true;
                                    System.out.print(i + 1 + ". ");
                                    System.out.println(availableUser.getAvailableTask()[i].getTitle() + " " + availableUser.getAvailableTask()[i].getStatus());

                                }
                            }
                            if (!statusFg) {
                                System.out.println("Status is Empty Here ");
                                break;
                            }
                            if (statusFg == true) {

                                String updateNumber = sc.nextLine();
                                Integer updateNumbers = 0;
                                try {
                                    updateNumbers = new Integer(updateNumber);
                                    if (updateNumber.equals("exit")) {
                                        throw new Exception();
                                    }
                                    if (updateNumber.isEmpty()) {
                                        System.out.println("Enter Title First");
                                        continue;
                                    }
                                } catch (Exception e) {
                                    if (updateNumber.equals("exit")) {
                                        System.out.println("Exit");
                                        updatetitle = true;
                                        update = true;
                                        continue;
                                    }
                                }


                                System.out.println("Pick Which Status want to Update");
                                System.out.println("1.Todo");
                                System.out.println("2.In-Progress");
                                System.out.println("3.Done");

                                String updateStatus = sc.nextLine();
                                Integer selectStatusChoice = new Integer(updateStatus);
                                if (updateStatus.equals("exit")) {
                                    throw new Exception();
                                }
                                if (updateStatus.isEmpty()) {
                                    System.out.println("Enter Status First");
                                    continue;
                                }
                                if (selectStatusChoice == 1) {
                                    String todo = "Todo";
                                    availableUser.getAvailableTask()[updateNumbers - 1].setStatus(todo);
                                    update = true;
                                }
                                if (selectStatusChoice == 2) {
                                    String inProgress = "In-Progress";
                                    availableUser.getAvailableTask()[updateNumbers - 1].setStatus(inProgress);
                                    update = true;
                                }
                                if (selectStatusChoice == 3) {
                                    String done = "Done";
                                    availableUser.getAvailableTask()[updateNumbers - 1].setStatus(done);
                                    update = true;
                                }
                                System.out.println("Updated successfully ");
                            }

                        } else {
                            System.out.println("Invalid option  ");
                            break;
                        }
                    }
                } else {
                    System.out.println("Empty task cannnot be Update for Update enter the list First");
                    update = true;
                }
            } catch (Exception e) {
                if (updateChoice.equals("exit")) {
                    System.out.println("Exit");
                    update = true;
                } else {
                    System.out.println("Enter the Correct Options");
                }

            }
        }

    }


    public void deleteTask(User availableUser) {
        boolean exit = false;
        while (!exit) {
            boolean titleIsEmpty = false;
            String inputOption = null;
            for (int i = 0; i < availableUser.getAvailableTask().length; i++) {
                if (availableUser.getAvailableTask()[i] != null) {
                    titleIsEmpty = true;
                    System.out.print(i + 1 + " ");
                    System.out.println(availableUser.getAvailableTask()[i].getTitle());
                }
            }
            if (titleIsEmpty == false) {
                System.out.println("There is no Title! ");
                break;
            }
            try {
                System.out.println("Pick the title to delete ");
                inputOption = sc.nextLine();
                if (inputOption.equals("exit")) {
                    throw new Exception();
                }
                if (inputOption.isEmpty()) {
                    System.out.println("Option should not bee empty!");
                    System.out.println("Invalid choice");
                    continue;
                }

                Integer inpNumOption = new Integer(inputOption);
                availableUser.getAvailableTask()[inpNumOption - 1] = null;

                Task[] newTasks = new Task[availableUser.getAvailableTask().length];
                int num = 0;

                for (int i = 0; i < availableUser.getAvailableTask().length; i++) {
                    if (availableUser.getAvailableTask()[i] != null) {
                        newTasks[num] = availableUser.getAvailableTask()[i];
                        availableUser.getAvailableTask()[num] = newTasks[num];
                        num++;
                    }
                }
                availableUser.setAvailableTask(newTasks);

            } catch (Exception e) {
                if (inputOption.equals("exit")) {
                    System.out.println("Exit");
                    exit = true;
                } else {
                    System.out.println("Invalid");
                }
            }

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
