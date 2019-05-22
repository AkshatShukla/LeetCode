import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortCharactersByFrequency {
    public static String frequencySort(String s) {
        Map<Character, Integer> countMap = new HashMap<>();

        // Add characters with their count to hash map
        for (char c : s.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Character> maxHeap = new PriorityQueue<>(Comparator.comparingInt(countMap::get).reversed());

        // Add characters to the heap
        for (char c : countMap.keySet()) {
            maxHeap.offer(c);
        }

        StringBuilder result = new StringBuilder();

        while (!maxHeap.isEmpty()) {
            char current = maxHeap.poll();
            for (int i = 0 ; i < countMap.get(current) ; i++) {
                result.append(current);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(frequencySort("tree")); // eert
    }
}
