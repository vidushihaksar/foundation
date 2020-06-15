// *  *  *  *
// *  *  *
// *  *
// *




import java.util.*;
      
      public class Main{
      
      public static void main(String[] args) {
          Scanner scn = new Scanner(System.in);
          int n = scn.nextInt();
           // write ur code here
           for(int i =0; i < n; i++ ){
               
               for(int j = n-1; j >= i; j--){
                   System.out.print("*	");
               }
                System.out.println();
           }
      
       }
      }