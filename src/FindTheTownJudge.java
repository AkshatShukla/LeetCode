import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindTheTownJudge {
    public static int findJudge(int N, int[][] trust) {
        // how many people he trusts
        int[] trusts = new int[N];

        // how many people trusts him, aka trusted by
        int[] trusted = new int[N];


        for (int[] rel : trust) {
            trusts[rel[0] - 1]++;
            trusted[rel[1] - 1]++;
        }

        int judge = -1;
        int j_num = 0;
        for (int i = 0; i < N; i++) {
            // rule 1 and 2:
            // he trusts no one, and everybody trusts him, everybody means everyone but himself
            if (trusts[i] == 0 && trusted[i] == N - 1) {
                judge = i + 1;
                j_num++;
            }
        }
        // rule number 3, there is only one judge
        if (j_num == 1) {
            return judge;
        }
        return -1;
    }

    public static int findJudge2(int N, int[][] trust) {
        Map<Integer, Set<Integer>> trustMap = new HashMap<>();
        Set<Integer> trustees = new HashSet<>();

        for (int[] ints : trust) {
            if (!trustMap.containsKey(ints[0]))
                trustMap.put(ints[0], new HashSet<>());
            trustMap.get(ints[0]).add(ints[1]);
        }
        int result = -1;

        for (int i = 1; i <= N; i++) {
            if (!trustMap.containsKey(i)) result = i;
        }

        for (int[] ints : trust) {
            if (ints[1] == result)
                trustees.add(ints[0]);
        }

        if (trustees.size() == N - 1) {
            return result;
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findJudge(2, new int[][]{{1, 2}}));
        System.out.println(findJudge(3, new int[][]{{1, 3}, {2, 3}}));
        System.out.println(findJudge(3, new int[][]{{1, 3}, {2, 3}, {3, 1}}));
        System.out.println(findJudge(3, new int[][]{{1, 2}, {2, 3}}));
        System.out.println(findJudge(4, new int[][]{{1, 3}, {1, 4}, {2, 3}, {2, 4}, {4, 3}}));
    }
}
