public class RemoveOuterParentheses {
    public static String removeOuterParentheses(String S) {
        /*
        Convert the given input String to a char array and start scanning.
        Maintain a sum counter (Initially 0) and for every following character in the input char array,
        When, ( check whether sum is greater than zero and if yes, add this char to your String Builder; Also, increment the sum by 1
        When, ) decrement the sum by 1 and then, check whether sum is greater than zero and if yes, add this char to your String Builder;
        Return the string from your builder.
         */
        if (S.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int countOpen = 0;

        for (char c : S.toCharArray()) {
            if (c == '(') {
                if (countOpen > 0) {
                    sb.append(c);
                }
                countOpen += 1;
            } else if (c == ')') {
                countOpen -= 1;
                if (countOpen > 0) {
                    sb.append(c);
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeOuterParentheses("(()())"));
        System.out.println(removeOuterParentheses("(()())(())(()(()))"));
    }
}
