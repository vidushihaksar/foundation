import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    System.out.println(countStrings(n));
 }
 
 public static int countStrings(int n){
     int[][]dp = new int[2][n+1];
     
     dp[0][1]=1;
     dp[1][1]=1;
     
 
         for(int j=2; j<=n; j++){
             dp[0][j] = dp[1][j-1];
             dp[1][j] = dp[0][j-1] + dp[1][j-1];
         }
         
        //  for(int i=0; i<2; i++){
        //      for(int j=0; j<=n; j++){
        //          System.out.print(dp[i][j]+" ");
        //      }
        //      System.out.println();
        //  }
     return dp[0][n] + dp[1][n];
     
 }

}