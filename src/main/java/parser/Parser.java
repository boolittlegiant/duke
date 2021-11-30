package parser;

import exception.TaskManagerException;
import task.Deadline;
import task.Event;
import task.Todo;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

public class Parser {

    public static String getCommand(String fullCommand) {
        String command = fullCommand.trim().split(" ")[0];
        return command;
    }

    public static Todo createTodo(String fullCommand) throws TaskManagerException {
        String description = fullCommand.substring("todo".length()).trim();
        assert (("todo " + description).equals(fullCommand)) : "Error for substring for todo description";
        if (description.isEmpty()) {
            throw new TaskManagerException("TODO Empty description");
        } else {
            return new Todo(description);
        }
    }

    public static Deadline createDeadLine(String fullCommand) throws TaskManagerException {
        int idxOfBy = fullCommand.indexOf("/by");
        if (idxOfBy < 0) {
            throw new TaskManagerException("Deadline missing /by");
        }

        try {
            String description = fullCommand.substring(0, idxOfBy).substring("deadline".length()).trim();
            assert (fullCommand.contains(description)) : "Error for substring for deadline description";
            if (description.isEmpty() || description.equals("")) {
                throw new TaskManagerException("Description missing for Deadline");
            }
            String deadline = fullCommand.substring(idxOfBy, fullCommand.length()).substring("/by".length()).trim();
            if (deadline.isEmpty() || deadline.equals("")) {
                throw new TaskManagerException("Missing deadline for Deadline");
            }
            return new Deadline(description, LocalDateTime.parse(deadline));
        } catch (DateTimeParseException e) {
            throw new TaskManagerException("Date/Time format incorrect...");
        }
    }

    public static Event createEvent(String fullCommand) throws TaskManagerException {
        int idxOfBy = fullCommand.indexOf("/at");
        if (idxOfBy < 0) {
            throw new TaskManagerException("Event missing /at");
        }

        try {
            String description = fullCommand.substring(0, idxOfBy).substring("event".length()).trim();
            assert (fullCommand.contains(description)) : "Error for substring for Event description";
            if (description.isEmpty() || description.equals("")) {
                throw new TaskManagerException("Description missing for Event");
            }
            String event = fullCommand.substring(idxOfBy, fullCommand.length()).substring("/at".length()).trim();
            if (event.isEmpty() || event.equals("")) {
                throw new TaskManagerException("Missing event for Event");
            }
            return new Event(description, LocalDateTime.parse(event));
        } catch (DateTimeParseException e) {
            throw new TaskManagerException("Date/Time format incorrect...");
        }
    }
}
