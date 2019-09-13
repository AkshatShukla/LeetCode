public class SearchA2DMatrixII {
    public static boolean searchMatrix2(int[][] matrix, int target) {

        int i = matrix.length - 1;
        int j = 0;

        while (i >= 0 && i < matrix.length && j >= 0 && j < matrix[0].length) {
            if (matrix[i][j] == target) {
                return true;
            }

            if (matrix[i][j] > target) {
                i = i - 1;
            } else {
                j = j + 1;
            }
        }

        return false;
    }

    public static boolean searchMatrix1(int[][] matrix, int target) {

        for (int[] row : matrix) {
            int low = 0;
            int high = matrix[0].length - 1;

            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (row[mid] == target) {
                    return true;
                }
                if (row[mid] < target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] ints = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        System.out.println(searchMatrix1(ints, 5));
        System.out.println(searchMatrix2(ints, 5));
    }
}
