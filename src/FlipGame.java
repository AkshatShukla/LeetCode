import java.util.ArrayList;
import java.util.List;

public class FlipGame {
    public static List<String> generatePossibleNextMoves(String s) {
        List<String> possibleStates = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            int nextMove = i == 0 ? s.indexOf("++") : s.indexOf("++", i);
            if (nextMove == -1) {
                // no other consecutive + signs
                return possibleStates;
            }
            String nextState = s.substring(0, nextMove) + "--" + s.substring(nextMove + 2);
            possibleStates.add(nextState);
            i = nextMove + 1;
        }
        return possibleStates;
    }

    public static void main(String[] args) {
        System.out.println(generatePossibleNextMoves("++++"));
    }
}
