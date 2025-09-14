import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    public List<Task> tasks = new ArrayList<Task>();

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

}
