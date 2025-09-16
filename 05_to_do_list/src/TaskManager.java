import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public class TaskManager {
    private List<Task> tasks = new ArrayList<>();

    public void addTask(Task task){
        tasks.add(task);
    }

    public void removeTask(int index){
        if (index > 0 && index <= tasks.size()){
            tasks.remove(index - 1);
            System.out.println("Task removed successfully.\n");
        } else {
            System.out.println("Invalid task number!\n");
        }
    }

    public void getDone(int index){
        if (index < 1 || index > tasks.size()){
            System.out.println("Invalid task number!");
            return;
        }

        Task task = tasks.get(index - 1);

        if (task.isDone()){
            System.out.println("Task has been done.");
        } else {
            task.setDone();
            System.out.println("Done successfully.");
        }
    }

    public List<Task> getTasks(String fileName) {
        return loadTasks(fileName);
    }

    // Serializing
    public void saveTasks(String title){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data/" + title + ".ser"))){
            oos.writeObject(tasks);
            System.out.println("Tasks saved to file!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // De-serializing
    public List<Task> loadTasks(String title){
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data/" + title + ".ser"))){
            return (List<Task>) ois.readObject();
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
