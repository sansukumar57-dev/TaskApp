import java.util.Scanner;

////TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
//// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
//void main() {
//    //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
//    // to see how IntelliJ IDEA suggests fixing it.
//    IO.println(String.format("Hello and welcome!"));
//
//    for (int i = 1; i <= 5; i++) {
//        //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
//        // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
//        IO.println("i = " + i);
//    }
//}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        User currentUser;
        System.out.println("===========WELCOME TO TODO CLI SYSTEM ==============");
        System.out.print("Enter your userName:");
        String userName = sc.nextLine();
        currentUser = new User(userName);
        System.out.print("\n");
        while (true) {
            System.out.print("Welcome ");
            System.out.println(currentUser.getUserName());
            System.out.println("Available features");
            System.out.println("1.Add the task");
            System.out.println("2.Show the task");
            System.out.println("3.Update the task");
            System.out.println("4.Delete the task");
            System.out.println("5.Exit");
            System.out.println("Choose any Option ");
            Integer option = new Integer(sc.nextLine());
            if (option == 1) {
                //Add the task
                System.out.println("Enter the task Description");
                String description = sc.nextLine();
                Task currentUserTask = new Task(description);
                //   System.out.println(currentUserTask.getDescription());
                for (int i = 0; i < currentUser.getCurrentUserTask().length; i++) {
                    if (currentUser.getCurrentUserTask()[i] == null) {
                        currentUser.getCurrentUserTask()[i] = currentUserTask;
                        break;// it assining the same address to all the array index
//                    System.out.print(i+1+" ");
//                    System.out.println(currentUser.getCurrentUserTask()[i].getDescription());
                    }
                }
                System.out.println("Your task is created Successfully");
                // It shows every time when task is created
                System.out.println("Created tasks are :");
                for (int i = 0; i < currentUser.getCurrentUserTask().length; i++) {
                    if(currentUser.getCurrentUserTask()[i]!=null){
                        System.out.print(i + 1 + " ");
                        System.out.print(currentUser.getCurrentUserTask()[i].getDescription());
                        System.out.print(" ^");
                        System.out.print(currentUser.getCurrentUserTask()[i].getStatus());
                        System.out.println("^");
                    }

                }
            } else if (option == 2) {
                boolean flag=false;
                System.out.println("List of available Tasks");
                    for (int i = 0; i < currentUser.getCurrentUserTask().length; i++) {
                        if (currentUser.getCurrentUserTask()[i]!= null) {
                  //   String des = currentUser.getCurrentUserTask()[i].getDescription();
                        System.out.print(i + 1 + " ");
                        System.out.println(currentUser.getCurrentUserTask()[i].getDescription());
                            System.out.println(currentUser.getCurrentUserTask()[i].getStatus());
                        flag=true;

                    }
                        else {
                            continue;
                        }
                }

                for (int i = 0; i < currentUser.getCurrentUserTask().length; i++) {
                    if(currentUser.getCurrentUserTask()[i]!=null){
                        System.out.print(i + 1 + " ");
                        System.out.println(currentUser.getCurrentUserTask()[i].getDescription());
                        System.out.println("If you want to Update Your Status: YES||NO");
                        String statusOption=new String(sc.nextLine());
                        Integer options=0;
                        String status="";
                        if(statusOption.equals("YES")){
                            System.out.println("Select the Status of task ");
                            System.out.println("1.Todo");
                            System.out.println("2.In-Progress");
                            System.out.println("3.Done");
                            System.out.println("Pick any number: ");
                            options=new Integer(sc.nextLine());

                            if(options==1){
                                status="Todo";
                                currentUser.getCurrentUserTask()[i].setStatus(status);
                            }
                            else if(options==2){
                                status="In-Progress";
                                currentUser.getCurrentUserTask()[i].setStatus(status);
                            } else if(options==3){
                                status="Done";
                                currentUser.getCurrentUserTask()[i].setStatus(status);
                            }
                            System.out.print((i + 1) + ". " );
                            System.out.print(currentUser.getCurrentUserTask()[i].getDescription());
                            System.out.print("Status:-");
                            System.out.println(currentUser.getCurrentUserTask()[i].getStatus());
                        }else{
                            System.out.println("check again");
                        }

                    }

                }





            }
            else if (option==3)
            {
                boolean flag=false;
                for (int i = 0; i < currentUser.getCurrentUserTask().length;  i++) {
                    if (currentUser.getCurrentUserTask()[i]!=null){
                        System.out.print(i + 1 + ". ");
                        System.out.println(currentUser.getCurrentUserTask()[i].getDescription());
                        flag=true;
                    }
                }
                System.out.println("Enter the number to update:");
                Integer choiceUpdate=new Integer(sc.nextLine());
                System.out.println("Enter the New description: ");
                String newDescription=sc.nextLine();
                currentUser.getCurrentUserTask()[choiceUpdate-1].setDescription(newDescription);
//              after updated i showing the updated tasks
                System.out.println("Updated tasks are :");
                for (int i = 0; i < currentUser.getCurrentUserTask().length; i++) {
                    if(currentUser.getCurrentUserTask()[i]!=null){
                        System.out.print(i + 1 + " ");
                        System.out.println(currentUser.getCurrentUserTask()[i].getDescription());
                    }

                }



            }
            else if (option==4) {
                boolean flag=false;
                for (int i = 0; i < currentUser.getCurrentUserTask().length;  i++) {
                    if (currentUser.getCurrentUserTask()[i]!=null){
                        System.out.print(i + 1 + ". ");
                        System.out.println(currentUser.getCurrentUserTask()[i].getDescription());
                        flag=true;
                    }
                }
                System.out.println("Enter the number to delete:");
                Integer choiceDelete=new Integer(sc.nextLine());
                String delete=null;
                currentUser.getCurrentUserTask()[choiceDelete-1].setDescription(delete);

                // after deleted i showing which task is deleted
                System.out.println("Deleted task are :");
                for (int i = 0; i < currentUser.getCurrentUserTask().length; i++) {
                    if(currentUser.getCurrentUserTask()[i]!=null){
                        System.out.print(i + 1 + " ");
                        System.out.println(currentUser.getCurrentUserTask()[i].getDescription());
                    }

                }
            }
            else{
                System.out.println("Exited Come Again ^_^ ");
                break;
            }

        }

}
}