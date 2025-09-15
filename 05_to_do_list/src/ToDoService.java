import java.io.*;
import java.util.List;


public class ToDoService {

    public void getAllFiles(){
        try {
            File folder = new File("data");
            String[] listOfFiles = folder.list();

            if (listOfFiles == null || listOfFiles.length == 0) {
                System.out.println("There are no files in the folder.");
            } else {
                // display all files
                System.out.println("Files in the folder:");
                for (int i  = 0; i < listOfFiles.length; i++) {
                    System.out.printf("%d. %s\n", i+1, listOfFiles[i]);
                }
                System.out.println();   // empty line for readability
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void openFile(String fileName){
        TaskManager tm = new TaskManager();

        System.out.println("You opened the file: " + fileName + ".ser");
        List<Task> tasks = tm.loadTasks(fileName);

        for (int i = 0; i < tasks.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, tasks.get(i));
        }
    }

    public void createFile(String fileName){
        String folderName = "data/";

        File file = new File(folderName + fileName + ".ser");
        try {
            if (file.createNewFile()) {
                System.out.println("File created");
            } else {
                System.out.println("File already exists");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void deleteFile(String fileName){
        String folderName = "data/";
        File file = new File(folderName + fileName + ".ser");

        if (file.delete()) {
            System.out.println("Deleted the file: " + file.getName());
        } else {
            System.out.println("Failed to delete the file.");
        }
    }
}
