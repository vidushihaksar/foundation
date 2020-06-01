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

    int[] nge = solve(a);
    display(nge);
 }
//********* my method ******************
//  public static int[] solve(int[] arr){
//   // solve
//   Stack<Integer> st = new Stack<>();
//   st.push(0);
//   int newarr[]= new int[arr.length];
   
//   for(int i=1; i<arr.length; i++){
//       while(st.size()!=0 && arr[i] > arr[st.peek()]){
//           newarr[st.pop()] = arr[i];
//       }
      
//           st.push(i);
       
//   }
   
//   while(st.size()!=0){
//       newarr[st.pop()]=-1;
//   }
   
//   return newarr;
  
//  }

// }

public static int[] solve(int[] arr){
       int n = arr.length;
       Stack<Integer> st = new Stack<>();
       int []ngor = new int[n];
       
       for(int i = n-1; i>=0; i--){
          
               while(st.size()!=0  && st.peek() < arr[i]){
                   st.pop();
               }
                if(st.size() == 0){
                    ngor[i] = -1;
               }
               else{
                 ngor[i] = st.peek();
               }
                 st.push(arr[i]);
           }
              
        return ngor;
           
       }
       
       
       
       
       
       

}