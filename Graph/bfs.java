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
         graph[v2].add(new Edge(v2, v1));
      }

      int src = Integer.parseInt(br.readLine());
      bfs(src, graph, new boolean[graph.length]);
      // write your code here  
   }
   
   public static class pair{
       int srcnode ;
       String path;
       
       pair(int srcnode, String path){
           this.srcnode=  srcnode;
           this.path = path;
       }
   }
   
   public static void bfs(int src, ArrayList<Edge>[] graph, boolean[] visited){
       
       Queue<pair> que = new ArrayDeque<>();
       que.add(new pair(src, ""+src));

       while(que.size() > 0){
           //remove;
           pair p = que.remove();

           if( !visited[p.srcnode] ){
               //mark
               visited[p.srcnode] = true;
               
               //print
               System.out.println(p.srcnode + "@" + p.path);
               
               //add all unvisited neighbours
               for(Edge e : graph[p.srcnode]){
                     if(!visited[e.nbr]){
                        que.add(new pair(e.nbr, p.path + e.nbr));
                     }
               }
           }
       }
   }
}