public class ReverseString {
    public static void reverseString(char[] s) {
        int low = 0;
        int high = s.length - 1;

        while (low < high) {
            char temp = s[low];
            s[low] = s[high];
            s[high] = temp;
            low++;
            high--;
        }
    }

    public static void main(String[] args) {
        String s = "hello";
        char[] chars = {'h','e','l','l','o'};
        reverseString(chars);
        System.out.println(chars);
//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append(s);
//        stringBuilder.reverse();
//        System.out.println(stringBuilder);
    }
}
