package task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Event extends Task {

    protected LocalDateTime at;

    public Event(String description, LocalDateTime at) {
        super(description);
        this.at = at;
    }

    public void setBy(LocalDateTime at) {
        this.at = at;
    }

    public LocalDateTime getAt() {
        return this.at;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + at.format(DateTimeFormatter.ofPattern("MMM dd yyyy HH:mm")) + ")";
    }

    @Override
    public String save() {
        return "E" + " | " + (this.getStatusForSave() ? 1 : 0) + " | " + this.getName().trim()
                + " | " + this.getAt().toString().trim() + System.lineSeparator();
    }
}
