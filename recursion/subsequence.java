import java.io.*;
import java.util.*;

public class subsequene {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
       
        printSS(str, "");
        System.out.println("");
    
    }

    public static void printSS(String que, String ans) {
        if(que.length() ==0){
            if(ans.length()!=0){
               System.out.println(ans);
            }
            return;
        }
        
            String nstr = que.substring(1);
            char ch = que.charAt(0);
            
            
              printSS(nstr, ans);
            
              printSS(nstr, ans +ch );
        
    }

}