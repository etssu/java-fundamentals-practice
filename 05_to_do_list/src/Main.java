import java.util.Scanner;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("=== To Do List ===\n1. Display all files.\n2. Open a file.\n3. Delete a file.\n4. Create a file.\n5. Quit.");
            System.out.print("Enter your choice(a number): ");
            int choice = sc.nextInt();
            switch(choice){
                case 4:
                    System.out.println("Don't forget to come back later. Your tasks are waiting for you!");
                    return;
                default:
                    System.out.println("Invalid Choice. Try again.");
            }
        }
    }
}