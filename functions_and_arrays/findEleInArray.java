import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for(int i =0; i<n; i++){
        arr[i] = scn.nextInt();
    }
    int ele = scn.nextInt();
    System.out.print(find(arr, ele));
 }
 
 public static int find(int[] arr, int ele){
     int idx=-1;
     for(int i=0; i<arr.length; i++){
         if(arr[i]==ele){
              idx=i;
              break;
         }
     }
     return idx;
 }

}