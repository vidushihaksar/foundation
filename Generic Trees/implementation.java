import java.util.*;

public class Main{
public static class Node{
    int data;
    ArrayList<Node> children  = new ArrayList<>();
    
}
public static void main(String[] args) {

  int[] arr = {10,20,50,-1,60,-1,-1,30,70,-1,-1,40,80,-1,90,100,-1,-1,-1,-1};
  
  Stack<Node> st = new Stack<>();
  Node root = null;
  
  for(int i = 0; i<arr.length; i++){
      // if -1 then it means no more children so pop the node
      if( arr[i] == -1){
          st.pop();
      }
      else{
          Node t = new Node();
          t.data = arr[i];
          
          // if st.size()==0 , it means it is the first node i.e root
          if(st.size() == 0){
              root = t; 
          }else{
              st.peek().children.add( t );
          }
          
          st.push(t);
      }
  }
  
  display(root);

 }
 
 public static void display(Node root){
     
     System.out.print(root.data + " -> ");
     for(Node child : root.children){
         System.out.print(child.data +", ");
     }
     System.out.println(".");
     
     for(Node child : root.children){
          display(child);
     }
     
 }

}