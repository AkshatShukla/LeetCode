public class BuyAndSellStocks {
    public static void main(String[] args) {
//        int[] prices = new int[]{7,5,1,3,6,4};
        int[] prices = new int[]{7,6,4,3,1};
        System.out.println(maxProfit(prices));
    }

    private static int maxProfit(int[] prices) {
        int min = prices[0];
        int start = 0;

        for (int i=0;i<prices.length;i++) {
            if (prices[i]<min) {
                min = prices[i];
                start = i;
            }
        }
        int max = prices[start];
        for (int i=start;i<prices.length;i++) {
            if (prices[i]>max) {
                max = prices[i];
            }
        }
        return max - min > 0 ? max - min : 0;
    }
}
