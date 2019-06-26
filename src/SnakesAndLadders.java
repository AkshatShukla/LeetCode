import java.util.*;

public class SnakesAndLadders {
    static class QueueEntry {
        int vertex; // vertex number
        int distance; // distance of vertex from source
    }

    public static int snakesAndLadders(int[][] board) {
        // convert to 1d array
        int N = board.length;
        int[] arr = new int[N * N];
        int idx = 0;
        int row = N - 1, column = 0, direction = 1;
        while (idx < N * N) {
            arr[idx] = board[row][column];
            if (direction == 1 && column == N - 1) {
                direction = -1;
                row--;
            } else if (direction == -1 && column == 0) {
                direction = 1;
                row--;
            } else {
                column += direction;
            }
            idx++;
        }
        boolean[] visited = new boolean[N * N];
        Queue<QueueEntry> queue = new LinkedList<>();
        QueueEntry init = new QueueEntry();
        init.vertex = 0;
        init.distance = 0;
        queue.offer(init);
        visited[0] = true;
        QueueEntry current = new QueueEntry();

        while (!queue.isEmpty()) {
            current = queue.peek();
            int currentVertex = current.vertex;
            if (currentVertex == (N * N) - 1) {
                return current.distance; // reached the destination (top-right square)
                // this is the distance of source to last cell
            }

            queue.poll();
            for (int i = currentVertex + 1; i <= Math.min(currentVertex + 6, N * N - 1); i++) {
                if (!visited[i]) {
                    QueueEntry newSquare = new QueueEntry();
                    newSquare.distance = current.distance + 1;
                    visited[i] = true;

                    if (arr[i] != -1) {
                        newSquare.vertex = arr[i] - 1; // cell with snakes/ladder
                    } else {
                        newSquare.vertex = i; // normal cell
                    }
                    queue.offer(newSquare);
                }
            }
        }
        return -1; // cannot reach destination
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 35, -1, -1, 13, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 15, -1, -1, -1, -1}};
        System.out.println(snakesAndLadders(input));
    }
}
