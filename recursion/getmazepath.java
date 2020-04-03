import java.io.*;
import java.util.*;

public class getmazepath {

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
        if(sr== dr && sc==dc){
            ArrayList<String> ans  = new ArrayList<>();
            ans.add("");
            return ans;
        }
        
            ArrayList<String> myList  = new ArrayList<>();
          
           
           //horizontal call
	        if(sc + 1 <= dc){
	            ArrayList<String> horz = getMazePaths(sr,sc+1, dr, dc);
	        
	            for(String s :horz){
                     myList.add("h"+s);
                }
	        }
	        
	        //vertical call
	        if(sr+1 <= dr){
	           ArrayList<String> ver = getMazePaths(sr+1,sc, dr, dc);
	        
	           for(String s : ver){
                  myList.add("v"+s);
                }
	        }
	        
	         
        return myList;
    }

}

// 	    public static void printMazePaths(int sr, int sc, int dr, int dc, String psf) {
// 	        if(sr==dr && sc==dc){
	            
// 	        }
	        
// 	        //horizontal call
// 	        if(sc + 1 <= dc){
// 	            printMazePaths(sr,sc+1, dr, dc, psf+"h");
// 	        }
	        
// 	        //vertical call
// 	        if(sr+1 <= dr){
// 	           printMazePaths(sr+1,sc, dr, dc, psf+"v");
// 	        }
	           
// 	    }

// 	}