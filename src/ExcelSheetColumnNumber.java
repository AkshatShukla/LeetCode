public class ExcelSheetColumnNumber {
    public static void main(String[] args) {
        String s = "B";
        System.out.println(titleToNumber(s));
    }

    private static int titleToNumber(String s) {
        int res = 0;
        for (char c:s.toCharArray()) {
            res *= 26;
            res += c - 'A' + 1;
        }
        return res;
    }
}
