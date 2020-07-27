import java.io.*;
import java.util.*;

public class Main {
  private static class Node {
    int data;
    ArrayList<Node> children = new ArrayList<>();
  }

  public static void display(Node node) {
    String str = node.data + " -> ";
    for (Node child : node.children) {
      str += child.data + ", ";
    }
    str += ".";
    System.out.println(str);

    for (Node child : node.children) {
      display(child);
    }
  }

  public static Node construct(int[] arr) {
    Node root = null;

    Stack<Node> st = new Stack<>();
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == -1) {
        st.pop();
      } else {
        Node t = new Node();
        t.data = arr[i];

        if (st.size() > 0) {
          st.peek().children.add(t);
        } else {
          root = t;
        }

        st.push(t);
      }
    }

    return root;
  }

  static Node predecessor;
  static Node successor;
  
  
  
  //********** extra space - O(n) ****************
  
//   static ArrayList<Node> ans;
//   public static void predecessorAndSuccessor(Node node, int data) {
      
//     ans.add(node);
//     for(Node n : node.children){
//         predecessorAndSuccessor(n, data);
//     }
   
 // }
 
 
 //************* Travel and change Approach (My approach)  **********
 
// static Node datanode = null;
//   public static void predecessorAndSuccessor(Node node, int data) {
    
//     if(node.data != data && datanode == null){
      
//         predecessor = node;
//     }else{
//         datanode = node;
//     }
//     for(Node child: node.children){
//         if(successor == null && datanode != null ){
//             successor = child;
//         }
//         predecessorAndSuccessor(child,  data);
//     }
    
//   }

//************* sir ka method **************************************
static int state;
 public static void predecessorAndSuccessor(Node node, int data) {

    if(state == 0){
        if(node.data == data){
            state=1;
        }else{
            predecessor = node;
        }
    }else if(state == 1){
        successor = node;
        state =2;
    
    }else if(state == 2){
        return;
    }
    
     for(Node child : node.children){
         if(state != 2)                // it will return and save few calls
              predecessorAndSuccessor(child, data);
     }
 }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(values[i]);
    }

    int data = Integer.parseInt(br.readLine());

    Node root = construct(arr);
    predecessor = null;
    successor = null;
    //ans = new ArrayList<>();
   
    state = 0;
    
    predecessorAndSuccessor(root, data);
    // int idx = -1;
    // for(int i =0; i< ans.size(); i++){
    //     Node nn = ans.get(i);
    //     if(nn.data == data){
    //         idx  = i;
    //         break;
    //     }
    // }
    
    // predecessor = (idx-1 >=0) ? ans.get(idx-1) : null;
    // successor = (idx+1 < ans.size()) ? ans.get(idx +1): null;
    
    if(predecessor == null){
      System.out.println("Predecessor = Not found");
    } else {
      System.out.println("Predecessor = " + predecessor.data);
    }

    if(successor == null){
      System.out.println("Successor = Not found");
    } else {
      System.out.println("Successor = " + successor.data);
    }
  }

}