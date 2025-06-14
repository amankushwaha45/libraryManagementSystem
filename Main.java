import java.util.Random;
import java.util.Scanner;
import Manager.*;
import Manager.LibraryManager;
import Manager.LoginManager;
import model.*;



public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LibraryManager library = new LibraryManager();
        LoginManager login = new LoginManager();

        User currentUser=null;
        while (currentUser==null){
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");
            int choice = scanner.nextInt();
            if(choice==1){
                System.out.println("Username: ");
                String username= scanner.next();
                System.out.println("Password: ");
                String password = scanner.next();
                currentUser=login.login(username,password,library.getAllUsers());
                if (currentUser==null){
                    System.out.println("Invalid username or password, Try again");

                }
            } else if (choice==2) {
                System.out.println("Name: ");
                String name = scanner.next();
                System.out.println("Username: ");
                String username = scanner.next();
                System.out.println("Password: ");
                String password = scanner.next();
                int userId=new Random().nextInt(9000)+1000;
                User newUser = new User(userId, name, username, password, false);
                library.addUser(newUser);
                System.out.println("User Registered Successfully, Now You can Login");
            } else if (choice==3) {
                System.out.println("Goodbye! ");
                return;

            } else {
                System.out.println("Invalid Choice, Try again");
            }
        }
        System.out.println("Welcome "+currentUser.getName());
        int choice;
        do {
            System.out.println("========Menu========");
            if (currentUser.getIsAdmin()){
                System.out.println("1. Add Book");
                System.out.println("2. View Book");
                System.out.println("3. View User");
                System.out.println("4. Logout");
                choice= scanner.nextInt();
                if (choice==1){
                    System.out.println("Book Title");
                    String title= scanner.nextLine();
                    System.out.println("Book Author");
                    String author= scanner.nextLine();
                    System.out.println("Book Publisher");
                    String publisher= scanner.nextLine();
                    System.out.println("Book Year");
                    int year= scanner.nextInt();
                    System.out.println("Copies");
                    int copies= scanner.nextInt();
                    int bookId= new Random().nextInt(9000);
                }
            }
        }while(true);
    }
}
