import java.util.*;
     
     public class Main{
     
      public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
                int n = scn.nextInt();
                int nn = 1;
                for(int i = 1; i <= n; i++){

                    
                    //* star *
                    for(int st = 1; st <= i; st++){
                        System.out.print(nn+"\t");
                        nn++;
                    }
                    
                     System.out.println();
                }
      }          
     }