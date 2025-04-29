import java.util.Scanner;

public class AirlineReservation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean[] seats = new boolean[10]; // All seats start as unassigned (false)

        while (true) {
            System.out.print("Please type 1 for First Class or 2 for Economy: ");
            int choice = scanner.nextInt();

            int seatNumber = assignSeat(seats, choice == 1 ? 0 : 5, choice == 1 ? 5 : 10);

            if (seatNumber != -1) {
                System.out.println("Boarding Pass: Seat " + (seatNumber + 1) + " (" +
                        (seatNumber < 5 ? "First Class" : "Economy") + ")");
            } else {
                System.out.println("Section full. Would you like a seat in the other section? (yes/no)");
                if (scanner.next().equalsIgnoreCase("yes")) {
                    seatNumber = assignSeat(seats, choice == 1 ? 5 : 0, choice == 1 ? 10 : 5);

                    if (seatNumber != -1) {
                        System.out.println("Boarding Pass: Seat " + (seatNumber + 1) + " (Alternate Section)");
                    } else {
                        System.out.println("Next flight leaves in 3 hours.");
                        break;
                    }
                } else {
                    System.out.println("Next flight leaves in 3 hours.");
                    break;
                }
            }
        }

        scanner.close();
    }

    // Assign seat in the given range (returns -1 if full)
    private static int assignSeat(boolean[] seats, int start, int end) {
        for (int i = start; i < end; i++) {
            if (!seats[i]) {
                seats[i] = true;
                return i;
            }
        }
        return -1; // No available seat
    }
}
