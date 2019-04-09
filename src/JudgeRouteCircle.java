import java.util.ArrayList;
import java.util.List;

public class JudgeRouteCircle {
    public static void main(String[] args) {
        System.out.println(judgeCircle("LLRR"));
    }
    private static boolean judgeCircle(String moves) {
        List<Character> a = new ArrayList<>();
        for (char c : moves.toCharArray())
            a.add(c);
        System.out.println(a);
        int count = 0;
        for (char c : a) {
            if ((c == 'U') || (c == 'R')){
                count++;
            }
            else {
                count--;
            }
        }
        return count == 0;
    }
}
