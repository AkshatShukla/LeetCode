import java.util.LinkedList;
import java.util.Queue;

public class PathWithMaximumScore {
    public static int maximumPath(int[][] matrix) {
        int l = matrix.length;
        int w = matrix[0].length;
        int minPath = Integer.MIN_VALUE;
        boolean[][] visited = new boolean[l][w];

        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{0, 0, 0});
        visited[0][0] = true;

        while (queue.size() > 0) {
            int[] currPos = queue.poll();
            int smallest = currPos[2];

            int[] xDir = new int[]{-1, 1, 0, 0};
            int[] yDir = new int[]{0, 0, 1, -1};

            for (int i = 0; i < 4; i++) {
                int newY = currPos[0] + yDir[i];
                int newX = currPos[1] + xDir[i];

                if (newY >= 0 && newY < l && newX >= 0 && newX < w) {
                    if (newX == l - 1 && newY == w - 1) {
                        if (minPath < smallest) {
                            minPath = smallest;
                        }
                    } else if (!visited[newY][newX]) {
                        visited[newY][newX] = true;
                        if (smallest < matrix[newY][newX]) {
                            smallest = matrix[newY][newX];
                        }
                        queue.add(new int[]{newY, newX, smallest});
                    }
                }
            }
        }
        return minPath;
    }

    public static void main(String[] args) {
        int[][] ints = new int[][]{{5, 1}, {4, 5}};
        System.out.println(maximumPath(ints));
    }
}
