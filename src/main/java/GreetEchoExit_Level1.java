import java.util.Scanner;

public class GreetEchoExit_Level1 {
    public static void main(String[] args) {
        System.out.println("Hello! I'm Boo.");
        System.out.println("What can I do for you?");

        String line;
        Scanner input = new Scanner(System.in);
        for(int i = 0; i<Integer.MAX_VALUE; i++){
            line = input.nextLine();
            if(line.toLowerCase().equals("bye")){
                System.out.println("Bye. Have a nice day!");
                break;
            }else{
                System.out.println(line);
            }
        }
    }
}
