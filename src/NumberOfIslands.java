public class NumberOfIslands {
    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int numberOfIslands = 0;
        for (int col=0; col<grid.length; col++) {
            for (int row=0; row<grid[col].length; row++) {
                if (grid[col][row] == '1') {
                    numberOfIslands += DFS(grid, col, row);
                }
            }
        }
        return numberOfIslands;
    }

    public static int DFS(char[][] grid, int col, int row) {
        if (col < 0 || col >= grid.length || row < 0 || row >= grid[col].length || grid[col][row] == '0') {
            return 0;
        }
        grid[col][row] = '0';
        DFS(grid, col-1, row);
        DFS(grid, col+1, row);
        DFS(grid, col, row-1);
        DFS(grid, col, row+1);
        return 1;
    }

    public static void main(String[] args) {

    }
}
