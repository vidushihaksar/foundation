import java.io.*;
import java.util.*;

public class Main {
   
   public static class Edge{
       int vtx;
       int nbr;
       
       Edge(int vtx, int nbr){
           this.vtx = vtx;
           this.nbr = nbr;
       }
       
   }
   public static void main(String[] args) throws Exception {
      
      
      Scanner scn = new Scanner(System.in);
      int n = scn.nextInt();
      int k = scn.nextInt();
      
      ArrayList<Edge> graph[] = new ArrayList[n];
      
      for(int i = 0; i< n; i++ ){
          graph[i] = new ArrayList<Edge>();
      }
      
      for(int j =0; j< k; j++){
          int vtx = scn.nextInt();
          int nbr = scn.nextInt();
          
          graph[vtx].add(new Edge(vtx, nbr));
          graph[nbr].add(new Edge(nbr, vtx));
      }
      
      System.out.println(perfectFriend(graph));
      
   }
   public static int perfectFriend(ArrayList<Edge> graph[]){
       boolean[]visited = new boolean[graph.length];
       ArrayList<Integer> comps = new ArrayList<>();
       
       for(int v= 0; v < graph.length ; v++){
           
           if( !visited[v] ){
               int sizeOfConnectedComponents = sizeOfgcc(graph, visited, v);
               comps.add(sizeOfConnectedComponents);
           }
       }
       
       int ways = 0;
       
       for(int i = 0; i < comps.size(); i++){
           for(int j = i+1; j <  comps.size(); j++){
               ways += comps.get(i)*comps.get(j);
           }
       }
       return ways;
   }
   
   public static int sizeOfgcc(ArrayList<Edge> graph[], boolean[]visited, int src){
       int count = 0;
       
       //mark visited
       visited[src] =  true;
       count++;
       
       //visit unvisited nbrs
       for(Edge e : graph[src]){
           
           if( ! visited[e.nbr]){
               count += sizeOfgcc(graph, visited, e.nbr);
           }
       }
       
       return count;
       
       
   }

}