// *  *  *  *  *  *  *
//    *           *
//       *     *
//          *
//       *  *  *     
//    *  *  *  *  *
// *  *  *  *  *  *  *    

import java.util.*;

public class Main{

public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    
    int nstar =n;
    int nspace =0;
    
    for(int i =1; i <= n; ){
        
        int ispace = 1;
        while(ispace <= nspace){
            System.out.print("\t");
            ispace++;
        }
        
        
        int istar =1;
        while(istar<= nstar){
            if(i > 1 && i < n/2+1 && istar > 1 && istar< nstar){
                System.out.print("\t");
            }else{
                System.out.print("*\t");
            }
            istar++;
        }
        
        i++;
        if(i <= n/2+1 ){
            nstar -= 2;
            nspace += 1;
        }else{
            nstar +=2;
            nspace -= 1;
        }
        
        System.out.println();
        
        
    }

 }
}