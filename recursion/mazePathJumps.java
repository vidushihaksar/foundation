import java.io.*;
	import java.util.*;

	public class mazePathJumps {

	    public static void main(String[] args) throws Exception {
	        Scanner scn =new Scanner(System.in);
	        int n  = scn.nextInt();
	        int m = scn.nextInt();
	        printMazePaths(0,0,n-1,m-1,"");
	        System.out.println();
	    }

	    // sr - source row
	    // sc - source column
	    // dr - destination row
	    // dc - destination column
	    
	    public static void printMazePaths(int sr, int sc, int dr, int dc, String psf) {
	        if(sr==dr && sc==dc){
	            System.out.println(psf);
	            return;
	        }
	        
	        
	        //horizontal call
	        for(int step = 1; sc + step <=dc ; step++){
	        
	            printMazePaths(sr,sc+step, dr, dc, psf+"h"+step);
	        }
	    
	        
	        
	        //vertical call
	        for(int step = 1; sr + step <= dr; step++){
	           printMazePaths(sr+step,sc, dr, dc, psf+"v"+step);
	        }
	        
	        
	        for(int step =1; sr+ step <= dr && sc + step <= dc; step++){
	            printMazePaths(sr+step,sc+step, dr, dc, psf+"d"+step);

	        }
	           
	    }
	    

	}