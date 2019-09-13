import javafx.util.Pair;

import java.util.*;

public class TopKFrequentWords {
    public static List<String> topKFrequent(String[] words, int k) {
        List<String> result = new ArrayList<>();
        Map<String, Integer> freqMap = new HashMap<>();

        PriorityQueue<String> queue = new PriorityQueue<>((w1, w2) -> freqMap.get(w1).equals(freqMap.get(w2)) ? w2.compareTo(w1) : freqMap.get(w1) - freqMap.get(w2));


        for (String s : words) {
            freqMap.put(s, freqMap.getOrDefault(s, 0) + 1);
        }

        for (String word : freqMap.keySet()) {
            queue.offer(word);
            if (queue.size() > k) {
                queue.poll();
            }
        }

        System.out.println(queue);

        while (!queue.isEmpty()) {
            result.add(queue.poll());
        }
        Collections.reverse(result);
        return result;
    }
}
