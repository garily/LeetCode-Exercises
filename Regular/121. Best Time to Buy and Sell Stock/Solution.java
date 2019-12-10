class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int[] minPrices = new int[prices.length];
        minPrices[0] = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            minPrices[i] = Math.min(minPrices[i - 1], prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minPrices[i]);
        }
        return maxProfit;
    }
}
