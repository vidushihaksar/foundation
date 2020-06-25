import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n =  scn.nextInt();
        int m =  scn.nextInt();
        int[][]a = new int[n][m];
        
        for(int i =0; i< n; i++){
            for(int j = 0; j< m; j++){
                a[i][j] = scn.nextInt();
                
            }
        }
        
        floodfill(a,0,0,"",new boolean[n][m]);
        
    }
    static int[][]dirArr ={{-1,0},{0,-1},{1,0},{0,1}};
    static char []dir ={'t', 'l','d','r'};
    
    public static boolean isSafe(int[][] maze, int row, int col, boolean[][] visited){
        if(row < 0 || col < 0 || row >= maze.length || col >= maze[0].length || maze[row][col] == 1 ||  visited[row][col] == true){
            return false;
        }
        return true;
    }
    
    public static void floodfill(int[][] maze, int row, int col, String psf, boolean[][] visited){
        if(row == maze.length-1 && col == maze[0].length-1){
            System.out.println(psf);
            return;
        }
        
        
        for(int i =0; i< dirArr.length; i++){
            int nr = row + dirArr[i][0];
            int nc = col + dirArr[i][1];
            
            visited[row][col] = true;
            
            if(isSafe(maze, nr, nc, visited)){
                
                
                floodfill(maze, nr, nc, psf + dir[i], visited);
                
            }
            visited[row][col] = false;
        }
    }
}