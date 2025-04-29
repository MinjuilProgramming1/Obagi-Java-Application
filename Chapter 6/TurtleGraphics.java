import java.util.Scanner;

public class TurtleGraphics {
    static int[][] floor = new int[20][20]; // 20x20 grid
    static int x = 0, y = 0; // Turtle's position
    static boolean penDown = false; // Pen status (false = up)

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int command;

        while (true) {
            System.out.print("Enter command (1=Pen Up, 2=Pen Down, 3=Move, 6=Display, 9=Exit): ");
            command = scanner.nextInt();

            switch (command) {
                case 1:
                    penDown = false;
                    System.out.println("Pen lifted.");
                    break;
                case 2:
                    penDown = true;
                    System.out.println("Pen lowered.");
                    break;
                case 3:
                    System.out.print("Enter steps to move: ");
                    int steps = scanner.nextInt();
                    move(steps);
                    break;
                case 6:
                    displayFloor();
                    break;
                case 9:
                    System.out.println("Exiting.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid command.");
            }
        }
    }

    private static void move(int steps) {
        for (int i = 0; i < steps; i++) {
            if (x < 19) x++; // Move right
            if (penDown) floor[y][x] = 1; // Mark path
        }
    }

    private static void displayFloor() {
        System.out.println("\nTurtle Drawing:");
        for (int[] row : floor) {
            for (int cell : row) {
                System.out.print(cell == 1 ? "*" : " ");
            }
            System.out.println();
        }
    }
}
