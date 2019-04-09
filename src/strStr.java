public class strStr {
    public static void main(String[] args) {
//        String haystack = "hello", needle = "ll";
        String haystack = "aaaaa", needle = "bba";
        System.out.println(needleInHaystack(haystack, needle));
    }

    private static int needleInHaystack(String haystack, String needle) {
        if (needle.isEmpty())
            return 0;
        return haystack.indexOf(needle);
    }
}
