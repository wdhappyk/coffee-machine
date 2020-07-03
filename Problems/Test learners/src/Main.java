import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        if (n == 1) {
            System.out.print("Yes!");
        } else if (n > 0 && n < 5) {
            System.out.print("No!");
        } else {
            System.out.print("Unknown number");
        }
    }
}