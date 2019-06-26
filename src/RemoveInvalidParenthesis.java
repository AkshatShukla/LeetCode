import java.util.*;

public class RemoveInvalidParenthesis {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) {
                continue;
            } else if (c == '(') {
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

    public static List<String> removeInvalidParentheses(String s) {
        Set<String> res = new HashSet<>();

        for (int i = 0; i < s.length() - 1; i++) {
            if (!Character.isLetter(s.charAt(i))) {
                String temp = s.substring(0,i) + s.substring(i+1);
                if (isValid(temp)) {
                    res.add(temp);
                }
            }
        }

        return new ArrayList<>(res);
    }

    public static void main(String[] args) {
//        System.out.println(removeInvalidParentheses("()())()"));
        System.out.println(removeInvalidParentheses("(a)())()"));
        System.out.println(isValid(")("));
    }
}
