import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args){
     Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[]a= new int[n];
        for(int i=0; i<a.length; i++){
            a[i] = scn.nextInt();
        }
        displayArrReverse(a, 0);
    }




    public static void displayArrReverse(int[] arr, int idx) {
        if(idx == arr.length){
            return;
        }
        
        displayArrReverse(arr, idx+1);
        System.out.println(arr[idx]);
    }

}