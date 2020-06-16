// *  *  *     *
//       *     *
// *  *  *  *  *  
// *     *
// *     *  *  *


import java.util.*;

public class Main{

public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    
    for(int irow = 1; irow <= n; irow++){
        
        for(int icol = 1; icol <= n; icol++){
            
            if(irow == 1){
                if(icol <= n/2+1 || icol == n){
                    System.out.print("*\t");
                }else{
                    System.out.print("\t");
                }
            }
            
            else if (irow < n/2+ 1){
                if(icol == n/2+1 || icol == n){
                    System.out.print("*\t");
                }else{
                    System.out.print("\t");
                }
            }
            
            else if (irow == n/2+1){
                    System.out.print("*\t");
            }
            
            else if(irow > n/2+1 && irow < n){
                if(icol == 1 || icol == n/2+1){
                    System.out.print("*\t");
                }else{
                    System.out.print("\t");
                }
                
            }
            
            else if( irow == n){
                if(icol >= n/2+1 || icol == 1){
                    System.out.print("*\t");
                }else{
                    System.out.print("\t");
                }
                
            }
        }
        System.out.println();
    }
 }
}


 