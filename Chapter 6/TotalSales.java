import java.util.Scanner;

public class TotalSales {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[][] sales = new double[5][4]; // Rows = products (1-5), Columns = salespeople (1-4)

        System.out.print("Enter the number of sales records: ");
        int records = scanner.nextInt();

        for (int i = 0; i < records; i++) {
            System.out.print("Enter salesperson number (1-4): ");
            int salesperson = scanner.nextInt() - 1;
            System.out.print("Enter product number (1-5): ");
            int product = scanner.nextInt() - 1;
            System.out.print("Enter sale amount: ");
            double amount = scanner.nextDouble();

            // Store the sale in the 2D array
            sales[product][salesperson] += amount;
        }

        scanner.close();

        // Display sales data in tabular format
        System.out.println("\nSales Summary:");
        System.out.println("Product |  Salesperson 1  Salesperson 2  Salesperson 3  Salesperson 4  |  Total");
        System.out.println("--------------------------------------------------------------------------");

        double[] salesByPerson = new double[4]; // Stores total sales per salesperson

        for (int row = 0; row < sales.length; row++) {
            double productTotal = 0; // Stores total sales per product
            System.out.printf("%7d | ", row + 1);
            for (int col = 0; col < sales[row].length; col++) {
                System.out.printf("%14.2f ", sales[row][col]);
                productTotal += sales[row][col];
                salesByPerson[col] += sales[row][col]; // Track total per salesperson
            }
            System.out.printf("| %10.2f%n", productTotal); // Total per product
        }

        // Display total sales per salesperson
        System.out.println("--------------------------------------------------------------------------");
        System.out.print("Total   | ");
        for (double total : salesByPerson) {
            System.out.printf("%14.2f ", total);
        }
        System.out.println();
    }
}
