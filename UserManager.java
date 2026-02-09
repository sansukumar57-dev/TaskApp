package Some.TODO;

import java.util.Scanner;

public class UserManager implements UserInterface{
    Scanner sc= new Scanner(System.in);
    User[] users = new User[4];

    public User login() {
        User currentUser = null;
        String username;
        System.out.println("Welcome to Your Task ");
        boolean name = false;

        while (!name) {
            System.out.println("Enter your name");
            try {
                username = sc.nextLine();
                if (username.isEmpty()) {
                    throw new Exception();
                }
                for (int i = 0; i < users.length; i++) {
                if (users[i] == null) {
                    continue;
                }
                if (users[i].getName().equals(username)) {
                    currentUser = users[i];
                    System.out.println("User is already Exists");
                    System.out.println("Welcome Back");
                    break;
                }
            }
            if (currentUser == null) {
                currentUser = new User(username);
                for (int i = 0; i < users.length; i++) {
                    if (users[i] == null) {
                        users[i] = currentUser;
                        break;
                    }
                }
            }
            name = true;
            } catch (Exception e) {
                System.out.println("Username should not be Empty ");
            }
        }
        return currentUser;

    }
}
