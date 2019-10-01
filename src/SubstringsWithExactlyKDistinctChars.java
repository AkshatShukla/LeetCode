import java.util.HashMap;
import java.util.Map;

public class SubstringsWithExactlyKDistinctChars {
    public static int substringWithKDistinctChars(String s, int K) {
        char[] A = s.toCharArray();
        int left = 0, right = 0;
        Map<Character, Integer> numCount = new HashMap<>();
//        int[] freqCount = new int[26];
        int distinct = 0;
        int result = 0;
        int prefix = 0;
        while (right < A.length) {
            if (numCount.containsKey(A[right]) && numCount.get(A[right]) != 0) {
                numCount.put(A[right], numCount.get(A[right]) + 1);
            } else {
                distinct++;
                numCount.put(A[right], 1);
            }
            //increment left pointer
            if (distinct > K) {
                numCount.put(A[left], numCount.get(A[left]) - 1);
                prefix = 0; // resetting the prefix since previous elements can not be used in next subset to keep k distinct elements
                distinct--;
                left++;
            }
            while (numCount.get(A[left]) > 1) {
                numCount.put(A[left], numCount.get(A[left]) - 1);
                left++;
                prefix++;
            }
            if (distinct == K)
                result += 1 + prefix;

            right++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(substringWithKDistinctChars("pqpqs", 2));
        System.out.println(substringWithKDistinctChars("aabab", 3));
    }
}
