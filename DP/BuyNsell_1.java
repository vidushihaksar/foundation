class Solution {
    public int maxProfit(int[] prices) {
        
        int maxProfit = 0;
        int minEle = Integer.MAX_VALUE;


        for(int i=0; i<prices.length; i++){
            if(prices[i] < minEle){
                minEle = prices[i];
            }
            
            if(prices[i] - minEle >= maxProfit ){
                maxProfit = prices[i] - minEle;
            }
        }
        return maxProfit;
    }
}