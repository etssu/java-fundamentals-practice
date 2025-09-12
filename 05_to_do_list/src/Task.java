import java.io.Serializable;

public class Task implements Serializable{
    String title;
    String deadline;
    boolean done;

    Task(String title){
        this.title = title;
        done = false;
    }



}
