import java.io.*;
import java.util.*;

public class srchInSortedArr {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
       
        int[][] a = new int[n][n];
        
        for(int i = 0; i<n; i++){
            for(int j = 0; j< n; j++){
                a[i][j] = scn.nextInt();
            }
        }
        int x = scn.nextInt();
        search(a,x);
    }
    
    public static void search(int[][]a, int x){
        int n = a.length;
        int m = a[0].length;
        
        for(int i = 0; i<n; i++){
            
            if(x <= a[i][n-1]){
                for(int j=0; j<m; j++){
                    if(a[i][j] == x){
                        System.out.println(i);
                        System.out.println(j);
                        return;
                    }
                }
            }
        }
        System.out.println("Not Found");
        
        
    }

}