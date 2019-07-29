public class BuyAndSellStocks {
    public static void main(String[] args) {
//        int[] prices = new int[]{7,5,1,3,6,4};
        int[] prices = new int[]{7,6,4,3,1};
        System.out.println(maxProfit(prices));
    }

    private static int maxProfit(int[] prices) {
        // look for valley (lowest point in graph), and keep updating. if at any point,
        // prices[i] - price[valley] > maxProfit so far, update maxProfit so far.
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }

        return maxProfit;
    }
}
