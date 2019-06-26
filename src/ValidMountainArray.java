public class ValidMountainArray {
    public static boolean validMountainArray(int[] A) {
        if (A.length < 3) return false;
        int max_index = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[max_index]) max_index = i;
        }
        if (max_index == 0 || max_index == A.length - 1) return false;

        for (int i = 0; i < max_index; i++) {
            if (A[i] < A[i + 1]) continue;
            else return false;
        }

        for (int i = max_index; i < A.length - 1; i++) {
            if (A[i] > A[i + 1]) continue;
            else return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(validMountainArray(new int[]{0, 1, 2, 1, 2}));
    }
}
