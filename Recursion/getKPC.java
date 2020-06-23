import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
         Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        
        ArrayList<String> ans = getKPC(str);
        System.out.println(ans);
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
    public static ArrayList<String> getKPC(String str) {
        if(str.length()==0){
            ArrayList<String> ans = new ArrayList<>();
            ans.add("");
            return ans;
        }
        
        int idx = str.charAt(0)-'0';
        String nstr = str.substring(1);
        
        ArrayList<String>a = getKPC(nstr);
        String key = keys[idx];
        ArrayList<String> myans = new ArrayList<>();

        for(int i=0; i< key.length(); i++){
            char c = key.charAt(i);
            for(String s: a){
                myans.add(c+s);
            }
        }
        
        return myans;
    }

}