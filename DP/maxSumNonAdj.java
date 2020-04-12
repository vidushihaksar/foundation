import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[]a = new int[n];
        for(int i=0; i<n; i++){
            a[i] = scn.nextInt();
        }
            System.out.println(nonAdjSum(n,a));

    }
    
    public static int nonAdjSum(int n,int[]a){
        int[][]dp = new int[2][n];
        
        dp[0][0]=0;
        dp[1][0] = a[0];
        
        for(int j=1; j<n; j++){
            dp[0][j] = Math.max(dp[0][j-1],dp[1][j-1]);
            dp[1][j] = dp[0][j-1] + a[j];
        }
        
        
        return Math.max(dp[0][n-1],dp[1][n-1]);

    }
}