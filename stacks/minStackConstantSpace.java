import java.io.*;
import java.util.*;

public class Main {

  public static class MinStack {
    Stack<Integer> data;
    int min;

    public MinStack() {
      data = new Stack<>();
      min = Integer.MAX_VALUE;
    }

    int size() {
      // write your code here
      return data.size();
    }


    void push(int val) {
      // write your code here
      if(data.size() ==0){
          min = val;
          data.push(val);
          
      }else if(val < min){
         int ele = 2*val - min;
         min = val;
         data.push(ele);
         
      }else {
         data.push(val);
      }
      
    }


    int pop() {
      // write your code here
      if(data.size() == 0){
          System.out.println("Stack underflow");
          return -1;
      }
      else if(data.peek() < min){
          int x = data.pop();
          int poppedEle = min;
          min = 2*min - x;
          return poppedEle;
      }
      else{
         return data.pop();
      }
    }

    int top() {
      // write your code here
      if(data.size() == 0){
          System.out.println("Stack underflow");
          return -1;
      }
      else if(data.peek() < min){
          int topEle = min;
          return topEle;
      }
      else{
          return data.peek();
      }
    }

    int min() {
      // write your code here
      if(data.size() == 0){
          System.out.println("Stack underflow");
          return -1;
      }else{
          return min;
      }
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    MinStack st = new MinStack();

    String str = br.readLine();
    while (str.equals("quit") == false) {
      if (str.startsWith("push")) {
        int val = Integer.parseInt(str.split(" ")[1]);
        st.push(val);
      } else if (str.startsWith("pop")) {
        int val = st.pop();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("top")) {
        int val = st.top();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("size")) {
        System.out.println(st.size());
      } else if (str.startsWith("min")) {
        int val = st.min();
        if (val != -1) {
          System.out.println(val);
        }
      }
      str = br.readLine();
    }
  }
}