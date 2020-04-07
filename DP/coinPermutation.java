import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
         Scanner scn =new Scanner(System.in);
        int n= scn.nextInt();
        int[]coins = new int[n];
        for(int i=0; i<n; i++){
            coins[i] = scn.nextInt();
        }
        int tar = scn.nextInt();
        int ans = coin_permutation(coins, tar);
        System.out.println(ans);
    }
    public static int coin_permutation(int[]coins, int tar){
        
        int[]dp = new int[tar + 1];
        
         for(int i=0; i<dp.length ; i++){
            for(int idx =0; idx<coins.length; idx++){
        
                if(i==0){
                  dp[i]=1;
                }
            
                if(i - coins[idx] >=0){
                  dp[i] += dp[i-coins[idx]]; 
                 }
            }
            
        }
        return dp[tar];
    }
}