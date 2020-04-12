import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[]a = new int[n+1];
        for(int i=0; i<n; i++){
            a[i] = scn.nextInt();
            
        }
        //int ans = transaction(n,a);
        int ans = trans(n,a);
        System.out.println(ans);
        
        
    }
//------------O(n^2)------------------------
    public static int transaction(int n, int[]a){
        int[]dp = new int[n];
        
        
            for(int j=0; j<n-1; j++){
                
                int max = Integer.MIN_VALUE;
                for(int k=j+1; k<n; k++){
                    if(a[k] > max){
                        max = a[k];
                    }
                }
                dp[j] = max - a[j];
            }
            
            int max = Integer.MIN_VALUE;
            for(int i=0; i<n;i++){
               
                    if(dp[i] > max){
                        max = dp[i];
                    } 
            }
            
        return max;
    }
    
//---------sir ka method - O(n)------------
public static int trans(int n, int[] a){
    int minSoFar =a[0];
    int maxProfit = 0;
    
    for(int i=1; i<n; i++){
        if(a[i]  < minSoFar){
            minSoFar = a[i];
        }
        if((a[i] - minSoFar) > maxProfit){
            maxProfit = a[i] - minSoFar;
        }
    }
    
    return maxProfit;
}

}