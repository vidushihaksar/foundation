import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[]step = new int[n];
        for(int i=0; i<n;i++){
            step[i] = scn.nextInt();
        }
        int[]dp = new int[n];
       // System.out.println(climbsWithJumps(0,step,dp));
        System.out.println(climbsWithJumps(n,step));

        
    }
//--------- MEMOIZATION -----------------
    // public static int climbsWithJumps(int n, int[]steps, int[]dp)
    // {
    //   if(n==steps.length-1 ){
    //       return 1;
    //   }
    //   int totalWays=0;

    //   if(dp[n]!=0){
    //       return dp[n];
    //     }
    
        
    //         int steptotal = steps[n];
                
    //         for(int step = 1; step <= steptotal; step++){
    //             if(n + step <=steps.length-1){
    //               totalWays += climbsWithJumps(n + step, steps,dp);
    //             }
                
    //         }
            
    //     dp[n] = totalWays;
    //     return dp[n];
    // }



//------------ TABULATION ------------------
    public static int climbsWithJumps(int n, int[] steps){
        int[]tabulation = new int[n];
        
        //answer simplest que
        tabulation[n-1] =1;
        
        for(int i = n -2; i>=0; i--){
            
            int step = steps[i];

            for(int jump =1; jump <= step; jump++){
                
                if(i + jump <= n - 1){
                    tabulation[i] += tabulation[ i+ jump];
                 }
            }
            
        }
        
       
        return tabulation[0];
    }
}