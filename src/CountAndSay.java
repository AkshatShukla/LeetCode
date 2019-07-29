public class CountAndSay {
    public static String countAndSay(int n) {
        String res = "1";
        for (int i = 2; i <= n; i++) {
            StringBuilder temp = new StringBuilder();
            char prev = res.charAt(0);
            int counter = 1;
            for (int j = 1; j < res.length(); j++) {
                char curr = res.charAt(j);
                if (prev != curr) {
                    temp.append(counter);
                    temp.append(prev);
                    counter = 1;
                    prev = curr;
                } else {
                    counter++;
                }
            }
            temp.append(counter);
            temp.append(prev);
            res = temp.toString();
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(1));
        System.out.println(countAndSay(2));
        System.out.println(countAndSay(3));
        System.out.println(countAndSay(4));
        System.out.println(countAndSay(5));
        System.out.println(countAndSay(6));
    }
}
