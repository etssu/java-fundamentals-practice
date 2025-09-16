import java.util.List;
import java.util.Scanner;

public class AppController {

    AppController(Scanner sc) {
        while (true) {
            System.out.println("=== To Do List ===\n1. Display all files.\n2. Open a file.\n3. Create a file.\n4. Delete a file.\n5. Quit.");
            System.out.print("Enter your choice(a number): ");
            int choice = sc.nextInt();
            sc.nextLine(); // clear input

            ToDoService service = new ToDoService();
            String fileName;

            switch (choice) {
                case 1: // display files
                    System.out.println(); // for readability
                    service.getAllFiles();
                    break;

                case 2: // open a file
                    System.out.println("\nNote: The program will add the .ser extension automatically.");
                    System.out.print("Enter file name: ");
                    fileName = sc.nextLine(); // get file name

                    if (!service.fileExists(fileName)) {
                        System.out.println("File does not exist. Try again.\n");
                        break;
                    }

                    service.openFile(fileName);
                    taskMenu(sc, fileName);
                    break;

                case 3: // create a file
                    System.out.println("\nNote: The program will add the .ser extension automatically.");
                    System.out.print("Enter file name: ");
                    fileName = sc.nextLine(); // get file name

                    if (service.fileExists(fileName)) {
                        System.out.println("File already exists.\n");
                        break;
                    }

                    service.createFile(fileName);
                    taskMenu(sc, fileName); // print all tasks
                    break;

                case 4: // delete a file
                    System.out.println("\nNote: The program will add the .ser extension automatically.");
                    System.out.print("Enter file name: ");
                    fileName = sc.nextLine();

                    if (!service.fileExists(fileName)) {
                        System.out.println("File does not exist. Try again.\n");
                        break;
                    }

                    service.deleteFile(fileName);
                    service.getAllFiles(); // print all the files after update
                    break;

                case 5: // quit
                    System.out.println("Don't forget to come back later. Your tasks are waiting for you!");
                    return;
                default:
                    System.out.println("Invalid Choice. Try again.");
            }
        }
    }

    private void taskMenu(Scanner sc, String fileName) {
        TaskManager manager = new TaskManager();
        List<Task> tasks;

        while (true) {
            System.out.println("What do you want to do next?");
            System.out.println("1. Display all tasks.\n2. Add a task.\n3. Mark as done.\n4. Delete a task.\n5. Back to menu.");
            System.out.print("Enter your choice (a number): ");
            int choice = sc.nextInt();
            sc.nextLine(); // to clear the input

            switch (choice) {
                // display tasks
                case 1:
                    tasks = manager.getTasks(fileName);
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks.\n");
                        break;
                    }

                    System.out.println("Tasks in current directory:");
                    for (int i = 0; i < tasks.size(); i++) {
                        System.out.printf("%d. %s\n", i + 1, tasks.get(i));
                    }
                    break;

                // add a task
                case 2:
                    System.out.print("Enter task name: ");
                    String taskName = sc.nextLine(); // get title
                    Task task = new Task(taskName);
                    manager.addTask(task);

                    manager.saveTasks(fileName); // serialize tasks
                    tasks = manager.getTasks(fileName);

                    // print out all tasks
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks.\n");
                        break;
                    }

                    System.out.println("Tasks in current directory:");
                    for (int i = 0; i < tasks.size(); i++) {
                        System.out.printf("%d. %s\n", i + 1, tasks.get(i));
                    }
                    System.out.println(); // spacing for readability
                    break;

                // mark as done
                case 3:
                    System.out.print("Enter a number of the task you want to mark as done: ");
                    int taskIndex = sc.nextInt();

                    manager.getDone(taskIndex);
                    manager.saveTasks(fileName);

                    // print updated tasks
                    tasks = manager.getTasks(fileName);
                    if (tasks == null) {
                        System.out.println("No tasks.\n");
                        break;
                    }

                    System.out.println("Tasks in current directory:");
                    for (int i = 0; i < tasks.size(); i++) {
                        System.out.printf("%d. %s\n", i + 1, tasks.get(i));
                    }
                    System.out.println(); // spacing for readability
                    break;

                // delete a task
                case 4:
                    System.out.print("Enter a number of the task you want to delete: ");
                    int taskNumber = sc.nextInt();

                    manager.removeTask(taskNumber);
                    manager.saveTasks(fileName); // update

                    // print updated tasks
                    tasks = manager.getTasks(fileName);
                    System.out.println("Tasks in current directory:");
                    for (int i = 0; i < tasks.size(); i++) {
                        System.out.printf("%d. %s\n", i + 1, tasks.get(i));
                    }
                    System.out.println();
                    break;

                // back to menu
                case 5:
                    System.out.println(); // spacing for readability
                    return;

                default:
                    System.out.println("Invalid Choice. Try again.\n");
            }
        }
    }

}
