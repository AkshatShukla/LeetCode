public class FindSmallestLetterGreaterThanTarget {
    public static char nextGreatestLetter(char[] letters, char target) {
        int low = 0;
        int high = letters.length;

        while (low < high) {
            int mid = (low + high) / 2;
            if (letters[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return letters[low % letters.length];
    }

    public static void main(String[] args) {
        char[] chars = {'c', 'f', 'j'};
        System.out.println(nextGreatestLetter(chars, 'a')); // c
        System.out.println(nextGreatestLetter(new char[]{'a', 'b', 'y'}, 'z')); // a
    }
}
