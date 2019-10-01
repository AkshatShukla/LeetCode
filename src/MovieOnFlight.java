import java.util.Arrays;

public class MovieOnFlight {
    private static int[] get2SumClosest(int[] movie_duration, int d) {
        Arrays.sort(movie_duration);
        int l = 0, r = movie_duration.length - 1;
        int max = 0;
        int[] res = new int[]{-1, -1};
        while (l < r) {
            int sum = movie_duration[l] + movie_duration[r];
            if (sum > max && sum <= d) {
                max = sum;
                res[0] = movie_duration[l];
                res[1] = movie_duration[r];
            }
            if (sum > d)
                r--;
            else
                l++;
        }
        return res;
    }
}
