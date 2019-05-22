public class CompareVersionNumbers {
    public static int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        int n = Math.max(v1.length, v2.length);
        for (int i = 0; i < n; i++) {
            Integer x = i < v1.length ? Integer.parseInt(v1[i]) : 0;
            Integer y = i < v2.length ? Integer.parseInt(v2[i]) : 0;
            int compare = x.compareTo(y);
            if (compare != 0) {
                return compare;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(compareVersion("01", "1"));
    }
}
