import java.util.HashSet;

public class InternationalMorseCode {
    public static void main(String[] args) {
        String[] words = {"gin", "zen", "gig", "msg"};
        String[] morse = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        HashSet<String> hashMap = new HashSet<>();
        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (char c : word.toCharArray()) {
                sb.append(morse[c-'a']);
            }
            hashMap.add(sb.toString());
        }
        System.out.println(hashMap.size());
    }
}
