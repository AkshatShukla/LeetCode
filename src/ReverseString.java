public class ReverseString {
    public static void main(String[] args) {
        String s = "hello";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(s);
        stringBuilder.reverse();
        System.out.println(stringBuilder);
    }
}
