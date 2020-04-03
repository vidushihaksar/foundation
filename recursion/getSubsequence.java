import java.io.*;
import java.util.*;

public class getSubsequence {

    public static void main(String[] args) throws Exception {
         Scanner scn = new Scanner(System.in);
         String str = scn.nextLine();
         
         ArrayList<String>ans =gss(str);
         System.out.println(ans);

    }

    public static ArrayList<String> gss(String str) {
        if(str.length() ==0){
            ArrayList<String> ans  = new ArrayList<>();
            ans.add("");
            return ans;
        }
            
               String nstr = str.substring(1);
               char ch = str.charAt(0);
          
              ArrayList<String> recans = gss(nstr);
              
              ArrayList<String> myList  = new ArrayList<>();
              
              //directly include in myList
              for(String s :recans){
                 myList.add(s);
              }
              //append mychar with recans
              for(String s : recans){
                 myList.add(ch+s);
              }
              
        return myList;
    }

}