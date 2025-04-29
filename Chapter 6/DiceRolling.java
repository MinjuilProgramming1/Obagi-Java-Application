import java.util.Random;

public class DiceRolling {
    public static void main(String[] args) {
        Random random = new Random();
        int[] frequency = new int[13]; // Index 0 unused, sums range from 2-12

        for (int i = 0; i < 36_000_000; i++) {
            int die1 = 1 + random.nextInt(6);
            int die2 = 1 + random.nextInt(6);
            int sum = die1 + die2;
            frequency[sum]++;
        }

        // Display results in tabular format
        System.out.println("Sum | Frequency");
        System.out.println("----------------");

        for (int sum = 2; sum <= 12; sum++) {
            System.out.printf("%2d  | %,d%n", sum, frequency[sum]);
        }
    }
}
