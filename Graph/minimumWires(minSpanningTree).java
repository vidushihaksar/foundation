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
         connectAllPcs(graph, new boolean[vtces]);
      
   }
   
   public static class pair implements Comparable<pair>{
       int vtx;
       int parent;
       int wt;
       
       pair(int vtx, int parent, int wt){
           this.vtx = vtx;
           this.parent = parent;
           this.wt = wt;
       }
       
       public int compareTo(pair o){
           return this.wt  - o.wt;
       }
   }
   
   public static void minSpanningTree(ArrayList<Edge>[] graph, boolean[] visited){
       PriorityQueue<pair> pq = new PriorityQueue<>();
       pq.add(new pair(0,-1,0));
       visited[0]= true;
       
       while(pq.size() > 0){
           pair rem = pq.remove();
           
           if(rem.parent != -1){
               
               if( !visited[rem.vtx] ){
                   
                   //mark visited
                   visited[rem.vtx] = true;
                   
                   //print
                   System.out.println("["+rem.vtx+"-"+rem.parent+"@"+rem.wt+"]");
                   
              }
           }
                   for(Edge e : graph[rem.vtx] ){
                       if(!visited[e.nbr]){
                           pq.add(new pair(e.nbr, rem.vtx, e.wt));
                       }
                   }
               
           
       }
   }
}
   
   