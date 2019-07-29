import java.util.Arrays;

public class VerifyingAnAlienDictionary {
    public static boolean isAlienSorted(String[] words, String order) {
        // character rank map
        int[] rankingOrder = new int[26];

        for (int i = 0; i < order.length(); i++) {
            rankingOrder[order.charAt(i) - 'a'] = i;
        }
        // lower the number, higher the rank for char

        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            if (rankingOrder[word1.charAt(0) - 'a'] > rankingOrder[word2.charAt(0) - 'a'])
                return false;
            if (rankingOrder[word1.charAt(0)- 'a'] == rankingOrder[word2.charAt(0) - 'a']) {
                if (!checkInnerOrder(word1, word2, rankingOrder)) return false;
            }
        }
        return true;
    }

    private static boolean checkInnerOrder(String word1, String word2, int[] rankingOrder) {
        int i = 0;
        int j = 0;
        while (i < word1.length() && j < word2.length()) {
            if (rankingOrder[word1.charAt(i) - 'a'] > rankingOrder[word2.charAt(j) - 'a']) {
                return false;
            }
            i++;
            j++;
        }
        return word1.length() < word2.length();
    }

    public static void main(String[] args) {
        String order = "hlabcdefgijkmnopqrstuvwxyz";
        String[] words = {"hello", "leetcode"};
        System.out.println(isAlienSorted(words, order));
    }
}
