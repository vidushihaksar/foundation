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

      System.out.println(isGraphBipartite(graph));
   }
   public static boolean isGraphBipartite(ArrayList<Edge>[] graph){
       HashMap<Integer, Integer> visited = new HashMap();
       for(int v = 0; v < graph.length; v++){
           if(!visited.containsKey(v) && isBipartite(graph, visited, v) == false){
               return false;
           }
       }
       return true;
   }
   
    public static class pair{
       int vtx ;
       int level;
       
       pair(int vtx, int level){
           this.vtx =  vtx;
           this.level = level;
       }
   }
   
   
   public static boolean isBipartite(ArrayList<Edge>[] graph, HashMap<Integer, Integer> visited  , int src ){
       Queue<pair> que = new ArrayDeque<>();
       que.add(new pair(src, 0));

       while(que.size() > 0){
           //remove;
           pair p = que.remove();
          
          
           if( !visited.containsKey(p.vtx) ){     // not visited

               //mark
               visited.put(p.vtx, p.level);
               
               //add all unvisited neighbours
               for(Edge e : graph[p.vtx]){
                     if(!visited.containsKey(e.nbr)){
                        que.add(new pair(e.nbr, p.level+1));
                     }
               }
           }else{
               int oldlevel = visited.get(p.vtx);
               if( (oldlevel % 2)  !=  (p.level % 2) ){
                   return false;
               }
           }
       }
       
        return true;
       
   
   }
}