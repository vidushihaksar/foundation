import java.io.*;
import java.util.*;

public class targetSum {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int[]a = new int[n];
        for(int i =0; i<n; i++){
            a[i] = scn.nextInt();
        }
        
        int tar = scn.nextInt();
        
        printTargetSumSubsets(a,0,"",0,tar);
        System.out.println();
    }

    // set is the subset
    // sos is sum of subset
    // tar is target
    public static void printTargetSumSubsets(int[] arr, int idx, String set, int sos, int tar) {
        //proactive condition
        // if(sos > tar){
        //     return
        // }
        
        //we will check till arr.length 
        //bcus it might happen that rest of the elements 
        //will be zero.So we have to take their contribbution.
        if(idx == arr.length){
    
            if(sos == tar){
               System.out.println(set+".");
               
            }
            return;
        }
        int ele = arr[idx];
        
        //we will check whether sum <= tar
        //preactive condition
        if(sos + ele <= tar){
            //ele will contribute in sum
           printTargetSumSubsets(arr, idx+1, set+ ele +", ", sos+ele, tar);
        }
        
        //ele will not contribute
        printTargetSumSubsets(arr, idx+1, set, sos, tar);
    }

}