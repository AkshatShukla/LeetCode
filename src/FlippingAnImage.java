public class FlippingAnImage {
    public static void main(String[] args) {
        int[][] A = new int[][]{{1,1,0},{1,0,1},{0,0,0}};
        for (int[] a: A) {
            for(int i=0; i<a.length/2; i++){
                int temp = a[i];
                a[i] = a[a.length -i -1];
                a[a.length -i -1] = temp;
            }
        }
        for (int[] a: A) {
            for(int i=0; i<a.length; i++){
                if (a[i] == 0) {
                    a[i] = 1;
                } else
                    a[i] = 0;
            }
        }
    }
}
