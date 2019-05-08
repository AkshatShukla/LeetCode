import java.util.*;

public class TopKFrequentElements {
    public static List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> countMap = new HashMap<>();

        for (int n : nums) {
            if (countMap.containsKey(n)) {
                int val = countMap.get(n);
                countMap.put(n, val+1);
            } else {
                countMap.put(n, countMap.getOrDefault(n, 0) + 1);
            }
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(countMap::get));

        for (int n: countMap.keySet()) {
            heap.offer(n);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        List<Integer> top_k = new ArrayList<>();
        while (!heap.isEmpty()) {
            top_k.add(heap.poll());
        }
        Collections.reverse(top_k);
        return top_k;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 2, 2, 3};
        System.out.println(topKFrequent(nums, 2)); // [1, 2]
    }
}
