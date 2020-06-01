import java.io.*;
import java.util.*;

public class Main{
  public static void display(int[] a){                                                                         
    StringBuilder sb = new StringBuilder();

    for(int val: a){
      sb.append(val + "\n");
    }
    System.out.println(sb);
  }

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for(int i = 0; i < n; i++){
       a[i] = Integer.parseInt(br.readLine());
    }

    int[] span = solve(a);
    display(span);
 }

 
public static int[] solve(int[] a){
   // solve
          
          Stack<Integer> st = new Stack<>();
          int[]ngol =new int[a.length];
          Arrays.fill(ngol,1);
          
          for(int i=0; i<a.length; i++){
              
              while(st.size()!=0 && a[st.peek()] <= a[i]){
                  ngol[i] += ngol[st.peek()];
                  st.pop();
              }
            //   if(st.size()==0){
            //       ngol[i]= i+1;
            //   }else{
            //       ngol[i] = i - st.peek();
            //   }
                  st.push(i);
          }
          
          
      
   return ngol;
 }
}