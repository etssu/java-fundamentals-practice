import java.io.Serializable;

public class Task implements Serializable{
    String title;
    boolean done;

    Task(String title){
        this.title = title;
        done = false;
    }

    public boolean isDone() { // to check whether the task is done
        return done;
    }

    public void setDone(){
        this.done = true;
    }

    @Override
    public String toString() {
        return (done ? "[x] " : "[ ] ") + title;
    }

}
