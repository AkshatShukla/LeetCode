import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberOfDistinctIslands {
    public static int numDistinctIslands(int[][] grid) {
        Set<List<Integer>> pathSet = new HashSet<>();
        boolean[][] seen = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    List<Integer> shape = new ArrayList<>();
                    dfs(grid, i, j, seen, shape, 0);
                    if (!shape.isEmpty()) {
                        pathSet.add(shape);
                    }
                }
            }
        }
        System.out.println(pathSet);
        return pathSet.size();
    }

    private static void dfs(int[][] grid, int i, int j, boolean[][] seen, List<Integer> shape, int direction) {
        if (i >= 0 && i < grid.length && j >= 0 && j < grid.length && grid[i][j] == 1 && !seen[i][j]) {
            shape.add(direction);
            seen[i][j] = true;
            dfs(grid, i + 1, j, seen, shape, 1);
            dfs(grid, i - 1, j, seen, shape, 2);
            dfs(grid, i, j + 1, seen, shape, 3);
            dfs(grid, i, j - 1, seen, shape, 4);
            shape.add(0);
        }
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 1, 1},
                {0, 0, 0, 1, 1}};
        System.out.println(numDistinctIslands(grid));
    }
}
