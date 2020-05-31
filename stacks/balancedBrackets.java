import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        
        System.out.println(balancedBrackets(str));
    }
    public static boolean balancedBrackets(String str){
        Stack<Character> st = new Stack<>();
        
        for(int i=0; i< str.length();i++){
            
            char ch = str.charAt(i);
            //opening brackets push
            if(ch == '(' || ch == '[' || ch== '{'){
                
                st.push(ch);
            
            //closing brackets pop
            }else if(ch== ')'){
                  if(st.size() == 0 || st.peek()!='('){
                    return false;
                  }else{
                      st.pop();
                  }
                  
            }else if(ch== '}'){
                  if(st.size() == 0 || st.peek()!='{'){
                    return false;
                  }else{
                      st.pop();
                  }
                  
            }else if(ch== ']'){
                  if(st.size() == 0 || st.peek()!='['){
                    return false;
                  }else{
                      st.pop();
                  }
            }
                  
            
        }
        
        return st.size()==0;
    }
    

}
    // public static boolean balancedBrackets(String str){
    //     Stack<Character> st = new Stack<>();
        
    //     for(int i=0; i< str.length();i++){
            
    //         char ch = str.charAt(i);
    //         //opening brackets push
    //         if(ch == '(' || ch == '[' || ch== '{'){
                
    //             st.push(ch);
            
    //         //closing brackets pop
    //         }else if(ch==')' || ch==']' || ch=='}'){
    //             if(st.size()!=0){
    //               if(ch== ')' ){
    //                 if(st.peek()=='('){
    //                     st.pop();
    //                 }
    //               }
    //               if(ch== ']' ){
    //                 if(st.peek()=='['){
    //                     st.pop();
    //                 }
    //               }
    //               if(ch== '}' ){
    //                 if(st.peek()=='{'){
    //                     st.pop();
    //                 }
    //               }
    //             }else{
    //               return false;
    //             }
    //         }
    //     }
        
    //     if(st.size()!=0){
    //         return false;
            
    //     }else{
    //         return true;
    //     }
    // }