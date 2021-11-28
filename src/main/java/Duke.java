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
        String exit="";
        String array[];
        array = new String[100];
        Scanner input = new Scanner(System.in);

        while (!exit.equalsIgnoreCase("bye")) {

            line = input.nextLine();
            String command[];
            command = line.split((" "));

            if ("bye".equals(command[0].toLowerCase())) {
                System.out.println("Bye. Have a nice day!");
                exit = command[0];
                break;

            } else if ("list".equals(command[0].toLowerCase())) {

                for (int k = 0; k < count; k++) {

                    //List out the Tasks.
                    System.out.println((k + 1) + ")" + array[k]); //why does it print null at certain areas?! ahhhhhh!!!
                }
            } else if ("done".equals(command[0].toLowerCase())) {
                System.out.println("Inside done");

            } else if ("event".equals(command[0].toLowerCase()) || "todo".equals(command[0].toLowerCase()) || "deadline".equals(command[0].toLowerCase())) {
                //Display when a Task is added.
                //array[i] = line;
//                count++;
//                System.out.println("I've added " + " to your to-do list");
                System.out.println("Inside Eevents/ todo / deadline");
            }

        }
    }
}

