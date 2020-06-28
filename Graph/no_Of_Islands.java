import java.io.*;
import java.util.*;

public class Main {
   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int m = Integer.parseInt(br.readLine());
      int n = Integer.parseInt(br.readLine());
      int[][] arr = new int[m][n];

      for (int i = 0; i < arr.length; i++) {
         String parts = br.readLine();
         for (int j = 0; j < arr[0].length; j++) {
            arr[i][j] = Integer.parseInt(parts.split(" ")[j]);
         }
      }
      System.out.println(noOfIslands(arr));

   }
   public static void visitLands(int[][]arr, int i , int j){
       
       //mark visited
       arr[i][j] = 2;
       
       //north
       if(i-1 >= 0 &&  arr[i-1][j] == 0){
           visitLands(arr , i-1, j);
       }
       
       //east
       if(j + 1 < arr[0].length && arr[i][j+1] == 0){
           visitLands(arr, i , j + 1);
       }
       
       //south
       if(i + 1 < arr.length && arr[i+1][j] == 0 ){
            visitLands(arr, i + 1 , j);
       }
       
       //west
       if( j-1 >= 0 && arr[i][j-1] == 0 ){
            visitLands(arr, i , j - 1);
       }
       
   }
   
   public static int noOfIslands(int[][] arr){
       
       // 0 -----> land
       // 1 -----> water
       // 2 -----> visited
       int count = 0;
       
       for (int i = 0; i < arr.length; i++) {
         for (int j = 0; j < arr[0].length; j++) {
         
         // **** if it is a land ******
             if( arr[i][j] == 0 ){
                 
                 visitLands(arr, i, j);
                 count++;
                 
                }
            }
        }
        return count;
   }

}