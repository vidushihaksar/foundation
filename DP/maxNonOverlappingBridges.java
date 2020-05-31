import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        NonOverlappingBridges();
    }
    
    public static class pair implements Comparable<pair>{
        int rb;
        int lb;
        
        
        
        public int compareTo(pair other){
            if(this.rb != other.rb){
                return this.rb - other.rb;
            }else{
                return this.lb - other.lb;
            }
        }
    }
    
    public static void NonOverlappingBridges(){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        pair Bridges[] = new pair[n];
        
        for(int i=0; i< n ; i++){
            pair bridge = new pair();
            bridge.rb = scn.nextInt();
            bridge.lb = scn.nextInt();
            
            Bridges[i] = bridge;
        }
        Arrays.sort(Bridges);
        int[] dp= new int[n];
        
        int maxLen = 0;
        for(int i=0; i<n; i++){
            int max = 0;
            for(int j =0; j<i; j++){
                
                if(Bridges[i].lb > Bridges[j].lb  && dp[j] > max){
                    max= dp[j];
                }
            }
            
            dp[i] = max +1;
            maxLen  = Math.max(maxLen, dp[i]);
        }
        
        System.out.println(maxLen);
        
        
        
    }

}