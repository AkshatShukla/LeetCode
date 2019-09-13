public class IsSubsequence {
    public static boolean isSubsequence(String s, String t) {
        // axc
        // ahbxdc
        // ^
        int anchor = 0;
        for (char c : s.toCharArray()) {
            if (t.contains(String.valueOf(c))) {
                anchor = t.indexOf(String.valueOf(c));
                t = t.substring(anchor + 1);
            } else {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isSubsequence("axc", "ahbxdc"));
    }
}
