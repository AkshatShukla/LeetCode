public class SearchA2DMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
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

    public static void main(String[] args) {
        int[][] ints = {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
        System.out.println(searchMatrix(ints, 13)); //false
        System.out.println(searchMatrix(ints, 5)); // true
    }
}
