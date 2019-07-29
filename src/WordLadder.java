import javafx.util.Pair;

import java.util.*;

public class WordLadder {
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int result = 0;
        Set<String> wordSet = new HashSet<>(wordList);

        if (!wordSet.contains(endWord)) return result;

        // Since all words are of same length
        int L = beginWord.length();

        Map<String, List<String>> allComboDict = new HashMap<>();

        wordList.forEach(
                word -> {
                    for (int i = 0; i < L; i++) {
                        // Key is the generic word
                        // value is the list of words which have same intermediate generic word
                        String newWord = word.substring(0, i) + "*" + word.substring(i + 1, L);
                        List<String> transformations = allComboDict.getOrDefault(newWord, new ArrayList<>());
                        allComboDict.computeIfAbsent(newWord, k -> new ArrayList<>()).add(word);
                        transformations.add(word);
                        allComboDict.put(newWord, transformations);
                    }
                }
        );


        System.out.println(allComboDict);

        // Queue for BFS
        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(beginWord, 1));

        // Visited to make sure we dont repeat processing for same word
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        while (!queue.isEmpty()) {
            Pair<String, Integer> node = queue.poll();
            String word = node.getKey();
            int level = node.getValue();

            for (int i = 0; i < L; i++) {

                // Intermediate words for current word
                String newWord = word.substring(0, i) + "*" + word.substring(i + 1, L);
                // Next states are all the words which share the same intermediate state.
                for (String adjacentWord : allComboDict.getOrDefault(newWord, new ArrayList<>())) {
                    // If at any point we find that endWord is adjacent, return the level + 1;
                    if (adjacentWord.equals(endWord)) {
                        return level + 1;
                    }

                    // Otherwise add it to the BFS queue and to the visited node set
                    if (!visited.contains(adjacentWord)) {
                        visited.add(adjacentWord);
                        queue.offer(new Pair<>(adjacentWord, level + 1));
                    }
                }
            }
            System.out.println(visited);
        }

        return 0;
    }

    public static void main(String[] args) {
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        System.out.println(ladderLength("hit", "cog", wordList));
    }
}
