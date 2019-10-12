import java.util.*;

public class FindTheRank {
    public static int rankIndex(List<List<Integer>> values, int rank) {
        // rank is the position in sorted list of total marks, from high to low
        // if 2 students have equal marks, their original order is maintained while sorting


        // highest rank (rank 1) is at peek of rankHeap. In case of tie in score, score with lower index is
        // given the peek in rankHeap.
        // {score, index}
        PriorityQueue<int[]> rankHeap = new PriorityQueue<>((o1, o2) -> {
            int cmp = o2[0] - o1[0];
            if (cmp == 0) {
                return o1[1] - o2[1];
            }
            return cmp;
        });
        for (int i = 0; i < values.size(); i++) {
            int performanceSum = 0;
            for (int subjectMarks : values.get(i)) {
                performanceSum += subjectMarks;
            }
            rankHeap.offer(new int[]{performanceSum, i});
        }
        while (!rankHeap.isEmpty()) {
            System.out.println(Arrays.toString(rankHeap.poll()));
        }
//      342, 334, 334, 317 -> 2
        // 439,430,410,390,380
        // 3, 2, 1, 0
        while (rank > 1) {
            rank--;
            rankHeap.poll();
        }
        return rankHeap.peek() != null ? rankHeap.peek()[1] : 0;
        //return 0;
    }

    public static void main(String[] args) {
        List<List<Integer>> values = new ArrayList<>();
        values.add(Arrays.asList(80, 96, 81, 77));
        values.add(Arrays.asList(78, 71, 93, 75));
        values.add(Arrays.asList(71, 98, 70, 95));
        values.add(Arrays.asList(80, 96, 89, 77));
//        values.add(Arrays.asList(99,92,93,94,61)); // 439
//        values.add(Arrays.asList(72,74,76,78,80)); // 380
//        values.add(Arrays.asList(82,84,86,88,90)); // 430
//        values.add(Arrays.asList(74,78,82,86,90)); // 410
//        values.add(Arrays.asList(66,72,78,84,90)); // 390
//        values.add(Arrays.asList(78,81,82,69));
//        values.add(Arrays.asList(74,92,75,73));
//        values.add(Arrays.asList(73,88,99,80));
        System.out.println(rankIndex(values, 3));
    }
}
