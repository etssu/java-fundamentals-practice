import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public class TaskManager {
    public List<Task> tasks = new ArrayList<>();

    public void addTask(Task task){
        tasks.add(task);
    }

    public void removeTask(int index){
        if (index > 0 && index < tasks.size()){
            tasks.remove(index - 1);
            System.out.println("Task removed successfully.");
        } else {
            System.out.println("Invalid task number!");
        }
    }

    public void getDone(int index){
        if (index > 0  && index < tasks.size()){
            Task task = tasks.get(index-1);
            task.setDone();
            System.out.println("Done successfully.");
        } else {
            System.out.println("Invalid task number!");
        }
    }

    public List<Task> getTasks() { return new ArrayList<>(tasks); }

    public void saveTasks(List<Task> tasks, String title){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data/" + title + ".ser"))){
            oos.writeObject(tasks);
            System.out.println("Tasks saved to file!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public void loadTasks(List<Task> tasks, String title){
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data/" + title + ".ser"))){
            tasks = (List<Task>) ois.readObject();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
