import java.util.Scanner;

public class FibonacciCalculator {
    public static int fibonacci(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;

        int first = 0, second = 1, next;
        for (int i = 2; i <= n; i++) {
            next = first + second;
            first = second;
            second = next;
        }
        return second;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the value of n: ");
        int n = scanner.nextInt();

        System.out.println("Fibonacci number at position " + n + " is: " + fibonacci(n));
        scanner.close();
    }
}
