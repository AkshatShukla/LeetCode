public class ReverseBits {
    public static void main(String[] args) {
        int n = 43261596;
        System.out.println(reverseBits(n));
    }

    private static int reverseBits(int n) {
        String s = Integer.toBinaryString(n);
        StringBuilder stringBuilder = new StringBuilder();
        if (s.length()<32){
            for(int i =s.length();i<32;i++){
                s='0'+s;
            }
        }
//        System.out.println(s);
        char[] chars = s.toCharArray();
        for (int i=0;i<s.toCharArray().length;i++) {
            stringBuilder.append(chars[i]);
        }
        stringBuilder.reverse();
//        System.out.println(stringBuilder);
        return (int) Long.parseLong(stringBuilder.toString(),2);
    }
}
