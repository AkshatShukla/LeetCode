import java.util.ArrayList;
import java.util.List;

public class JewelsAndStones {

    public static void main(String[] args) {
        String S = "aAAbbbb";
        List<Character> stones = new ArrayList<>();
        for(char c : S.toCharArray()) {
            stones.add(c);
        }
        String J = "aA";
        List<Character> jewels = new ArrayList<>();
        for(char c : J.toCharArray()) {
            jewels.add(c);
        }
        int count = 0;
        for (char c: stones) {
            if (jewels.contains(c)){
                count++;
            }
        }
        System.out.println(count);
    }
}
