import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[]steps = new int[n];
        for(int i=0; i<n;i++){
            steps[i] = scn.nextInt();
        }
        
        int[]dp = new int[n];
       // System.out.println(climbsWithMinMoves(0,step,dp));
      int  v=climbsWithMinMoves(n,steps);
        System.out.println(v);

    }

// ------------ MEMOIZATION -----------------------------

    // public static int climbsWithMinMoves(int n, int[]steps,int[]dp){
    //   if(n==steps.length-1 ){
    //       return 0;
    //   }
     

    //   if(dp[n]!=0){
    //       return dp[n];
    //     }
    
    //         int minMoves = Integer.MAX_VALUE;
    //         int steptotal = steps[n];
            
    //         if(steptotal == 0){
    //             return Integer.MAX_VALUE;
    //         }
                
    //         for(int step = 1; step <= steptotal; step++){
                
    //             if(n + step <= steps.length-1){
    //               minMoves = Math.min(minMoves, climbsWithMinMoves(n + step, steps,dp));
    //             }
                
    //         }
            
    //     dp[n] = minMoves +1;
    //     return dp[n] ;
    // }
    

// -------------- TABULATION --------------------------------

    public static int climbsWithMinMoves(int n, int[]steps){
        int[] tabulation = new int[n];
        
        tabulation[n-1] = 0;
        
        for(int i = n-2; i>=0; i--){
            int step = steps[i];
            int min= Integer.MAX_VALUE;
            
            if( step ==0){
                tabulation[i]= Integer.MAX_VALUE;
            }
            else{
                for(int move =1; move <= step && i + move <= n-1; move++){
                    min = Math.min(min, tabulation[i + move]);
                }
            
                tabulation[i]=min + 1;
            }
        }
        
        // for(int i =0; i<n; i++){
        //     System.out.print(tabulation[i]+" ");
        // }
        return tabulation[0];
    }

}