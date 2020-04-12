import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    long ans = arrange(n);
    System.out.println(ans);
 }
 public static long arrange(int n){
     long[][]dp = new long[2][n+1];
     
     dp[0][1] = 1;
     dp[1][1] = 1;
     
     for(int j = 2; j<=n ; j++){
         dp[0][j] = dp[0][j-1] + dp[1][j-1];
         dp[1][j] = dp[0][j-1];
     }
     long road1_Config = dp[0][n] + dp[1][n];
     long road2_Config = road1_Config;
     
        
     return road1_Config*road2_Config;
 }

}