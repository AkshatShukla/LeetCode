import java.util.ArrayList;

public class HappyNumber {
    public static void main(String[] args) {
        int i = 2;
        System.out.println(isHappy(i));
    }

    private static boolean isHappy(int n) {
        if (n < 10) {
            return n == 1 || n == 7;
        }
        int newsum = 0;
        while (n != 0) {
            int digit = n % 10;
            newsum += digit*digit;
            n /= 10;
        }
        //System.out.println(newsum);
        return isHappy(newsum);
//        if (n < 10) {
//            return n == 1 || n == 7;
//        }
//        return computeHappy(n) == 1;
    }

    private static int computeHappy(int i) {
        int a;
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (i != 0) {
            a = i % 10;
            arrayList.add(a);
            i = i / 10;
        }
        int x = happyNumber(arrayList);
        if (x!=1) {
            arrayList.clear();
            x = computeHappy(x);
        }
        return x;
    }

    private static int happyNumber(ArrayList<Integer> arrayList) {
        int sum = 0;
        for (int x : arrayList) {
            sum += Math.pow(x, 2);
        }
        return sum;
    }
}
