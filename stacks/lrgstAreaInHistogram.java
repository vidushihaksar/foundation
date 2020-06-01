import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for(int i = 0; i < n; i++){
       a[i] = Integer.parseInt(br.readLine());
    }
    int[] nsol = nxtSmallerleft(a);
    // for(int i = 0; i < n; i++){
    //   System.out.print(nsol[i]+" ");
    // }
    // System.out.println();
    int[] nsor = nxtSmallerRyt(a);
    // for(int i = 0; i < n; i++){
    //   System.out.print(nsor[i]+" ");
    // }
    
    int []area= new int[n];
    int maxArea = Integer.MIN_VALUE;
    
    for(int i =0; i<n; i++){
        int height = a[i];
        int width = nsor[i]-nsol[i]-1;
        area[i] = height*width;
        if(area[i]>maxArea){
            maxArea = area[i];
        }
    }
    
    System.out.println(maxArea);
    // code
 }
 public static int[] nxtSmallerleft(int[] a){
          Stack<Integer> st = new Stack<>();
          int[]nsol =new int[a.length];
          
          for(int i=0; i<a.length; i++){
              
              while(st.size()!=0 && a[st.peek()] >= a[i]){
                  st.pop();
              }
              if(st.size()==0){
                  nsol[i]= -1;
              }else{
                  nsol[i] =  st.peek();
              }
                  st.push(i);
          }
          return nsol;
          
 }
 public static int[] nxtSmallerRyt(int[] a){
          Stack<Integer> st = new Stack<>();
          int[]nsor =new int[a.length];
          
          for(int i=a.length-1; i>=0; i--){
              
              while(st.size()!=0 && a[st.peek()] >= a[i]){
                  st.pop();
              }
              if(st.size()==0){
                  nsor[i]= a.length;
              }else{
                  nsor[i] =  st.peek();
              }
                  st.push(i);
          }
          return nsor;
          
 }
 
}