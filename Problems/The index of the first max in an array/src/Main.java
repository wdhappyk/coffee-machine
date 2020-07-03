import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int sizeOfArray = scanner.nextInt();

        int max = 0;
        int idx = 0;

        for (int i = 0; i < sizeOfArray; ++i) {
            final int n = scanner.nextInt();
            if (n > max) {
                max = n;
                idx = i;
            }
        }

        System.out.print(idx);
    }
}