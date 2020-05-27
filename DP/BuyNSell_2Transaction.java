class Solution {
    public int maxProfit(int[] prices) {
        
        int n = prices.length;
        if(n==0)return 0;
        
        int first[] = new int[n];
        
        int min = prices[0];
        first[0] =0;
        for(int i=1 ; i<n; i++){
            if(prices[i] < min){
                min = prices[i];
            }
            
            first[i] = Math.max(prices[i] - min, first[i-1]);
        }
        
        
        int second[] = new int[n];
        
        int max = prices[n - 1];
        second[n - 1] =0;
        for(int i=n-2 ; i>=0; i--){
            if(prices[i] > max){
                max = prices[i];
            }
            
            second[i] = Math.max(max - prices[i] , second[i+1]);
        }
        
        
        
        int maxProfit =0;
        for(int i=0; i< n; i++){
            maxProfit = Math.max( first[i]+second[i], maxProfit);
        }
        
        
        return maxProfit;
        
    }
}