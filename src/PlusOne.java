import java.util.Arrays;

public class PlusOne {
    public static void main(String[] args) {
        int[] digits = new int[]{9,9,9,9};
        System.out.println(Arrays.toString(plusOne(digits)));
//        System.out.println(Arrays.toString(digits));
    }

    private static int[] plusOne(int[] digits) {
        for (int i=digits.length-1;i>=0;i--) {

            if (digits[i]<9) {
                //digits[length-1] = 0;
                digits[i]++;
                //System.out.println(digits[i]);
                return digits;
            }
            digits[i] = 0;
        }

        int[] newArray = new int[digits.length+1];
        newArray[0] = 1;
        return newArray;
    }
}
