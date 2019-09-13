public class IntegerToRoman {
    final static String[] M = {"", "M", "MM", "MMM"};
    final static String[] C = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    final static String[] X = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    final static String[] I = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

    public static String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        sb.append(M[num / 1000]);
        sb.append(C[(num % 1000) / 100]);
        sb.append(X[(num % 100) / 10]);
        sb.append(I[(num % 10)]);
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(3));
        System.out.println(intToRoman(1972));
    }
}
