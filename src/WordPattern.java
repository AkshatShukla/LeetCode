import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    public static boolean wordPattern(String pattern, String str) {
        if (pattern == null || str == null)
            return false;

        char[] chars = pattern.toCharArray();

        String[] parts = str.split(" ");

        if (parts.length != pattern.length())
            return false;
        Map<Character, String> mapping = new HashMap<>();
        // store each character seen with its string
        int i = 0;

        while (i < parts.length) {
            if (mapping.containsKey(chars[i])) {
                if (!mapping.get(chars[i]).equals(parts[i]))
                    return false;
            } else {
                if (mapping.containsValue(parts[i]))
                    return false;
                mapping.put(chars[i], parts[i]);
            }
            i++;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(wordPattern("abba", "dog cat cat dog"));
        System.out.println(wordPattern("abba", "dog act act dog"));
        System.out.println(wordPattern("abba", "dog act cat dog"));
        System.out.println(wordPattern("abba", "dog cat cat fish"));
    }
}
