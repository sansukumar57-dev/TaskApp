package Task;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        User[] users = new User[5];
        while (true) {
            System.out.println("Welcome to the task manager");
            System.out.println("Enter the user name:");
            String userName = sc.nextLine();

            boolean findUser = false;
            int userPositionArray = 0;

            for (int i = 0; i < users.length; i++) {
                if (users[i] == null) {
                    continue;
                }
                if (users[i].getUserName().equals(userName)){
                    findUser=true;
                    userPositionArray=i;
                    break;
            }

        }


            User currentUser;
            if (findUser == false) {
                currentUser = new User(userName);

                for (int i = 0; i < users.length; i++) {
                    if (users[i] == null) {
                        users[i] = currentUser;
                        break;
                    }

                }
            } else {
                currentUser = users[userPositionArray];
                System.out.println("User is already Exists");
            }



            Integer choice = 0;//Autoboxing
            while(choice!=5){
        System.out.print("welcome ");
        System.out.println(currentUser.getUserName());
                System.out.println("1.Add task");
                System.out.println("2.List of Task");
                System.out.println("3.Update");
                System.out.println("4.Delete");
                System.out.println("5.Exit");
                System.out.print("Enter your choice: ");
                System.out.println();
                choice = new Integer(sc.nextLine());
                if(choice==1){
                    //add
                    System.out.print("Enter the description: ");
                    String description=sc.nextLine();
                    Task userTask=new Task(description);
                   // System.out.println(userTask.getDescription());
                    for (int i = 0; i <currentUser.getTask().length; i++) {
                        if(currentUser.getTask()[i]==null){
                        currentUser.getTask()[i]=userTask;
                        System.out.print("Description Added: ");
                        System.out.println(currentUser.getTask()[i].getDescription());
                        break;
                    }
                    }
                    System.out.println("User Task is Added ");
                    //add list delete
                    //main user task
                    //
                }
                else if(choice==2){
                    //list
                    boolean isTask=false;
                    for (int i = 0; i < currentUser.getTask().length; i++) {
                        if(currentUser.getTask()[i]!=null) {
                            String taskDescription = currentUser.getTask()[i].getDescription();
                            System.out.println("List of the available Tasks ");
                            System.out.println(taskDescription);
                            isTask=true;
                        }
                    }if(isTask==false){
                        System.out.println("no task is there ");
                    }
                } else if (choice==3) {
                    //update
                    boolean update=false;
                    for(int i=0;i<currentUser.getTask().length;i++){
                        if(currentUser.getTask()[i]!=null){
                            System.out.print(i+1+" ");
                            System.out.println(currentUser.getTask()[i].getDescription());
                            update=true;
                        }

                    }
                    if(update==false){
                        System.out.println("no available update for now");
                    }
                    System.out.println("Enter the number between <10 to update:");

                    Integer up=new Integer(sc.nextLine());
                    System.out.println("Enter the description to update");
                    String updated= sc.nextLine();
                    currentUser.getTask()[up-1].setDescription(updated);


                } else if (choice==4) {
                    for (int i = 0; i < currentUser.getTask().length; i++) {
                        if (currentUser.getTask()[i]!=null){
                            System.out.print(i+1+" ");
                            System.out.println(currentUser.getTask()[i].getDescription());
                        }

                    }
                    System.out.println("Enter the number  between <10 to delete ");
                    Integer delete=new Integer(sc.nextLine());
                    currentUser.getTask()[delete-1]=null;

                } else {
                    System.out.println("EXIT from Task ");
                }
            }
        }
    }
}