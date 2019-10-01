import java.util.Arrays;

public class FindPairWithMaxAppealSum {
    public static int[] maximumAppealValue(int[] A) {
        /*
        We can consider A[i] - i as a whole part. When we go through the array (by index i), we add the largest (A[k] - k)
         we have ever found to A[i] + i and judge whether the sum is the largest appeal(Since i is always larger or equal
          to k, this can write as A[i] + A[k] + i - k). Just for a remind, we need to find the largest "gain" before
          computing the largest appeal cause i = j allowed.
         */
        int len = A.length;
        if (len < 2) return new int[0];
        int[] res = new int[2];
        int maxGainIdx = 0, maxAppeal = A[0] + A[0] + (0 - 0);
        for (int i = 1; i < len; i++) {
            int gain = A[i] - i;
            maxGainIdx = (gain > A[maxGainIdx] - maxGainIdx) ? i : maxGainIdx;
            int appeal = A[i] + i + A[maxGainIdx] - maxGainIdx;
            if (appeal > maxAppeal) {
                maxAppeal = appeal;
                res[0] = maxGainIdx;
                res[1] = i;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] ints = {1, 3, -1};
        System.out.println(Arrays.toString(maximumAppealValue(ints)));
    }
}
