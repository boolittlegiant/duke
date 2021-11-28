public class Task {

    protected String name;
    protected boolean isDone;

    public Task(String name){
        this.name = name;
        this.isDone = false;
    }

    public String getStatus(){
        return (isDone ? "X" : " "); //X is done
    }

    public void markAsDone(){
        this.isDone = true;
    }

    //Override
    public String toString(){
        return ("["+ getStatus() + "] " + name);
    }

}



