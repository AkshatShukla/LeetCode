import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreasureIsland {
    public static int treasureIsland(char[][] island) {
        List<int[]> result = new ArrayList<>();
        int steps = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        result.add(new int[]{0, 0});
        boolean[][] visited = new boolean[island.length][island[0].length];
        visited[0][0] = true;
        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!queue.isEmpty()) {
            int level = queue.size();
            for (int i = 0; i < level; i++) {
                int[] coords = queue.poll();
                int x = coords[0];
                int y = coords[1];
                if (island[x][y] == 'X') {
                    result.forEach(a -> System.out.println("(" + a[0] + ", " + a[1] + ")"));
                    return steps;
                }
                for (int[] dir : directions) {
                    int newX = x + dir[0];
                    int newY = y + dir[1];
                    if (newX >= 0 && newX < island.length && newY >= 0 && newY < island[0].length &&
                            island[newX][newY] != 'D' && !visited[newX][newY]) {
                        queue.offer(new int[]{newX, newY});
                        visited[newX][newY] = true;
                        result.add(new int[]{newX, newY});
                    }
                }
            }
            steps++;
        }
        return steps;
    }

    public static void main(String[] args) {
        char[][] island = {{'O', 'O', 'O', 'O'},
                {'D', 'O', 'D', 'O'},
                {'O', 'O', 'O', 'O'},
                {'X', 'D', 'D', 'O'}};
        System.out.println(treasureIsland(island));
    }
}
