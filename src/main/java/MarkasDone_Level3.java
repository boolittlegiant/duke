public class MarkasDone_Level3 {
    protected String list;
    protected boolean isDone;

    public Task(String list){
        this.list = list;
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
        return ("["+ getStatus() + "] " + list);
    }
}
