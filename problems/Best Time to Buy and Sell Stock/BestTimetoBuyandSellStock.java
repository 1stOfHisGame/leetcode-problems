class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        if(prices.length <= 1)
            return profit;
        int[] maxArray = new int[prices.length-1];
        for(int i=prices.length-1; i>0; i--){
            maxArray[i-1] = Math.max(prices[i], i<prices.length-1 ? maxArray[i] : 0);
        }
        for(int i=0; i<prices.length-1; i++){
            int tempProfit = maxArray[i] - prices[i];
            if(tempProfit > profit)
                profit = tempProfit;
        }
        return profit;
    }
}
