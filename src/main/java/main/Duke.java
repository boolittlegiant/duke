package main;

import exception.TaskManagerException;
import parser.Parser;
import storage.Storage;
import storage.helper;
import task.Deadline;
import task.Event;
import task.Task;
import task.Todo;
import tasklist.TaskList;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Duke {

    public static void main(String[] args) {
        String logo =
                " ____              \n"
                        + "|  _ \\_____ _____ \n"
                        + "| |_| |  _  |  _  |\n"
                        + "|  _  | | | | | | |\n"
                        + "| |_| | |_| | |_| |\n"
                        + "|____/ \\____|\\____|\n";
        System.out.println(logo + "Welcome I'm Boo.");
        System.out.println("What can I do for you?\n");

        String line;
        int count = 0;
        String exit = "";
        Storage storage = new Storage("data/tasks.txt");

        TaskList tasks;
        try {
            tasks = new TaskList(storage.load());
        } catch (FileNotFoundException e) {
            //Starting with an empty task list");
            tasks = new TaskList(new ArrayList<>());
        }

        Scanner input = new Scanner(System.in);

        while (!exit.equalsIgnoreCase("bye")) {

            line = input.nextLine();
            String command[];
            command = line.split((" "));
            String commandWord = Parser.getCommand(line);


            if ("bye".equals(commandWord.toLowerCase())) {
                storage.save(tasks.getAllTasks());
                System.out.println("<< Saving tasks :) >>");
                for (int i = 0; i < 5; i++) {
                    System.out.print(".");
                    try {
                        Thread.sleep(120);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("complete~!");
                System.out.println("Bye~ Have a nice day!");
                exit = commandWord;

            } else if ("help".equals(commandWord.toLowerCase())) {
                helper.helpMessage();

            } else if ("list".equals(commandWord.toLowerCase())) {

                if (tasks.getNumberOfTasks() > 0) {
                    try {
                        tasks.printAllTasks();
                    } catch (NullPointerException e) {
                        System.out.println("List is empty, add some tasks!");
                    }
                } else {
                    System.out.println("List is empty, add some tasks!");
                }


            } else if ("done".equals(commandWord.toLowerCase())) {
                tasks.markAsDone(line);

            } else if ("notdone".equals(commandWord.toLowerCase())) {
                tasks.markNotDone(line);

            } else if ("delete".equals(commandWord.toLowerCase())) {
                tasks.deleteTask(line);

            } else if ("event".equals(commandWord.toLowerCase()) || "todo".equals(commandWord.toLowerCase())
                    || "deadline".equals(commandWord.toLowerCase()) || "task".equals(commandWord.toLowerCase())) {

                try {
                    if (command[0].toLowerCase().equals("event")) {
                        tasks.addATask(Parser.createEvent(line));

                    } else if (command[0].toLowerCase().equals("todo")) {
                        tasks.addATask(Parser.createTodo(line));

                    } else if (command[0].toLowerCase().equals("deadline")) {
                        tasks.addATask(Parser.createDeadLine(line));

                    } else {
                        System.out.println("Invalid command...");
                    }

                    //Display when a Task.Task is added.
                    //array[i] = line;
//                count++;
//                System.out.println("Got it, I've added this task:\n " + "\n"+"Now you have "+" tasks in the list.");
                    //System.out.println("Inside Events/ todo / deadline");

                } catch (TaskManagerException e) {
                    System.out.println(e.getMessage());
                }
            } else {
                System.out.println("Unknown command! please try again. Please type \"help\" to view a list of commands.");
            }
        }
    }
}

