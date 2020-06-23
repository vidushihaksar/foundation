import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
             Scanner scn =new Scanner(System.in);
	        int n  = scn.nextInt();
	        int m = scn.nextInt();
	        ArrayList<String>ans = getMazePaths(0,0,n-1,m-1);
	        System.out.println(ans);
    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
        if(sr==dr && sc==dc){
                ArrayList<String> ans  = new ArrayList<>();
                ans.add("");
	            return ans;
	        }
	        
            ArrayList<String> myList  = new ArrayList<>();

	        //horizontal call
	        for(int step = 1; sc + step <=dc ; step++){
	            ArrayList<String> horz = getMazePaths(sr,sc+step, dr, dc);
	        
	            for(String s :horz){
                     myList.add("h"+step+s);
                }
            }
	    
	        //vertical call
	        for(int step = 1; sr + step <= dr; step++){
                ArrayList<String> v = getMazePaths(sr+step,sc, dr, dc);
	        
	            for(String s :v){
                     myList.add("v"+step+s);
                }	        }
	        
	        
	        for(int step =1; sr+ step <= dr && sc + step <= dc; step++){
                ArrayList<String> d = getMazePaths(sr+step,sc+step, dr, dc);
	        
	            for(String s : d){
                     myList.add("d"+step+s);
                }
	        }
	        
        return myList;
    }

}