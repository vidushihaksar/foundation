class Solution {
    public int maxProfit(int k, int[] prices) {
        
        int n = prices.length;
        if(n < 2 )return 0;
        
        if (k > n / 2) {          //**** infinite transations ******
            int res = 0;
            for (int i = 1; i < prices.length; i++) {
                res += Math.max(0, prices[i] - prices[i - 1]);
            }
            return res;
        }
        
        
        int dp[][] = new int[k+1][prices.length];
        
        for(int i = 1; i<=k; i++ ){
           for(int j = 1; j<n; j++){
       
               int Max = Integer.MIN_VALUE;
              for(int x =0; x< j; x++){
                  Max = Math.max(prices[j] - prices[x] + dp[i-1][x], Max);
              }
               
               dp[i][j] = Math.max(Max, dp[i][j-1]);
                
            }
        }
        
        return dp[k][n-1];
    }
}
 