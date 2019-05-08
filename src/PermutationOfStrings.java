import java.util.ArrayList;
import java.util.List;

public class PermutationOfStrings {
    public static List<String> permutations(String s) {
        List<String> results = new ArrayList<>();
        permutations("", s, results);
        return results;
    }

    public static void permutations(String prefix, String suffix, List<String> results) {
        if (suffix.length() == 0) {
            results.add(prefix);
        } else {
            for (int i = 0; i < suffix.length(); i++) {
                permutations(prefix + suffix.charAt(i), suffix.substring(0, i) + suffix.substring(i+1), results);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(permutations("abc"));
    }
}
