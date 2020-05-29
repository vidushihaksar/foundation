import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
      Scanner scn =new Scanner(System.in);
      String str = scn.nextLine();
      int n = str.length();
      
      int dp[][] = new int[n][n];
      
      for(int d =0; d < n; d++){
          for(int i =0, j=d; i <n && j < n; i++,j++){
              
              if(d == 0){
                  dp[i][j] =1;
              }
              else{
                      int x = dp[i+1][j-1];
                      int y = dp[i][j-1];
                      int z = dp[i+1][j];
                      
                  if(str.charAt(i) != str.charAt(j)) {
                      dp[i][j] = y + z -x;
                  }
                  else{
                      dp[i][j] = y + z + 1;
                  }
              }
          }
      }
      System.out.println(dp[0][n-1]);
}
}