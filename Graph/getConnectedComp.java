import java.io.*;
import java.util.*;

public class Main {
   static class Edge {
      int src;
      int nbr;
      int wt;

      Edge(int src, int nbr, int wt) {
         this.src = src;
         this.nbr = nbr;
         this.wt = wt;
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
         int wt = Integer.parseInt(parts[2]);
         graph[v1].add(new Edge(v1, v2, wt));
         graph[v2].add(new Edge(v2, v1, wt));
      }

      ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
      
      getConnectedComponents(graph, comps, new boolean[vtces]);

      System.out.println(comps);
   }
   
   public static void getConnectedComponents(ArrayList<Edge>[] graph, ArrayList<ArrayList<Integer>> comps, boolean[]visited){
       
       // ***** iterate over all components *****
       for(int vtx = 0; vtx < visited.length; vtx++ ){
           if(  !visited[vtx] ){
               
               ArrayList<Integer> comp = new ArrayList<>();
               gcc( graph, visited, vtx, comp );
               comps.add(comp);
           }
           
       }
   }
   
   public static void gcc(ArrayList<Edge>[] graph, boolean[]visited, int src, ArrayList<Integer> comp ){
       
       comp.add(src);
       visited[src] = true;
       
       for(Edge e : graph[src]){
           
           if( !visited[e.nbr] ){
               
               gcc(graph, visited, e.nbr, comp);
           }
       }
       
       
   }
}