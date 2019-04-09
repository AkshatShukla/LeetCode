public class PeakIndexOfMountainArray {
    public static void main(String[] args) {
        int[] A = new int[]{0,2,1,0};
        for (int i = 1; i < A.length; i++) {
            if (A[i-1] > A[i])
            {
                System.out.println(i-1);
            }
        }
        System.out.println(-1);
    }
}
