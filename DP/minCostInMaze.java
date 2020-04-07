import java.io.*;
import java.util.*;

public class Main {

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
        
        int ans = minCost(a,0,0,n-1,m-1);
        System.out.println(ans);
    }
    
//------------ TABULATION ------------------------------------------

    public static int minCost(int[][]a,int sr, int sc, int dr, int dc){
        int[][]tabulation = new int[a.length][a[0].length];
        
        // tabulation[dr][dc] = a[dr][dc];
        
        // for(int j = dc-1; j>=0; j--){
        //     tabulation[dr][j] = tabulation[dr][j+1] + a[dr][j];
        // }
        
        // for(int i = dr - 1; i>=0; i--){
        //     tabulation[i][dc] = tabulation[i+1][dc] + a[i][dc];

        // }
        
        for(int i = dr; i >= 0; i--){
            for(int j = dc; j >= 0; j--){
                
                if(i==dr && j== dc){
                    tabulation[i][j] = a[i][j];

                }
                else if( i == dr){
                    tabulation[i][j] = tabulation[i][j+1] + a[i][j];

                }
                else if(j == dc){
                    tabulation[i][j] = tabulation[i+1][j] + a[i][j];

                }
                else
                    tabulation[i][j] = Math.min(tabulation[i+1][j], tabulation[i][j+1]) + a[i][j];
                
                
                
            }
        }
        
        return tabulation[0][0];
        
    }

}