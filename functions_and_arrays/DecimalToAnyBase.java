import java.util.*;
  
  public class Main{
  
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      int n = scn.nextInt();
      int b = scn.nextInt();
      int dn = getValueInBase(n, b);
      System.out.println(dn);
   }
  
   public static int getValueInBase(int n, int b){
       int ans = 0, pow =1;
       while( n >0){
           int rem = n % b;
           n = n / b;
           ans =  rem*pow + ans;
           pow *= 10;
           
       }
       return ans;
   }
  }