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

      int src = Integer.parseInt(br.readLine());
      hamiltonian(graph, src, src, "" , new HashSet<Integer>());
   }


   public static void hamiltonian(ArrayList<Edge>[] graph, int osrc, int vtx, String psf, HashSet<Integer> visited){
      
      //last vtx will not be marked true . 
       if(visited.size() == graph.length-1){
           
           //add last vtx in path so far
           psf = psf + vtx;
           
           //boolean variable to check if cycle exists
           boolean cycle =  false;
           
           for(Edge e : graph[vtx]){
               if( e.nbr == osrc){
                   cycle = true;
               }
           }
           
           if(cycle){ System.out.println(psf + "*"); }
           else{ System.out.println(psf + "."); }
           
       }
       
       //mark visited
       visited.add(vtx);
       
       for(Edge e: graph[vtx]){
           if( !visited.contains(e.nbr) ){
               hamiltonian(graph, osrc, e.nbr, psf + vtx, visited);
           }
       }
       
       // mark unvisited because we need to find all paths
       visited.remove(vtx);
   }

}