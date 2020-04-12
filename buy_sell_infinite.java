import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[]a = new int[n];
        for(int i=0; i<n; i++){
            a[i] = scn.nextInt();
        }
        System.out.println(multiple(n,a));
    }
    public static int multiple(int n, int[]a){
        int buying_point= 0, selling_point =0, profit=0;
        
        for(int i=0; i<a.length-1; i++){
            if(a[i] <= a[i+1]){
                selling_point +=1;
                //System.out.println(selling_point);
                
                
            }
            else{
               profit = profit + (a[selling_point]-a[buying_point]);
               selling_point +=1;
               buying_point  = selling_point ;
               //System.out.println(selling_point +" " + buying_point);
            }
        }
        //include last profit
        profit = profit + (a[selling_point]-a[buying_point]);

        return profit;
    }

}