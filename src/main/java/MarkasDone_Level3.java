public abstract class MarkasDone_Level3 {
    protected String task;
    protected boolean isDone;

    public Task(String task){
        this.task = task;
        this.isDone = false;
    }

    public String getStatus(){
        return (isDone ? "X" : " "); //X is done
    }

    public void markAsDone(){
        this.isDone = true;
    }

    public abstract String toString(){
        return  ("["+ getStatus() + "] " + getTask());
    }

    /*public String getTask(){
        return this.task;
    }

    @Override
    public String toString() {
        return ("["+ getStatus() + "] " + getTask());
    }*/

}
