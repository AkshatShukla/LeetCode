import java.util.*;

public class TaskScheduler {
    public static int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c : tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        maxHeap.addAll(map.values());

        int cycles = 0;

        while (!maxHeap.isEmpty()) {
            List<Integer> temp = new ArrayList<>(); // store all processes to run in this iteration
            for (int i = 0; i <= n; i++) {
                if (!maxHeap.isEmpty()) {
                    temp.add(maxHeap.poll());
                }
            }

            for (int i : temp) {
                i -= 1; // decrement the amount of task remaining
                if (i > 0) {
                    // task still needs running
                    maxHeap.offer(i);
                }
            }

            cycles += maxHeap.isEmpty() ? temp.size() : n + 1; // if stuck in a cooldown, then n + 1;
        }

        return cycles;
    }

    public static void main(String[] args) {
        char[] chars = new char[]{'A', 'A', 'A', 'B', 'B', 'B'};
        System.out.println(leastInterval(chars, 2));
    }
}
