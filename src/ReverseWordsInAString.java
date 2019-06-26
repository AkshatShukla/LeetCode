public class ReverseWordsInAString {
    public static String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] strArray = s.split(" ");
        reverse(strArray);
        for (String str : strArray) {
            if (!str.isEmpty()) {
                sb.append(str).append(" ");
            }
        }
        return sb.toString().trim();
    }

    private static void reverse(String[] s) {
        int low = 0;
        int high = s.length - 1;
        while (low < high) {
            String temp = s[high];
            s[high] = s[low];
            s[low] = temp;
            low++;
            high--;
        }
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("a good  example"));
    }
}
