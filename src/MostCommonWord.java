import java.util.*;

public class MostCommonWord {
    public static String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedWords = new HashSet<>();
        Collections.addAll(bannedWords, banned);

        Map<String, Integer> count = new HashMap<>();
        StringBuilder word = new StringBuilder();
        String ans = "";
        int ansFreq = 0;
        for (char c : paragraph.toCharArray()) {
            if (Character.isLetter(c)) {
                word.append(Character.toLowerCase(c));
            } else if (word.length() > 0) {
                String finalWord = word.toString();
                if (!bannedWords.contains(finalWord) && finalWord.trim().length() > 0) {
                    count.put(finalWord, count.getOrDefault(finalWord, 0) + 1);
                    if (count.get(finalWord) > ansFreq) {
                        ans = finalWord;
                        ansFreq = count.get(ans);
                    }
                }
                word = new StringBuilder();
            }
        }

        System.out.println(count);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", new String[]{"hit"}));
        System.out.println(mostCommonWord("Bob", new String[]{}));
        System.out.println(mostCommonWord("Jack and Jill went to the market to buy bread and cheese. Cheese is Jack’s and Jill’s favorite food.", new String[]{"and", "he", "the", "to", "is", "Jack", "Jill"}));
    }
}
