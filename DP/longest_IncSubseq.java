class Solution {
    
    //********* O(n^2) ******************
    public int lengthOfLIS(int[] nums) {
        
        int n = nums.length;
        if(n==0) return 0;
        if(n==1)return 1;
        
        int dp[] = new int[n];
        dp[0] =1;
        int length = 0;
        
        for(int i=1; i<n; i++){
            int maxLen = 0;
            for(int j=0; j<i; j++){
                if(nums[i] > nums[j] && dp[j] > maxLen){
                    maxLen = dp[j];
                }
            }
            dp[i] = maxLen + 1;
            length = Math.max(length, dp[i]);
        }
        
        return length;
    }
}