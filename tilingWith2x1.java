import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[]dp = new int[n+1];
       // System.out.println(tiles(n,dp));
        System.out.println(tilesplacement(n));

    }
    public static int tiles(int n, int[]dp){
        if(n<=2)return n;
        
        if(dp[n]!=0){
            return dp[n];
        }
        int nn =tiles(n-2,dp) + tiles(n-1,dp);
        dp[n]=nn;
        
        return dp[n];
        
    }
    
    public static int tilesplacement(int n){
        int[]dp = new int[n+1];
        dp[0]=0;
        dp[1]=1;
        dp[2]= 2;
        
        for(int i=3; i<=n; i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}