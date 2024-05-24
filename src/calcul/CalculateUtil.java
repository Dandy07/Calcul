package calcul;

import java.util.Scanner;

public class CalculateUtil {

    public static String readInputFromConsole() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();
        return input;
    }
}
