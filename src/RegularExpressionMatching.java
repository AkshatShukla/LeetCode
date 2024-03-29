public class RegularExpressionMatching {
    /*
        '.' Matches any single character.
        '*' Matches zero or more of the preceding element.
     */
    public static boolean isMatch(String s, String p) {
        char[] text = s.toCharArray();
        char[] pattern = p.toCharArray();

        boolean[][] T = new boolean[text.length + 1][pattern.length + 1];

        T[0][0] = true;
        //Deals with patterns like a* or a*b* or a*b*c*
        for (int i = 1; i < T[0].length; i++) {
            if (pattern[i - 1] == '*') {
                T[0][i] = T[0][i - 2];
            }
        }

        for (int i = 1; i < T.length; i++) {
            for (int j = 1; j < T[0].length; j++) {
                if (pattern[j - 1] == '.' || pattern[j - 1] == text[i - 1]) {
                    T[i][j] = T[i - 1][j - 1];
                } else if (pattern[j - 1] == '*') {
                    // 0 occurrences of character, remove * and that character and check if remaining are regex
                    T[i][j] = T[i][j - 2];
                    // check if without these two chars, pattern has . and that . matches previous char of text
                    if (pattern[j - 2] == '.' || pattern[j - 2] == text[i - 1]) {
                        T[i][j] = T[i][j] || T[i - 1][j];
                    }
                } else {
                    T[i][j] = false;
                }
            }
        }
        return T[text.length][pattern.length];
    }

    public static void main(String[] args) {
        System.out.println(isMatch("aa", "a"));
        System.out.println(isMatch("aa", "a*"));
        System.out.println(isMatch("ab", ".*"));
        System.out.println(isMatch("aab", "c*a*b"));
    }
}
