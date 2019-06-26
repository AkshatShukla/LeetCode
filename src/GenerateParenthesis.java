import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GenerateParenthesis {
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack("", 0, 0, n, result);
        return result;
    }

    private static void backtrack(String current, int openCount, int closeCount, int n, List<String> result) {
        if (current.length() == n * 2 && isValid(current)) {
            result.add(current);
            return;
        }

        if (openCount < n) {
            backtrack(current+"(", openCount + 1, closeCount, n, result);
        }
        if (closeCount < n) {
            backtrack(current+")", openCount, closeCount + 1, n, result);
        }
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
}
