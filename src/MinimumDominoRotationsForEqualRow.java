public class MinimumDominoRotationsForEqualRow {
    public static int minDominoRotations(int[] A, int[] B) {
        // pick A[0] and check if all elements in A or B can be made to A[0]
        // pick B[0] and check if all elements in A or B can be made to B[0]
        int rotations = check(A[0], A, B, A.length);
        if (rotations != -1 || A[0] == B[0]) return rotations;
        else
            return check(B[0], B, A, B.length);
    }

    public static int check(int x, int[] A, int[] B, int n) {
        int rotations_a = 0, rotations_b = 0;
        for (int i = 0; i < n; i++) {
            if (A[i] != x && B[i] != x)
                return -1;
            if (A[i] != x)
                rotations_a++;
            if (B[i] != x)
                rotations_b++;
        }

        return Math.min(rotations_a, rotations_b);
    }

    public static void main(String[] args) {
        int[] A = new int[]{2, 1, 2, 4, 2, 2};
        int[] B = new int[]{5, 2, 6, 2, 3, 2};
        System.out.println(minDominoRotations(A, B)); // 2
        /*
        The first figure represents the dominoes as given by A and B: before we do any rotations.
        If we rotate the second and fourth dominoes, we can make every value in the top row equal to 2,
        as indicated by the second figure.
         */
    }
}
