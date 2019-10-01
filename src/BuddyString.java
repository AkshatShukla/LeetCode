import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BuddyString {
    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length()) return false;
        boolean Arepeat = false;
        boolean Brepeat = false;
        Set<Character> setA = new HashSet<>();
        Set<Character> setB = new HashSet<>();
        List<Integer> pos = new ArrayList<>();
        for (int i = 0; i < A.length(); i++) {
            char a = A.charAt(i);
            char b = B.charAt(i);

            if (setA.contains(a)) Arepeat = true;
            if (setB.contains(b)) Brepeat = true;

            if (a != b) {
                pos.add(i);
            }
            setA.add(a);
            setB.add(b);
        }

        if (pos.size() == 2) {
            if (A.charAt(pos.get(0)) == B.charAt(pos.get(1)) &&
                    A.charAt(pos.get(1)) == B.charAt(pos.get(0))
            ) {
                return true;
            }
        }

        if (A.equals(B) && Arepeat && Brepeat) {
            return true;
        }
        return false;
    }
}
