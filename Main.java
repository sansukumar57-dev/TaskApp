package Task;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        User[] users = new User[5];
        while (true) {
            System.out.println("Welcome to the task manager");
            //1.it for introducing my self to the user
            System.out.println("Enter the user name:");
            //2.it for saying the user to enter your name
            String userName = sc.nextLine();
            //3.if the user enter his name then i get his name through by gettig the address of the scannerand called the scanner class and it give me the methods to communcate withe terminal and main throug ht the String reference variable
            // now the user gave this name that i stored in the string object and i stored in the reference variable.
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
        //4.after the user type his name in the terminal i stored in the reference variable inside the string object where it is datatype.Then now i displaying the user before i display the welcome in the terminal .
                //asking back directly to the user that Enter any option
        System.out.println(currentUser.getUserName());
        //it prints in the console
        //5.here i calling the currentuser it gives me the useraddress and by the address i call the userclassObject and it give me contract that has the method to communicate with the main and terminal
        //call the currentuser and it give the address using the address mulaiyama ennaku contract ketaichadu addu vacchu na  getusenamemethod kupputen and it returns the address of that users what it given in the terminal that already it has know soi get it from the user

                System.out.println("1.Add task");
                //priting in the terminal to select the 1.option then i can able to store it some what as the integer and by using that integer address
                System.out.println("2.List of Task");
                //printing text in the terminal to show user to select this option then i store the givan value some respective integer class
                System.out.println("3.Update");//for this also
                System.out.println("4.Delete");// fro this also
                System.out.println("5.Exit");//for this also
                System.out.print("Enter your choice: ");//now i force the user t enter some integer in the terminal so i can store some where and take it from ther an compare the number with si=ome boolean
                System.out.println();
                choice = new Integer(sc.nextLine());
                //when the user give some thing in the terminal i saying the terminal that now you get only integer .
                //by seeing the new keyword it created the objects and the object called integer that convert the string into int value because of wrapper class
                //
                if(choice==1){
                    // her the choice of Integer is converted into the value so only it wold be compared with ( == ) to 1 because it is in the range
                    System.out.print("Enter the description: ");
                    //I print in the console that you would be display
                    String description=sc.nextLine();
                    //giting the address from the scanner and call the scanner then it give the contract of the scanner and i take the nextline method to get the input from the terminal and finally it now has the address that i going to store in the description.
                    //it sores the strings address
                    Task userTask=new Task(description);
                    //by seeing the new keyword it creates the object inside the java memory model in the heap meory
                    //it gives the address and now i store in the variable
                    //now it has the userdefinded task constructor description it stores in the instance variable
                   // System.out.println(userTask.getDescription());
                    for (int i = 0; i <currentUser.getTask().length; i++) {
                        //

                        if(currentUser.getTask()[i]==null){
                        currentUser.getTask()[i]=userTask;
                        System.out.print("Description Added: ");
                        System.out.println(currentUser.getTask()[i].getDescription());
                            System.out.print(" << Status --");
                            System.out.print(currentUser.getTask()[i].getStatus());

                        break;
                    }
                    }
                    System.out.println("User Task is Added ");
                    //when the description is enterd by the user next to say the user that the task is created it simply display in the console that it is created              //
                }
                else if(choice==2){
                    //list
                    boolean isTask=false;
                    for (int i = 0; i < currentUser.getTask().length; i++) {
                        if(currentUser.getTask()[i]!=null) {
                            System.out.println("List of the available Tasks ");
                            System.out.print(i+1+ ". ");
                            System.out.print(currentUser.getTask()[i].getDescription());
                            System.out.print(" << Status --");
                            System.out.print(currentUser.getTask()[i].getStatus());
                          //  System.out.print(" ---");
                            System.out.println();
                            isTask=true;
                        }
                    }if(isTask==false){
                        System.out.println("no task is there ");
                    }
                    //
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
                    System.out.println(currentUser.getTask()[up-1].getDescription());
                    currentUser.getTask()[up-1].setStatus("In progress");
                    System.out.println(currentUser.getTask()[up-1].getStatus());



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
        }//inprogress-working  done-have to do todo-starting
    }
}