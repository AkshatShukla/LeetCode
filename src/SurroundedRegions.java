import java.util.Arrays;

public class SurroundedRegions {
    public static void solve(char[][] board) {
        // dfs on the 4 borders an
        // start with O not on the border
        // do dfs checking if any of the neighbor is X, flipping the current
        // node to X
        if (board == null || board.length == 0) return;
        int rows = board.length, cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];

        // check first and the last row
        for (int j = 0; j < cols; j++) {
            if (board[0][j] == 'O') {
                dfs(board, 0, j, visited, false);
            }

            if (board[rows - 1][j] == 'O') {
                dfs(board, rows - 1, j, visited, false);
            }
        }

        // check first and last col
        for (int i = 0; i < rows; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0, visited, false);
            }

            if (board[i][cols - 1] == 'O') {
                dfs(board, i, cols - 1, visited, false);
            }
        }

        // dfs flip on the inner matrix
        for (int i = 1; i < rows - 1; i++) {
            for (int j = 1; j < cols - 1; j++) {
                if (board[i][j] == 'O' && !visited[i][j]) {
                    dfs(board, i, j, visited, true);
                }
            }
        }

    }

    public static void dfs(char[][] board, int i, int j, boolean[][] visited, boolean flip) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[i].length || board[i][j] == 'X' || visited[i][j]) {
            return;
        }
        if (flip) {
            board[i][j] = 'X';
        }
        visited[i][j] = true;
        dfs(board, i + 1, j, visited, flip);
        dfs(board, i - 1, j, visited, flip);
        dfs(board, i, j + 1, visited, flip);
        dfs(board, i, j - 1, visited, flip);
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        solve(board);
        System.out.println(Arrays.deepToString(board));
        char[][] board1 = new char[][]{{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'X', 'O', 'X'}};
        solve(board1);
        System.out.println(Arrays.deepToString(board1));
    }
}
