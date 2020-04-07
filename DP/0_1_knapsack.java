import java.io.*;
import java.util.*;

public class 0_1_knapsack {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        
        for(int i=0; i<n;i++){
            values[i] = scn.nextInt();
        }
        
        
        for(int i=0; i<n;i++){
            weights[i] = scn.nextInt();
        }
        int capacity = scn.nextInt();
        
        System.out.println(knapsack(n, values, weights, capacity));
    
        
    }
    public static int knapsack(int n, int[] values, int[] wt, int cap ){
        int[][]dp = new int[n+1][cap+1];
        
        for(int i=0; i<dp.length; i++){
           
            for(int j=0; j<dp[0].length; j++){
                
                if(i==0 || j==0){
                    dp[i][j] = 0;
                }
                else{
                    
                    if(j - wt[i-1] >=0){
                        dp[i][j] = Math.max(dp[i-1][j - wt[i-1]] + values[i-1], dp[i-1][j]);
                    }
                    else{
                        dp[i][j] =  dp[i-1][j];
                    }
                }
                
            }
           
        }
        
        // for(int i=0; i<dp.length; i++){
           
        //     for(int j=0; j<dp[0].length; j++){
        //         System.out.print(dp[i][j]+"	");
        //     }
        //     System.out.println();
        // }
        return dp[n][cap];
        
    }
}