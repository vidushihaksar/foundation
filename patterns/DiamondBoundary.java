// *  *  *    *  *  *
// *  *          *  * 
// *                *
// *  *          *  * 
// *  *  *    *  *  *
         




import java.util.*;
               
              public class Main{
               
              public static void main(String[] args) {
                  Scanner scn = new Scanner(System.in);
                  int n = scn.nextInt();
                   
                  int nspc = 1;
                  int nstar = n/2 + 1;
                  int i = 0;
                  
                  
                  while( i < n){     
                      // **** star ****
                      int istar = 1;
                      while(istar <= nstar){
                          System.out.print("*\t");
                          istar++;
                      }
                       
                      //**** space *****
                      int ispace = 1;
                      while(ispace <= nspc){
                          System.out.print("\t");
                          ispace++;
                      }
                       
                      // **** star ****
                       istar = 1;
                      while(istar <= nstar){
                          System.out.print("*\t");
                          istar++;
                      }
                        
                      i++;
                      System.out.println();
                       
                      if( i <= n/2){
                          nspc += 2;
                          nstar -= 1;
                      }else{
                          nspc -= 2;
                          nstar += 1;
                      }
                  }
                }
              }
               
  