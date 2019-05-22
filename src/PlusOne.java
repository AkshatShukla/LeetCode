import java.util.Arrays;

public class PlusOne {
    public static void main(String[] args) {
        int[] digits = new int[]{9, 9, 9, 9};
        int[] digits2 = new int[]{1,2,9};
//        System.out.println(Arrays.toString(plusOne(digits)));
        System.out.println(Arrays.toString(plusOne2(digits)));
        System.out.println(Arrays.toString(plusOne2(digits2)));
//        System.out.println(Arrays.toString(digits));
    }

    private static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {

            if (digits[i] < 9) {
                //digits[length-1] = 0;
                digits[i]++;
                //System.out.println(digits[i]);
                return digits;
            }
            digits[i] = 0;
        }

        int[] newArray = new int[digits.length + 1];
        newArray[0] = 1;
        return newArray;
    }

    public static int[] plusOne2(int[] digits) {
        int[] result = new int[digits.length];
        int carry = 1;

        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = digits[i] + carry;

            if (sum != 10) {
                carry = 0;
                result[i] = sum % 10;
            } else {
                result[i] = 0;
            }
        }
        if (carry == 1) {
            int[] res =  Arrays.copyOf(result, result.length + 1);
            res[0] = 1;
            return res;
        }
        return result;
    }
}
