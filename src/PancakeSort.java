import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PancakeSort {
    /*
    Keep an end pointer (starting from last position to 0-th index) for holding the current max after each iteration
    until the pointer reaches 0.

    There are basically 3 steps in each iteration:

        Find the current max within [0, curEndIndex].
        Do a flip (from 0 to curMaxIndex) to put it to the front.
        Flip again to put it to endIndex. endIndex--.
     */
    public static List<Integer> pancakeSort(int[] A) {
        List<Integer> flips = new ArrayList<>();

        if (A == null || A.length < 2) {
            return flips;
        }
        int currentEndIndex = A.length - 1;

        while (currentEndIndex > 0) {
            int currentMaxIndex = getCurMaxIndex(A, currentEndIndex);
            if (currentMaxIndex != currentEndIndex) {
                flip(A, 0, currentMaxIndex);
                flips.add(currentMaxIndex + 1);
                flip(A, 0, currentEndIndex);
                flips.add(currentEndIndex + 1);
            }
            currentEndIndex--;
        }
        System.out.println(Arrays.toString(A));
        return flips;
    }

    private static int getCurMaxIndex(int[] A, int endIndex) {
        int max = A[0];
        int maxIndex = 0;
        for (int i = 1; i <= endIndex; i++) {
            if (A[i] > max) {
                max = A[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    private static void flip(int[] arr, int low, int high) {
        while (low < high) {
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            low++;
            high--;
        }
    }

    public static void main(String[] args) {
        System.out.println(pancakeSort(new int[]{3, 2, 4, 1}));
    }
}
