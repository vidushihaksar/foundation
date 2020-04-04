import java.io.*;
import java.util.*;

public class diagTraversal {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        //int m = scn.nextInt();
        int[][] a = new int[n][n];
        
        for(int i = 0; i<n; i++){
            for(int j = 0; j< n; j++){
                a[i][j] = scn.nextInt();
            }
        }
        
        // for(int i =0; i< n; i++){
        //     int k=0;
        //     for(int j = i; j< n; j++){
        //       System.out.println(a[k][j]);
        //       k++;
        //     }
        // }
        int k=0,j=0;
        for(int i =0; i< n; i++){
            
            for( k=0,j = i; k<n && j< n; k++, j++){
               System.out.println(a[k][j]);
              
            }
        }
    }

}