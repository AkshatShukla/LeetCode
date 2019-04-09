import java.util.LinkedHashMap;

public class FirstUniqueCharacter {
    public static void main(String[] args) {
        String s = "loveleetcode";
        System.out.println(firstUniqChar(s));
    }

    private static int firstUniqChar(String s) {
        LinkedHashMap<Character, Integer> linkedHashMap = new LinkedHashMap<>();
        int count;
        for (char c : s.toCharArray()) {
            if (linkedHashMap.containsKey(c)) {
                count = linkedHashMap.get(c);
                linkedHashMap.put(c, count + 1);
            } else
                linkedHashMap.put(c, 1);
        }
        for (char c : linkedHashMap.keySet()) {
            if (linkedHashMap.get(c) == 1)
                return s.indexOf(c);
        }
        return -1;
    }
}

// Also can use s.lastIndexOf to get the last occurrence of the character in the string
/*
        char[] str = s.toCharArray();
        for(int i = 0; i<s.length(); i++){
            if(s.indexOf(str[i]) == s.lastIndexOf(str[i])){
                return i;
            }
        }

        return -1;
 */
