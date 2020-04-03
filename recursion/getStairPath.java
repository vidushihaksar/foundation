import java.io.*;
import java.util.*;

public class getStairPath {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ArrayList<String> ans = getStairPaths(n);
        System.out.println(ans);

        
    }
//pre active
    public static ArrayList<String> getStairPaths(int n) {
        //if(n < 0){ return new ArrayList<>(); }
        
        if(n == 0){
            ArrayList<String> ans  = new ArrayList<>();
            ans.add("");
            return ans;
        }
        
        ArrayList<String> myList  = new ArrayList<>();

        // if( n-1 >= 0){
        //     ArrayList<String> path = getStairPaths(n-1);
        //     for(String s :path){
        //          myList.add("1"+s);
        //       }
            
            
        //     if( n - 2 >= 0){
        //         ArrayList<String> path1 = getStairPaths(n-2);
        //          for(String s : path1){
        //             myList.add("2"+s);
        //          }

                
        //         if(n - 3 >=0){
        //              ArrayList<String> path2 = getStairPaths(n-3);
        //              for(String s : path2){
        //                 myList.add("3"+s);
        //              }

        //         }

        //     }

        // }
        
        for(int step = 1; n- step >=0 && step<=3; step++){
            ArrayList<String> len = getStairPaths(n - step);
            for(String s : len){
                        myList.add(""+step+s);
                     }
            
        }
        return myList;
    }

}