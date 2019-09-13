import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourceToTarget {
    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(graph, allPaths, path, 0);
        return allPaths;
    }

    private static void dfs(int[][] graph, List<List<Integer>> allPaths, List<Integer> path, int currIdx) {
        // reached target
        if (currIdx == graph.length - 1) {
            allPaths.add(new ArrayList<>(path));
            return;
        }

        for (int neighbour : graph[currIdx]) {
            path.add(neighbour);
            dfs(graph, allPaths, path, neighbour);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(allPathsSourceTarget(new int[][]{{1, 2}, {3}, {3}, {}}));
    }
}
