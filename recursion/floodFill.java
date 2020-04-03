// import java.io.*;
// import java.util.*;

// public class floodFill {

//     public static void main(String[] args) throws Exception {
//         // write your code here
//         Scanner scn = new Scanner(System.in);
//         int n = scn.nextInt();
//         int m = scn.nextInt();
//         int[][]a = new int[n][m];
        
//         for(int i =0; i<n; i++){
//             for(int j =0; j<m; j++){
//                 a[i][j] = scn.nextInt();
//             }
//         }
//         boolean[][] v = new boolean[n][m];
//         floodfill(a,0,0,"",v);
//     }

//     public static void floodfill(int[][] maze, int row, int col, String psf, boolean[][] visited){
//          if(row < 0 ||  col < 0 || row >= maze.length ||col >= maze[0].length || maze[row][col]==1 || visited[row][col]==true){
//             return;
//         }
        
//         if(row == maze.length-1 && col == maze[0].length-1){
//             System.out.println(psf);
//             return;
//         }
        
//         visited[row][col] = true;
        
//         floodfill(maze, row - 1, col, psf + "t", visited);
//         floodfill(maze, row , col-1, psf + "l", visited);
//         floodfill(maze, row + 1, col, psf + "d", visited);
//         floodfill(maze, row , col+1, psf + "r", visited);


//         visited[row][col] = false;

        
        
//     }
// }






// my technique

import java.io.*;
import java.util.*;

public class floodFill {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][]a = new int[n][m];
        
        for(int i =0; i<n; i++){
            for(int j =0; j<m; j++){
                a[i][j] = scn.nextInt();
            }
        }
        boolean[][] v = new boolean[n][m];
        floodfill(a,0,0,"",v);
    }
    static String[] dir = {"t","l","d","r"};
    static int[][]dir_ ={ {-1,0},{0,-1},{1,0},{0,1}};
    
    public static boolean isSafe(int[][]maze,int row, int col, boolean[][]visited){
        if(row < 0 ||  col < 0 || row >= maze.length ||col >= maze[0].length || maze[row][col]==1 || visited[row][col]==true){
            return false;
        }
        
            return true;
        
    }
    public static void floodfill(int[][] maze, int row, int col, String psf, boolean[][] visited){
        if(row == maze.length-1 && col == maze[0].length-1){
            System.out.println(psf);
            return;
        }
        
        visited[row][col] = true;
        
        for(int i=0; i<dir.length; i++){
            int r = row + dir_[i][0];
            int c = col + dir_[i][1];
        
            if(isSafe(maze,r,c,visited)   ){
                  floodfill(maze, r, c, psf+dir[i]  ,visited );
             } 
             
        }
        visited[row][col]=false;
        
    }
}