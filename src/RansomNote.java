import java.util.Arrays;

public class RansomNote {
    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] charCount = new int[26];

        for (int i = 0; i < magazine.length(); i++) {
            charCount[magazine.charAt(i) - 'a']++;
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            charCount[ransomNote.charAt(i) - 'a']--;
        }

        for (int count : charCount) {
            if (count < 0) {
                return false;
            }
        }
        System.out.println(Arrays.toString(charCount));
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canConstruct("aa", "ab"));
    }
}
