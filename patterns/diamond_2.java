//       1
//    2  3  2
// 3  4  5  4  3
//    2  3  2
//       1

import java.util.*;

      
      public class Main{
      
      public static void main(String[] args) {
                  Scanner scn = new Scanner(System.in);
                  int n = scn.nextInt();
                   
                  int nspc = n/2;
                  int nstar = 1;
                  int i = 0, val =1;
                  

                  while( i < n){     
                      //**** space *****
                      int ispace = 1;
                      while(ispace <= nspc){
                          System.out.print("\t");
                          ispace++;
                      }
                       
                      // **** star ****
                      int istar = 1, p = val;
                      while(istar <= nstar){
                               System.out.print(p+"\t");
                          
                          if(istar <= nstar/2){
                               p++;
                          }else{
                              p--;
                          }      
                          istar++;
                      }
                       
                        
                      i++;
                      System.out.println();
                       
                      if( i <= n/2){
                          val++;
                          nspc -= 1;
                          nstar += 2;
                         
                      }else{
                          val--;
                          nspc += 1;
                          nstar -= 2;
                         
                      }
                  }
       }
      }