import java.util.Arrays;

public class NumberCompliment {
    public static void main(String[] args) {
        int a = 85;
        System.out.println(findCompliment(a));
    }

    private static int findCompliment(int num) {
        int i = 0;
        int j = 0;
        System.out.println(Integer.toBinaryString(num));
        while (i < num)
        {
            i += Math.pow(2, j);
            j++;
        }
        int x = i-num;
        System.out.println(Integer.toBinaryString(x));
        return i - num;
    }
}
