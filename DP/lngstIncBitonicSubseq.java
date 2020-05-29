import java.io.*;
import java.util.*;

public class Main {

        public static void main(String[] args) throws Exception{
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = scn.nextInt();
        }

        System.out.println(bitonicSub(arr, n));
    }

    public static int bitonicSub(int[]arr, int n){
        int[] lis = new int[n];
        lis[0]= 1;
        for(int i=1; i<n; i++){
            int len =0;
            for(int j=0; j<i; j++){
                if(arr[i] > arr[j] && lis[j] > len){
                    len = lis[j];
                }
            }
            lis[i] =len +1;

        }

        int[] lds = new int[n];
        lds[n-1] = 1;
        for(int i=n-2; i>=0; i--){
            int len =0;
            for(int j=n-1; j>i; j--){
                if(arr[i] > arr[j] && lds[j] > len){
                    len = lds[j];
                }
            }
            lds[i] =len +1;

        }

        int max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            max = Math.max(lis[i] + lds[i] -1,max);
        }

        return max;

    }

}