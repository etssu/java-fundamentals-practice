import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    public List<Task> tasks = new ArrayList<Task>();

    public void addTask(Task task){
        tasks.add(task);
    }

    public List<Task> getTasks() {
        return tasks;
    }
}
