import java.io.*;
import java.util.*;

public class Main {
   static class Edge {
      int src;
      int nbr;

      Edge(int src, int nbr) {
         this.src = src;
         this.nbr = nbr;
      }
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int vtces = Integer.parseInt(br.readLine());
      ArrayList<Edge>[] graph = new ArrayList[vtces];
      for (int i = 0; i < vtces; i++) {
         graph[i] = new ArrayList<>();
      }

      int edges = Integer.parseInt(br.readLine());
      for (int i = 0; i < edges; i++) {
         String[] parts = br.readLine().split(" ");
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);
         graph[v1].add(new Edge(v1, v2));
      }
      
       orderOfCompilation(graph);
      
   }
   public static void orderOfCompilation(ArrayList<Edge>[] graph){
       
       boolean[]visited = new boolean[graph.length];
       Stack<Integer> st = new Stack<>();
       
       
       // for visted all components of the graph
       for(int v =0 ; v < visited.length; v++){
           if( !visited[v] ){
               topologicalSort(graph, v, visited, st);
           }
       }
       
       while(st.size()> 0 ){
           System.out.println(st.pop());
       }
   }
   public static void topologicalSort(ArrayList<Edge>[] graph, int src, boolean[] visited, Stack<Integer> st){
       
       
       //mark visited
       visited[src] = true;
       
       //visit univisited nbrs in depth first manner
       for(Edge e : graph[src] ){
           if( !visited[e.nbr] ){
               topologicalSort(graph, e.nbr, visited, st);
           }
       }
       
       //push into stack
       st.push(src);
   }

}