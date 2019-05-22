import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        if (matrix.length == 0) {
            return result;
        }

        int k = 0, l = 0;
        int last_row = matrix.length - 1;
        int last_column = matrix[0].length - 1;

        while (k <= last_row && l <= last_column) {
            // print first row
            for (int i = l; i <= last_column; i++) {
                result.add(matrix[k][i]);
            }
            k++;

            // print last column
            for (int i = k; i <= last_row; i++) {
                result.add(matrix[i][last_column]);
            }
            last_column--;

            // print last row
            if (k <= last_row) {
                for (int i = last_column; i >= l; i--) {
                    result.add(matrix[last_row][i]);
                }
                last_row--;
            }

            // print first column and reset points to inner matrix
            if (l <= last_column) {
                for (int i = last_row; i >= k; i--) {
                    result.add(matrix[i][l]);
                }
                l++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        System.out.println(spiralOrder(input));
        System.out.println(spiralOrder(new int[][]{}));
    }
}
