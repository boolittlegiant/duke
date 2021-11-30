package task;

public class Todo extends Task {

    public Todo(String description) {
        super(description);
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

    @Override
    public String save() {
        return "T" + " | " + (this.getStatusForSave() ? 1 : 0) + " | " + super.save() + System.lineSeparator();
    }
}