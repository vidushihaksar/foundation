import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int startrow = scn.nextInt();
        int startcol = scn.nextInt();
        printKnightsTour(new int[n][n], startrow, startcol, 1);
        
        System.out.println();
        
        
        
    }
    static int[][]dir ={{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2},{-1,-2},{-2,-1}};
    
    public static boolean isSafe(int[][]chess,int row, int col){
        if(row < 0 ||  col < 0 || row >= chess.length ||col >= chess[0].length || chess[row][col]!=0 ){
            return false;
        }
        
            return true;
        
    }
    public static void printKnightsTour(int[][] chess, int row, int col, int upcomingMove) {
        int n = chess.length;
        int m= chess[0].length;
        int total = n*m;
        
        if(upcomingMove == total){
            chess[row][col] = upcomingMove;
            displayBoard(chess);
            chess[row][col] = 0;

            return;
        }
         chess[row][col] = upcomingMove;

        
        for(int i=0; i<dir.length; i++){
            int r = row + dir[i][0];
            int c = col +  dir[i][1];
            
            if(isSafe(chess,r,c)){
                 printKnightsTour(chess,r,c,upcomingMove+1);
            }
            
        }
        chess[row][col] = 0;

        
        
    }

    public static void displayBoard(int[][] chess){
        for(int i = 0; i < chess.length; i++){
            for(int j = 0; j < chess[0].length; j++){
                System.out.print(chess[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }
}