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
        String array[];
        array = new String[100];
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < array.length; i++) {
            line = input.nextLine();
            if (line.toLowerCase().equals("bye")) {
                System.out.println("Bye. Have a nice day!");
                break;
            } else if (line.toLowerCase().equals("list")){
                for (int k =0; k < count; k++){
                    //line.remove(null);
                    System.out.println((k + 1 )+ ")" + array[k]); //why does it print null at certain areas?! ahhhhhh!!!
                }
            }else{
                array[i] = line;
                count ++;
                System.out.println("I've added " + array[i] + " to your to-do list");
            }
        }
    }
}
