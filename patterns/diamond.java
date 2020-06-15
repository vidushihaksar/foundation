//           *
//        *  *  *
//     *  *  *  *  *
//  *  *  *  *  *  *  *
//     *  *  *  *  *
//        *  *  *
//           *


import java.util.*;
               
              public class Main{
               
              public static void main(String[] args) {
                  Scanner scn = new Scanner(System.in);
                  int n = scn.nextInt();
                   
                  int nspc = n/2;
                  int nstar = 1;
                  int i = 0;
                  
                  
                  while( i < n){     
                      //**** space *****
                      int ispace = 1;
                      while(ispace <= nspc){
                          System.out.print("\t");
                          ispace++;
                      }
                       
                      // **** star ****
                      int istar = 1;
                      while(istar <= nstar){
                          System.out.print("*\t");
                          istar++;
                      }
                       
                        
                      i++;
                      System.out.println();
                       
                      if( i <= n/2){
                          nspc -= 1;
                          nstar += 2;
                      }else{
                          nspc += 1;
                          nstar -= 2;
                      }
                  }
                }
              }
               
  