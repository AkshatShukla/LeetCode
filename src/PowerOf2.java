public class PowerOf2 {
    public static boolean isPowerOfTwo(int n) {
        while (n > 0) {
            if (n == 1) {
                return true;
            }
            if (n % 2 != 0) {
                return false;
            }
            n /= 2;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(536870912));
    }
}
