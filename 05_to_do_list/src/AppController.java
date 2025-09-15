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

                    service.openFile(fileName);
                    taskMenu(sc, fileName);
                    break;

                case 3: // create a file
                    System.out.println("\nNote: The program will add the .ser extension automatically.");
                    System.out.print("Enter file name: ");
                    fileName = sc.nextLine(); // get file name

                    service.createFile(fileName);
                    taskMenu(sc, fileName); // print all tasks
                    break;

                case 4: // delete a file
                    System.out.println("\nNote: The program will add the .ser extension automatically.");
                    System.out.print("Enter file name: ");
                    fileName = sc.nextLine();

                    service.deleteFile(fileName);
                    service.getAllFiles(); // print all the tasks after update
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
            System.out.println("1. Add a task\n2. Delete a task\n3. Mark as done\n4. Back to menu.");
            System.out.print("Enter your choice(a number): ");
            int choice = sc.nextInt();

            switch (choice) {
                // add a task
                case 1:
                    System.out.print("Enter task name: ");
                    String taskName = sc.nextLine(); // get title
                    Task task = new Task(taskName);
                    manager.addTask(task);

                    tasks = manager.getTasks(fileName);
                    manager.saveTasks(fileName); // serialize tasks

                    // print out all tasks
                    for (Task t : tasks){
                        System.out.println(t);
                    }
                    break;

                // delete a task
                case 2:
                    System.out.print("Enter a number of the task you want to delete: ");
                    int taskNumber = sc.nextInt();

                    manager.removeTask(taskNumber);
                    manager.saveTasks(fileName); // update

                    // print updated tasks
                    tasks = manager.getTasks(fileName);
                    for (Task t : tasks){
                        System.out.println(t);
                    }
                    break;

                // mark as done
                case 3:
                    System.out.print("Enter a number of the task you want to mark as done: ");
                    int taskIndex = sc.nextInt();

                    manager.getDone(taskIndex);
                    manager.saveTasks(fileName);

                    // print updated tasks
                    tasks = manager.getTasks(fileName);
                    for (Task t : tasks){
                        System.out.println(t);
                    }
                    break;

                case 4: // back to menu
                    System.out.println(); // empty line for readability
                    return;
                default:
                    System.out.println("Invalid Choice. Try again.");
            }
        }
    }

}
