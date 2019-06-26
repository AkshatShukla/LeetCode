import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReorderLogs {
    public static String[] reorderLogFiles(String[] logs) {
        List<String> letterLogs = new ArrayList<>();
        List<String> digitLogs = new ArrayList<>();

        for (String log : logs) {
            String[] elements = log.split(" ");
            if (Character.isLetter(elements[1].charAt(0))) {
                letterLogs.add(log);
            } else {
                digitLogs.add(log);
            }
        }

        letterLogs.sort((o1, o2) -> {
            String[] s1 = o1.split(" ");
            String[] s2 = o2.split(" ");
            String id1 = s1[0];
            String id2 = s2[0];
            int len1 = s1.length;
            int len2 = s2.length;

            for (int i = 1; i < Math.min(len1, len2); i++) {
                if (!s1[i].equals(s2[i])) {
                    return s1[i].compareTo(s2[i]);
                } else if (i == Math.min(len1, len2) - 1 && s1[i].equals(s2[i])) {
                    return id1.compareTo(id2);
                }
            }
            return 0;
        });

        for (int i = 0; i < logs.length; i++) {
            if (i < letterLogs.size()) {
                logs[i] = letterLogs.get(i);
            } else {
                logs[i] = digitLogs.get(i - letterLogs.size());
            }
        }

        return logs;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(reorderLogFiles(new String[]{"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"})));
        System.out.println(Arrays.toString(reorderLogFiles(new String[]{"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo","a2 act car"})));
    }
}
