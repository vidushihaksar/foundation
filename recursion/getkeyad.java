import java.io.*;
import java.util.*;

public class getkeypad {

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
         String key = keys[idx];
         
         ArrayList<String> recans = getKPC(nstr);
         ArrayList<String> myans = new ArrayList<>();
         
         for(int j=0; j<key.length(); j++){
             char s = key.charAt(j);
             for(String st : recans){
                 myans.add(s+st);
             }
             
         }
        
        
        return myans;
    }

}