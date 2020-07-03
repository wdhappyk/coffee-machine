import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        int n;

        do {
            n = scanner.nextInt();
            sum += n;
        } while (n != 0 && sum < 1000);

        if (sum >= 1000) {
            System.out.print(sum - 1000);
        } else {
            System.out.print(sum);
        }
    }
}