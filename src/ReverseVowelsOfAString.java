import java.util.*;

public class ReverseVowelsOfAString {
    public static String reverseVowels(String s) {
        List<Character> stringVowels = new ArrayList<>();
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

        for (char c : s.toCharArray()) {
            if (vowels.contains(c)) {
                stringVowels.add(c);
            }
        }
        Collections.reverse(stringVowels);
        int idx = 0;
        char[] letters = s.toCharArray();
        for (int i = 0; i < letters.length; i++) {
            if (vowels.contains(letters[i])) {
                letters[i] = stringVowels.get(idx);
                idx++;
            }
        }
        return new String(letters);
    }

    public static String reverseVowelsEfficient(String s) {
        if (s.length() == 0) return s;
        Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        char[] a = s.toCharArray();

        int j = s.length() - 1, i = 0;
        while (i < j) {
            while (i < j && !set.contains(a[i])) {
                i++;
            }

            while (i < j && !set.contains(a[j])) {
                j--;
            }

            char temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i++;
            j--;
        }

        return String.valueOf(a);
    }

    public static void main(String[] args) {
        System.out.println(reverseVowels("hello"));
        System.out.println(reverseVowels("leetcode"));
        System.out.println(reverseVowels("aA"));
        System.out.println(reverseVowelsEfficient("a.b,."));
    }
}
