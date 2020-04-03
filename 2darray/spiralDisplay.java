import java.io.*;
import java.util.*;

public class spiralDisplay {

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
    
       spiral(a);
        
    }
    public static void spiral(int[][]a){
        int n = a.length;
        int m = a[0].length;
        int RowMin=0, RowMax = n-1, ColMin=0, ColMax = m-1;
        int count =0;
        
        while(count < n*m){
            
            //leftwall
            for(int i = RowMin ; i <= RowMax ; i++){
                System.out.println(a[i][ColMin]);
                count++;
            }
            
            ColMin++;
            //bottom wall
            for(int i = ColMin; i<= ColMax && count <  n*m; i++){
                System.out.println(a[RowMax][i]);
                count++;
            }
            
            RowMax--;
            //right wall
            for(int i = RowMax; i>=RowMin && count <  n*m; i--){
                System.out.println(a[i][ColMax]);
                count++;
            }
            
            ColMax--;
            //top wall
            for(int i = ColMax; i>=ColMin && count <  n*m; i--){
                System.out.println(a[RowMin][i]);
                count++;
            }
            
            RowMin++;
            
        }
    }

}