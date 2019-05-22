import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {
    public static List<String> letterCombinations(String digits) {
        List<String> results = new ArrayList<>();
        if (digits == null || digits.isEmpty()) {
            return new ArrayList<>();
        }
        Map<Integer, String> map = new HashMap<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");

        permute("", digits, 0, map, results);
        return results;
    }

    private static void permute(String current, String digits, int index, Map<Integer, String> map, List<String> results) {
        if (index == digits.length()) {
            results.add(current);
        } else {
            String letters = map.get(digits.charAt(index) - '0');
            for (int i = 0; i < letters.length(); i++) {
                permute(current + letters.charAt(i), digits, index+1, map, results);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }
}
