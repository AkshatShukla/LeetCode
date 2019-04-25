public class NextClosestTime {
    public static String nextClosestTime(String time) {
        int[] res = new int[4];
        int i = 0;
        for (char c:time.toCharArray()) {
            if (c != ':') {
                res[i] = c - '0';
                i++;
            }
        }
        for (int n:res){
            System.out.println(n);
        }

        return null;
    }

    public static void main(String[] args) {
        System.out.println(nextClosestTime("19:34"));
    }
}
