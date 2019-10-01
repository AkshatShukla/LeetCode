import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Dota2Senate {
    public static String predictPartyVictory(String senate) {
        if (senate == null || senate.isEmpty())
            return "Dire";

        Stack<Character> stack = new Stack<>();
        List<Character> senators = new ArrayList<>();

        for (char c : senate.toCharArray())
            senators.add(c);

        while (senators.size() > 0) {
            List<Character> senatorsLeft = new ArrayList<>();
            for (char senator : senators) {
                if (stack.size() == 0 || stack.peek() == senator)
                    stack.push(senator);
                else
                    senatorsLeft.add(stack.pop());
            }
            senators = senatorsLeft;
        }

        if (stack.peek() == 'R')
            return "Radiant";
        else
            return "Dire";
    }

    public static void main(String[] args) {
        System.out.println(predictPartyVictory(""));
        System.out.println(predictPartyVictory("RD"));
        System.out.println(predictPartyVictory("RDD"));
        System.out.println(predictPartyVictory("RDRRDR"));
        System.out.println(predictPartyVictory("DR"));
    }
}
