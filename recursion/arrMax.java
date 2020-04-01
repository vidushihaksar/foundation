import java.io.*;
import java.util.*;

public class arrMax {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[]a= new int[n];
        for(int i=0; i<a.length; i++){
            a[i] = scn.nextInt();
        }
        
        System.out.println(maxOfArray(a, 0));
        
    }
    
    static int max = Integer.MIN_VALUE;
    public static int maxOfArray(int[] arr, int idx){
        
    //     if(idx == arr.length){
    //         return max;
    //     }
       
    //     if(arr[idx] > max){
    //         max = arr[idx];
    //     }
        
    //   return maxOfArray(arr, idx+1); 
    
    if(idx == arr.length - 1){
        return arr[idx];
    }
    
    int maxTillNow = maxOfArray(arr, idx+1);
    int currEle = arr[idx];
    
    if(maxTillNow < currEle){
        return currEle;
    }
    else{
        return maxTillNow;
    }
        
    }

}