public class IsPowerOfThree {
    public static void main(String[] args) {
        int n = 243;
        System.out.println(isPowerOfThree(n));
    }

    private static boolean isPowerOfThree(int n) {
        if (n == 0)
            return false;
        double x = (Math.log10(n) / Math.log10(3));
        System.out.println(x%1);
        return x%1 == 0;
    }
}
