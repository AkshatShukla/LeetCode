import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInBinaryMatrix {
    public static int shortestPathBinaryMatrix(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0][0] == 1) {
            return -1;
        }

        int n = grid.length;

        Queue<int[]> queue = new LinkedList<>();
        int[][] dirs = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

        queue.offer(new int[]{0, 0, 1});
        grid[0][0] = 1;

        while (!queue.isEmpty()) {
            int level = queue.size();
            for (int i = 0; i < level; i++) {
                int[] node = queue.poll();
                int x = node[0];
                int y = node[1];
                int dist = node[2];

                if (x == n - 1 && y == n - 1) {
                    return dist;
                }
                for (int[] dir : dirs) {
                    int newX = x + dir[0];
                    int newY = y + dir[1];
                    if (newX < 0 || newY < 0 || newX >= n || newY >= n || grid[newX][newY] == 1) {
                        continue;
                    }
                    grid[newX][newY] = 1;
                    queue.offer(new int[]{newX, newY, dist + 1});
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(shortestPathBinaryMatrix(new int[][]{{0, 1}, {1, 0}}));
        System.out.println(shortestPathBinaryMatrix(new int[][]{{1, 0, 0}, {1, 1, 0}, {1, 1, 0}}));
        System.out.println(shortestPathBinaryMatrix(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}));
    }
}
