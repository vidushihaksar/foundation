import java.io.*;
import java.util.*;

public class towerOfHanoi {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int t1id = scn.nextInt();
        int t2id = scn.nextInt();
        int t3id = scn.nextInt();
        
        toh(n, t1id, t2id, t3id);
    }

    public static void toh(int n, int t1id, int t2id, int t3id){
        
        if(n==0) return;
            
    
        // move n-1 discs from src to helper using dest
        toh(n-1, t1id, t3id, t2id);
        
        // move n disc from src to dest
        System.out.println(n+"["+t1id+" -> "+t2id+"]");

        // move n-1 discs from helper to dest using src
        toh(n-1, t3id, t2id, t1id);
        
    }

}