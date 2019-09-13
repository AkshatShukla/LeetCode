import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class O1Matrix {
    public static int[][] updateMatrix(int[][] matrix) {
        int rows = matrix.length;
        if (rows == 0)
            return matrix;
        int cols = matrix[0].length;
        int[][] dist = new int[rows][cols];

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                dist[i][j] = Integer.MAX_VALUE;
                if (matrix[i][j] == 0) {
                    dist[i][j] = 0;
                    queue.offer(new int[]{i, j});
                }
            }
        }

        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!queue.isEmpty()) {
            int[] curr = queue.peek();
            queue.poll();
            for (int[] ints : dir) {
                int new_r = curr[0] + ints[0];
                int new_c = curr[1] + ints[1];
                if (new_r >= 0 && new_c >= 0 && new_r < rows && new_c < cols) {
                    if (dist[new_r][new_c] > dist[curr[0]][curr[1]] + 1) {
                        dist[new_r][new_c] = dist[curr[0]][curr[1]] + 1;
                        queue.offer(new int[]{new_r, new_c});
                    }
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        int[][] ints = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        int[][] ints1 = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        System.out.println(Arrays.deepToString(updateMatrix(ints)));
        System.out.println(Arrays.deepToString(updateMatrix(ints1)));
    }
}
