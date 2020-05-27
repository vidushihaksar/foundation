import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n =scn.nextInt();
        int[]nums = new int[n];
        
        for(int i=0; i< n; i++){
            nums[i] = scn.nextInt();
        }
        
        if(n==0){
            System.out.println(0);
            
        }else if(n==1){
            System.out.println(nums[0]);
        }
        
        else{
            int dp[] = new int[n];
            dp[0] = nums[0];
        
            int Sum=0;
        
            for(int i=1; i<n; i++){
               int maxSum = 0;
               for(int j=0; j<i; j++){
                  if(nums[i] >= nums[j] && dp[j] > maxSum){
                    maxSum = dp[j];
                   }
                }
                dp[i] = maxSum + nums[i];
                Sum = Math.max(Sum, dp[i]);
            }
        
            System.out.println(Sum);
        }
    }

}