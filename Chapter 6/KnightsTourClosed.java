import java.util.Random;

public class KnightsTourClosed {
    static final int SIZE = 8;
    static int[][] board = new int[SIZE][SIZE];

    static final int[] horizontal = {2, 1, -1, -2, -2, -1, 1, 2};
    static final int[] vertical = {-1, -2, -2, -1, 1, 2, 2, 1};

    public static void main(String[] args) {
        Random random = new Random();
        
        int startRow = random.nextInt(SIZE); // Random start position
        int startCol = random.nextInt(SIZE);
        int row = startRow, col = startCol;
        int moveCount = 1;
        board[row][col] = moveCount;

        while (moveCount < SIZE * SIZE) {
            boolean moveMade = false;

            for (int move = 0; move < 8; move++) {
                int newRow = row + vertical[move];
                int newCol = col + horizontal[move];

                if (isValidMove(newRow, newCol)) {
                    row = newRow;
                    col = newCol;
                    board[row][col] = ++moveCount;
                    moveMade = true;
                    break;
                }
            }

            if (!moveMade) break; // If no valid move, terminate
        }

        displayBoard();
        System.out.println("Total Moves: " + moveCount);

        // Test for closed tour
        if (moveCount == SIZE * SIZE && isOneMoveAway(row, col, startRow, startCol)) {
            System.out.println("Closed Tour Achieved! The knight can return to the starting position.");
        } else {
            System.out.println("This was NOT a closed tour.");
        }
    }

    static boolean isValidMove(int row, int col) {
        return row >= 0 && row < SIZE && col >= 0 && col < SIZE && board[row][col] == 0;
    }

    static boolean isOneMoveAway(int row, int col, int startRow, int startCol) {
        for (int move = 0; move < 8; move++) {
            int newRow = row + vertical[move];
            int newCol = col + horizontal[move];

            if (newRow == startRow && newCol == startCol) {
                return true; // Knight can return in one move
            }
        }
        return false;
    }

    static void displayBoard() {
        System.out.println("\nKnight’s Tour Path:");
        for (int[] row : board) {
            for (int square : row) {
                System.out.printf("%2d ", square);
            }
            System.out.println();
        }
    }
}
