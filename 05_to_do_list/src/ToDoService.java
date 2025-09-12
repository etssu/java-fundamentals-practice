import java.io.File;

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
}
