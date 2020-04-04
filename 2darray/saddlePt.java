import java.io.*;
import java.util.*;

public class saddlePt {

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
        int found =0;
        for(int i=0; i< n; i++){
            
            
            int min = Integer.MAX_VALUE;
            int min_col =-1;
            for(int j =0; j<n; j++){
                if(a[i][j] < min){
                    min = a[i][j];
                    min_col = j;
                }
            }
            
            int max = Integer.MIN_VALUE;
            for(int k=0; k< n; k++){
                if(a[k][min_col] > max){
                    max = a[k][min_col];
                }
            }
            
            if(min == max){
                System.out.println(min);
                found =1;
                break;
            }
        }
        if(found ==0){
            System.out.println("Invalid input");
        }
    }

}