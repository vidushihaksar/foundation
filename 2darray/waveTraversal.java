import java.io.*;
import java.util.*;

public class waveTraversal{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] a = new int[n][m];
        
        for(int i = 0; i<n; i++){
            for(int j = 0; j< m; j++){
                a[i][j] = scn.nextInt();
            }
        }
        wave(a);
    
 }
 public static void wave(int[][]a){
     int n = a.length;
     int m = a[0].length;
     
     for(int i = 0; i< m; i++ ){
         
         if( i % 2 == 0){
             for(int j = 0; j < n; j++){
                 System.out.println(a[j][i]);
             }
         }
         
         else{
             for(int k = n-1; k>=0 ; k--){
                 System.out.println(a[k][i]);
             }
         }
     }
 }

}