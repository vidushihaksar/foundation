// class Solution {
//     public int maxProfit(int[] prices, int fee) {
        
//         int[][] dp = new int[2][prices.length];
//         dp[0][0]  = -prices[0];
//         dp[1][0]  = 0;
        
//         for(int i=1; i<prices.length; i++){
            
//             //buy Profit
//             dp[0][i] = Math.max(dp[0][i-1], dp[1][i-1] - prices[i]);
            
//             //sell profit
//             dp[1][i] = Math.max(dp[1][i-1], dp[0][i-1] + prices[i] -fee );
//         }
        
//         return dp[1][prices.length-1];
//     }
// }

// class Solution {
//     public int maxProfit(int[] prices, int fee) {
        
//         int[][] dp = new int[2][prices.length];
//         dp[0][0]  = -prices[0];
//         dp[1][0]  = 0;
        
//         for(int i=1; i<prices.length; i++){
            
//             //buy Profit
//             dp[0][i] = Math.max(dp[0][i-1], dp[1][i-1] - prices[i]);
            
//             //sell profit
//             dp[1][i] = Math.max(dp[1][i-1], dp[0][i-1] + prices[i] -fee );
//         }
        
//         return dp[1][prices.length-1];
//     }
// }

class Solution {
    public int maxProfit(int[] prices, int fee) {
        
       
         int buyP = -prices[0];
         int sellP  = 0;
        
        for(int i=1; i<prices.length; i++){
            
            //buy Profit
            int newbuyP = Math.max(buyP, sellP - prices[i]);
            
            //sell profit
            int newSellP = Math.max(sellP, buyP + prices[i] -fee );
            
            buyP = newbuyP;
            sellP = newSellP;
        }
        
        return sellP;
    }
}