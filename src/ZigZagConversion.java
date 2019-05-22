import java.util.Arrays;

public class ZigZagConversion {
    public static String convert(String s, int numRows) {
        if (s == null || numRows <= 0) {
            return null;
        }
        if (numRows == 1) {
            return s;
        }
        int currPos = 1;
        String[] strings = new String[numRows];
        Arrays.fill(strings, "");
        boolean goUp = false; // down
        for (int i = 0; i < s.length(); i++) {
            if (currPos == numRows) {
                goUp = true;
            } else if (currPos == 1) {
                goUp = false;
            }
            if (currPos < numRows && !goUp) {
                strings[currPos-1] += s.charAt(i);
                currPos++;
            } else {
                strings[currPos-1] += s.charAt(i);
                currPos--;
            }
            System.out.println(Arrays.toString(strings));
        }
        StringBuilder result = new StringBuilder();
        for (String str : strings) {
            result.append(str);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
    }
}
