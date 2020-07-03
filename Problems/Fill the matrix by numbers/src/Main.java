import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int i = 0; i < n; ++i) {
            for (int j = -i; j < n - i; ++j) {
                System.out.print(Math.abs(j) + " ");
            }
            System.out.println();
        }
    }
}