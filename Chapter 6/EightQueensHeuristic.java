public class EightQueensHeuristic {
    static final int SIZE = 8;
    static int[][] board = new int[SIZE][SIZE];
    static int[][] elimination = {
            {22, 19, 17, 16, 16, 17, 19, 22},
            {19, 23, 21, 20, 20, 21, 23, 19},
            {17, 21, 25, 24, 24, 25, 21, 17},
            {16, 20, 24, 27, 27, 24, 20, 16},
            {16, 20, 24, 27, 27, 24, 20, 16},
            {17, 21, 25, 24, 24, 25, 21, 17},
            {19, 23, 21, 20, 20, 21, 23, 19},
            {22, 19, 17, 16, 16, 17, 19, 22}
    };

    public static void main(String[] args) {
        placeQueens(0);
        displayBoard();
    }

    static boolean placeQueens(int row) {
        if (row == SIZE) return true; // All queens placed

        int minElimination = Integer.MAX_VALUE;
        int bestCol = -1;

        for (int col = 0; col < SIZE; col++) {
            if (board[row][col] == 0 && elimination[row][col] < minElimination) {
                minElimination = elimination[row][col];
                bestCol = col;
            }
        }

        if (bestCol == -1) return false; // No valid placement

        board[row][bestCol] = 1;
        updateElimination(row, bestCol);
        return placeQueens(row + 1);
    }

    static void updateElimination(int row, int col) {
        for (int i = 0; i < SIZE; i++) {
            elimination[row][i] += SIZE; // Same row
            elimination[i][col] += SIZE; // Same column

            int diag1 = row - col + i;
            int diag2 = row + col - i;

            if (diag1 >= 0 && diag1 < SIZE) elimination[diag1][i] += SIZE;
            if (diag2 >= 0 && diag2 < SIZE) elimination[diag2][i] += SIZE;
        }
    }

    static void displayBoard() {
        System.out.println("\nChessboard Configuration:");
        for (int[] row : board) {
            for (int square : row) {
                System.out.print((square == 1 ? "Q " : ". "));
            }
            System.out.println();
        }
    }
}
