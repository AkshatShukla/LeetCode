public class LicenseKeyFormatting {
    public static String licenseKeyFormatting(String S, int K) {
        StringBuilder sb = new StringBuilder();
        int dashes = 0;
        for (int i = S.length()-1; i >= 0; i--) {
            char c = S.charAt(i);
            if (c == '-') {
                continue;
            }
            sb.append(Character.toUpperCase(c));
            if ((sb.length() - dashes) % K == 0) {
                sb.append('-');
                dashes++;
            }
        }
        if (sb.length() > 0 && sb.charAt(sb.length()-1) == '-')
            sb.deleteCharAt(sb.length()-1);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(licenseKeyFormatting("5F3Z-2e-9-w", 4));
        System.out.println(licenseKeyFormatting("2-5g-3-J", 2));
    }
}
