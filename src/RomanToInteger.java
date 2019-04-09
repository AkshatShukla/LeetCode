public class RomanToInteger {
    public static void main(String[] args) {
        int res = 0;
        String s = "IV";
        if (s.isEmpty()) {
            System.out.println("No String given");
        }
        else {
            int s1, s2;
            for (int i = 0; i<s.length(); i++) {
                s1 = value(s.charAt(i));
                if (i+1<s.length()) {
                    s2 = value(s.charAt(i+1));
                    if (s1 >= s2) {
                        res = res + s1;

                    } else {
                        res = res + s2 - s1;
                        i++;
                    }
                }
                else {
                    res = res + s1;
                    i++;
                }
            }
            System.out.println(res);
        }
    }

    private static int value(char s){
        switch (s) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }

    }
}
