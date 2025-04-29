import java.util.Scanner;

public class SalesCommissions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Define salary ranges
        int[] salaryRanges = new int[9]; // One counter per range

        // Read sales data
        System.out.print("Enter number of salespeople: ");
        int numSalespeople = scanner.nextInt();

        for (int i = 0; i < numSalespeople; i++) {
            System.out.print("Enter gross sales for salesperson " + (i + 1) + ": ");
            double sales = scanner.nextDouble();

            // Calculate salary
            int salary = (int) (200 + (0.09 * sales)); // Truncate to integer

            // Determine appropriate range
            if (salary >= 200 && salary <= 299) {
                salaryRanges[0]++;
            } else if (salary >= 300 && salary <= 399) {
                salaryRanges[1]++;
            } else if (salary >= 400 && salary <= 499) {
                salaryRanges[2]++;
            } else if (salary >= 500 && salary <= 599) {
                salaryRanges[3]++;
            } else if (salary >= 600 && salary <= 699) {
                salaryRanges[4]++;
            } else if (salary >= 700 && salary <= 799) {
                salaryRanges[5]++;
            } else if (salary >= 800 && salary <= 899) {
                salaryRanges[6]++;
            } else if (salary >= 900 && salary <= 999) {
                salaryRanges[7]++;
            } else {
                salaryRanges[8]++;
            }
        }

        scanner.close();

        // Display results in tabular format
        System.out.println("\nSalary Distribution:");
        System.out.println("Range         | Count");
        System.out.println("----------------------");

        String[] ranges = {"$200-299", "$300-399", "$400-499", "$500-599", "$600-699",
                           "$700-799", "$800-899", "$900-999", "$1000+"};

        for (int i = 0; i < salaryRanges.length; i++) {
            System.out.printf("%-12s | %d%n", ranges[i], salaryRanges[i]);
        }
    }
}
