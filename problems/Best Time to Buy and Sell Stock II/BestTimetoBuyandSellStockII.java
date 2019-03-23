class Solution {
    public int maxProfit(int[] prices) {
        int totalProfit = 0;
        int minIndex = -1;
        int maxIndex = -1;
        for(int i=0; i<prices.length; i++){
            if(minIndex == -1){
                minIndex = i;
                continue;
            }
            if(minIndex != -1){
                if(maxIndex == -1 && prices[i] > prices[minIndex]){
                    maxIndex = i;
                    continue;  
                } else if(prices[i] <= prices[minIndex]){
                    if(maxIndex > -1){
                        int tempProfit = prices[maxIndex] - prices[minIndex];    
                        totalProfit += tempProfit;   
                    }
                            minIndex = i;
                            maxIndex = -1;
                            continue;    
                }
            }
            if(prices[i] >= prices[maxIndex]){
                maxIndex = i;
                continue;
            }
            else {
                int tempProfit = prices[maxIndex] - prices[minIndex];    
                totalProfit += tempProfit;
                minIndex = i;
                maxIndex = -1;
            }   
        }
        if(maxIndex > -1)
            totalProfit += prices[maxIndex] - prices[minIndex];
        return totalProfit;
    }
}
