class Solution {
    public int maxProfit(int[] prices) {
        int beforeBuy = 0;
        int prevBeforeBuy = 0;
        int beforeSell = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            beforeSell = Math.max(beforeSell, prevBeforeBuy - prices[i]);
            prevBeforeBuy = beforeBuy;
            beforeBuy = Math.max(beforeBuy, beforeSell + prices[i]);
            
        }
        return beforeBuy;
    }
}
