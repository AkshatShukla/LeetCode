import javafx.util.Pair;
import java.util.ArrayList;
import java.util.List;

public class CriticalConnections {
    public static List<Pair<Integer, Integer>> criticalConnections(int n, List<Pair<Integer, Integer>> connections) {
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();

        for (int i = 0; i < connections.size(); i++) {
            Pair<Integer, Integer> edge = connections.get(i);
            graph[edge.getKey() - 1].add(edge.getValue());
            graph[edge.getValue() - 1].add(edge.getKey());
        }
        boolean[] visited = new boolean[n];
        int[] order = new int[n];
        List<Pair<Integer, Integer>> results = new ArrayList<>();
        int[] uuid = new int[1]; // a global unique counter that assigns traversal order to each node
        dfs(graph, -1, 1, visited, order, uuid, results);
        return results;
    }

    public static void dfs(List<Integer>[] graph, int pre, int src, boolean[] visited, int[] order, int[] uuid, List<Pair<Integer, Integer>> results) {
        visited[src - 1] = true;
        order[src - 1] = uuid[0]++;
        int orig_order = order[src - 1];
        for (Integer neighbour : graph[src - 1]) {
            if (neighbour == pre)
                continue; // pre: guarantee no backward traversal
            if (!visited[neighbour - 1])
                dfs(graph, src, neighbour, visited, order, uuid, results);
            // order[src] keeps the earliest point that src can reach without passing src->pre
            order[src - 1] = Math.min(order[src - 1], order[neighbour - 1]); // used by its predecessor to tell if pre->src is critical.
            if (orig_order < order[neighbour - 1])
                results.add(new Pair<>(src, neighbour));
        }
    }

    public static void main(String[] args) {
        List<Pair<Integer, Integer>> edges = new ArrayList<>();
        edges.add(new Pair<>(1, 2));
        edges.add(new Pair<>(1, 3));
        edges.add(new Pair<>(3, 4));
        edges.add(new Pair<>(1, 4));
        edges.add(new Pair<>(4, 5));
        List<Pair<Integer, Integer>> newEdges = new ArrayList<>();
        newEdges.add(new Pair<>(1, 2));
        newEdges.add(new Pair<>(1, 3));
        newEdges.add(new Pair<>(2, 3));
        newEdges.add(new Pair<>(3, 4));
        newEdges.add(new Pair<>(3, 6));
        newEdges.add(new Pair<>(4, 5));
        newEdges.add(new Pair<>(6, 7));
        newEdges.add(new Pair<>(6, 9));
        newEdges.add(new Pair<>(7, 8));
        newEdges.add(new Pair<>(8, 9));
        List<Pair<Integer, Integer>> result = criticalConnections(9, newEdges);
        for (Pair<Integer, Integer> ints : result)
            System.out.println(ints);
    }
}
