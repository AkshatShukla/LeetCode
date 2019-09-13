import java.util.Arrays;

public class CompareStrings {
    public static int[] compareStrings(String A, String B) {
        String[] a = A.split(",");
        String[] b = B.split(",");
        int[] result = new int[b.length];
        int idx = 0;
        for (String Bstr : b) {
            int count = 0;
            for (String Astr : a) {
                if (compare(Astr, Bstr)) {

                }
            }
            result[idx++] = count;
        }

        return result;
    }

    public static boolean compare(String Astr, String Bstr) {
        return false;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(compareStrings("abcd aabc bd", "aaa aa"))); // [3,2]
    }
}
