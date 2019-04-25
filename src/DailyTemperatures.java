public class DailyTemperatures {
    public static int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        res[T.length-1] = 0;
        int i = T.length-2;
        while (i>=0) {
            if (T[i]<T[i+1]) {
                res[i] = 1;
                i--;
            } else {
                int j = i + 1;
                while (res[j]!=0) {
                    j += res[j];
                    if (T[i] < T[j]) {
                        res[i] = j - i;
                        break;
                    }
                }
                i--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] T = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        for (int temp:dailyTemperatures(T)) {
            System.out.println(temp);
        }
    }
}
