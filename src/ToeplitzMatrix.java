public class ToeplitzMatrix {
    public static boolean isToeplitzMatrix(int[][] matrix) {
        // A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same element.
        // a[0][0] = a[1][1], a[0][1] = a[1][2], a[0][2] = a[1][3]
        // a[1][0] = a[2][1]
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[i].length - 1; j++) {
                if (matrix[i][j] != matrix[i + 1][j + 1]) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4},
                {5, 1, 2, 3},
                {9, 5, 1, 2}};
        System.out.println(isToeplitzMatrix(matrix));
        int[][] matrix2 = new int[][]{{1, 2}, {2, 2}};
        System.out.println(isToeplitzMatrix(matrix2));
    }
}
