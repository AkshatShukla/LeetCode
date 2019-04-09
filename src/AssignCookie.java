import java.util.Arrays;

public class AssignCookie {
    public static void main(String[] args) {
        int[] greediness = new int[]{1,2,3};
        int[] sizes = new int[]{1,1};
        System.out.println(findContentChildren(greediness,sizes));
    }

    //Just assign the cookies starting from the child with less greediness to maximize the number of happy children .
    private static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0;
        for(int j=0;i<g.length && j<s.length;j++) {
            if(g[i]<=s[j]) i++;
        }
        return i;
    }
}
