package Utilities;

import java.util.Scanner;

public class ConsoleReader {
    static Scanner sc = new Scanner(System.in);
    static String input;

    /**Alternative to .nextInt() from Scanner objects. Prevents exceptions*/
    public static int readInteger() {
        int result = 0;
        boolean goodToGo = false;

        do {
            try {
                System.out.print(">> ");
                input = sc.nextLine();
                result = Integer.parseInt(input);
                goodToGo = true;
            } catch (Exception e) {
                //Somehow the System.err.println() gives problems and makes it hard to align correctly with the other prints.
                System.out.println(Colors.red + "-- Invalid input --" + Colors.reset);
            }
        } while (!goodToGo);

        return result;
    }

    public static String readString() {
        do {
            System.out.print(">> ");
            input = sc.nextLine();
        } while (input.isEmpty());
        return input;
    }
}
