import java.util.HashMap;
import java.util.Scanner;

public class TwoSum {
    public static int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                result[1] = i;
                result[0] = map.get(target - numbers[i]);
                return result;
            }else {
                map.put(numbers[i], i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        int n = sc.nextInt();
        int input[] = new int[n];
        for (int i=0;i<n;i++)
            input[i] = sc.nextInt();
        int[] res = twoSum(input,target);
        for (int i = 0;i<res.length;i++)
            System.out.println(res[i]);

    }
}