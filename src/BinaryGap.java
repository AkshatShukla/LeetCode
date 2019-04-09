
public class BinaryGap {
    public static void main(String[] args) {
        int N = 5;
        int j = 0;
        int binaryGap = 0;
        if (Integer.bitCount(N) > 1) {
            String res = Integer.toBinaryString(N);
            System.out.println(res);
            for (int i=0;i<res.length();i++) {
                if (res.charAt(i) == '0') {
                    j += 1;
                }
                if (res.charAt(i) == '1') {
                    if (j >= binaryGap) {
                        binaryGap = j+1;
                    }
                    j = 0;
                }
            }
            System.out.println(binaryGap);

        } else {
            System.out.println(0);
        }
    }
}
