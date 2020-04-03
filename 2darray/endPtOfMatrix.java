import java.io.*;
import java.util.*;

public class endPtOfMatrix {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] a = new int[n][m];
        
        for(int i = 0; i<n; i++){
            for(int j = 0; j< m; j++){
                a[i][j] = scn.nextInt();
            }
        }
        exit(a);
    }
    
    public static void exit(int[][]a){
        int n = a.length;
        int m = a[0].length;
        
        int count =0;
       
        int i=0,j=0,x=0, y=0;
        
        while(i>=0 && j>=0 && i<n && j<m){
              x =i;
              y=j;
              
            if(a[i][j]==1){
             count++;
             count = count % 4;
            }
            if(count == 0){ j++; }
            else if(count == 1){ i++; }
            else if(count == 2) { j--; }
            else if(count == 3){ i--;  }
          
        }
        System.out.println(x+""+y);
        
        
    }

}