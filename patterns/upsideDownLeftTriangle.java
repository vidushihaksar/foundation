// *   *   *  *
//     *   *  *
//         *  *
//            *


import java.util.*;
          
          public class Main{
          
          public static void main(String[] args) {
               Scanner scn = new Scanner(System.in);
                int n = scn.nextInt();
                
                for(int i = n; i > 0; i--){
                    
                    //* space *
                    for(int sp = 1; sp <= n-i; sp++){
                        System.out.print("	");
                    }
                    
                    //* star *
                    for(int st = 1; st <= i; st++){
                        System.out.print("*	");
                    }
                    
                     System.out.println();
                }
           }
          }