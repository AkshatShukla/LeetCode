import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreasureIslandII {
    public static int treasureIsland(char[][] island) {
        List<int[]> result = new ArrayList<>();
        int steps = 0;
        Queue<int[]> queue = new LinkedList<>();
        result.add(new int[]{0, 0});
        boolean[][] visited = new boolean[island.length][island[0].length];
        visited[0][0] = true;
        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int row = 0; row < island.length; row++) {
            for (int col = 0; col < island[0].length; col++) {
                if (island[row][col] == 'S') {
                    queue.offer(new int[]{row, col});
                    visited[row][col] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            int level = queue.size();
            for (int i = 0; i < level; i++) {
                int[] coords = queue.poll();
                int x = coords[0];
                int y = coords[1];
                if (island[x][y] == 'X') return steps;
                for (int[] dir : directions) {
                    int newX = x + dir[0];
                    int newY = y + dir[1];
                    if (newX < 0 || newY < 0 || newX >= island.length || newY >= island[0].length || visited[newX][newY] ||
                            island[newX][newY] == 'D')
                        continue;
                    queue.offer(new int[]{newX, newY});
                    visited[newX][newY] = true;
                }
            }
            steps++;
        }
        return -1;
    }

    public static void main(String[] args) {
        char[][] island = {{'S', 'O', 'O', 'S', 'S'},
                {'D', 'O', 'D', 'O', 'D'},
                {'O', 'O', 'O', 'O', 'X'},
                {'X', 'D', 'D', 'O', 'O'},
                {'X', 'D', 'D', 'D', 'O'}};
        System.out.println(treasureIsland(island));
    }
}
