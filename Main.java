package Todo_APP_System;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        User[] userArray=new User[10];
        System.out.println("================ToDo==================");
        while (true) {
            System.out.println("Enter your username");
            String userName = sc.nextLine();
            boolean isExistingUser=false;
            int currentUserPosition=0;
            for (int i = 0; i < userArray.length; i++) {

                if(userArray[i]==null){
                    continue;
                }


                User user= userArray[i];
                String name= userName;

                 if( userArray[i].getUserName().equals(userName)) {
                     currentUserPosition=i;
                 break;
                }
            }

            User currentUser;
            if(!isExistingUser){
                 currentUser=new User(userName);
                for (int i = 0; i < userArray.length; i++) {
                   if(userArray[i]!= null){
                      continue;
                    }
                   userArray[i]=currentUser;
                   break;
                }
                 userArray[0]=currentUser;
            }
            else {
               currentUser= userArray[currentUserPosition];
            }

//             currentUser = new User(userName);
            Integer choice = 0;
            while (choice != 2) {
                System.out.print("Welcome ");
                System.out.println(currentUser.getUserName());
                System.out.println("1.Add Task ");
                System.out.println("2.List of my task ");
                System.out.println("3.Exit ");
                System.out.println("4.Update ");
                System.out.println("Enter your choice");
                choice = new Integer(sc.nextLine());

                if (choice == 1) {
                    System.out.println("Enter taskDescription");
                    String taskDescription = sc.nextLine();
                    Task userTask = new Task(taskDescription);

                    for (int i = 0; i < currentUser.getTaskArray().length; i++) {
if (currentUser.getTaskArray()[i]==null){
    currentUser.getTaskArray()[i]=userTask;

    System.out.println("TaskAdded successfully");
break;
}
                    }



//                    currentUser.getTaskArray()[0] = userTask;
//                    System.out.println("TaskAdded successfully");
                }
                else if (choice == 3) {
                    System.out.println("Thanks for use task ");

                } else if (choice ==2) {
            boolean isThereAnyTask=false;
            for (int i = 0; i < currentUser.getTaskArray().length; i++) {
        if(currentUser.getTaskArray()[i]!=null){
            String taskDescription=  currentUser.getTaskArray()[i].getTaskDescription();

                        System.out.println(taskDescription);
                        isThereAnyTask=true;
                    }
        if(isThereAnyTask==false){
            System.out.println("There is no task at this momemnt.");
        }


                }
            } else if (choice==4)

                {
                    System.out.println("Update the task:");
                    boolean isUpdate=false;
                    for (int i = 0; i < currentUser.getTaskArray().length; i++) {
                        if (currentUser.getTaskArray()[i]!=null){
                            System.out.print((i+1));
                            System.out.print(".");
                            System.out.println(" "+currentUser.getTaskArray()[i].getTaskDescription());
isUpdate=true;
                        }
                        if(!isUpdate){
                            System.out.println("No update is there ");
                        }

                    }
                }
                if (choice==5)
                {
                        System.out.println("Update the task:");
                        boolean isDelete=false;
                        for (int i = 0; i < currentUser.getTaskArray().length; i++) {
                            if (currentUser.getTaskArray()[i]!=null){
                                System.out.print((i-1));
                                System.out.print(".");
                                System.out.println(" "+currentUser.getTaskArray()[i].getTaskDescription());
                                isDelete=true;
                            }
                            if(!isDelete){
                                System.out.println("No Deleted is there ");
                            }

                        }

                }


    }
  }
 }
}