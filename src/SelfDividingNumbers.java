import java.util.ArrayList;
import java.util.List;

public class SelfDividingNumbers {
    public static void main(String[] args) {
        int left = 1;
        int right = 22;
        selfDividingNumbers(left, right);
    }

    private static List<Integer> selfDividingNumbers(int left, int right) {
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i=left;i<=right;i++) {
            if (isValid(i))
                ans.add(i);
        }

        return ans;
    }

    private static boolean isValid(int number) {
        int original = number;
        while (number != 0) {
            int digit = number%10;
            if (digit == 0) return false;
            if (original%digit != 0) return false;
            number /= 10;
        }
        return true;
    }
}
