import java.util.Scanner;

class Mains {

   public static void main(String[] args) {

       Scanner sc=new Scanner(System.in);
       User[] currentUsers=new User[5];
       boolean existUser=false;
       int current=0;
       {
           System.out.println("welcome to Todays Task");
           System.out.println("Enter username");
           String userName = sc.nextLine();

           User currentUser;
           if(!existUser){
               currentUser = new User(userName);
               currentUsers[current]=currentUser;
           }
           else{
            currentUser =  currentUsers[current];
           }


           Integer choice = 0;
           while (choice != 5) {
               System.out.print("Welcome ");
               System.out.println(currentUser.getUserName());

               System.out.println("Choose any number");
               System.out.println("1.Create Task");
               System.out.println("2.Remove Task");
               System.out.println("3.Update Task");
               System.out.println("4.Show Tasks");
               System.out.println("5.Exit Task");
               System.out.println();

               System.out.println("Your choice");
               choice = new Integer(sc.nextInt());
               sc.nextLine();

               //  Task createdTask=null;
               if (choice == 1) {
                   System.out.println("Enter your description");
                   String description = sc.nextLine();
                   Task createdTask = new Task(description);
                   for (int i = 0; i < currentUser.getTask().length; i++) {
                       if (currentUser.getTask()[i] == null) {
                           currentUser.getTask()[i] = createdTask;
                           break;
                       }
                   }
                   System.out.println("Task is created ++");

               } else if (choice == 2) {
                   for (int i = 0; i < currentUser.getTask().length; i++) {
                     if(currentUser.getTask()!=null){
                         System.out.print(i+1);
                         System.out.print(" : ");
                         System.out.print(currentUser.getTask()[i].getComments());
                     }
                   }
                   System.out.println("pick option to removed the task");
                   Integer choi=new Integer(sc.nextLine());
                   currentUser.getTask()[choi-1]=null;
               } else if (choice == 3) {

                   for (int i = 0; i < currentUser.getTask().length; i++) {
                       if(currentUser.getTask()!=null){
                           System.out.println(i+1);
                           System.out.println(" : ");
                           System.out.println(currentUser.getTask()[i].getComments());
                           existUser=true;
                       }
                   }
                   if(!existUser){
                       System.out.println("not upadted task");
                       continue;
                   }
                   System.out.println("pick option to update the task");
                   Integer choi=new Integer(sc.nextLine());
                   System.out.println("Enter the description ");
                  String newComments=sc.nextLine();
                   currentUser.getTask()[choi-1].setComments(newComments);
                   System.out.println("updated the task");
               } else if (choice == 4) {
                   Task[] tasks= currentUser.getTask();
                   boolean found=false;

                   System.out.println("Your tasks");
                   for (int i = 0; i < tasks.length; i++) {
                       if(tasks[i]!=null){
                           System.out.println(i+1);
                           System.out.println(" : ");
                           System.out.println(currentUser.getTask()[i].getComments());
                           found=true;
                       }

                   }
                   if(!found){
                       System.out.println("no task is contain");
                   }
               } else {
                   System.out.println("Exited successfully");
               }

           }


       }

































































//int[] a  =new int[5];
//        System.out.println("whatbefore............");
//        for (int i = 0; i < a.length; i++) {
//            System.out.println(" "+i+" "+a[i]);
//        }
//
//        System.out.println("whatafter..............");
//        for(int i=0;i<a.length;i++){
//            a[i]=i+3;
//            System.out.println(" "+i+" "+a[i]);
//        }
//        System.out.println("whatdelete....................");
//        int n=a.length;
//        for(int i=1;i<a.length-1;i++){
//            a[i]=a[i]+1;
//            n=(a.length)-1;
//        }
//        System.out.println("Array after declaration");
//        for(int i=0;i<n;i++){
//            System.out.println(" "+i+" "+a[i]);
//        }
//        System.out.println("search");
//        for (int i = 0; i <n ; i++)
//        {if(a[i]==5){
//            System.out.println(3+" "+i);
//        }
//
//        }
     //   System.out.println("array elements are ");
//        for(int i=1;i<a.length;i++){
//            a[i]=a[i]+2;
//            System.out.println(i+" "+a[i]+" ");
//        }


    }
}