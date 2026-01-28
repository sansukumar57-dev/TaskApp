package Some.TODO;
import java.util.Scanner;
public class Mains {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        User[] users=new User[4];
        Integer choice;
        User currentUser = null;
        int userPositionArray = 0;
        boolean findUser;
        String username;
        while(true) {
            findUser = false;
            System.out.println("Welcome to Your Task ");
            System.out.println("Enter your name");
            username = sc.nextLine();
            for (int i = 0; i < users.length; i++) {
                if (users[i] == null) {
                    continue;
                }
                if (users[i].getName().equals(username)) {
                    findUser = true;
                    userPositionArray = i;
                    break;
                }
            }
            if (findUser == false) {
                currentUser = new User(username);
                for (int i = 0; i < users.length; i++) {
                    if (users[i] == null) {
                        users[i] = currentUser;
                        break;
                    }
                }
            } else {
                currentUser = users[userPositionArray];
                System.out.println("Welcome Back");
            }
            choice = 0;
            while (choice != 6) {
                System.out.println("Available features");
                System.out.println("1.Add the task");
                System.out.println("2.Show the task");
                System.out.println("3.Update the task");
                System.out.println("4.Delete the task");
                System.out.println("5.Exit");
                System.out.println("Choose any Option ");
                choice = new Integer(sc.nextLine());
                TaskManager taskManager = new TaskManager();
                if (choice == 1) {
                    taskManager.addTask(currentUser);
                } else if (choice == 2) {
                    taskManager.showTask(currentUser);
                } else if (choice == 3) {
                    taskManager.updateTask(currentUser);
                } else if (choice == 4) {
                    taskManager.deleteTask(currentUser);
                }
                else {
                    System.out.println("Come Again! NextTime ");
                    break;
                }




                //System.out.println("5.List of task with status");
//                else if (choice==5) {
//
//                    for (int i = 0; i < availableUser.getAvailableTask().length; i++) {
//                if (availableUser.getAvailableTask()[i] != null) {
//                    System.out.print((i + 1) + ". ");
//                    System.out.println(availableUser.getAvailableTask()[i].getDescription());
//                    System.out.print("  CurrentStatus: ");
//                    System.out.println(availableUser.getAvailableTask()[i].getStatus());
//                }
//            }


            }

        }
    }
}