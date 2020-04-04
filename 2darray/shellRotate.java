import java.io.*;
import java.util.*;

public class shellRotate {

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
        int s = scn.nextInt();
        int r = scn.nextInt();
        shellrotate(a,s,r);
        display(a);
    }
    
    public static void shellrotate(int[][]a, int s, int r){
        //extract the elements
        int[] arr = fill1d(a,s);
        //rotate
        rotate(arr, r);
        //insert the elements
        fill2d(a,s,arr);
        
        
    }
    
    public static int[] fill1d( int[][]a, int s){
        //extract the elements
        int n  = a.length;
        int m = a[0].length;
        
        //find no of elements in shell
        int shell_length = m - 2*(s -1);
        int shell_col = n - 2*(s - 1);
        
        int totalEle = 2*(shell_length + shell_col)-4;
        
        int[] shellele = new int[totalEle];
        //shell starting pt (shell -1, shell-1)
        //shell ending pt (rows-1-(shell-1) , col-1-(shell-1))
        int startr = s-1, startc = s-1;
        int endr = n-1-(s-1), endc = m-1-(s-1);
        
        int idx =0;
        //left wall
        for(int i = startr; i<=endr; i++){
            shellele[idx] = a[i][startc];
            idx++;
        }
        
        startc++;
        //bottom wall
        for(int i = startc; i<=endc; i++){
            shellele[idx] = a[endr][i];
            idx++;
        }
        
        endr--;
        //ryt wall
        for(int i = endr; i>= startr; i--){
            shellele[idx] = a[i][endc];
            idx++;
        }
        
        endc--;
        //top wall
        for(int j = endc; j>=startc; j--){
            shellele[idx] = a[startr][j];
            idx++;
        }
        
        startc--;
        
        return shellele;
    }
    public static void rotate(int[] a, int r){
        r = r % a.length;      //absolute rotation
        if(r < 0){
            r = r + a.length;
        }
        
        //call reverse algo for ratation
        reverse(a, a.length - r , a.length -1);
        reverse(a, 0, a.length - r - 1 );
        reverse(a, 0, a.length - 1);
    }
    public static void reverse(int[]a, int st, int ed){
        while(st < ed){
            int temp = a[st];
            a[st] = a[ed];
            a[ed] = temp;
            st++;
            ed--;
        }
        
    }
    public static void fill2d(int[][]a, int s, int[] rotatedArr){
        int n  = a.length;
        int m = a[0].length;
        
        
        //shell starting pt (shell -1, shell-1)
        //shell ending pt (rows-1-(shell-1) , col-1-(shell-1))
        int startr = s-1, startc = s-1;
        int endr = n-1-(s-1), endc = m-1-(s-1);
        
        int idx =0;
        //left wall
        for(int i = startr; i<=endr; i++){
           a[i][startc] = rotatedArr[idx];
            idx++;
        }
        
        startc++;
        //bottom wall
        for(int i = startc; i<=endc; i++){
            a[endr][i] = rotatedArr[idx];;
            idx++;
        }
        
        endr--;
        //ryt wall
        for(int i = endr; i>= startr; i--){
            a[i][endc] = rotatedArr[idx];;
            idx++;
        }
        
        endc--;
        //top wall
        for(int j = endc; j>=startc; j--){
            a[startr][j] = rotatedArr[idx];;
            idx++;
        }
        
        startc--;

    }

    public static void display(int[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}