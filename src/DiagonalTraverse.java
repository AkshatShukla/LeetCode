import java.util.*;

public class DiagonalTraverse {
    public static int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return new int[0];
        int r = 0, c = 0;
        int rows = matrix.length, cols = matrix[0].length;
        int[] res = new int[rows * cols];
        for (int i = 0; i < res.length; i++) {
            res[i] = matrix[r][c];
            if ((r + c) % 2 == 0) {
                if (c == cols - 1) r++;
                else if (r == 0) c++;
                else {
                    r--;
                    c++;
                }
            } else {
                if (r == rows - 1) c++;
                else if (c == 0) r++;
                else {
                    r++;
                    c--;
                }
            }
        }
        return res;
    }

    public static int[] findDiagonalOrder2(int[][] matrix) {
        if (matrix.length == 0 || matrix == null) {
            return new int[]{};
        }

        List<List<Integer>> result = new ArrayList<>();
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> tmpList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                int[] currentCell = queue.poll();
                int row = currentCell[0];
                int col = currentCell[1];

                if (level % 2 != 0)
                    tmpList.add(0, matrix[row][col]);
                else
                    tmpList.add(matrix[row][col]);

                if (row + 1 < matrix.length)
                    queue.offer(new int[]{row + 1, col});

                if (i == size - 1 && col + 1 < matrix[0].length)
                    queue.offer(new int[]{row, col + 1});
            }
            level++;
            result.add(tmpList);
        }

        int[] ans = new int[matrix.length * matrix[0].length];

        int idx = 0;
        for (List<Integer> nums : result) {
            for (int i : nums) {
                ans[idx] = i;
                idx++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(Arrays.toString(findDiagonalOrder(matrix)));
        System.out.println(Arrays.toString(findDiagonalOrder2(matrix)));
    }
}
