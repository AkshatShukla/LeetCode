import java.util.*;
import java.util.Map.Entry;

public class Test {
    public static String[] Solution(String source, String target) {
        List<String> res = new ArrayList<>();
        int i = 0;
        int idx = 0;
        int tidx = 0;
        // loop over source
        while (idx < source.length() && tidx < target.length()) {
            if (source.charAt(idx) == target.charAt(tidx)) {
                res.add("" + source.charAt(idx));
                i++;
                idx++;
                tidx++;
            } else if (source.charAt(idx) != target.charAt(tidx)) {
                // chars not same
                if ((""+target.charAt(tidx)).equals(res.get(i - 1))) {
                    res.add("+" + target.charAt(tidx));
                    tidx++;
                } else {
                    res.add("-" + source.charAt(idx));
                    idx++;
                }
            }
        }

        while (tidx < target.length()) {
            res.add("+" + target.charAt(tidx));
            tidx++;
        }
        System.out.println(res.size());
        String[] ans = new String[res.size()];
        i = 0;
        while (i < res.size()) {
            ans[i] = res.get(i);
            i++;
        }

        return ans;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(Solution("ABCDEFG", "ABDFFGH")));
        String p = "CREATE: id=14&amount=800&currency=USD";
        String s = "PAY: id=14";
        String[] com = s.split("&");
        String invoiceId = com[0].split("=")[1];
        System.out.println(Arrays.toString(com));
        System.out.println(invoiceId);
        int spaceIdx = s.indexOf(" ");
        String actionType = s.substring(0, spaceIdx - 1);
        System.out.println(actionType);
    }
}
