package contacts;

import java.util.Scanner;

public class InputHandler {
    private static final Scanner scanner = new Scanner(System.in);

    public static String  readInfo(String message){
        System.out.print(message);
        return scanner.nextLine().trim();
    }
}
