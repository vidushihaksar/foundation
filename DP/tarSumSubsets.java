import java.io.*;
import java.util.*;

public class tarSumSubsets {

    public static void main(String[] args) throws Exception {
        Scanner scn =new Scanner(System.in);
        int n=  scn.nextInt();
        int[]coins = new int[n];
        
        for(int i=0; i<n; i++){
            coins[i] = scn.nextInt();
            
        }
        int tar = scn.nextInt();
        
        boolean res = tar(coins,tar);
        System.out.println(res);
        
    }
    
    public static boolean tar(int[] coins, int tar){
        boolean[][] dp = new boolean[coins.length +1][tar + 1];
        
        
        for(int row =0; row < coins.length+1; row++){
            for(int col =0; col < tar+1; col++){
                
                if(col == 0){
                    dp[row][col] = true;
                }
                else if(row ==0 && col!=0){
                    dp[row][col] = false;
                }
                else{
                    
                //if(row-1 >=0){
                    int coin = coins[row-1];
                    boolean exc = dp[row -1][col];
                    boolean inc = false;
                    if(coin <= col){
                        inc = dp[row -1][col - coin] ;
                    }
                    dp[row][col] = inc || exc ;
               // }
                    
                }
            }
            if(dp[row][tar]==true){
                return true;
            }
        }
        
        return dp[coins.length][tar];
    }
}