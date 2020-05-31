class Solution {
    
    public class pair implements Comparable<pair>{
        int width;
        int height;
        
    public int compareTo(pair other){
        if(this.width !=  other.width){
            return this.width - other.width;
        }else{
            return other.height - this.height;  // (4,5)(4,6) same starting point also means overlapping
                                                //if in que same StartPt not considered as overlapping, than u can do this.height- other.height
        }
     }
    }
    public int maxEnvelopes(int[][] envelopes) {
        pair[] envlps = new pair[envelopes.length];
        
        for(int i=0; i<envelopes.length; i++){
          pair obj = new pair();
          obj.width = envelopes[i][0];
          obj.height = envelopes[i][1];
            
            envlps[i] = obj;
        }
        
        Arrays.sort(envlps);
        int[]dp = new int[envelopes.length];
        
        int maxLen = 0;
        for(int i=0; i<envelopes.length; i++){
            int max = 0;
            for(int j =0; j<i; j++){
                
                if(envlps[i].height > envlps[j].height  && dp[j] > max){
                    max= dp[j];
                }
            }
            
            dp[i] = max +1;
            maxLen  = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }
}