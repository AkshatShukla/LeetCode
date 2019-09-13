import java.util.Arrays;

public class WallsAndGates {
    public static void wallsAndGates(int[][] rooms) {
        for (int row = 0; row < rooms.length; row++) {
            for (int col = 0; col < rooms[0].length; col++) {
                if (rooms[row][col] == 0) {
                    dfs(rooms, row, col, 0);
                }
            }
        }
    }

    public static void dfs(int[][] rooms, int i, int j, int distance) {
        if (i < 0 || j < 0 || i >= rooms.length || j >= rooms[i].length || rooms[i][j] < distance) {
            return;
        }
        rooms[i][j] = distance;
        dfs(rooms, i + 1, j, distance + 1);
        dfs(rooms, i - 1, j, distance + 1);
        dfs(rooms, i, j - 1, distance + 1);
        dfs(rooms, i, j + 1, distance + 1);
    }

    public static void main(String[] args) {
        int x = Integer.MAX_VALUE;
        int[][] ints = new int[][]{{x, -1, 0, x}, {x, x, x, -1}, {x, -1, x, -1}, {0, -1, x, x}};
        wallsAndGates(ints);
        System.out.println(Arrays.deepToString(ints));

    }
}
