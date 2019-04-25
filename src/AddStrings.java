public class AddStrings {
    public static String addStrings(String num1, String num2) {
        int one = num1.length() - 1;
        int two = num2.length() - 1;
        StringBuilder result = new StringBuilder();
        int carry = 0;
        while (one >= 0 || two >= 0) {
            int a = one >= 0 ? num1.charAt(one) - '0' : 0;
            int b = two >= 0 ? num2.charAt(two) - '0' : 0;
            int sum = a + b + carry;
            carry = sum / 10;
            sum = sum % 10;
            result.append((char)(sum + '0'));
            one--;
            two--;
        }
        if (carry == 1) {
            result.append('1');
        }
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        String num1 = "9333852702227987";
        String num2 = "85731737104263";
        System.out.println(addStrings(num1, num2));
    }
}
