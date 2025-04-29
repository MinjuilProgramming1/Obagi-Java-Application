import java.util.Random;

public class KnightsTour {
    static final int SIZE = 8;
    static int[][] board = new int[SIZE][SIZE];

    // Possible moves for a knight
    static final int[] horizontal = {2, 1, -1, -2, -2, -1, 1, 2};
    static final int[] vertical = {-1, -2, -2, -1, 1, 2, 2, 1};

    public static void main(String[] args) {
        Random random = new Random();
        int row = random.nextInt(SIZE); // Random start position
        int col = random.nextInt(SIZE);
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
    }

    static boolean isValidMove(int row, int col) {
        return row >= 0 && row < SIZE && col >= 0 && col < SIZE && board[row][col] == 0;
    }

    static void displayBoard() {
        for (int[] row : board) {
            for (int square : row) {
                System.out.printf("%2d ", square);
            }
            System.out.println();
        }
    }
}
