package Some.TODO;
import java.util.Scanner;
public class Mains {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        UserManager userManager = new UserManager();
        while (true) {
            User currentUser = userManager.login();


            Integer choice;
            choice = 0;
            while (choice != 5) {
                boolean valid = false;
                System.out.println("Available features");
                System.out.println("1.Add the task");
                System.out.println("2.Show the task");
                System.out.println("3.Update the task");
                System.out.println("4.Delete the task");
                System.out.println("5.Exit");
                System.out.println("Choose any Option ");
                String choices = sc.nextLine();

                try {
                    if (choices.equals("exit")) {
                        throw new Exception();
                    }
                    if (choices.isEmpty()) {
                        System.out.println("Option should not be empty");
                        continue;

                    }
                    boolean trueChoice = false;
                    while (!trueChoice) {
                        try {
                            choice = new Integer(choices);
                            if (choice < 1 || choice > 5) {
                                throw new Exception();
                            }
                            trueChoice = true;

                        } catch (Exception e) {
                            System.out.println("=== Enter the valid option first ===");
                            trueChoice = true;
                        }
                    }
                    if (trueChoice) {
                        TaskManager taskManager = new TaskManager();
                        if (choice == 1) {
                            taskManager.addTask(currentUser);
                        } else if (choice == 2) {
                            taskManager.showTask(currentUser);
                        } else if (choice == 3) {
                            taskManager.updateTask(currentUser);
                        } else if (choice == 4) {
                            taskManager.deleteTask(currentUser);
                        } else if (choice == 5) {
                            throw new Exception();
                        }
                    }


                } catch (Exception e) {
                    if (choice == 5 || choices.equals("exit")) {
                        System.out.println("Exit");
                        System.out.println("Come Again! NextTime ");
                        break;
                    }
                }

            }

        }
    }
    }

