import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KeyboardRow {
    public static String[] findWords(String[] words) {
        String row1 = "qwertyuiop", row2 = "asdfghjkl", row3 = "zxcvbnm";
        int[] chars = new int[26];
        //Fill row number for each letter of the alphabet
        for (char c : row1.toCharArray()) chars[c - 'a'] = 1;
        for (char c : row2.toCharArray()) chars[c - 'a'] = 2;
        for (char c : row3.toCharArray()) chars[c - 'a'] = 3;

        List<String> result = new ArrayList<>();

        for (String word : words) {
            int curr_row = chars[word.toLowerCase().charAt(0) - 'a'];
            boolean sameRow = true;
            for (char letter : word.toLowerCase().toCharArray()) {
                if (chars[letter - 'a'] != curr_row) {
                    sameRow = false;
                    break;
                }
            }
            if (sameRow)
                result.add(word);
        }

        return result.toArray(new String[result.size()]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findWords(new String[]{"Hello", "Alaska", "Dad", "Peace"})));
    }
}
