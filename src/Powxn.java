public class Powxn {
    public static void main(String[] args) {
        double x = 2;
        int n = 10;
        System.out.println(myPow(x,n));
    }

    private static double myPow(double x, int n) {
        if (n == 0)
            return 1;
        if(n<0){
            x = 1/x;
            return (n %2 == 0) ? myPow(x*x, -(n/2)) : x*myPow(x*x, -(n/2));
        }
        return (n%2 == 0) ? myPow(x*x, n/2) : x*myPow(x*x, n/2);
    }
}
