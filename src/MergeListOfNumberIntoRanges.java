import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeListOfNumberIntoRanges {
    public static List<String> mergeIntoRanges(List<Integer> nums) {
        List<String> result = new ArrayList<>();

        // [0, 1, 2, 5, 7, 8, 9, 9, 10, 11, 15]
        //  ^
        int start = 0;
        int anchor = start;
        while (start < nums.size() - 1) {
            if (nums.get(start) + 1 < nums.get(start + 1)) {
                String temp = nums.get(anchor) + "->" + nums.get(start);
                result.add(temp);
                anchor = start + 1;
            }
            start++;
        }
        String temp = nums.get(anchor) + "->" + nums.get(start);
        result.add(temp);

        return result;
    }

    public static void main(String[] args) {
        System.out.println(mergeIntoRanges(new ArrayList<>(Arrays.asList(0, 1, 2, 5, 7, 7, 7, 8, 9, 9, 9, 9, 10, 11, 15))));
    }
}
