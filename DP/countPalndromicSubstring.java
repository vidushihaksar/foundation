import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        int n = str.length();
        
        boolean [][]dp = new boolean[n][n];
        int count=0;
        
        for(int diag =0; diag < n; diag++){
            
            for(int i=0, j=diag; j<n; i++,j++){
                
                if( diag ==0){
                    dp[i][j] = true;
                }
                
                else if( diag == 1){
                    if(str.charAt(i) == str.charAt(j)){
                        dp[i][j] = true;
                    }else{
                        dp[i][j] = false;
                    }
                }
                else{
                    if(str.charAt(i) == str.charAt(j) && dp[i+1][j-1]==true){
                         dp[i][j] = true;
                    }else{
                        dp[i][j] = false;
                    }
                    
                }
            
                
                if( dp[i][j] == true ){
                    count += 1;
                }
            }
            
        }
        System.out.print(count);
    }

}