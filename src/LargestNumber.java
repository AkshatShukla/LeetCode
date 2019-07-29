import java.util.Arrays;

public class LargestNumber {
    public static String largestNumber(int[] nums) {
        String[] strArray = new String[nums.length];
        for (int i = 0; i < strArray.length; i++) {
            strArray[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(strArray, (o1, o2) -> {
            String order1 = o1 + o2;
            String order2 = o2 + o1;
            return order1.compareTo(order2);
        });

        System.out.println(Arrays.toString(strArray));
        if (strArray[0].equals("0")) {
            return "0";
        }

        // Build largest number from sorted array
        StringBuilder result = new StringBuilder();
        for (String str : strArray) result.append(str);

        return result.toString();
    }


    public static void main(String[] args) {
        int[] ints = new int[]{10, 2};

        System.out.println(largestNumber(ints));
    }
}
