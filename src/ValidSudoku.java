import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    public static boolean isValidSudoku(char[][] board) {
        // same row
        for (int row = 0; row < board.length; row++) {
            Set<Character> set = new HashSet<>();
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] != '.') {
                    if (!set.add(board[row][col])) {
                        return false;
                    }
                }
            }
        }

        // transpose the matrix
        char[][] transposedBoard = transpose(board);

        // same col
        for (int row = 0; row < transposedBoard.length; row++) {
            Set<Character> set = new HashSet<>();
            for (int col = 0; col < transposedBoard[row].length; col++) {
                if (transposedBoard[row][col] != '.') {
                    if (!set.add(transposedBoard[row][col])) {
                        return false;
                    }
                }
            }
        }

        // same cell
        for (int row = 0; row < board.length; row += 3) {
            for (int col = 0; col < board[row].length; col += 3) {
                Set<Character> set = new HashSet<>();
                for (int i = row; i < row + 3; i++) {
                    for (int j = col; j < col + 3; j++) {
                        if (board[i][j] != '.') {
                            if (!set.add(board[i][j])) {
                                return false;
                            }
                        }
                    }
                }
            }
        }

        return true;
    }

    private static char[][] transpose(char[][] board) {
        char[][] result = new char[board.length][board.length];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board.length; col++) {
                result[row][col] = board[col][row];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        System.out.println(isValidSudoku(board));
    }
}
