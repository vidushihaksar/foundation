//           *
//           *  *
//           *  *  *
//  *  *  *  *  *  *  *
//           *  *  *
//           *  *
//           *




import java.util.*;
       
       public class Main{
       
       public static void main(String[] args) {
           Scanner scn = new Scanner(System.in);
       
            // write ur code here
            int n = scn.nextInt();
            
            int irow =1;
            int nspace= (n/2);
            int nstar = 1;
            while(irow<= n){
                
                int ispace =1;
                while(ispace<= nspace){
                    if(irow == n/2 + 1){
                        System.out.print("*	");
                    }
                    else{
                        System.out.print("	");
                    }
                    ispace++;
                }
                
                int  istar =1;
                while(istar <= nstar){
                    System.out.print("*	");
                    istar++;
                }
                
                if(irow <= n/2){
                    nstar++;
                }
                else{
                    nstar--;
                }
                irow++;
                System.out.println();
            }
       
        }
       }