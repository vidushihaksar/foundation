import java.io.*;
import java.util.*;

public class keypad {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        printKPC(str, "");

    }

    static String[] keys = {
        ".;",
        "abc",
        "def",
        "ghi",
        "jkl",
        "mno",
        "pqrs",
        "tu",
        "vwx",
        "yz"
    };
    public static void printKPC(String str, String ans) {
        if(str.length()==0){
            System.out.println(ans);
            return;
        }
     
         int idx = str.charAt(0)-'0';
         String nstr = str.substring(1);
         String key = keys[idx];
         
         for(int j=0; j<key.length(); j++){
             char s = key.charAt(j);
             
             printKPC(nstr, ans+s);
             
         }
     }
     

    

}