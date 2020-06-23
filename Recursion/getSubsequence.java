import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str   = scn.nextLine();
        ArrayList<String> ans = gss(str);
        System.out.println(ans);
        
    }

    public static ArrayList<String> gss(String str) {
        if(str.length() == 0){
            ArrayList<String> ans = new ArrayList<String>();
            ans.add("");
            return ans;
        }
         ArrayList<String> myans = new ArrayList<String>();
        
        char ch = str.charAt(0);
        String nstr =  str.substring(1);
        
        ArrayList<String> a1 = gss(nstr);
        for(String s : a1){
            myans.add(s);
        }
        
        for(String s : a1){
            myans.add(ch+s);
        }
        return myans;
    }

}