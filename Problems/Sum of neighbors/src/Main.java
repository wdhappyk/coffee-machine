import java.util.ArrayList;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> lines = new ArrayList<String>();

        while (true) {
            String line = scanner.nextLine();

            if (line.equalsIgnoreCase("end")) {
                break;
            }

            lines.add(line);
        }


    }
}