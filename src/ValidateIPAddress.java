import java.util.Arrays;

public class ValidateIPAddress {
    public static String validIPAddress(String IP) {
        if (validIPv4(IP)) return "IPv4";
        else if (validIPv6(IP)) return "IPv6";
        else return "Neither";
    }

    private static boolean validIPv4(String s) {
        if (s.length() < 7) return false;
        if (s.charAt(0) == '.') return false;
        if (s.charAt(s.length() - 1) == '.') return false;
        String[] parts = s.split("\\.");
        if (parts.length != 4) return false;
        for (String part : parts) {
            if (!isValidIPv4Token(part)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isValidIPv4Token(String token) {
        if (token.startsWith("0") && token.length() > 1) return false;
        try {
            int parsedInt = Integer.parseInt(token);
            if (parsedInt < 0 || parsedInt > 255) return false;
            if (parsedInt == 0 && token.charAt(0) != '0') return false;
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static boolean validIPv6(String s) {
        if (s.length() < 15) return false;
        if (s.charAt(0) == ':') return false;
        if (s.charAt(s.length() - 1) == ':') return false;
        String[] parts = s.split(":");
        if (parts.length != 8) return false;
        for (String part : parts) {
            if (!isValidIPv6Token(part)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isValidIPv6Token(String token) {
        if (token.length() > 4 || token.length() == 0) return false;
        char[] chars = token.toCharArray();
        for (char c : chars) {
            boolean isDigit = c >= 48 && c <= 57;
            boolean isUppercaseAF = c >= 65 && c <= 70;
            boolean isLowerCaseAF = c >= 97 && c <= 102;
            if (!(isDigit || isUppercaseAF || isLowerCaseAF))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(validIPAddress("172.16.254.1"));
        System.out.println(validIPAddress("256.256.256.256"));
        System.out.println(validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334"));
        System.out.println(validIPAddress("02001:0db8:85a3:0000:0000:8a2e:0370:7334"));
    }
}
