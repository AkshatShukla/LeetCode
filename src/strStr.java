public class strStr {
    public static void main(String[] args) {
        String haystack = "hello", needle = "ll";
//        String haystack = "aaaaa", needle = "bba";
        System.out.println(needleInHaystack(haystack, needle));
    }

    private static int needleInHaystack(String haystack, String needle) {
        if (needle.equals("") || haystack.equals("")) return 0;
        int len = needle.length();

        for (int i = 0; i < haystack.length() - len + 1; i++){
            String sub = haystack.substring(i, i + len);
            System.out.println(sub);
            if (sub.equals(needle))
                return i;
        }

        return -1;
    }
}
