import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KthSmallestElementInASortedMatrix {
    public static int kthSmallest(int[][] matrix, int k) {
        List<Integer> elements = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                elements.add(matrix[i][j]);
            }
        }
        System.out.println(elements);
        Collections.sort(elements);
        return elements.get(k - 1);
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
        int[][] input2 = new int[][]{{1, 2}, {1, 3}};
        System.out.println(kthSmallest(input, 8));
        System.out.println(kthSmallest(input2, 2));
    }
}
