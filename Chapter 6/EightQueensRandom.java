import java.util.Random;

public class EightQueensRandom {
    static final int SIZE = 8;
    static int[][] board = new int[SIZE][SIZE];

    public static void main(String[] args) {
        Random random = new Random();
        boolean success = false;

        while (!success) {
            resetBoard();
            for (int row = 0; row < SIZE; row++) {
                int col;
                do {
                    col = random.nextInt(SIZE);
                } while (!isValid(row, col));

                board[row][col] = 1;
            }
            success = validateBoard();
        }

        displayBoard();
    }

    static void resetBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = 0;
            }
        }
    }

    static boolean isValid(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1 || (col - (row - i) >= 0 && board[i][col - (row - i)] == 1)
                    || (col + (row - i) < SIZE && board[i][col + (row - i)] == 1)) {
                return false;
            }
        }
        return true;
    }

    static boolean validateBoard() {
        for (int row = 0; row < SIZE; row++) {
            int queens = 0;
            for (int col = 0; col < SIZE; col++) {
                if (board[row][col] == 1) queens++;
            }
            if (queens != 1) return false;
        }
        return true;
    }

    static void displayBoard() {
        System.out.println("\nRandom Chessboard Configuration:");
        for (int[] row : board) {
            for (int square : row) {
                System.out.print((square == 1 ? "Q " : ". "));
            }
            System.out.println();
        }
    }
}
