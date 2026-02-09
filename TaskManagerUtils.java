package Some.TODO;

public abstract class TaskManagerUtils {


    public static void displayTitle(User avilableUser){
        for (int i = 0; i < avilableUser.getAvailableTask().length; i++) {
            if ( avilableUser.getAvailableTask()[i]!=null){
                System.out.print(i+1+" ");
                System.out.println( avilableUser.getAvailableTask()[i].getTitle());
            }
        }

    }

    public static  void displayStatus(User availableUser, String status){

        int n=1;
        for (int i = 0; i < availableUser.getAvailableTask().length; i++) {
            if(availableUser.getAvailableTask()[i].getStatus().equals(status)){
                System.out.print(n +" ");
                System.out.println(availableUser.getAvailableTask()[i].getTitle());
                System.out.println(availableUser.getAvailableTask()[i].getDescription());;
                n++;
                System.out.println(availableUser.getAvailableTask()[i].getStatus());
            }
        }

    }
    public static boolean emptyTask(User availableUser){
        for (int i = 0; i < availableUser.getAvailableTask().length; i++) {
            if (availableUser.getAvailableTask()[i] != null) {
                return true;
            }
        }
        return false;

    }


}
