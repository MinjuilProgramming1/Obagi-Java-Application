public class KnightsTourHeuristic {
    static final int SIZE = 8;
    static int[][] board = new int[SIZE][SIZE];
    static int[][] accessibility = {
            {2, 3, 4, 4, 4, 4, 3, 2},
            {3, 4, 6, 6, 6, 6, 4, 3},
            {4, 6, 8, 8, 8, 8, 6, 4},
            {4, 6, 8, 8, 8, 8, 6, 4},
            {4, 6, 8, 8, 8, 8, 6, 4},
            {4, 6, 8, 8, 8, 8, 6, 4},
            {3, 4, 6, 6, 6, 6, 4, 3},
            {2, 3, 4, 4, 4, 4, 3, 2}
    };

    static final int[] horizontal = {2, 1, -1, -2, -2, -1, 1, 2};
    static final int[] vertical = {-1, -2, -2, -1, 1, 2, 2, 1};

    public static void main(String[] args) {
        int row = 0, col = 0; // Start at top-left
        int moveCount = 1;
        board[row][col] = moveCount;

        while (moveCount < SIZE * SIZE) {
            int bestMove = -1, minAccess = Integer.MAX_VALUE;

            for (int move = 0; move < 8; move++) {
                int newRow = row + vertical[move];
                int newCol = col + horizontal[move];

                if (isValidMove(newRow, newCol) && accessibility[newRow][newCol] < minAccess) {
                    bestMove = move;
                    minAccess = accessibility[newRow][newCol];
                }
            }

            if (bestMove == -1) break;

            row += vertical[bestMove];
            col += horizontal[bestMove];
            board[row][col] = ++moveCount;
            reduceAccessibility(row, col);
        }

        displayBoard();
        System.out.println("Total Moves: " + moveCount);
    }

    static boolean isValidMove(int row, int col) {
        return row >= 0 && row < SIZE && col >= 0 && col < SIZE && board[row][col] == 0;
    }

    static void reduceAccessibility(int row, int col) {
        for (int move = 0; move < 8; move++) {
            int newRow = row + vertical[move];
            int newCol = col + horizontal[move];

            if (newRow >= 0 && newRow < SIZE && newCol >= 0 && newCol < SIZE)
                accessibility[newRow][newCol]--;
        }
    }

    static void displayBoard() {
        for (int[] row : board