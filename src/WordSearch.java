public class WordSearch {
    public static boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (word.charAt(0) == board[i][j] && dfs(board, i, j, 0, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(char[][] board, int i, int j, int idx, String word) {
        if (idx == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length || word.charAt(idx) != board[i][j]) {
            return false;
        }
        char temp = board[i][j];
        board[i][j] = ' '; // dont use same letter again
        boolean didFind = dfs(board, i + 1, j, idx + 1, word) ||
                dfs(board, i - 1, j, idx + 1, word) ||
                dfs(board, i, j + 1, idx + 1, word) ||
                dfs(board, i, j - 1, idx + 1, word);
        board[i][j] = temp; // restore value of letter in board
        return didFind;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{{'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};
        System.out.println(exist(board, "ABCCED")); // true
        System.out.println(exist(board, "SEE")); // true
        System.out.println(exist(board, "ABCB")); // false
    }
}
