package tasklist;

import task.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskList {

    private static List<Task> tasks = new ArrayList<>();

    public TaskList(List<Task> tasks) {
        this.tasks = tasks;
    }

    public String getTaskName() {
        String tasksDescription = "";
        for (int i = 0; i < tasks.size(); i++) {
            tasksDescription += tasks.get(i).getName().trim();
            if (i == tasks.size() - 1) {

            } else {
                tasksDescription += "|";
            }
        }
        return tasksDescription;
    }

    public List<Task> getAllTasks() {
        return this.tasks;
    }

    public static int getNumberOfTasks() {
        return tasks.size();
    }

    public void addATask(Task task) {
        System.out.println(task);
        tasks.add(task);
    }

    public void printAllTasks() {
        System.out.println("Tasks:");
        int i = 1;
        for (Task t : this.tasks) {
            System.out.println("[" + (i) + "] " + t);
            i++;
        }
    }

    public static String getTaskCount() {
        return "Tasks in the list: " + tasks.size();
    }

    public static int getNoOfTasks() {
        return tasks.size();
    }

    public void markAsDone(String fullCommand) {
        int index = Integer.parseInt(fullCommand.substring("done".length()).trim());
        tasks.get(index - 1).markAsDone();

    }

    public void markNotDone(String fullCommand) {
        int index = Integer.parseInt(fullCommand.substring("notdone".length()).trim());
        tasks.get(index - 1).markNotDone();

    }

    public void deleteTask(String fullCommand) {
        int index = Integer.parseInt(fullCommand.substring("remove".length()).trim());
        tasks.remove(index - 1);
    }
}
