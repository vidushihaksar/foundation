import java.io.*;
import java.util.*;

public class matrixMult{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn = new Scanner(System.in);
        int n1 = scn.nextInt();
        int m1 = scn.nextInt();
        int[][] a = new int[n1][m1];
        
        for(int i = 0; i<n1; i++){
            for(int j = 0; j< m1; j++){
                a[i][j] = scn.nextInt();
            }
        }
        int n2 = scn.nextInt();
        int m2 = scn.nextInt();
        int[][] b = new int[n2][m2];
        
        for(int i = 0; i<n2; i++){
            for(int j = 0; j< m2; j++){
                b[i][j] = scn.nextInt();
            }
        }
        
        int[][] mult = new int[n1][m2];
        
        if(m1 == n2){
            for(int i =0 ; i<n1; i++){
                for(int j =0; j< m2; j++){
                    int sum =0;
                    for(int k = 0 ; k < m1; k++){
                        sum+= a[i][k]*b[k][j];
                    }
                    mult[i][j] = sum;
                }
            }
            
            for(int i = 0; i<n1; i++){
            for(int j = 0; j< m2; j++){
                System.out.print(mult[i][j]+" ");
            }
            System.out.println();
        }
        }
        else{
            System.out.println("Invalid input");
        }

 }

}