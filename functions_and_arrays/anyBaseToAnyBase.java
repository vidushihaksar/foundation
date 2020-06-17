import java.util.*;
  
  public class Main{
  
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      int n = scn.nextInt();
      int b1 = scn.nextInt();
      int b2 = scn.nextInt();
  
      int d = getValue(n, b1, b2);
      System.out.println(d);
   }
  public static int getValueIndecimal(int n, int b){
      // write your code here
      int dec=0;
      int faceValue=1;
      while(n>0){
          int re = n%10;
          dec = dec + (re *faceValue);
          faceValue = faceValue*b;
          n/= 10;
      }
      return dec;
   }
   public static int getValueInBase(int n, int b){
      int pow =1, sum=0;
       //int div = b*pow;
       while(n>0){
           int re = n%b;
           sum = sum+  re*pow; 
           n= n/b;
           pow=pow * 10;
       }
       
       return sum;
   }
   public static int getValue(int n, int b1, int b2){
       // write your code here
       int dec = getValueIndecimal(n,b1);
       return getValueInBase(dec,b2);
       
   }
  
   
  }