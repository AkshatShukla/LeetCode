import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubstringsOfSizeKWithKDistinctChars {
    public static List<String> findSubstrings(String s, int k) {
        if (s == null || s.length() == 0)
            return new ArrayList<>();
        Set<String> strings = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        
        // abcabc
        //   ^
        // ^
        // aaabc
        //     ^
        // start = 2
        // end = 4
        // window: [bc]
        Set<Character> window = new HashSet<>();
        int end = 0, start = 0;
        while (end < s.length()){
            char endChar = s.charAt(end);
            if (window.contains(endChar)) {
                char startChar = s.charAt(start);
                window.remove(startChar);
                start++;
            }
            window.add(endChar);
            if (window.size() == k) {
                strings.add(s.substring(start, end + 1));
                char startChar = s.charAt(start);
                window.remove(startChar);
                start++;
            }
            end++;
        }
        return new ArrayList<>(strings);
    }

    public static void main(String[] args) {
        System.out.println(findSubstrings("abcabc", 3));
        System.out.println(findSubstrings("aaabc", 3));
        System.out.println(findSubstrings("pqpqs", 2));
    }
}
