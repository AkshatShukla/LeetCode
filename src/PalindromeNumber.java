public class PalindromeNumber {
    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int reversed = rev(x);
        return reversed == x;
    }

    public static int rev(int x) {
        int revNum = 0;
        while (x != 0) {
            revNum = revNum*10 + x%10;
            x /= 10;
        }
        return revNum;
    }

    public static void main(String[] args) {
        int input1 = 121;
        int input2 = -124;
        int input3 = 321;
        System.out.println(isPalindrome(input1)); // true
        System.out.println(isPalindrome(input2)); // false
        System.out.println(isPalindrome(input3)); // false
    }
}
