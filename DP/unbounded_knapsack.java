import java.io.*;
	import java.util.*;

	public class Main {

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
	     
	     public static int knapsack(int n, int[]values, int[]weights,int cap){
	         int[]dp = new int[cap + 1];
	         
	         dp[0]= 0;
	         for(int i=0; i<n; i++){
	             int w = weights[i];
	             int v = values[i];
	             
	             for(int j = w; j <= cap ; j++){
	                 dp[j] = Math.max(dp[j -w]+v, dp[j]);
	             }
	         }
	         return dp[cap];
	     }
	}