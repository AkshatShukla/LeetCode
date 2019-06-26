public class ConsecutiveNumbersSum {
    public static int consecutiveNumbersSumNaive(int N) {
        int count = 0;
        for (int i = 1; i <= N; i++) {
            int sumSoFar = i;
            for (int j = i + 1; j <= N; j++) {
                sumSoFar += j;
                if (sumSoFar == N) {
                    count++;
                } else if (sumSoFar > N) {
                    break;
                }
            }
        }

        return count + 1;
    }

    public static int consecutiveNumbersSumEfficient(int N) {
        /*
        N can be expressed as k + 1, k + 2, ..., k + i, where k is a positive integer; therefore

        N = k * i + (i + 1) * i / 2 =>
        N - (i + 1) * i / 2 = k * i, which implies that as long as N - (i + 1) * i / 2 is k times of i, we get a
        solution corresponding to i; Hence iteration of all possible values of i, starting from 1, will cover all cases
        of the problem.

        Since for i = 1, N can always be written as one number sequence: N, we can start from i = 2, ans = 1.
         */
        int ans = 1;
        for (int i = 2; i * (i + 1) / 2 <= N; i++) {
            if ((N - i * (i + 1) / 2) % i == 0) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(consecutiveNumbersSumNaive(15));
        System.out.println(consecutiveNumbersSumEfficient(15));
    }
}
