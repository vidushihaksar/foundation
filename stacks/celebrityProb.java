import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            for (int k = 0; k < n; k++) {
                arr[j][k] = line.charAt(k) - '0';
            }
        }

        findCelebrity(arr);

    }

    public static void findCelebrity(int[][] arr) {
        // if a celebrity is there print it''s index (not position), if there is not then
        // print "none"
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<arr.length; i++){
            st.push(i);
        }
        
        while(st.size() > 1){
            int p1 = st.pop();
            int p2 = st.pop();
            
            if(arr[p1][p2] == 1){
                st.push(p2);
            }else{
                st.push(p1);
            }
        }
        for(int i=0; i< arr.length; i++){
                   
            if( i!= st.peek() && arr[i][st.peek()]!=1 && arr[st.peek()][i]!=0){
                 
                System.out.println("none");
                return;
            }
        }
        System.out.println(st.peek());
    }

}