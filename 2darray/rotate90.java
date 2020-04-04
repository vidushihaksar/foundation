import java.io.*;
import java.util.*;

public class rotate90 {

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
        rotate(a);
        display(a);
    }
    
    public static void rotate(int[][] a){
        int n = a.length;
        int m = a[0].length;
        
        //transpose
        for(int i = 0; i<n; i++){
            for(int j = 0; j<=i; j++){
                int temp = a[i][j];
                a[i][j] = a[j][i];
                a[j][i] = temp;
            }
        }
        
        //reverse
        for(int i =0; i < n; i++){
            int start = 0;
            int end = a[0].length-1;
            
            while(start <= end){
                int temp = a[i][start];
                a[i][start] = a[i][end];
                a[i][end] = temp;
            
                start++;
                end--;
            }
           
        }
    }

    public static void display(int[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}