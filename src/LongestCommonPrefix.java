import java.util.Arrays;

// Sort the array and the compare the prefix characters of first and last strings
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strings = new String[]{"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strings));
    }

    private static String longestCommonPrefix(String[] strs) {
        StringBuilder stringBuilder = new StringBuilder();
        Arrays.sort(strs);
        if (strs.length != 0) {
            String first = strs[0];
            String last = strs[strs.length-1];
            char[] firstChars = first.toCharArray();
            char[] lastChars = last.toCharArray();

            for (int i=0;i<firstChars.length;i++) {
                if (lastChars.length>0 && lastChars[i]==firstChars[i])
                    stringBuilder.append(lastChars[i]);
                else
                    return stringBuilder.toString();
            }
        }
        return stringBuilder.toString();
    }
}
