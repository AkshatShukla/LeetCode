import java.util.Arrays;

public class RotateImage {
    public static void rotate(int[][] matrix) {
        // Transpose Matrix
        for(int i = 0; i < matrix.length; i++){
            for(int j = i; j < matrix[0].length; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // Flip it by symmetry
        for(int i =0 ; i < matrix.length; i++){
            for(int j = 0; j < matrix.length/2; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length-1-j];
                matrix[i][matrix.length-1-j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3},
                                    {4,5,6},
                                    {7,8,9}};
        System.out.println(Arrays.deepToString(matrix));
        rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}
