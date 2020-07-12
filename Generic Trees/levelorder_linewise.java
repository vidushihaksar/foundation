import java.io.*;
import java.util.*;

public class Main {
    private static class Node {
        int data;
        ArrayList < Node > children = new ArrayList < > ();

        Node(int data) {
            this.data = data;
        }
    }

    public static void display(Node node) {
        String str = node.data + " -> ";
        for (Node child: node.children) {
            str += child.data + ", ";
        }
        str += ".";
        System.out.println(str);

        for (Node child: node.children) {
            display(child);
        }
    }

    public static Node construct(int[] arr) {
        Node root = null;

        Stack < Node > st = new Stack < > ();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1) {
                st.pop();
            } else {
                Node t = new Node(arr[i]);


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

    public static int size(Node node) {
        int s = 0;

        for (Node child: node.children) {
            s += size(child);
        }
        s += 1;

        return s;
    }

    public static int max(Node node) {
        int m = Integer.MIN_VALUE;

        for (Node child: node.children) {
            int cm = max(child);
            m = Math.max(m, cm);
        }
        m = Math.max(m, node.data);

        return m;
    }

    public static int height(Node node) {
        int h = -1;

        for (Node child: node.children) {
            int ch = height(child);
            h = Math.max(h, ch);
        }
        h += 1;

        return h;
    }

    public static void traversals(Node node) {
        System.out.println("Node Pre " + node.data);

        for (Node child: node.children) {
            System.out.println("Edge Pre " + node.data + "--" + child.data);
            traversals(child);
            System.out.println("Edge Post " + node.data + "--" + child.data);
        }

        System.out.println("Node Post " + node.data);
    }
    //******* Approach- 1 Using two Queues ********

    public static void levelOrderLinewise1(Node node) {
        Queue < Node > mainQ = new ArrayDeque < > ();
        Queue < Node > secQ = new ArrayDeque < > ();

        mainQ.add(node);

        while (mainQ.size() > 0) {

            Node rem = mainQ.remove();
            System.out.print(rem.data + " ");

            for (Node child: rem.children) {
                secQ.add(child);
            }

            if (mainQ.size() == 0) {
                System.out.println();
                mainQ = secQ;
                secQ = new ArrayDeque < > ();

            }

        }

    }
    // ********* Approach-2 Using delimiter ***********

    public static void levelOrderLinewise2(Node node) {

        Queue < Node > que = new ArrayDeque < > ();
        Node temp = node;
        que.add(temp);
        que.add(new Node(Integer.MIN_VALUE));

        while (que.size() > 0) {
            //remove
            Node remove = que.remove();
            if (remove.data == Integer.MIN_VALUE) {

                System.out.println();

                if (que.size() > 0) { // avoids stack overflow condition
                    que.add(new Node(Integer.MIN_VALUE));
                }

            } else {
                //Print
                System.out.print(remove.data + " ");
                //Add children
                for (Node n: remove.children) { // for-each loop
                    que.add(n);
                }
            }
        }
    }
    // ********* Approach-3 Using count variable ***********

    public static void levelOrderLinewise (Node node) {

        Queue < Node > que = new ArrayDeque < > ();
        Node temp = node;
        que.add(temp);
        int count  = 1;
        
        while(que.size() > 0) {
            
            while(count > 0){
              Node remove = que.remove();
              //Print
              System.out.print(remove.data + " ");
              //Add children
              for (Node n: remove.children) { // for-each loop
                que.add(n);
               }
               
              count--;
            }
           
            System.out.println();
            count = que.size();
            
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

        Node root = construct(arr);
        levelOrderLinewise(root);
    }

}