import java.io.*;
import java.util.*;

public class Main {

   public static void main(String[] args) throws Exception {
     Scanner scn = new Scanner(System.in);
     int n= scn.nextInt();
     int k = scn.nextInt();
     //System.out.println(subsets(n, k));
     System.out.println(kPart(n, k));

   }
   public static long subsets(int n, int k){
     long[][] dp = new long[n + 1][k + 1];


      if (n == 0 || k == 0 || n < k) {
          dp[n][k] =0;
         
      }

      for (int i = 1; i <= n; i++) {
         for (int j = 1; j <= k; j++) {
            if ( j == 1 || i == j) {
               dp[i][j] = 1;
            } else {
               dp[i][j] = dp[i - 1][j - 1] + j * dp[i-1][j];
            }
         }
      }
    //   for(int i=0; i<=n; i++){
    //       for(int j=0; j<=k; j++){
    //           System.out.print(dp[i][j]+" ");
    //       }
    //       System.out.println();
    //   }

      return dp[n][k];
   }
   
   
   
   //---------sir ka method------------------
   public static long kPart(int n, int k){
       long dp[][] = new long[k+1][n+1];
       
       for(int i=1; i<=k; i++){
           for(int j=i;j<=n; j++){
               if(i==1 || j==1 || i==j){
                   dp[i][j] =1;
               }else{
                   dp[i][j] = dp[i-1][j-1] + i*dp[i][j-1];
               }
           }
       }
       
       return dp[k][n];
   }

}