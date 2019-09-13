public class FriendCircle {
    public static int findCircleNum(int[][] M) {
        int totalCircles = 0;
        boolean[] visited = new boolean[M.length];
        for (int i = 0; i < M.length; i++) {
            if (!visited[i]) {
                totalCircles++;
                dfs(M, i, visited);
            }
        }
        return totalCircles;
    }

    public static void dfs(int[][] M, int i, boolean[] visited) {
        visited[i] = true;
        for (int j = 0; j < M[i].length; j++) {
            if (M[i][j] == 1 && !visited[j]) {
                dfs(M, j, visited);
            }
        }
    }

    public static void main(String[] args) {
        int[][] ints = new int[][]{{1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}};
        System.out.println(findCircleNum(ints)); // 2
        /*
        The 0th and 1st students are direct friends, so they are in a friend circle.
        The 2nd student himself is in a friend circle. So return 2.
         */
        int[][] ints1 = new int[][]{{1, 0, 0, 1},
                {0, 1, 1, 0},
                {0, 1, 1, 1},
                {1, 0, 1, 1}};
        System.out.println(findCircleNum(ints1)); // 1
    }
}
