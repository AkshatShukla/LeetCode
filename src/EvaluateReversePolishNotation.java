import java.util.Stack;

public class EvaluateReversePolishNotation {
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String s : tokens) {
            if (!s.isEmpty() && ("+-*/").contains(s)) {
                int x = stack.pop();
                int y = stack.pop();
                switch (s) {
                    case "+":
                        stack.push(y + x);
                        break;
                    case "-":
                        stack.push(y - x);
                        break;
                    case "*":
                        stack.push(y * x);
                        break;
                    case "/":
                        stack.push(y / x);
                        break;
                    default:
                        break;
                }
            } else {
                stack.push(Integer.valueOf(s));
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        String[] input = new String[]{"2", "1", "+", "3", "*"};
        String[] input1 = new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        String[] input2 = new String[]{"4", "13", "5", "/", "+"};
        System.out.println(evalRPN(input)); // ((2 + 1) * 3) = 9
        System.out.println(evalRPN(input1)); // ((10 * (6 / ((9 + 3) * -11))) + 17) + 5 = 22
        System.out.println(evalRPN(input2)); // (4 + (13 / 5)) = 6
    }
}
