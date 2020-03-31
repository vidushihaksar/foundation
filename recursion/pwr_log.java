import java.io.*;
import java.util.*;

public class pwr_log {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int x = scn.nextInt();
        int n = scn.nextInt();
        System.out.println(power(x, n));
    }

    public static int power(int x, int n){
        if(n == 0){
            return 1;
        }
        
        int p = power(x,n/2);
        if(n % 2 == 0){
            return p*p;
        }
        else{
            return p*p*x;
        }
        
       
    }

}