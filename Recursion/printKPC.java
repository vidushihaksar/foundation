import java.io.*;
import java.util.*;

public class Main {

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
       if(str.length() == 0){
           System.out.println(ans);
           return;
       }
       
       int ch =  str.charAt(0)-'0';
       String nstr = str.substring(1);
       String key = keys[ch];
       
       for(int i =0; i < key.length(); i++){
           char c = key.charAt(i);
           
           printKPC(nstr, ans+c);
       }
     }
     
}