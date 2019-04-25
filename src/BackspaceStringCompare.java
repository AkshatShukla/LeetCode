public class BackspaceStringCompare {
    public static boolean backspaceCompare(String S, String T) {
        StringBuilder sb = new StringBuilder();
        StringBuilder tb = new StringBuilder();

        for (int i=0; i<S.length(); i++) {
            if (S.charAt(i) != '#') {
                sb.append(S.charAt(i));
            } else if (sb.length() != 0) {
                sb.deleteCharAt(sb.length()-1);
            }
        }

        for (int i=0; i<T.length(); i++) {
            if (T.charAt(i) != '#') {
                tb.append(T.charAt(i));
            } else if (tb.length() != 0) {
                tb.deleteCharAt(tb.length()-1);
            }
        }

        return sb.toString().equals(tb.toString());
    }

    public static void main(String[] args) {
        System.out.println(backspaceCompare("#ab#c", "ad#c"));
    }
}
