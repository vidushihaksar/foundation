import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ArrayList<String>ans =  getStairPaths(n);;
        System.out.println(ans);
    }

//************** proactive approach ***************************
    // public static ArrayList<String> getStairPaths(int n) {
    //   if(n == 0){
    //       ArrayList<String> a = new ArrayList<String>();
    //       a.add("");
    //       return a;
    //   }
       
    //   ArrayList<String> myans = new ArrayList<String>();
       
    //   if( n-1 >= 0){
    //         ArrayList<String> r1 = getStairPaths(n-1);
    //         for(String s : r1){
    //             myans.add("1"+s);
    //         }
            
    //         if( n - 2 >= 0){
    //             ArrayList<String> r2 = getStairPaths(n-2);
    //             for(String s : r2){
    //               myans.add("2"+s);
    //             }
                
    //             if(n - 3 >=0){
    //                  ArrayList<String> r3 = getStairPaths(n-3);
    //                  for(String s : r3){
    //                       myans.add("3"+s);
    //                   }
    //             }

    //         }

    //     }
    //         return myans;
    // }

    public static ArrayList<String> getStairPaths(int n) {
        
        if(n==0){
            ArrayList<String>a = new ArrayList<String>();
            a.add("");
            return a;
        }
        
        
        ArrayList<String>myList = new ArrayList<String>();
        
        for (int step =1; n-step>=0 && step<=3; step++){
            ArrayList<String>rec = getStairPaths(n- step);
            
            for(String s :  rec){
                myList.add(step + s);
            }
            
        }
        
        return myList;
    }

    

    
}