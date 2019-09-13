import java.util.Arrays;

public class TwoSumLessThanK {
    public static int twoSumLessThanK(int[] A, int K) {
        Arrays.sort(A);
        int low = 0;
        int high = A.length - 1;
        int maxSum = -1;
        while (low < high) {
            int sum = A[low] + A[high];
            if (sum < K) {
                maxSum = sum;
                low++;
            } else {
                high--;
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(twoSumLessThanK(new int[]{34, 23, 1, 24, 75, 33, 54, 8}, 60));
        System.out.println(twoSumLessThanK(new int[]{10, 20, 30}, 15));
    }
}
