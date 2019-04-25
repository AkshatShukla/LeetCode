public class Sqrtx {
    public static int mySqrt(int x) {
        long low = 0;
        long high = x /2 + 1;

        while (low <= high) {
            long mid = (low + high) / 2;
            long result = mid * mid;
            if (result == (long) x) {
                return (int) mid;
            } else if (result > x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return (int) high;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(4));
    }
}
