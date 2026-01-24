package Some.TODO;
import java.util.Scanner;
public class Mains {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        User[] users=new User[4];
        Integer choice, wantToUpdateChoice,wantToDeleteChoice;
        User availableUser = null;
        int userPositionArray = 0;
        boolean findUser;
        String username,description,wantToUpdateDescription;
        while(true) {
            findUser=false;
            System.out.println("Welcome to Your Task ");
            System.out.println("Enter your name");
            username = sc.nextLine();
            for (int i = 0; i < users.length; i++) {
                if(users[i]==null){
                    continue;
                }
                if(users[i].getName().equals(username))
                {
                    findUser=true;
                    userPositionArray=i;
                    break;
                }
            }
            if(findUser==false){
                availableUser=new User(username);
                for (int i = 0; i < users.length; i++) {
                    if (users[i]==null){
                        users[i]=availableUser;
                        break;
                    }
                }
            }else{
                availableUser=users[userPositionArray];
                System.out.println("Welcome Back" );
            }
            choice = 0;
            while (choice!=5) {
                System.out.println("Available features");
                System.out.println("1.Add the task");
                System.out.println("2.Show the task");
                System.out.println("3.Update the task");
                System.out.println("4.Delete the task");
                System.out.println("5.Exit");
                System.out.println("Choose any Option ");
                choice = new Integer(sc.nextLine());
                if (choice == 1) {

                    System.out.println("Enter the description:");
                     description = sc.nextLine();
                    Task task = new Task(description);
                    for (int i = 0; i < availableUser.getAvailableTask().length; i++) {
                        if (availableUser.getAvailableTask()[i]==null){
                            availableUser.getAvailableTask()[i]=task;
                            break;
                        }
                    }
                    System.out.println("Your Task is created Success fully ");
                    for (int i = 0; i < availableUser.getAvailableTask().length; i++) {
                        if (availableUser.getAvailableTask()[i] != null) {
                            System.out.print((i + 1) + ". ");
                            System.out.println(availableUser.getAvailableTask()[i].getDescription());
                        }
                    }

                }
                else if (choice == 2)
                {
                    System.out.println("The available Tasks you created ");
                    for (int i = 0; i < availableUser.getAvailableTask().length; i++) {
                        if (availableUser.getAvailableTask()[i] != null) {
                            System.out.print(i + 1 + ". ");
                            System.out.println(availableUser.getAvailableTask()[i].getDescription());
                        }
                    }
                }
                else if(choice==3)
                {   System.out.println("Enter the number to update the task");
                    for (int i = 0; i < availableUser.getAvailableTask().length; i++) {
                            if (availableUser.getAvailableTask()[i]!=null){
                                System.out.print(i+1+". ");
                                System.out.println(availableUser.getAvailableTask()[i].getDescription());
                            }
                        }
                        System.out.print("Pick the choice: ");
                        wantToUpdateChoice=new Integer(sc.nextLine());
                        System.out.print("Enter the New Description: ");
                        wantToUpdateDescription=sc.nextLine();
                        availableUser.getAvailableTask()[wantToUpdateChoice-1].setDescription(wantToUpdateDescription);
                    System.out.println();
                    System.out.println("If you want to update the Status Enter 'YES||NO' ");
                    String updateStatus=sc.nextLine();
                    if(updateStatus.equals("YES")||updateStatus.equals("yes")||updateStatus.equals("Yes")) {
                        for (int i = 0; i < availableUser.getAvailableTask().length; i++) {
                            if (availableUser.getAvailableTask()[i]!=null){
                                System.out.print(i+1+". ");
                                System.out.println(availableUser.getAvailableTask()[i].getDescription());
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
                        }
                        else if (statusOption == 2) {
                            String inProgress = "In-Progress";
                            availableUser.getAvailableTask()[statusNumber].setStatus(inProgress);
                        }
                        else  if (statusOption == 3) {
                            String doNe = "Done";
                            availableUser.getAvailableTask()[statusNumber].setStatus(doNe);
                        }
                        else{
                            System.out.println("Enter the correct StatusOption ");
                        }
                        {
                            System.out.println(availableUser.getAvailableTask()[statusNumber].getStatus());
                        }
                    }
                    else{
                        System.out.println("You Don't want to update the Status");
                    }
                }
                else if(choice==4)
                    {
                        Task[] newTasks = new Task[availableUser.getAvailableTask().length];
                    System.out.println("Enter the number to delete the task");
                    for (int i = 0; i < availableUser.getAvailableTask().length; i++) {
                        if (availableUser.getAvailableTask()[i] != null) {
                            System.out.print(i + 1 + ". ");
                            System.out.println(availableUser.getAvailableTask()[i].getDescription());
                            System.out.print("  CurrentStatus: ");
                            System.out.println(availableUser.getAvailableTask()[i].getStatus());
                        }
                    }
                    System.out.print("Pick any one: ");
                    wantToDeleteChoice = new Integer(sc.nextLine());
                    // wantToDeleteChoice=wantToDeleteChoice-1;
                    availableUser.getAvailableTask()[wantToDeleteChoice - 1] = null;
                        if (availableUser.getAvailableTask()[wantToDeleteChoice-1] == null) {
                            System.out.println("Invalid choice");
                            continue;
                        } else if (wantToDeleteChoice < 0) {
                            System.out.println("Invalid choice");
                            continue;
                        }
                    int num = 0;
                    for (int i = 0; i < availableUser.getAvailableTask().length; i++) {
                        if (availableUser.getAvailableTask()[i] != null) {
                            newTasks[num] = availableUser.getAvailableTask()[i];
                            num++;

                        }
                    }
                    for (int i = 0; i < availableUser.getAvailableTask().length; i++) {
                            availableUser.getAvailableTask()[i]=newTasks[i];
                        }

                    availableUser.setAvailableTask(newTasks);

                    for (int i = 0; i < availableUser.getAvailableTask().length; i++) {
                        if (newTasks[i] != null) {
                            System.out.print((i + 1) + ". ");
                            System.out.println(newTasks[i].getDescription());
                            System.out.print("  CurrentStatus: ");
                            System.out.println(availableUser.getAvailableTask()[i].getStatus());
                        }
                    }
                } else {
                    System.out.println("Come Again! NextTime ");
                    break;
                }
            }

        }

    }

// System.out.print("  CurrentStatus: ");
//                            System.out.println(availableUser.getAvailableTask()[i].getStatus());

}

