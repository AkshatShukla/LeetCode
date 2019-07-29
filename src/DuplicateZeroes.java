import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DuplicateZeroes {
    public static void duplicateZeros(int[] arr) {
        // [1,0,2,3,0,4,5,0]
        //                ^
        // [1,0,2,3,0,4,5,0]
        //          ^
        //
        List<Integer> list = new ArrayList<>();

        int n = arr.length;

        for (int i = 0 ; i < n; i++) {
            list.add(arr[i]);
            if (arr[i] == 0 && i != n - 1) {
                list.add(arr[i]);
            }

        }

        System.out.println(list);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
    }

    public static void main(String[] args) {
        int[] ints = new int[]{1,0,2,3,0,4,5,0};
        duplicateZeros(ints);
        System.out.println(Arrays.toString(ints));
    }
}
