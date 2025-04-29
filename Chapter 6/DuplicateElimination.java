import java.util.Scanner;

public class DuplicateElimination {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] uniqueNumbers = new int[5]; // Array to store unique values
        int count = 0; // Number of unique elements entered

        for (int i = 0; i < 5; i++) {
            System.out.print("Enter a number between 10 and 100: ");
            int num = scanner.nextInt();

            // Check for duplicates
            boolean isDuplicate = false;
            for (int j = 0; j < count; j++) {
                if (uniqueNumbers[j] == num) {
                    isDuplicate = true;
                    break;
                }
            }

            // Store the number if it's unique
            if (!isDuplicate) {
                uniqueNumbers[count] = num;
                count++;
                System.out.println("Unique numbers so far: ");
                for (int k = 0; k < count; k++) {
                    System.out.print(uniqueNumbers[k] + " ");
                }
                System.out.println();
            } else {
                System.out.println("Duplicate number ignored.");
            }
        }

        scanner.close();

        // Final display of unique numbers
        System.out.println("\nFinal set of unique values:");
        for (int i = 0; i < count; i++) {
            System.out.print(uniqueNumbers[i] + " ");
        }
    }
}
