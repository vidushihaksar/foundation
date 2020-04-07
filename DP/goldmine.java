import java.io.*;
import java.util.*;

public class goldmine {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][]a = new int[n][m];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                a[i][j] = scn.nextInt();
            }
        
        }
        
        int[][]ans  = goldmine(a,n,m);
        int max = ans[0][0];
        
            for(int row =1; row <n; row++){
                max = Math.max(max, ans[row][0]);
            }
            
        
        System.out.println(max);
        
    }
    
    public static int[][] goldmine(int[][]a, int n, int m){
        int[][]tabulation = new int[n][m];
        
        for(int col = m-1; col >= 0; col--){
            for(int row = 0; row < n; row++){
                
                if(col == m-1){
                    tabulation[row][col] = a[row][col];
                }
                else{
                    if(row == 0){
                        tabulation[row][col] = Math.max(tabulation[row][col+1],tabulation[row+1][col+1]) + a[row][col];
                    }
                    else if( row == n-1){
                        tabulation[row][col] = Math.max(tabulation[row][col+1],tabulation[row-1][col+1]) + a[row][col];
                        
                    }
                    else{
                        tabulation[row][col] = Math.max(tabulation[row][col+1],Math.max(tabulation[row-1][col+1],tabulation[row+1][col+1]) )+ a[row][col];

                    }
                    
                }
            }
        }
        
        return tabulation;
        
    }

}