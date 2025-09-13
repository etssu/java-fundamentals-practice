import java.io.Serializable;

public class Task implements Serializable{
    String title;;
    boolean done;

    Task(String title){
        this.title = title;
        done = false;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done){
        this.done = done;
    }

    @Override
    public String toString() {
        return (done ? "[x] " : "[ ] ") + title;
    }

}
