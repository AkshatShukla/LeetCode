public class Wayfair {
    public static int solution(int[] A) {
        // return sum of two digit numbers
        if (A == null || A.length == 0)
            return 0;

        int twoDigitSum = 0;

        for (int num : A) {
            if (Math.abs(num) >= 10 && Math.abs(num) < 100) {
                twoDigitSum += num;
            }
        }

        return twoDigitSum;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1}));
        System.out.println(solution(new int[]{}));
        System.out.println(solution(new int[]{1, 1000, 80, -91}));
        System.out.println(solution(new int[]{47, 1900, 1, 90, 45}));
        System.out.println(solution(new int[]{-13, 1900, 1, 100, 45}));
    }
}
