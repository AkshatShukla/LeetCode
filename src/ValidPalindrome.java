public class ValidPalindrome {
    public static void main(String[] args) {
        String input = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(input));
    }

    private static boolean isPalindrome(String s) {
        //Anything that isn't a word character (including punctuation etc)
        s = s.replaceAll("\\W+","").toLowerCase();
        System.out.println(s);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(s);
        String s1 = stringBuilder.reverse().toString();
        return s.matches(s1);
    }
}
