import java.util.HashMap;
import java.util.Map;

public class FindWordsThatCanBeFormedByCharacters {
    public static int countCharacters2(String[] words, String chars) {
        int sumLens = 0;
        int[] charCount = new int[26];

        for (char c : chars.toCharArray()) {
            charCount[c - 'a']++;
        }

        for (String word : words) {
            int[] countMap = charCount.clone();
            boolean valid = true;
            for (char c : word.toCharArray()) {
                countMap[c - 'a']--;
                if (countMap[c - 'a'] < 0) {
                    valid = false;
                    break;
                }
            }
            if (valid)
                sumLens += word.length();
        }

        return sumLens;
    }

    public static int countCharacters1(String[] words, String chars) {
        int sumLens = 0;
        Map<Character, Integer> charSet = new HashMap<>();

        for (char c : chars.toCharArray()) {
            charSet.put(c, charSet.getOrDefault(c, 0) + 1);
        }

        outer:
        for (String word : words) {
            Map<Character, Integer> charCount = new HashMap<>();
            for (char c : word.toCharArray())
                charCount.put(c, charCount.getOrDefault(c, 0) + 1);
            for (char c : word.toCharArray()) {
                if (charSet.getOrDefault(c, 0) < charCount.get(c))
                    continue outer;
            }
            sumLens += word.length();
        }

        return sumLens;
    }

    public static void main(String[] args) {
        String[] words = {"cat","bt","hat","tree"};
        String[] words1 = {"hello","world","leetcode"};

        System.out.println(countCharacters1(words, "atach")); // The strings that can be formed are "cat" and
        // "hat" so the answer is 3 + 3 = 6.
        System.out.println(countCharacters1(words1, "welldonehoneyr")); // The strings that can be formed are
        // "hello" and "world" so the answer is 5 + 5 = 10.
        System.out.println(countCharacters2(words, "atach"));
        System.out.println(countCharacters2(words1, "welldonehoneyr"));
    }
}
