import java.util.Scanner;

public class AddList_Level2 {
    public static void main(String[] args) {
        System.out.println("Hello! I'm Boo.");
        System.out.println("What do you have to do today");

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
