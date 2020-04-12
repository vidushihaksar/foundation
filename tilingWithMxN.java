import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
               long[]dp = new long[n+1];

       //System.out.println(tiles(n,m,dp));
        System.out.println(tilesplacement(n,m));

    }

    //------inclusion-exclusion--------------
    public static long tilesplacement(int n,int m){
       int[]dp = new int[n+1];
       
        
        for(int pos=1; pos<=n; pos++){
            if(pos < m)
                dp[pos] = 1;
            else if(pos == m){
                dp[pos] = 2;
            }
            else
               dp[pos] = dp[pos-1]+dp[pos-m];
        }
            
        return dp[n];
    }
}