import java.util.*;

public class Main{

public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int b = scn.nextInt();
    int n1 = scn.nextInt();
    int n2 = scn.nextInt();

    int d = getProduct(b, n1, n2);
    System.out.println(d);
 }

 public static int getProduct(int b, int n1, int n2){
     // write your code here
     int res = 0, pow=1;
     while(n2 > 0){
         int r = n2 % 10;
         n2 /= 10;
         
         int singleDigAns = getSingleDigitAns(n1, r, b);
          res = getSum(b,res, singleDigAns * pow );
          pow = pow* 10;
     }
     return res;
 }
 
 public static int getSingleDigitAns(int n1, int sdn2, int b){
     int carry = 0, mul = 0, pow  = 1;
     while(n1 > 0 || carry != 0){
         int sdn1 = n1 % 10;
         n1 = n1 / 10;
         
         int m = sdn1 *sdn2 + carry;
         carry = m / b;
         mul = (m % b)*pow + mul;
         pow = pow * 10;
     }
     return mul;
 }
public static int getSum(int b, int n1, int n2){
       // write ur code here
       int carry=0,  div=0,re, sum=0, result =0, mul =1;
       while(n1>0 || n2>0 || carry !=0){
           int rem1 = n1 % 10;
           int rem2 = n2 % 10;
           
          
           int s =rem1 + rem2 + carry;
           
        //   if(D >=b) {
        //       carry=D /b;
        //       D = D % b;
        //   }
        //   else{
               
        //       carry =0;
        //   }
        
        carry = s/b;
        s = s % b;
           
           result = (s * mul) + result ;
           mul = mul *10;
           
           n1/=10;
           n2/=10;
           
       }
       return result;
      
   }
}