import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int ans = printStairPaths(n,new int[n+1] );
        System.out.println(ans);
    }
    
//pro active approach
    // public static int printStairPaths(int n,  int[] count) {
    //     //if(n < 0){ return; }
        
        // if(n == 0){
        //     return 1;
        // }
        // if(count[n]!=0){
        //     return count[n];
        // }
        
    //     if( n-1 >= 0){
            
    //         int c = printStairPaths(n-1,count);
    //          count[n]+= c ;
             
    //         if( n - 2 >= 0){
    //           int v = printStairPaths(n-2, count);
    //             count[n] +=  v;
                
    //             if(n - 3 >=0){
    //               int  m=printStairPaths(n-3, count);
    //               count[n]+=m;
    //             }

    //         }

    //     }
        
    //     return count[n];
    // }
    
    
//---------sir ka method ------------------------------------
    public static int printStairPaths(int n, int[]count){
        if(n == 0){
            return 1;
        }
        if(count[n]!=0){
            return count[n];
        }
        
        int totalWays=0;
        if(count[n]!=0){
            return count[n];
        }
        
        
        for(int step =1; n-step>=0 && step <= 3; step++){
            totalWays += printStairPaths(n - step, count);
        }
        
        count[n] = totalWays;
        return count[n];
    }


}