package storage;

import java.text.SimpleDateFormat;
import java.util.Date;

import static contants.Constants.*;

public class helper {
    public static String getDateInFileWriteFormat() {
        String pattern = "ddMMMyyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(new Date());
        return date;
    }

    public static void helpMessage() {
        String helpMessage = String.format("\n%-15s%s\n\n%-15s%s\n\n%-15s%s\n\n%-15s%s\n\n%-15s%s\n\n%-15s%s\n \n%-15s%s\n",
                TODO, TODO_HELP_STATEMENT,
                DEADLINE, DEADLINE_HELP_STATEMENT,
                EVENT, EVENT_HELP_STATEMENT,
                LIST, LIST_HELP_STATEMENT,
                DONE, DONE_HELP_STATEMENT,
                NOTDONE, NOTDONE_HELP_STATEMENT,
                DELETE, DELETE_HELP_STATEMENT);

        System.out.println(helpMessage);
    }

}
