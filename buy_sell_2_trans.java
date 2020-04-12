import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[]a = new int[n+1];
        for(int i=0; i<n; i++){
            a[i] = scn.nextInt();
            
        }
        int ans = trans(n,a);
        System.out.println(ans);
        
    }
    
    public static int trans(int n, int[] a){
     int[]minsofar = new int[n];
    int[]profit1 = new int[n];
    int[]maxsofar = new int[n];
    int[]profit2 = new int[n];
    
    minsofar[0] = a[0];
    profit1[0] =0;
    for(int i=1; i<n; i++){
            minsofar[i] = minsofar[i-1];
            profit1[i] = profit1[i-1];

        if(a[i]  < minsofar[i-1]){
            minsofar[i] = a[i];
            profit1[i] = profit1[i-1];
        }
        if((a[i] - minsofar[i-1]) > profit1[i-1]){
            profit1[i] = a[i] - minsofar[i-1];
            minsofar[i] = minsofar[i-1];
        }
        
    }
    maxsofar[n-1]=a[n-1];
    profit2[n-1] =0;
    for(int i=n-2; i>=0; i--){
            maxsofar[i] = maxsofar[i+1];
            profit2[i] = profit2[i+1];

        if(a[i]  > maxsofar[i+1]){
            maxsofar[i] = a[i];
            profit2[i] = profit2[i+1];
        }
        if((maxsofar[i+1] - a[i]) > profit2[i+1]){
            profit2[i] = maxsofar[i+1] - a[i];
            maxsofar[i] = maxsofar[i+1];
        }
        
    }
    int max = Integer.MIN_VALUE;
    for(int i=0; i<n; i++){
        if (profit1[i]+ profit2[i] > max)
                    max =  profit1[i]+ profit2[i];
    }
    return max;
    
    
}

}