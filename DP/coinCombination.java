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
        int ans = coin_combination(coins, tar);
        System.out.println(ans);
    }
    
    
//---------------my method --------------------------------------
    // public static int coin_combination(int[]coins, int tar){
    //     int[]dp = new int[tar + 1];
        
    //     for(int idx =0; idx<coins.length; idx++){
        
    //         for(int i=0; i<dp.length ; i++){
    //             if(i==0){
    //               dp[i]=1;
    //             }
            
    //             if(i - coins[idx] >=0){
    //               dp[i] += dp[i-coins[idx]]; 
    //              }
    //         }
            
    //     }
    //     return dp[tar];
    // }
    
//-----------sir ka method--------------------------------------
    public static int coin_combination(int[]coins, int tar){
        int[]dp = new int[tar + 1];
        
        dp[0] = 1;
        for(int idx =0; idx<coins.length; idx++){
            int coin = coins[idx];
            
            for(int i=coin; i<dp.length ; i++){
            
                   dp[i] += dp[i-coin]; 
                 
            }
            
        }
        return dp[tar];
    }
}