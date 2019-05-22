import java.util.Arrays;
import java.util.Stack;

public class FloodFill {
    // [[1,1,1],[1,1,0],[1,0,1]]
    // sr = 1, sc = 1, newColor = 2
    // OP: [[2,2,2],[2,2,0],[2,0,1]]
    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int color = image[sr][sc];

        if (color != newColor) {
            recursiveDFS(image, sr, sc, color, newColor);
        }
        return image;
    }

    private static void iterativeDFS(int[][] image, int sr, int sc, int color, int newColor) {
        Stack<int[]> nodeStack = new Stack<>();
        nodeStack.push(new int[]{sr, sc});
        boolean[][] visited = new boolean[image.length][image[0].length];
        while (!nodeStack.isEmpty()) {
            int[] current = nodeStack.pop();
            int srCurr = current[0];
            int scCurr = current[1];
            int oldColor = image[srCurr][scCurr];
            image[srCurr][scCurr] = newColor;
            visited[srCurr][scCurr] = true;

            if (srCurr + 1 < image.length && image[srCurr + 1][scCurr] == oldColor && !visited[srCurr + 1][scCurr]) {
                nodeStack.push(new int[]{srCurr + 1, scCurr});
            }
            if (srCurr - 1 >= 0 && image[srCurr - 1][scCurr] == oldColor && !visited[srCurr - 1][scCurr]) {
                nodeStack.push(new int[]{srCurr - 1, scCurr});
            }
            if (scCurr + 1 < image[0].length && image[srCurr][scCurr + 1] == oldColor && !visited[srCurr][scCurr + 1]) {
                nodeStack.push(new int[]{srCurr, scCurr + 1});
            }
            if (scCurr - 1 >= 0 && image[srCurr][scCurr - 1] == oldColor && !visited[srCurr][scCurr - 1]) {
                nodeStack.push(new int[]{srCurr, scCurr - 1});
            }
        }
    }

    private static void recursiveDFS(int[][] image, int sr, int sc, int color, int newColor) {
        if (sr < 0 || sc < 0 || sr >= image.length  || sc >= image[0].length || image[sr][sc] != color || image[sr][sc] == newColor) {
            return;
        }
        image[sr][sc] = newColor;
        recursiveDFS(image, sr + 1, sc, color, newColor);
        recursiveDFS(image, sr - 1, sc, color, newColor);
        recursiveDFS(image, sr, sc + 1, color, newColor);
        recursiveDFS(image, sr, sc - 1, color, newColor);

    }

    public static void main(String[] args) {
        int[][] input = new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        System.out.println(Arrays.deepToString(floodFill(input, 1, 1, 2))); // [[2, 2, 2], [2, 2, 0], [2, 0, 1]]
    }
}
