public class GetSum {
    public static void main(String[] args) {
        int a = 2, b = 4;
        System.out.println(getSum(a,b));
    }

    private static int getSum(int a, int b) {
        if(b == 0) return a;
        int carry = (a & b) << 1;
        int sum = a ^ b;
        return getSum(sum, carry);
    }
}
