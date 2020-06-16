// 1                 1
// 1  2           2  1
// 1  2  3     3  2  1
// 1  2  3  4  3  2  1


import java.util.*;
      
      public class Main{
      
      public static void main(String[] args) {
          Scanner scn = new Scanner(System.in);
          int n = scn.nextInt();
          int nstar =1;
          int nspaces = 2*n - 3;
          
          for(int i = 1; i <= n; i++){
              
              int istar =1;
              while(istar <= i){
                  System.out.print(istar+"\t");
                  istar++;
              }
              
              int ispaces = 1;
              while(ispaces <= nspaces){
                  System.out.print("\t");
                  ispaces++;
              }
              
              istar--;
              if(i  == n){
                  istar--;
              }
              while(istar >= 1){
                  System.out.print(istar+"\t");
                  istar--;
              }
              
              nspaces -= 2;
              System.out.println();
              
          }
      
       }
      }