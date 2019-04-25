public class RepeatedStringMatch {
    public static int repeatedStringMatch(String A, String B) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        while (sb.length() < B.length()) {
            sb.append(A);
            count++;
        }
        if (sb.toString().contains(B)) {
            return count;
        }
        if (sb.append(A).toString().contains(B)) {
            return count+1;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(repeatedStringMatch("abcd", "cdabcdab")); // 3
    }
}
