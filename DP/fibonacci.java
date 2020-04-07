import java.io.*;
import java.util.*;

public class fibonaci{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn = new Scanner(System.in);
    int n= scn.nextInt();
    int arr[]=new int[n+1];
    int a = fib(n,arr);
    System.out.println(a);
 }
 public static int fib(int n, int[]a){
     if(n<=1){
         return n;
     }
     if(a[n]!=0){
         return a[n];
     }
     
     int ans = fib(n-1,a) + fib(n-2,a);
     a[n] = ans;
     
     return a[n];
 }

}