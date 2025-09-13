import java.io.*;
import java.util.List;


public class ToDoService {

    public void getAllFiles(){
        try {
            File folder = new File("data");
            String[] listOfFiles = folder.list();

            // display the names of the files
            for (String fileName : listOfFiles) {
                System.out.println(fileName);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public void openFile(String fileName){
        String folderName = "data/";
        String filePath = folderName + fileName + ".ser"; // get file path

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            List<Task> tasks = (List<Task>) ois.readObject();

            System.out.println("You opened the file " + fileName + ".ser:");

            if (tasks.isEmpty()) {
                System.out.println("The file is empty.");
            } else {
                for (int i = 0; i < tasks.size(); i++) {
                    System.out.printf("%d. %s\n", i + 1, tasks.get(i));
                }
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
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
