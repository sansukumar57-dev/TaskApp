package Task1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        User[] users = new User[6];
        Integer choice = 0;
        User availableUser = null;
        int userPositionArray = 0;
        boolean findUser;
        while (true) {
            System.out.println("Welcome to Task Manager ");
            System.out.println("Welcome to Task Manager ");
            System.out.println("Enter the userName: ");
            String userName = scanner.nextLine();

            findUser = false;

            for (int i = 0; i < users.length; i++) {
                if (users[i] == null) {
                    continue;
                }
                if (users[i].getName().equals(userName)) {
                    findUser = true;
                    userPositionArray = i;
                    break;
                }


            }
            if (findUser == false) {
                availableUser = new User(userName);
                for (int i = 0; i < users.length; i++) {
                    if (users[i] == null) {
                        users[i] = availableUser;
                        break;
                    }


                }
            } else {
                availableUser = users[userPositionArray];
                System.out.println("User is already Exists");
            }


            while (choice != 9) {
                try {
                    System.out.println("What all you can do with me!!");
                    System.out.println("1.Add Task");
                    System.out.println("2.Update");
                    System.out.println("3.Delete");
                    System.out.println("4.List of all Task");
                    System.out.println("5.Update the status ");
                    System.out.println("6.All TODO");
                    System.out.println("7.All In-Progress");
                    System.out.println("8.All Done");
                    System.out.println("9.Exit");
                    System.out.println("Enter your choice");
                    choice = new Integer(scanner.nextLine());
                }catch (Exception e){
                    System.out.println("Please enter the number only ");
                    choice=0;
                    continue;
                }

                if (choice == 1) {
                    System.out.println("Enter the descripition");
                    String description = scanner.nextLine();
                    Task task = new Task(description);
                    for (int i = 0; i < availableUser.getTasks().length; i++) {
                        if (availableUser.getTasks()[i] == null) {
                            availableUser.getTasks()[i] = task;
                            break;
                        }
                    }
                    System.out.println("task is created ");
                    System.out.println();
                } else if (choice == 2) {
                    System.out.println("To Update task select the number ");
                    for (int i = 0; i < availableUser.getTasks().length; i++) {
                        if (availableUser.getTasks()[i] != null) {
                            System.out.print(1 + i + ". ");
                            System.out.println(availableUser.getTasks()[i].getDescription());
                        }
                    }
                    System.out.println("Select the choice ");
                    Integer option = new Integer(scanner.nextLine());
                    System.out.println("Enter the new Description ");
                    String newDescription = scanner.nextLine();
                    availableUser.getTasks()[option - 1].setDescription(newDescription);
                } else if (choice == 3) {
                    System.out.println("To delete the task select the number");
                    for (int i = 0; i < availableUser.getTasks().length; i++) {
                        if (availableUser.getTasks()[i] != null) {
                            System.out.print(1 + i + ". ");
                            System.out.println(availableUser.getTasks()[i].getDescription());
                        }
                    }
                    System.out.println("Select the choice ");
                    Integer option = new Integer(scanner.nextLine());
                    availableUser.getTasks()[option - 1] = null;
                } else if (choice == 4) {
                    System.out.println("List of tasks ");
                    for (int i = 0; i < availableUser.getTasks().length; i++) {
                        if (availableUser.getTasks()[i] != null) {
                            System.out.print(1 + i + ". ");
                            System.out.print(availableUser.getTasks()[i].getDescription());
                            System.out.print("(");
                            System.out.print(availableUser.getTasks()[i].getStatus());
                            System.out.println(")");
                            System.out.println();
                        }
                    }
                } else if (choice == 5) {
                    System.out.println("List of tasks to update the status ");
                    for (int i = 0; i < availableUser.getTasks().length; i++) {
                        if (availableUser.getTasks()[i] != null) {
                            System.out.print(1 + i + ". ");
                            System.out.print(availableUser.getTasks()[i].getDescription());
                            System.out.print("(");
                            System.out.print(availableUser.getTasks()[i].getStatus());
                            System.out.println(")");
                        }
                    }
                    System.out.println("Enter the task number ");
                    Integer taskChoice = new Integer(scanner.nextLine());
                    if (availableUser.getTasks()[taskChoice - 1] != null) {
                        System.out.println("Enter the number to update the status ");
                        System.out.println("1.TODO");
                        System.out.println("2.In-Progress");
                        System.out.println("3.Done");
                        Integer statusChoice = new Integer(scanner.nextLine());
                        if (statusChoice == 1) {
                            String changeStatus = "TODO";
                            availableUser.getTasks()[taskChoice - 1].setStatus(changeStatus);
                        } else if (statusChoice == 2) {
                            String changeStatus = "In-Progress";
                            availableUser.getTasks()[taskChoice - 1].setStatus(changeStatus);
                        } else if (statusChoice == 3) {
                            String changeStatus = "DONE";
                            availableUser.getTasks()[taskChoice - 1].setStatus(changeStatus);
                        } else {
                            System.out.println("Check it once ");
                        }
                    }
                } else if (choice == 6) {
                    boolean flag = false;
                    for (int i = 0; i < availableUser.getTasks().length; i++) {
                        if (availableUser.getTasks()[i] != null) {
                            if (availableUser.getTasks()[i].getStatus().equals("TODO") || availableUser.getTasks()[i].getStatus().equals("Todo")) {
                                System.out.print(1 + i + ". ");
                                System.out.print(availableUser.getTasks()[i].getDescription());
                                System.out.print("(");
                                System.out.print(availableUser.getTasks()[i].getStatus());
                                System.out.println(")");
                                flag = true;
                            }
                        }
                    }
                    if (flag == false) {
                        System.out.println("No todo are here ");
                    }
                } else if (choice == 7) {
                    boolean flag = false;
                    for (int i = 0; i < availableUser.getTasks().length; i++) {
                        if (availableUser.getTasks()[i] != null) {
                            if (availableUser.getTasks()[i].getStatus().equals("In-Progress")) {
                                System.out.print(1 + i + ". ");
                                System.out.print(availableUser.getTasks()[i].getDescription());
                                System.out.print("(");
                                System.out.print(availableUser.getTasks()[i].getStatus());
                                System.out.println(")");

                            }
                        }
                    }
                    if (flag == false) {
                        System.out.println("No In-Progress status are here ");
                    }
                } else if (choice == 8) {
                    boolean flag = false;
                    for (int i = 0; i < availableUser.getTasks().length; i++) {
                        if (availableUser.getTasks()[i] != null) {
                            if (availableUser.getTasks()[i].getStatus().equals("DONE")) {
                                System.out.print(1 + i + ". ");
                                System.out.print(availableUser.getTasks()[i].getDescription());
                                System.out.print("(");
                                System.out.print(availableUser.getTasks()[i].getStatus());
                                System.out.println(")");
                                flag = true;
                            }
                        }
                    }
                    if (flag == false) {
                        System.out.println("No DONE status are here ");
                    }

                } else {
                    System.out.println("Exit come again");
                }

            }
        }

//    static void showTask() {
//
//
//        for (int i = 0; i < availableUser.getTasks().length; i++) {
//            if (availableUser.getTasks()[i] != null) {
//                System.out.println(availableUser.getTasks()[i].getDescription());
//            }
//
//        }
//
//    }
    }
}