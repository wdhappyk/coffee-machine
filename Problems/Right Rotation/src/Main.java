import java.util.Scanner;
import java.lang.StringBuilder;

class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final String[] numbers = scanner.nextLine().split(" ");
        final int steps = scanner.nextInt();

        final int offset = steps % numbers.length;

        final StringBuilder sb = new StringBuilder();

        for (int i = numbers.length - offset; i < numbers.length; ++i) {
            sb.append(numbers[i]).append(" ");
        }

        for (int i = 0; i < numbers.length - offset; ++i) {
            sb.append(numbers[i]).append(" ");
        }

        System.out.print(sb.toString().trim());
    }
}