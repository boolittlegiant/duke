package storage;

import task.Deadline;
import task.Event;
import task.Task;
import task.Todo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SuppressWarnings("Duplicates")
public class Storage {

    private String filePath = "/data/tasks.txt";

    public Storage(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }

    public List<Task> load() throws FileNotFoundException {
        List<Task> loadedTasks = new ArrayList<>();

        List<String> lines = getLines(this.filePath);
        for (String line : lines) {
            if (line.trim().isEmpty()) { //ignore empty lines
                continue;
            }
            loadedTasks.add(createTask(line)); //convert the line to a task and add to the list
        }
        return loadedTasks;
    }


    private Task createTask(String line) {
        Task task = null;
        String[] s = line.split("\\|");
        if (s[0].trim().equals("T")) {
            task = new Todo(s[2].trim());
            if ((1 == Integer.parseInt(s[1].trim()))) {
                task.markAsDone();
            }
        } else if (s[0].trim().equals("D")) {
            task = new Deadline(s[2], LocalDateTime.parse(s[3].trim()));
            if ((1 == Integer.parseInt(s[1].trim()))) {
                task.markAsDone();
            }
        }   else if (s[0].trim().equals("E")) {
            task = new Event(s[2], LocalDateTime.parse(s[3].trim()));
            if ((1 == Integer.parseInt(s[1].trim()))) {
                task.markAsDone();
            }
        } else {
            System.out.println("Error");
        }
        return task;
    }

    /**
     * Returns the lines in the form of a List<String> variable
     *
     * @param filePath
     * @return List<String> lines
     * @throws FileNotFoundException
     */
    private List<String> getLines(String filePath) throws FileNotFoundException {
        List<String> lines = new ArrayList<String>();
        File f = new File(filePath); // create a File for the given file path
        Scanner s = new Scanner(f); // create a Scanner using the File as the source
        while (s.hasNext()) {
            lines.add(s.nextLine());
        }
        return lines;
    }


    public void save(List<Task> tasks) {
        try {
            FileWriter fw = new FileWriter(this.filePath);
            if (Files.isDirectory(Paths.get("/data"))) {
                System.out.println("dir exists");
            } else {
                Files.createDirectories(Paths.get("/data"));
                System.out.println("dir did not exist");
            }
            File f = new File(this.filePath); // create a File for the given file path
            Scanner s = new Scanner(f); // create a Scanner using the File as the source
            for (Task task : tasks) {
                if (s.hasNext()) {
                    fw.write("\r\n");
                }
                fw.write(task.save());
            }
            fw.close();
        } catch (IOException e) {

        }
    }
}