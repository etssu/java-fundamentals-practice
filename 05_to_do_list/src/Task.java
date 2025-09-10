import java.io.Serializable;

public class Task implements Serializable{
    String name;
    String deadline;
    boolean done;

    Task(String name,String deadline){
        this.name = name;
        this.deadline = deadline;
        done = false;
    }



}
