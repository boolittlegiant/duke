package task;

public class Task {

    protected String name;
    protected boolean isDone;

    public Task(String name) {
        this.name = name;
        this.isDone = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return (isDone ? "X" : " "); //X is done
    }

    public Boolean getStatusForSave() {
        return this.isDone;
    }

    public void markAsDone() {
        this.isDone = true;
    }

    public void markNotDone() {
        this.isDone = false;
    }


    public String toString() {
        return ("[" + getStatus() + "] " + name);
    }

    public String save() {
        return this.getName();
    }

}



