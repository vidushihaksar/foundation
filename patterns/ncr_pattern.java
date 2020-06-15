// 1
// 1  1
// 1  2  1
// 1  3  3  1
// 1  4  6  4  1


import java.util.*;
     
     public class Main{
     
      public static void main(String[] args) {
            Scanner scn = new Scanner(System.in);
            int i = scn.nextInt();
            
            for(int n = 0; n < i; n++){
                    int ncr = 1;
                for(int r = 0; r <= n; r++){
                    System.out.print(ncr+"\t");
                    int ncr_plus_1 = ((n -r)*ncr) / (r+1);
                    ncr = ncr_plus_1;
                }
                System.out.println();
            }
      
          
          
          
      }
     }
     
    