import java.util.Scanner;

public class AppController {
    AppController(Scanner sc) {
        while (true) {
            System.out.println("=== To Do List ===\n1. Display all files.\n2. Open a file.\n3. Create a file.\n4. Delete a file.\n5. Quit.");
            System.out.print("Enter your choice(a number): ");
            int choice = sc.nextInt();

            ToDoService service = new ToDoService();
            String fileName;
            switch (choice) {
                case 1:
                    service.getAllFiles();
                    break;
                case 2:
                    System.out.print("Enter file name(without .ser): ");
                    fileName = sc.nextLine(); // get file name

                    service.openFile(fileName);
                    break;
                case 3:
                    System.out.print("Enter file name(without .ser): ");
                    fileName = sc.nextLine(); // get file name

                    service.createFile(fileName);
                    break;
                case 4:
                    System.out.print("Enter file name(without .ser): ");
                    fileName = sc.nextLine();

                    service.deleteFile(fileName);
                    break;
                case 5:
                    System.out.println("Don't forget to come back later. Your tasks are waiting for you!");
                    return;
                default:
                    System.out.println("Invalid Choice. Try again.");
            }
        }
    }

}
