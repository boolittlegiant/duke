package contants;

public class Constants {
    public static final String TODO = "todo";
    public static final String DEADLINE = "deadline";
    public static final String EVENT = "event";
    public static final String LIST = "list";
    public static final String DONE = "done";
    public static final String NOTDONE = "notdone";
    public static final String DELETE = "delete";


    public static final String TODO_HELP_STATEMENT = "Type \"todo\" \"description of task\" to create a new Todo Task." +
            " E.g. todo Return textbook";
    public static final String DEADLINE_HELP_STATEMENT = "Type \"deadline\" \"description of task\" /by" +
            " \"description of deadline\" to create a new Deadline Task. E.g. deadline Hand in homework /by 2021-12-05T23:59 ";
    public static final String EVENT_HELP_STATEMENT ="Type \"event\" \"description of task\" /at " +
            "\"description of event\" to create a new Event Task. E.g. event Zumba@Labrador Park /at 2021-12-04T10:00 ";
    public static final String LIST_HELP_STATEMENT = "Type \"list\" and press enter to print out the current list of tasks.";
    public static final String DONE_HELP_STATEMENT = "Type \"done\" and the number of the task from the list. " +
            "Use \"list\" to display the tasks and their corresponding number first. E.g. done 1\n" +
            "\t\t\t   [This will set that task's status to done/ complete]";
    public static final String NOTDONE_HELP_STATEMENT = "Type \"undone\" and the number of the task from the list." +
            "Use \"list\" to display the tasks and their corresponding number first. E.g. undone 1\n" +
            "\t\t\t   [This will set that task's status to not done/ incomplete]\n" +
            "\t\t\t   Can be used when a task is mistakenly set as done or for a repeatable task";
    public static final String DELETE_HELP_STATEMENT = "Type \"list\" and the number of the task to be deleted from the list.\n" +
            "\t\t\t   Use \"list\" to display the tasks and their corresponding number first. E.g. delete 1\n" +
            "\t\t\t   [This will delete/remove that task from the list.]";
}
